package fr.delthas.sxlang.types;

import java.util.ArrayList;
import java.util.List;

public class Expression {
  
  public enum Type {
    Literal,
    Cast,
    Asm,
    UnknownId,
    This,
    BlockArrayLength,
    ArrayLength,
    Method,
    Field,
    Array,
    FunctionCall,
    ExternalCall,
    UnaryOp,
    BinaryOp,
  }
  
  public Type type;
  public Literal literal;
  public Expression base;
  public Primitive cast;
  public String data;
  public String constraints;
  public Expression index;
  public BaseType returnType;
  public List<Expression> parameters;
  public UnaryOp unaryOp;
  public BinaryOp binaryOp;
  public Expression left;
  public Expression right;
  
  private Expression(Type type) {
    this.type = type;
  }
  
  public static Expression literal(Literal literal) {
    Expression expression = new Expression(Type.Literal);
    expression.literal = literal;
    return expression;
  }
  
  public static Expression cast(Primitive primitive, Expression base) {
    Expression expression = new Expression(Type.Cast);
    expression.cast = primitive;
    expression.base = base;
    return expression;
  }
  
  public static Expression asm(BaseType returnType, List<Expression> parameters, String constraints, String asm) {
    Expression expression = new Expression(Type.Asm);
    expression.returnType = returnType;
    expression.parameters = parameters;
    expression.data = asm;
    expression.constraints = constraints;
    return expression;
  }
  
  public static Expression unknownId(String id) {
    Expression expression = new Expression(Type.UnknownId);
    expression.data = id;
    return expression;
  }
  
  public static Expression thiz() {
    Expression expression = new Expression(Type.This);
    return expression;
  }
  
  public static Expression arrayLength(Expression base) {
    Expression expression = new Expression(Type.ArrayLength);
    expression.base = base;
    return expression;
  }
  public static Expression blockArrayLength() {
    Expression expression = new Expression(Type.BlockArrayLength);
    return expression;
  }
  
  public static Expression methodOrField(Expression base, String method) {
    Expression expression = new Expression(Type.Field);
    expression.base = base;
    expression.data = method;
    return expression;
  }
  
  public static Expression array(Expression base, Expression index) {
    Expression expression = new Expression(Type.Array);
    expression.base = base;
    expression.index = index;
    return expression;
  }
  
  public static Expression functionCall(Expression base, List<Expression> parameters) {
    Expression expression = new Expression(Type.FunctionCall);
    expression.base = base;
    expression.parameters = parameters;
    return expression;
  }
  
  public static Expression externalCall(String id, List<Expression> parameters) {
    Expression expression = new Expression(Type.ExternalCall);
    expression.data = id;
    expression.parameters = parameters==null?new ArrayList<>(0):parameters;
    return expression;
  }
  
  public static Expression unaryOp(Expression base, UnaryOp unaryOp) {
    Expression expression = new Expression(Type.UnaryOp);
    expression.base = base;
    expression.unaryOp = unaryOp;
    return expression;
  }
  
  public static Expression binaryOp(Expression left, Expression right, BinaryOp binaryOp) {
    Expression expression = new Expression(Type.BinaryOp);
    expression.left = left;
    expression.right = right;
    expression.binaryOp = binaryOp;
    return expression;
  }
}
