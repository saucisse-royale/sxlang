package fr.delthas.sxlang;

import fr.delthas.sxlang.generated.SxlangLexer;
import fr.delthas.sxlang.generated.SxlangParser;
import fr.delthas.sxlang.types.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;

import javax.swing.*;

import static org.bytedeco.javacpp.LLVM.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Sxlang {
  
  private static class Box<T> {
    public T v;
  
    public Box(T v) {
      this.v = v;
    }
  }
  
  private static class ExpressionV {
    public LLVMValueRef rawValue;
    public Type type;
    public boolean pointer;
  
    public ExpressionV(LLVMValueRef value, Type type, boolean pointer) {
      rawValue = value;
      this.type = type;
      this.pointer = pointer;
    }
  }
  
  private static class Label {
    public LLVMBasicBlockRef block;
    public LLVMBasicBlockRef after;
  
    public Label(LLVMBasicBlockRef block, LLVMBasicBlockRef after) {
      this.block = block;
      this.after = after;
    }
  }
  
  private static final String HELP = "sxlang - The sxlang programming language compiler\nby Maitre Van Diest, Delthas, (emersion xd)";
  private static final String USAGE = "Usage: sxlang <files>";
  
  private Map<String, Declaration> clazzsDeclarations = new HashMap<>();
  private Map<String, Declaration> functionDeclarations = new HashMap<>();
  private List<Map<String, ExpressionV>> stack = new ArrayList<>();
  private Declaration parseClassId, parseFunctionId;
  private List<LLVMValueRef> arrayStack = new ArrayList<>();
  private String classId;
  private LLVMModuleRef module;
  private LLVMBuilderRef builder;
  private List<Label> labels = new ArrayList<>();
  private BytePointer triple;
  private String[] target;
  
  @SuppressWarnings("unchecked")
  private static <T extends Pointer> PointerPointer<T> pointer(List<T> list) {
    return new PointerPointer((Pointer[]) list.toArray(new Pointer[list.size()]));
  }
  
  @SuppressWarnings("unchecked")
  private static <T extends Pointer> PointerPointer<T> pointer(T... list) {
    return new PointerPointer(list);
  }
  
  private void start(String... args) throws Exception {
    triple = LLVMGetDefaultTargetTriple();
    String tripleString = triple.getString();
    int c=0;
    target = new String[4];
    for(int i=0;i<4;++i) {
      int next = tripleString.indexOf('-', c);
      if(next == -1) next = tripleString.length();
      target[i] = tripleString.substring(c, next);
      c = next+1;
    }
    
    List<Declaration> declarations;
    if((declarations = parse(args)) == null) return;
    translate(declarations);
  }
  
  private int getFieldOffset(Declaration declaration, String name) {
    int i = 0;
    for(Declaration classVar : parseClassId.body) {
      if(classVar.type != Declaration.Type.Variable) continue;
      if(classVar.id.equals(name)) break;
      ++i;
    }
    return i;
  }
  
  private LLVMValueRef getValue(ExpressionV expression) {
    if(!expression.pointer) {
      return expression.rawValue;
    }
    return LLVMBuildLoad(builder, expression.rawValue, "ptrload");
  }
  
  private LLVMValueRef getPointer(ExpressionV expression) {
    if(expression.pointer) {
      return expression.rawValue;
    }
    LLVMValueRef pointer = alloca(LLVMGetBasicBlockParent(LLVMGetInsertBlock(builder)), getType(expression.type), "__tmp");
    LLVMBuildStore(builder, expression.rawValue, pointer);
    return pointer;
  }
  
  private ExpressionV getStack(String name) {
    for(int i=stack.size()-1;i>=0;--i) {
      Map<String, ExpressionV> scope = stack.get(i);
      ExpressionV value = scope.get(name);
      if(value != null) return value;
    }
    return null;
  }
  
  private LLVMTypeRef getPrimitiveType(Primitive primitive) {
    switch(primitive) {
      case Byte: return LLVMInt8Type();
      case UInt16: return LLVMInt16Type();
      case UInt32: return LLVMInt32Type();
      case UInt64: return LLVMInt64Type();
      case Int16: return LLVMInt16Type();
      case Int32: return LLVMInt32Type();
      case Int64: return LLVMInt64Type();
      case Float32: return LLVMFloatType();
      case Float64: return LLVMDoubleType();
      default: throw new RuntimeException();
    }
  }
  
  private LLVMValueRef getFunction(Declaration function) {
    if(function.parentId == null) {
      return LLVMGetNamedFunction(module, "_main_" + function.id);
    }
    return LLVMGetNamedFunction(module, function.parentId + "_" + function.id);
  }
  
  private LLVMTypeRef getBaseType(BaseType type) {
    if(type.type == BaseType.Type.Class) {
      return LLVMGetTypeByName(module, type.clazz);
    } else {
      return getPrimitiveType(type.primitive);
    }
  }
  
  private LLVMTypeRef getType(Type type) {
    if(type == null) return LLVMVoidType();
    if(type.array) {
      return LLVMPointerType(LLVMInt8Type(), 0);
    }
    return getBaseType(type.baseType);
  }
  
  private LLVMTypeRef processClass(Set<String> current, Declaration clazz) {
    LLVMTypeRef type = LLVMGetTypeByName(module, clazz.id);
    if(type != null) return type;
    if(!current.add(clazz.id)) throw new RuntimeException("Mutual References!");
  
    List<LLVMTypeRef> types = new ArrayList<>();
    for(Declaration declaration : clazz.body) {
      if(declaration.type != Declaration.Type.Variable) continue;
      LLVMTypeRef variableType;
      if(declaration.variableType.array) {
        variableType = LLVMPointerType(LLVMInt8Type(), 0);
      } else {
        if(declaration.variableType.baseType.type == BaseType.Type.Class) {
          variableType = processClass(current, clazzsDeclarations.get(declaration.variableType.baseType.clazz));
        } else {
          variableType = getPrimitiveType(declaration.variableType.baseType.primitive);
        }
      }
      if(declaration.instance) {
        types.add(variableType);
      } else {
        LLVMAddGlobal(module, variableType, "_" + clazz.id + "_" + declaration.id);
      }
    }
    LLVMTypeRef classType = LLVMStructCreateNamed(LLVMGetModuleContext(module), clazz.id);
    LLVMStructSetBody(classType, pointer(types), types.size(), 0);
    return classType;
  }
  
  private LLVMValueRef processCondition(Expression condition) {
    ExpressionV cond = processExpression(condition);
    if(cond.type.array || cond.type.baseType.type == BaseType.Type.Class) throw new RuntimeException("invalid cond");
    if(cond.type.baseType.primitive.floating) throw new RuntimeException("invalid cond");
    LLVMValueRef condValue = LLVMBuildICmp(builder, LLVMIntNE, getValue(cond), LLVMConstInt(LLVMInt1Type(), 0, 0), "ifcond");
    return condValue;
  }
  
  private ExpressionV processExpression(Expression expression) {
    switch (expression.type) {
      case Literal:
        Literal literal = expression.literal;
        switch(literal.type) {
          case ArrayLiteral:
            // TODO LLVMSetAlignment  (et LLVMAlignOf)
            LLVMValueRef value;
            if(literal.arrayBody.values == null) {
              LLVMValueRef count = getValue(processExpression(literal.arrayBody.count));
              value = LLVMBuildArrayMalloc(builder, LLVMInt8Type(), LLVMBuildAdd(builder, LLVMSizeOf(LLVMInt64Type()), LLVMBuildMul(builder, count, LLVMSizeOf(getBaseType(literal.arrayType)), "arraysizemul"), "arraysizeadd"), "arrayalloc");
              LLVMBuildStore(builder, LLVMBuildZExt(builder, count, LLVMInt64Type(), "arraysizecast"), LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, value, pointer(LLVMConstInt(LLVMInt32Type(), 0, 0)), 1, "arraysizegep"), LLVMPointerType(LLVMInt64Type(), 0), "arraysizecast"));
              if(literal.arrayBody.value != null) {
                LLVMValueRef init = getValue(processExpression(literal.arrayBody.value));
                LLVMValueRef function = LLVMGetBasicBlockParent(LLVMGetInsertBlock(builder));
                LLVMValueRef iterator = alloca(function, LLVMInt64Type(), "_arrayi");
                LLVMBuildStore(builder, LLVMConstInt(LLVMInt64Type(), 0, 0), iterator);
                LLVMBasicBlockRef whilz = LLVMAppendBasicBlock(function, "arraywhile");
                LLVMBasicBlockRef after = LLVMAppendBasicBlock(function, "arraywhileafter");
                LLVMValueRef condValue = LLVMBuildICmp(builder, LLVMIntULT, LLVMBuildLoad(builder, iterator, "loadarrayi"), count, "arraycond");
                LLVMBuildCondBr(builder, condValue, whilz, after);
                LLVMPositionBuilderAtEnd(builder, whilz);
                LLVMBuildStore(builder, init, LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, value, pointer(LLVMBuildAdd(builder, LLVMSizeOf(LLVMInt64Type()), LLVMBuildMul(builder, LLVMBuildLoad(builder, iterator, "loadarrayi"), LLVMSizeOf(getBaseType(literal.arrayType)), "arraymul"), "arrayadd")), 1, "arraygep"), LLVMPointerType(getBaseType(literal.arrayType), 0), "arraysizecast"));
                LLVMBuildStore(builder, LLVMBuildAdd(builder, LLVMBuildLoad(builder, iterator, "loadarrayi"), LLVMConstInt(LLVMInt64Type(), 1, 0), "addarrayi"), iterator);
                condValue = LLVMBuildICmp(builder, LLVMIntULT, LLVMBuildLoad(builder, iterator, "loadarrayi"), count, "arraycond");
                LLVMBuildCondBr(builder, condValue, whilz, after);
                LLVMPositionBuilderAtEnd(builder, after);
              }
            } else {
              value = LLVMBuildArrayMalloc(builder, LLVMInt8Type(), LLVMBuildAdd(builder, LLVMSizeOf(LLVMInt64Type()), LLVMBuildMul(builder, LLVMConstInt(LLVMInt64Type(), literal.arrayBody.values.size(), 0), LLVMSizeOf(getBaseType(literal.arrayType)), "arraysizemul"), "arraysizeadd"), "arrayalloc");
              LLVMBuildStore(builder, LLVMConstInt(LLVMInt64Type(), literal.arrayBody.values.size(), 0), LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, value, pointer(LLVMConstInt(LLVMInt32Type(), 0, 0)), 1, "arraysizegep"), LLVMPointerType(LLVMInt64Type(), 0), "arraysizecast"));
              for(int i=0;i<literal.arrayBody.values.size();++i) {
                LLVMValueRef init = getValue(processExpression(literal.arrayBody.values.get(i)));
                LLVMBuildStore(builder, init, LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, value, pointer(LLVMBuildAdd(builder, LLVMSizeOf(LLVMInt64Type()), LLVMBuildMul(builder, LLVMConstInt(LLVMInt64Type(), i, 0), LLVMSizeOf(getBaseType(literal.arrayType)), "arraymul"), "arrayadd")), 1, "arraygep"), LLVMPointerType(getBaseType(literal.arrayType), 0), "arraysizecast"));
              }
            }
            return new ExpressionV(value, new Type(literal.arrayType, true), false);
          case NumberLiteral:
            Primitive numberType;
            if(literal.numberType == null) {
              numberType = literal.string.contains(".") ? Primitive.Float32 : Primitive.Int32;
            } else {
              numberType = literal.numberType;
            }
            switch(numberType) {
              case Byte:
              case Int16:
              case Int32:
              case Int64:
              case UInt16:
              case UInt32:
              case UInt64:
                return new ExpressionV(LLVMConstIntOfString(getPrimitiveType(numberType), literal.negative ? ("-" + literal.string) : literal.string, (byte)10), new Type(new BaseType(numberType), false), false);
              case Float32:
              case Float64:
                return new ExpressionV(LLVMConstRealOfString(getPrimitiveType(numberType), literal.negative ? ("-" + literal.string) : literal.string), new Type(new BaseType(numberType), false), false);
              default: throw new IllegalArgumentException("invalid literal");
            }
          case StringLiteral:
            // TODO
            throw new IllegalArgumentException("unsupported!");
          default: throw new IllegalArgumentException("invalid literal");
        }
      case Cast:
        ExpressionV cast = processExpression(expression.base);
        if(cast.type.array || cast.type.baseType.type == BaseType.Type.Class) throw new IllegalArgumentException("invalid cast arg");
        return castType(cast, expression.cast);
      case Asm:
        if(expression.returnType.type != BaseType.Type.Primitive) throw new IllegalArgumentException("invalid return type");
        List<LLVMTypeRef> types = new ArrayList<>(expression.parameters.size());
        List<LLVMValueRef> values = new ArrayList<>(expression.parameters.size());
        for(Expression param : expression.parameters) {
          ExpressionV exp = processExpression(param);
          if(exp.type.baseType.type == BaseType.Type.Class) throw new IllegalArgumentException("invalid asm param type");
          if(exp.type.array) {
            types.add(LLVMPointerType(LLVMInt8Type(), 0));
            values.add(LLVMBuildGEP(builder, getValue(exp), pointer(LLVMSizeOf(LLVMInt64Type())), 1, "asmtaboffset"));
          } else {
            types.add(getPrimitiveType(exp.type.baseType.primitive));
            values.add(getValue(exp));
          }
        }
        return new ExpressionV(LLVMBuildCall(builder, LLVMConstInlineAsm(LLVMFunctionType(getBaseType(expression.returnType), pointer(types), types.size(), 0), expression.data, expression.constraints, 1, 0), pointer(values), values.size(), "asmcall"), new Type(expression.returnType, false), false);
      case UnknownId:
        ExpressionV variable = getStack(expression.data);
        if(variable != null) return variable;
        Declaration declaration;
        if((declaration = clazzsDeclarations.get(expression.data)) != null) {
          parseClassId = declaration;
          return null;
        }
        if(classId != null) {
          String function = classId + "_" + expression.data;
          if((declaration = functionDeclarations.get(function)) != null) {
            parseFunctionId = declaration;
            return null;
          }
        }
        String function = "_main_" + expression.data;
        if((declaration = functionDeclarations.get(function)) != null) {
          parseFunctionId = declaration;
          return null;
        }
        throw new IllegalArgumentException("invalid id " +expression.data);
      case This:
        if(classId == null) throw new RuntimeException("invalid this");
        ExpressionV self = getStack("%");
        return new ExpressionV(LLVMBuildLoad(builder, getValue(self), "self"), self.type, false);
      case ArrayLength:
        ExpressionV baseArrayLength = processExpression(expression.base);
        return new ExpressionV(LLVMBuildLoad(builder, LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, getValue(baseArrayLength), pointer(LLVMConstInt(LLVMInt32Type(), 0, 0)), 1, "arraylengthgep"), LLVMPointerType(LLVMInt64Type(), 0), "arraylengthcast"), "arraylengthload"), new Type(new BaseType(Primitive.UInt64), false), false);
      case BlockArrayLength:
        return new ExpressionV(LLVMBuildLoad(builder, LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, arrayStack.get(arrayStack.size() - 1), pointer(LLVMConstInt(LLVMInt32Type(), 0, 0)), 1, "arraylengthgep"), LLVMPointerType(LLVMInt64Type(), 0), "arraylengthcast"), "arraylengthload"), new Type(new BaseType(Primitive.UInt64), false), false);
      case Field:
        if(parseClassId != null) {
          Declaration parseClassId = this.parseClassId;
          this.parseClassId = null;
          for(Declaration var : parseClassId.body) {
            if(var.type != Declaration.Type.Variable) continue;
            if(var.instance) continue;
            if(!var.id.equals(expression.data)) continue;
            return new ExpressionV(LLVMGetNamedGlobal(module, "_" + parseClassId + "_" + expression.data), var.variableType, true);
          }
          throw new IllegalArgumentException("invalid field");
        }
        if(parseFunctionId != null) throw new IllegalArgumentException("invalid function use");
        ExpressionV baseField = processExpression(expression.base);
        if(baseField.type.baseType.type != BaseType.Type.Class) throw new IllegalArgumentException("invalid field base");
        int i = 0;
        for(Declaration var : clazzsDeclarations.get(baseField.type.baseType.clazz).body) {
          if(var.type != Declaration.Type.Variable) continue;
          if(!var.id.equals(expression.data)) {
            if(var.instance) ++i;
            continue;
          }
          if(var.instance) {
            return new ExpressionV(LLVMBuildStructGEP(builder, getValue(baseField), i, "fieldgep"), var.variableType, true);
          } else {
            return new ExpressionV(LLVMGetNamedGlobal(module, "_" + baseField.type.baseType.clazz + "_" + var.id), var.variableType, true);
          }
        }
        throw new IllegalArgumentException("invalid field");
      case Method:
        if(parseClassId != null) {
          Declaration parseClassId = this.parseClassId;
          this.parseClassId = null;
          for(Declaration var : parseClassId.body) {
            if(var.type != Declaration.Type.Function) continue;
            if(var.instance) continue;
            if(!var.id.equals(expression.data)) continue;
            parseFunctionId = functionDeclarations.get(parseClassId + "_" + expression.data);
            return null;
          }
          throw new IllegalArgumentException("invalid method");
        }
        if(parseFunctionId != null) throw new IllegalArgumentException("invalid function use");
        ExpressionV baseMethod = processExpression(expression.base);
        if(baseMethod.type.baseType.type != BaseType.Type.Class) throw new IllegalArgumentException("invalid method base");
        for(Declaration var : clazzsDeclarations.get(baseMethod.type.baseType.clazz).body) {
          if(var.type != Declaration.Type.Function) continue;
          if(!var.id.equals(expression.data)) continue;
          parseFunctionId = functionDeclarations.get(parseClassId + "_" + expression.data);
          return var.instance ? baseMethod : null;
        }
        throw new IllegalArgumentException("invalid method");
      case Array:
        ExpressionV base = processExpression(expression.base);
        arrayStack.add(getValue(base));
        ExpressionV index = processExpression(expression.index);
        arrayStack.remove(arrayStack.size() - 1);
        return new ExpressionV(LLVMBuildPointerCast(builder, LLVMBuildGEP(builder, getValue(base), pointer(LLVMBuildAdd(builder, LLVMSizeOf(LLVMInt64Type()), LLVMBuildMul(builder, getValue(index), LLVMSizeOf(getBaseType(base.type.baseType)), "arraymul"), "arrayadd")), 1, "arraygep"), LLVMPointerType(getBaseType(base.type.baseType), 0), "arraysizecast"), new Type(base.type.baseType, false), true);
      case ExternalCall:
        List<LLVMValueRef> eValues = new ArrayList<>();
        for(Expression parameter : expression.parameters) {
          ExpressionV exp = processExpression(parameter);
          if(exp.type.array) {
            eValues.add(LLVMBuildGEP(builder, getValue(exp), pointer(LLVMSizeOf(LLVMInt64Type())), 1, "asmtaboffset"));
          } else {
            eValues.add(getValue(exp));
          }
        }
        Declaration decl = functionDeclarations.get(expression.data);
        return new ExpressionV(LLVMBuildCall(builder, LLVMGetNamedFunction(module, expression.data), pointer(eValues), eValues.size(), "externcall"), decl.returnType, false);
      case FunctionCall:
        ExpressionV caller = processExpression(expression.base);
        if(parseFunctionId == null) throw new IllegalArgumentException("no function set");
        if(parseClassId != null) throw new IllegalArgumentException("invalid class use");
        Declaration parseFunctionId = this.parseFunctionId;
        this.parseFunctionId = null;
        List<LLVMValueRef> params = new ArrayList<>();
        if(parseFunctionId.instance) {
          params.add(getPointer(caller));
        }
        for(Expression parameter : expression.parameters) {
          params.add(getPointer(processExpression(parameter)));
        }
        return new ExpressionV(LLVMBuildCall(builder, getFunction(parseFunctionId), pointer(params), params.size(), parseFunctionId.returnType == null ? "" : "functioncall"), parseFunctionId.returnType, false);
      case UnaryOp:
        ExpressionV baseUnary = processExpression(expression.base);
        if(baseUnary.type.array || baseUnary.type.baseType.type != BaseType.Type.Primitive) throw new IllegalArgumentException("invalid unary base");
        switch(expression.unaryOp) {
          case Not:
            return new ExpressionV(LLVMBuildNot(builder, getValue(baseUnary), "not"), baseUnary.type, false);
          case PrePlus:
            return baseUnary;
          case PreMinus:
            return new ExpressionV(LLVMBuildNeg(builder, getValue(baseUnary), "neg"), baseUnary.type, false);
          case PreIncrement:
            if(!baseUnary.pointer) throw new IllegalArgumentException("not lvalue!");
            if(baseUnary.type.baseType.primitive.floating) {
              LLVMBuildStore(builder, LLVMBuildFAdd(builder, getValue(baseUnary), LLVMConstReal(getPrimitiveType(baseUnary.type.baseType.primitive), 1), "fpreincrement"), baseUnary.rawValue);
            } else {
              LLVMBuildStore(builder, LLVMBuildAdd(builder, getValue(baseUnary), LLVMConstInt(getPrimitiveType(baseUnary.type.baseType.primitive), 1, 0), "preincrement"), baseUnary.rawValue);
            }
            return baseUnary;
          case PreDecrement:
            if(!baseUnary.pointer) throw new IllegalArgumentException("not lvalue!");
            if(baseUnary.type.baseType.primitive.floating) {
              LLVMBuildStore(builder, LLVMBuildFSub(builder, getValue(baseUnary), LLVMConstReal(getPrimitiveType(baseUnary.type.baseType.primitive), 1), "fpredecrement"), baseUnary.rawValue);
            } else {
              LLVMBuildStore(builder, LLVMBuildSub(builder, getValue(baseUnary), LLVMConstInt(getPrimitiveType(baseUnary.type.baseType.primitive), 1, 0), "predecrement"), baseUnary.rawValue);
            }
            return baseUnary;
          case PostIncrement:
            if(!baseUnary.pointer) throw new IllegalArgumentException("not lvalue!");
            LLVMValueRef pre = getValue(baseUnary);
            if(baseUnary.type.baseType.primitive.floating) {
              LLVMBuildStore(builder, LLVMBuildFAdd(builder, pre, LLVMConstReal(getPrimitiveType(baseUnary.type.baseType.primitive), 1), "fpostincrement"), baseUnary.rawValue);
            } else {
              LLVMBuildStore(builder, LLVMBuildAdd(builder, pre, LLVMConstInt(getPrimitiveType(baseUnary.type.baseType.primitive), 1, 0), "postincrement"), baseUnary.rawValue);
            }
            return new ExpressionV(pre, baseUnary.type, false);
          case PostDecrement:
            if(!baseUnary.pointer) throw new IllegalArgumentException("not lvalue!");
            pre = getValue(baseUnary);
            if(baseUnary.type.baseType.primitive.floating) {
              LLVMBuildStore(builder, LLVMBuildFSub(builder, pre, LLVMConstReal(getPrimitiveType(baseUnary.type.baseType.primitive), 1), "fpostdecrement"), baseUnary.rawValue);
            } else {
              LLVMBuildStore(builder, LLVMBuildSub(builder, pre, LLVMConstInt(getPrimitiveType(baseUnary.type.baseType.primitive), 1, 0), "postdecrement"), baseUnary.rawValue);
            }
            return new ExpressionV(pre, baseUnary.type, false);
            default: throw new IllegalArgumentException("invalid unaryop type");
        }
      case BinaryOp:
        Box<ExpressionV> left = new Box<>(processExpression(expression.left));
        Box<ExpressionV> right = new Box<>(processExpression(expression.right));
        switch(expression.binaryOp) {
          case Multiplication:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFMul(builder, getValue(left.v), getValue(right.v), "fmul"), left.v.type, false);
            } else {
              return new ExpressionV(LLVMBuildMul(builder, getValue(left.v), getValue(right.v), "imul"), left.v.type, false);
            }
          case Division:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFDiv(builder, getValue(left.v), getValue(right.v), "fdiv"), left.v.type, false);
            } else if(left.v.type.baseType.primitive.unsigned) {
              return new ExpressionV(LLVMBuildUDiv(builder, getValue(left.v), getValue(right.v), "uintdiv"), left.v.type, false);
            } else {
              return new ExpressionV(LLVMBuildSDiv(builder, getValue(left.v), getValue(right.v), "intdiv"), left.v.type, false);
            }
          case Modulo:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFRem(builder, getValue(left.v), getValue(right.v), "frem"), left.v.type, false);
            } else if(left.v.type.baseType.primitive.unsigned) {
              return new ExpressionV(LLVMBuildURem(builder, getValue(left.v), getValue(right.v), "uintrem"), left.v.type, false);
            } else {
              return new ExpressionV(LLVMBuildSRem(builder, getValue(left.v), getValue(right.v), "intrem"), left.v.type, false);
            }
          case Addition:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFAdd(builder, getValue(left.v), getValue(right.v), "fadd"), left.v.type, false);
            } else {
              return new ExpressionV(LLVMBuildAdd(builder, getValue(left.v), getValue(right.v), "intadd"), left.v.type, false);
            }
          case Subtraction:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFSub(builder, getValue(left.v), getValue(right.v), "fsub"), left.v.type, false);
            } else {
              return new ExpressionV(LLVMBuildSub(builder, getValue(left.v), getValue(right.v), "intsub"), left.v.type, false);
            }
          case LessThan:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFCmp(builder, LLVMRealOLT, getValue(left.v), getValue(right.v), "flt"), new Type(new BaseType(Primitive.Boolean), false), false);
            } else {
              return new ExpressionV(LLVMBuildICmp(builder, left.v.type.baseType.primitive.unsigned ? LLVMIntULT : LLVMIntSLT, getValue(left.v), getValue(right.v), "ilt"), new Type(new BaseType(Primitive.Boolean), false), false);
            }
          case LessEqualThan:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFCmp(builder, LLVMRealOLE, getValue(left.v), getValue(right.v), "fle"), new Type(new BaseType(Primitive.Boolean), false), false);
            } else {
              return new ExpressionV(LLVMBuildICmp(builder, left.v.type.baseType.primitive.unsigned ? LLVMIntULE : LLVMIntSLE, getValue(left.v), getValue(right.v), "ile"), new Type(new BaseType(Primitive.Boolean), false), false);
            }
          case GreaterThan:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFCmp(builder, LLVMRealOGT, getValue(left.v), getValue(right.v), "fgt"), new Type(new BaseType(Primitive.Boolean), false), false);
            } else {
              return new ExpressionV(LLVMBuildICmp(builder, left.v.type.baseType.primitive.unsigned ? LLVMIntUGT : LLVMIntSGT, getValue(left.v), getValue(right.v), "igt"), new Type(new BaseType(Primitive.Boolean), false), false);
            }
          case GreaterEqualThan:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFCmp(builder, LLVMRealOGE, getValue(left.v), getValue(right.v), "fge"), new Type(new BaseType(Primitive.Boolean), false), false);
            } else {
              return new ExpressionV(LLVMBuildICmp(builder, left.v.type.baseType.primitive.unsigned ? LLVMIntUGE : LLVMIntSGE, getValue(left.v), getValue(right.v), "ige"), new Type(new BaseType(Primitive.Boolean), false), false);
            }
          case Equals:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFCmp(builder, LLVMRealOEQ, getValue(left.v), getValue(right.v), "feq"), new Type(new BaseType(Primitive.Boolean), false), false);
            } else {
              return new ExpressionV(LLVMBuildICmp(builder, LLVMIntEQ, getValue(left.v), getValue(right.v), "ieq"), new Type(new BaseType(Primitive.Boolean), false), false);
            }
          case NotEquals:
            if(extendTypes(left, right)) {
              return new ExpressionV(LLVMBuildFCmp(builder, LLVMRealONE, getValue(left.v), getValue(right.v), "fne"), new Type(new BaseType(Primitive.Boolean), false), false);
            } else {
              return new ExpressionV(LLVMBuildICmp(builder, LLVMIntNE, getValue(left.v), getValue(right.v), "ine"), new Type(new BaseType(Primitive.Boolean), false), false);
            }
          case ShiftLeft:
            if(right.v.type.baseType.primitive.floating) throw new IllegalArgumentException("invalid shift");
            return new ExpressionV(LLVMBuildShl(builder, getValue(left.v), getValue(castType(right.v, left.v.type.baseType.primitive)), "shl"), left.v.type, false);
          case ShiftRight:
            if(right.v.type.baseType.primitive.floating) throw new IllegalArgumentException("invalid shift");
            return new ExpressionV(LLVMBuildAShr(builder, getValue(left.v), getValue(castType(right.v, left.v.type.baseType.primitive)), "ashr"), left.v.type, false);
          case ShiftLogicalRight:
            if(right.v.type.baseType.primitive.floating) throw new IllegalArgumentException("invalid shift");
            return new ExpressionV(LLVMBuildLShr(builder, getValue(left.v), getValue(castType(right.v, left.v.type.baseType.primitive)), "lshr"), left.v.type, false);
          case BitAnd:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            return new ExpressionV(LLVMBuildAnd(builder, getValue(left.v), getValue(right.v), "band"), left.v.type, false);
          case BitXor:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            return new ExpressionV(LLVMBuildXor(builder, getValue(left.v), getValue(right.v), "bxor"), left.v.type, false);
          case BitOr:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            return new ExpressionV(LLVMBuildOr(builder, getValue(left.v), getValue(right.v), "bor"), left.v.type, false);
          case And:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            if(left.v.type.baseType.primitive.bits != 1) throw new IllegalArgumentException("invalid types");
            return new ExpressionV(LLVMBuildAnd(builder, getValue(left.v), getValue(right.v), "and"), left.v.type, false);
          case Or:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            if(left.v.type.baseType.primitive.bits != 1) throw new IllegalArgumentException("invalid types");
            return new ExpressionV(LLVMBuildOr(builder, getValue(left.v), getValue(right.v), "or"), left.v.type, false);
          case Assign:
            if(!left.v.pointer) throw new IllegalArgumentException("not lvalue!");
            if(!(left.v.type.equals(right.v.type) && left.v.type.array)) {
              checkTypes(left, right);
            }
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignAddition:
            if(extendTypes(left, right)) {
              right.v = new ExpressionV(LLVMBuildFAdd(builder, getValue(left.v), getValue(right.v), "assfadd"), left.v.type, false);
            } else {
              right.v = new ExpressionV(LLVMBuildAdd(builder, getValue(left.v), getValue(right.v), "assintadd"), left.v.type, false);
            }
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignSubtraction:
            if(extendTypes(left, right)) {
              right.v = new ExpressionV(LLVMBuildFSub(builder, getValue(left.v), getValue(right.v), "assfsub"), left.v.type, false);
            } else {
              right.v = new ExpressionV(LLVMBuildSub(builder, getValue(left.v), getValue(right.v), "assisub"), left.v.type, false);
            }
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignMultiplication:
            if(extendTypes(left, right)) {
              right.v = new ExpressionV(LLVMBuildFMul(builder, getValue(left.v), getValue(right.v), "assfmul"), left.v.type, false);
            } else {
              right.v = new ExpressionV(LLVMBuildMul(builder, getValue(left.v), getValue(right.v), "assimul"), left.v.type, false);
            }
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignDivision:
            if(extendTypes(left, right)) {
              right.v = new ExpressionV(LLVMBuildFDiv(builder, getValue(left.v), getValue(right.v), "assfdiv"), left.v.type, false);
            } else if(left.v.type.baseType.primitive.unsigned) {
              right.v = new ExpressionV(LLVMBuildUDiv(builder, getValue(left.v), getValue(right.v), "assuintdiv"), left.v.type, false);
            } else {
              right.v = new ExpressionV(LLVMBuildSDiv(builder, getValue(left.v), getValue(right.v), "assintdiv"), left.v.type, false);
            }
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignModulo:
            if(extendTypes(left, right)) {
              right.v = new ExpressionV(LLVMBuildFRem(builder, getValue(left.v), getValue(right.v), "assfrem"), left.v.type, false);
            } else if(left.v.type.baseType.primitive.unsigned) {
              right.v = new ExpressionV(LLVMBuildURem(builder, getValue(left.v), getValue(right.v), "assuintrem"), left.v.type, false);
            } else {
              right.v = new ExpressionV(LLVMBuildSRem(builder, getValue(left.v), getValue(right.v), "assintrem"), left.v.type, false);
            }
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignBitAnd:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            right.v = new ExpressionV(LLVMBuildAnd(builder, getValue(left.v), getValue(right.v), "assband"), left.v.type, false);
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignBitOr:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            right.v = new ExpressionV(LLVMBuildOr(builder, getValue(left.v), getValue(right.v), "assbor"), left.v.type, false);
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignBitXor:
            if(extendTypes(left, right)) throw new IllegalArgumentException("invalid types");
            right.v = new ExpressionV(LLVMBuildXor(builder, getValue(left.v), getValue(right.v), "assbxor"), left.v.type, false);
            checkTypes(left, right);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignShiftLeft:
            if(right.v.type.baseType.primitive.floating) throw new IllegalArgumentException("invalid shift");
            right.v = new ExpressionV(LLVMBuildShl(builder, getValue(left.v), getValue(castType(right.v, left.v.type.baseType.primitive)), "assshl"), left.v.type, false);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignShiftRight:
            if(right.v.type.baseType.primitive.floating) throw new IllegalArgumentException("invalid shift");
            right.v = new ExpressionV(LLVMBuildAShr(builder, getValue(left.v), getValue(castType(right.v, left.v.type.baseType.primitive)), "assashr"), left.v.type, false);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          case AssignShiftLogicalRight:
            if(right.v.type.baseType.primitive.floating) throw new IllegalArgumentException("invalid shift");
            right.v = new ExpressionV(LLVMBuildLShr(builder, getValue(left.v), getValue(castType(right.v, left.v.type.baseType.primitive)), "asslshr"), left.v.type, false);
            LLVMBuildStore(builder, getValue(right.v), getPointer(left.v));
            return left.v;
          default: throw new IllegalArgumentException("unknown operator");
        }
      default: throw new IllegalArgumentException("invalid expr type");
    }
  }
  
  private ExpressionV castType(ExpressionV base, Primitive cast) {
    Primitive primitive = base.type.baseType.primitive;
    if(cast == primitive) return base;
    ExpressionV nex = new ExpressionV(base.rawValue, new Type(new BaseType(cast), false), false);
    if(cast.floating) {
      if(primitive.floating) {
        if(primitive.bits < cast.bits) {
          nex.rawValue = LLVMBuildFPExt(builder, getValue(base), getPrimitiveType(cast), "floatcast");
        } else {
          nex.rawValue = LLVMBuildFPTrunc(builder, getValue(base), getPrimitiveType(cast), "floatcast");
        }
      } else {
        if(primitive.unsigned) {
          nex.rawValue = LLVMBuildUIToFP(builder, getValue(base), getPrimitiveType(cast), "uinttofloatcast");
        } else {
          nex.rawValue = LLVMBuildSIToFP(builder, getValue(base), getPrimitiveType(cast), "inttofloatcast");
        }
      }
    } else {
      if(primitive.floating) {
        if(cast.unsigned) {
          nex.rawValue = LLVMBuildFPToUI(builder, getValue(base), getPrimitiveType(cast), "floattouintcast");
        } else {
          nex.rawValue = LLVMBuildFPToSI(builder, getValue(base), getPrimitiveType(cast), "floattointcast");
        }
      } else {
        if(primitive.bits < cast.bits) {
          if(primitive.unsigned) {
            nex.rawValue = LLVMBuildZExt(builder, getValue(base), getPrimitiveType(cast), "uintcast");
          } else {
            nex.rawValue = LLVMBuildSExt(builder, getValue(base), getPrimitiveType(cast), "intcast");
          }
        } else if(primitive.bits != cast.bits) {
          nex.rawValue = LLVMBuildTrunc(builder, getValue(base), getPrimitiveType(cast), "intcast");
        }
      }
    }
    return nex;
  }
  
  private void checkTypes(Box<ExpressionV> left, Box<ExpressionV> right) {
    if(left.v.type.equals(right.v.type)) return;
    if(left.v.type.array || right.v.type.array) throw new IllegalArgumentException("invalid types");
    if(left.v.type.baseType.type == BaseType.Type.Class || right.v.type.baseType.type == BaseType.Type.Class) throw new IllegalArgumentException("invalid types");
    Primitive lPrim = left.v.type.baseType.primitive;
    Primitive rPrim = right.v.type.baseType.primitive;
    if(lPrim == rPrim) return;
    ExpressionV nRight = new ExpressionV(null, left.v.type, false);
    if(lPrim.floating) {
      if(rPrim.floating) {
        if(lPrim.bits < rPrim.bits) throw new IllegalArgumentException("invalid types");
        nRight.rawValue = LLVMBuildFPExt(builder, getValue(right.v), getPrimitiveType(lPrim), "floatcast");
        right.v = nRight;
        return;
      }
      if(rPrim.unsigned) {
        nRight.rawValue = LLVMBuildUIToFP(builder, getValue(right.v), getPrimitiveType(lPrim), "uinttofloatcast");
      } else {
        nRight.rawValue = LLVMBuildSIToFP(builder, getValue(right.v), getPrimitiveType(lPrim), "inttofloatcast");
      }
      right.v = nRight;
      return;
    }
    if(lPrim.bits <= rPrim.bits) throw new IllegalArgumentException("invalid types");
    if(rPrim.floating) throw new IllegalArgumentException("invalid types");
    if(rPrim.unsigned) {
      nRight.rawValue = LLVMBuildZExt(builder, getValue(right.v), getPrimitiveType(lPrim), "uintcast");
    } else {
      nRight.rawValue = LLVMBuildSExt(builder, getValue(right.v), getPrimitiveType(lPrim), "intcast");
    }
    right.v = nRight;
  }
  
  /**
   * @return true if types are (now) floating point
   */
  private boolean extendTypes(Box<ExpressionV> left, Box<ExpressionV> right) {
    if(left.v.type.array || right.v.type.array) throw new IllegalArgumentException("invalid types");
    if(left.v.type.baseType.type == BaseType.Type.Class || right.v.type.baseType.type == BaseType.Type.Class) throw new IllegalArgumentException("invalid types");
    Primitive lPrim = left.v.type.baseType.primitive;
    Primitive rPrim = right.v.type.baseType.primitive;
    if(lPrim == rPrim) return lPrim.floating;
    if(!lPrim.floating && !rPrim.floating && lPrim.unsigned != rPrim.unsigned && lPrim.bits == rPrim.bits && lPrim.bits != 1) throw new IllegalArgumentException("invalid types");
    if(lPrim.floating != rPrim.floating) {
      Box<ExpressionV> cast;
      ExpressionV other;
      if(rPrim.floating) {
        cast = left; other = right.v;
      } else {
        cast = right; other = left.v;
      }
      ExpressionV nCast = new ExpressionV(null, other.type, false);
      if(cast.v.type.baseType.primitive.unsigned) {
        nCast.rawValue = LLVMBuildUIToFP(builder, getValue(cast.v), getPrimitiveType(other.type.baseType.primitive), "uinttofloatcast");
      } else {
        nCast.rawValue = LLVMBuildSIToFP(builder, getValue(cast.v), getPrimitiveType(other.type.baseType.primitive), "inttofloatcast");
      }
      cast.v = nCast;
      return true;
    }
    Box<ExpressionV> lowest;
    ExpressionV highest;
    if(lPrim.bits < rPrim.bits) {
      lowest = left; highest = right.v;
    } else {
      lowest = right; highest = left.v;
    }
    ExpressionV nLow = new ExpressionV(null, highest.type, false);
    if(lPrim.floating) {
      nLow.rawValue = LLVMBuildFPExt(builder, getValue(lowest.v), getPrimitiveType(highest.type.baseType.primitive), "floatcast");
      lowest.v = nLow;
      return true;
    }
    if(lowest.v.type.baseType.primitive.unsigned) {
      nLow.rawValue = LLVMBuildZExt(builder, getValue(lowest.v), getPrimitiveType(highest.type.baseType.primitive), "uintcast");
    } else {
      nLow.rawValue = LLVMBuildSExt(builder, getValue(lowest.v), getPrimitiveType(highest.type.baseType.primitive), "intcast");
    }
    lowest.v = nLow;
    return false;
  }
  
  private void processStatement(Statement statement) {
    LLVMValueRef function = LLVMGetBasicBlockParent(LLVMGetInsertBlock(builder));
    switch (statement.type) {
      case Return:
        LLVMBuildRet(builder, getValue(processExpression(statement.returz)));
        break;
      case Continue:
        LLVMBuildBr(builder, labels.get(labels.size() - statement.shift).block);
        break;
      case Break:
        LLVMBuildBr(builder, LLVMGetNextBasicBlock(labels.get(labels.size() - statement.shift).after));
        break;
      case If:
        LLVMBasicBlockRef merge = LLVMAppendBasicBlock(function, "ifcont");
        for(IfBlock block : statement.ifs) {
          if(block.condition != null) {
            LLVMValueRef condValue = processCondition(block.condition);
            LLVMBasicBlockRef then = LLVMAppendBasicBlock(function, "then");
            LLVMBasicBlockRef elsz = LLVMAppendBasicBlock(function, "else");
            LLVMBuildCondBr(builder, condValue, then, elsz);
            LLVMPositionBuilderAtEnd(builder, then);
            for(Statement blockStatement : block.body) {
              processStatement(blockStatement);
            }
            if(LLVMIsAReturnInst(LLVMGetLastInstruction(LLVMGetInsertBlock(builder))) == null) {
              LLVMBuildBr(builder, merge);
            }
            LLVMPositionBuilderAtEnd(builder, elsz);
          } else {
            for(Statement blockStatement : block.body) {
              processStatement(blockStatement);
            }
          }
        }
        if(LLVMIsAReturnInst(LLVMGetLastInstruction(LLVMGetInsertBlock(builder))) == null) {
          LLVMBuildBr(builder, merge);
        }
        LLVMPositionBuilderAtEnd(builder, merge);
        break;
      case For:
        // todo
        break;
      case While:
        LLVMBasicBlockRef whilz = LLVMAppendBasicBlock(function, "while");
        LLVMBasicBlockRef after = LLVMAppendBasicBlock(function, "whileafter");
        labels.add(new Label(whilz, after));
        LLVMValueRef condValue = processCondition(statement.condition);
        LLVMBuildCondBr(builder, condValue, whilz, after);
        LLVMPositionBuilderAtEnd(builder, whilz);
        condValue = processCondition(statement.condition);
        for(Statement blockStatement : statement.body) {
          processStatement(blockStatement);
        }
        if(LLVMIsAReturnInst(LLVMGetLastInstruction(LLVMGetInsertBlock(builder))) == null) {
          LLVMBuildCondBr(builder, condValue, whilz, after);
        }
        LLVMPositionBuilderAtEnd(builder, after);
        labels.remove(labels.size() - 1);
        break;
      case Variable:
        LLVMTypeRef variableType;
        if(statement.variableDeclaration.variableType.array) {
          variableType = LLVMPointerType(LLVMInt8Type(), 0);
        } else {
          if(statement.variableDeclaration.variableType.baseType.type == BaseType.Type.Class) {
            variableType = LLVMGetTypeByName(module, statement.variableDeclaration.variableType.baseType.clazz);
          } else {
            variableType = getPrimitiveType(statement.variableDeclaration.variableType.baseType.primitive);
          }
        }
        LLVMValueRef variable = alloca(LLVMGetBasicBlockParent(LLVMGetInsertBlock(builder)), variableType, "alloca");
        Box<ExpressionV> expression = new Box<>(new ExpressionV(variable, statement.variableDeclaration.variableType, true));
        if(statement.variableDeclaration.value != null) {
          Box<ExpressionV> value = new Box<>(processExpression(statement.variableDeclaration.value));
          checkTypes(expression, value);
          LLVMBuildStore(builder, getValue(value.v), getPointer(expression.v));
        }
        stack.get(stack.size()-1).put(statement.variableDeclaration.id, expression.v);
        break;
      case Expression:
        processExpression(statement.expression);
        break;
      case Free:
        ExpressionV free = processExpression(statement.expression);
        if(!free.pointer) throw new IllegalArgumentException("invalid free");
        if(free.type.array) {
          LLVMBuildFree(builder, getValue(free));
        } else if(free.type.baseType.type != BaseType.Type.Class) {
          throw new IllegalArgumentException("invalid free");
        } else {
          Declaration clazz = clazzsDeclarations.get(free.type.baseType.clazz);
          List<LLVMValueRef> offsets = new ArrayList<>();
          offsets.add(LLVMConstInt(LLVMInt32Type(), 0, 0));
          processFree(free, offsets, clazz);
        }
        break;
    }
  }
  
  private void processFree(ExpressionV base, List<LLVMValueRef> offsets, Declaration clazz) {
    int i=0;
    for(Declaration declaration : clazz.body) {
      if(declaration.type != Declaration.Type.Variable) continue;
      if(!declaration.instance) continue;
      if(declaration.variableType.array) {
        offsets.add(LLVMConstInt(LLVMInt32Type(), i, 0));
        LLVMBuildFree(builder, LLVMBuildLoad(builder, LLVMBuildGEP(builder, base.rawValue, pointer(offsets), offsets.size(), "freegep"), "freeload"));
        offsets.remove(offsets.size()-1);
      } else if(declaration.variableType.baseType.type == BaseType.Type.Class) {
        offsets.add(LLVMConstInt(LLVMInt32Type(), i, 0));
        processFree(base, offsets, clazzsDeclarations.get(declaration.variableType.baseType.clazz));
        offsets.remove(offsets.size()-1);
      }
      ++i;
    }
  }
  
  private void processFunctionPrototype(Declaration declaration) {
    List<LLVMTypeRef> parameterTypes;
    if(declaration.statements == null) {
      parameterTypes = new ArrayList<>(declaration.parameters.size());
      for(Parameter parameter : declaration.parameters) {
        if(parameter.type.baseType.type == BaseType.Type.Class) throw new IllegalArgumentException("invalid external param");
        parameterTypes.add(getType(parameter.type));
      }
      if(declaration.returnType.array || declaration.returnType.baseType.type == BaseType.Type.Class) throw new IllegalArgumentException("invalid external return");
      LLVMTypeRef functionType = LLVMFunctionType(getPrimitiveType(declaration.returnType.baseType.primitive), pointer(parameterTypes), parameterTypes.size(), 0);
      String functionId = declaration.id;
      LLVMAddFunction(module, functionId, functionType);
      return;
    }
    if(declaration.parentId != null) {
      parameterTypes = new ArrayList<>(declaration.parameters.size() + 1);
      parameterTypes.add(LLVMPointerType(LLVMGetTypeByName(module, declaration.parentId), 0));
    } else {
      parameterTypes = new ArrayList<>(declaration.parameters.size());
    }
    for(Parameter parameter : declaration.parameters) {
      parameterTypes.add(LLVMPointerType(getType(parameter.type), 0));
    }
  
    LLVMTypeRef functionType = LLVMFunctionType(getType(declaration.returnType), pointer(parameterTypes), parameterTypes.size(), 0);
    String functionId = (declaration.parentId != null ? (declaration.parentId + "_") : "_main_") + declaration.id;
    LLVMValueRef function = LLVMAddFunction(module, functionId, functionType);
    int i = 0;
    if(declaration.parentId != null) {
      LLVMSetValueName(LLVMGetParam(function, i++), "self");
    }
    for(Parameter parameter : declaration.parameters) {
      LLVMSetValueName(LLVMGetParam(function, i++), parameter.id);
    }
  }
  
  private void processFunctionBody(Declaration declaration) {
    if(declaration.statements == null) return;
    classId = declaration.parentId;
    LLVMValueRef function = getFunction(declaration);
    LLVMBasicBlockRef basicBlock = LLVMAppendBasicBlock(function, "entry");
    LLVMPositionBuilderAtEnd(builder, basicBlock);
    
    if(classId != null) {
      Map<String, ExpressionV> scope = new HashMap<>();
      stack.add(scope);
      int i = 0;
      for(Declaration variable : clazzsDeclarations.get(classId).body) {
        if(variable.type != Declaration.Type.Variable) continue;
        if(variable.instance) {
          scope.put(variable.id, new ExpressionV(LLVMBuildStructGEP(builder, LLVMGetParam(function, 0), i, "paramgep"), variable.variableType, true));
          ++i;
        } else {
          scope.put(variable.id, new ExpressionV(LLVMGetNamedGlobal(module, "_" + classId + "_" + variable.id), variable.variableType, true));
        }
      }
      
    }
  
    Map<String, ExpressionV> scope = new HashMap<>();
    stack.add(scope);
    
    int i = 0;
    if(classId != null) {
      scope.put("%", new ExpressionV(LLVMGetParam(function, 0), new Type(new BaseType(classId), false), true));
      ++i;
    }
    for(Parameter parameter : declaration.parameters) {
      scope.put(parameter.id, new ExpressionV(LLVMGetParam(function, i++), parameter.type, true));
    }
  
    for(Statement statement : declaration.statements) {
      processStatement(statement);
    }
    
    stack.remove(stack.size() - 1);
    if(classId != null) {
      stack.remove(stack.size() - 1);
    }
  
    if(declaration.returnType == null) {
      LLVMBuildRetVoid(builder);
    } else if(LLVMIsAReturnInst(LLVMGetLastInstruction(LLVMGetInsertBlock(builder))) == null) {
      LLVMBuildUnreachable(builder);
    }
  
    if(LLVMVerifyFunction(function, LLVMPrintMessageAction) != 0) {
      System.err.println("savapa " + declaration.id);
    }
  
  }
  
  private LLVMValueRef alloca(LLVMValueRef function, LLVMTypeRef type, String name) {
    LLVMBuilderRef builder = LLVMCreateBuilder();
    LLVMPositionBuilder(builder, LLVMGetEntryBasicBlock(function), LLVMGetFirstInstruction(LLVMGetEntryBasicBlock(function)));
    LLVMValueRef value = LLVMBuildAlloca(builder, type, name);
    LLVMDisposeBuilder(builder);
    return value;
  }
  
  private void translate(List<Declaration> declarations) throws Exception {
    BytePointer error = new BytePointer((Pointer)null);
    
    module = LLVMModuleCreateWithName("sxlang");
    builder = LLVMCreateBuilder();
  
    for(Declaration declaration : declarations) {
      switch(declaration.type) {
        case Type:
          clazzsDeclarations.put(declaration.id, declaration);
          for(Declaration function : declaration.body) {
            if(function.type != Declaration.Type.Function) continue;
            functionDeclarations.put(declaration.statements == null ? declaration.id : (declaration.id + "_" + function.id), function);
          }
          break;
        case Function:
          functionDeclarations.put(declaration.statements == null ? declaration.id : ("_main_" + declaration.id), declaration);
          break;
        default:
      }
    }
    
    for(Declaration declaration : clazzsDeclarations.values()) {
      processClass(new HashSet<>(), declaration);
    }
  
    for(Declaration declaration : functionDeclarations.values()) {
      processFunctionPrototype(declaration);
    }
    
    for(Declaration declaration : functionDeclarations.values()) {
      processFunctionBody(declaration);
    }
  
    LLVMTypeRef mainType;
    Declaration declaration = functionDeclarations.get("_main_main");
    if(declaration.returnType == null) {
      mainType = null;
    } else if(!declaration.returnType.array && declaration.returnType.baseType.type == BaseType.Type.Primitive && !declaration.returnType.baseType.primitive.floating) {
      mainType = getPrimitiveType(declaration.returnType.baseType.primitive);
    } else {
      throw new IllegalArgumentException("invalid main return value");
    }
    LLVMTypeRef functionType = LLVMFunctionType(mainType==null?LLVMVoidType():mainType, new PointerPointer(), 0, 0);
    LLVMValueRef function = LLVMAddFunction(module, "main", functionType);
    LLVMBasicBlockRef basicBlock = LLVMAppendBasicBlock(function, "entry");
    LLVMPositionBuilderAtEnd(builder, basicBlock);
    if(mainType == null) {
      LLVMBuildCall(builder, LLVMGetNamedFunction(module, "_main_main"), new PointerPointer(), 0, "");
      LLVMBuildRetVoid(builder);
    } else  {
      LLVMBuildRet(builder, LLVMBuildCall(builder, LLVMGetNamedFunction(module, "_main_main"), new PointerPointer(), 0, ""));
    }
  
    if(LLVMVerifyModule(module, LLVMPrintMessageAction, error) != 0) {
      System.err.println(error.getString());
      LLVMDisposeMessage(error);
    }
  
    LLVMDumpModule(module);
    
    LLVMPassManagerRef passManager = LLVMCreatePassManager();
    LLVMAddVerifierPass(passManager);
    LLVMAddInstructionCombiningPass(passManager);
    LLVMAddReassociatePass(passManager);
    LLVMAddGVNPass(passManager);
    LLVMAddBasicAliasAnalysisPass(passManager);
    LLVMAddPromoteMemoryToRegisterPass(passManager);
    LLVMAddInstructionCombiningPass(passManager);
    LLVMAddReassociatePass(passManager);
    LLVMInitializeFunctionPassManager(passManager);
    
    LLVMRunPassManager(passManager, module);
    
    LLVMInitializeNativeTarget();
    LLVMTargetRef target = new LLVMTargetRef();
    if(LLVMGetTargetFromTriple(triple, target, error) != 0) {
      System.err.println(error.getString());
      LLVMDisposeMessage(error);
    }
    LLVMTargetMachineRef machine = LLVMCreateTargetMachine(target, triple, new BytePointer(""), new BytePointer(""), LLVMCodeGenLevelNone, this.target[2].equals("linux") ? LLVMRelocPIC : LLVMRelocDefault, LLVMCodeModelDefault);
    LLVMInitializeNativeAsmPrinter();
    LLVMInitializeNativeAsmParser();
    LLVMTargetMachineEmitToFile(machine, module, new BytePointer("sxlang.o"), LLVMObjectFile, error);
    System.err.println(error.getString());
    LLVMDisposeMessage(error);
    LLVMDisposeMessage(triple);
    
    LLVMDumpModule(module);
    
    LLVMDisposePassManager(passManager);
    LLVMDisposeBuilder(builder);
    LLVMDisposeModule(module);
  }
  
  private List<Declaration> parse(String... args) throws Exception {
    if(args.length == 0) {
      System.out.println(HELP);
      System.out.println(USAGE);
      return null;
    }
    for(String arg : args) {
      if(arg.startsWith("-")) {
        System.err.println("Unsupported option: " + arg);
        System.err.println(USAGE);
        return null;
      }
    }
    List<Declaration> declarations = null;
    for(String arg : args) {
      System.out.println("Parsing file " + arg + " ...");
      try(InputStream in = new BufferedInputStream(Files.newInputStream(Paths.get(arg)))) {
        CharStream stream = CharStreams.fromStream(in);
        SxlangLexer lexer = new SxlangLexer(stream);
        lexer.target = target;
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SxlangParser parser = new SxlangParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        List<Declaration> fileDeclarations = parser.file().v;
        if(declarations == null) declarations = fileDeclarations;
        else declarations.addAll(fileDeclarations);
      } catch(IOException ex) {
        System.err.println("Error while reading file: " + arg);
        ex.printStackTrace();
      } catch(RecognitionException ex) {
        System.err.println("Error while parsing file: " + arg);
        ex.printStackTrace();
      } catch(ParseCancellationException ex) {
        System.err.println("Error while parsing file: " + arg);
        ex.getCause().printStackTrace();
      }
    }
    return declarations;
  }
  
  public static void main(String... args) throws Exception {
    new Sxlang().start(args);
  }
}
