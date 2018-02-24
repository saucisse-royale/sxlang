grammar Sxlang;

@parser::header {
import java.util.*;
import fr.delthas.sxlang.types.*;
import static fr.delthas.sxlang.SxlangAux.*;
}

@lexer::header {
import java.util.*;
import fr.delthas.sxlang.types.*;
import static fr.delthas.sxlang.SxlangAux.*;
}

@lexer::members {
  public String[] target;
  private boolean asm;
  private boolean platform;
  private boolean ignore;
  private int ignoreBrackets=-1;
  private boolean validSpec;
  private PlatformKey platformKey;
  int lastTokenType = 0;
  public void emit(Token token) {
      super.emit(token);
      lastTokenType = token.getType();
  }
  private static PlatformKey getPlatformKey(String id) {
    if(id == null) return null;
    switch(id) {
      case "arch": return PlatformKey.Arch;
      case "vendor": return PlatformKey.Vendor;
      case "sys": return PlatformKey.Sys;
      case "abi": return PlatformKey.Abi;
      default: return null;
    }
  }
  private void checkPlatform(PlatformKey key, String value) {
    if(!validSpec) return;
    switch(key) {
      case Arch:
        if(!target[0].startsWith(value)) validSpec=false;
        return;
      case Vendor:
        if(!target[1].equals(value)) validSpec=false;
        return;
      case Sys:
        if(!target[2].equals(value)) validSpec=false;
        return;
      case Abi:
        if(!target[3].equals(value)) validSpec=false;
        return;
      default: throw new IllegalArgumentException("invalid platform key");
    }
  }
}

@parser::members {
  private static UnaryOp getPre(String id) {
    switch(id) {
      case "++": return UnaryOp.PreIncrement;
      case "--": return UnaryOp.PreDecrement;
      case "+": return UnaryOp.PrePlus;
      case "-": return UnaryOp.PreMinus;
      case "!": return UnaryOp.Not;
      default: return null;
    }
  }
  private static UnaryOp getPost(String id) {
    switch(id) {
      case "++": return UnaryOp.PostIncrement;
      case "--": return UnaryOp.PostDecrement;
      default: return null;
    }
  }
  private static BinaryOp getBin(String id) {
    switch(id) {
      case "*": return BinaryOp.Multiplication;
      case "/": return BinaryOp.Division;
      case "%": return BinaryOp.Modulo;
      case "+": return BinaryOp.Addition;
      case "-": return BinaryOp.Subtraction;
      case "<": return BinaryOp.LessThan;
      case "<=": return BinaryOp.LessEqualThan;
      case ">": return BinaryOp.GreaterThan;
      case ">=": return BinaryOp.GreaterEqualThan;
      case "==": return BinaryOp.Equals;
      case "!=": return BinaryOp.NotEquals;
      case "<<": return BinaryOp.ShiftLeft;
      case ">>": return BinaryOp.ShiftRight;
      case ">>>": return BinaryOp.ShiftLogicalRight;
      case "&": return BinaryOp.BitAnd;
      case "^": return BinaryOp.BitXor;
      case "|": return BinaryOp.BitOr;
      case "&&": return BinaryOp.And;
      case "||": return BinaryOp.Or;
      case "=": return BinaryOp.Assign;
      case "+=": return BinaryOp.AssignAddition;
      case "-=": return BinaryOp.AssignSubtraction;
      case "*=": return BinaryOp.AssignMultiplication;
      case "/=": return BinaryOp.AssignDivision;
      case "%=": return BinaryOp.AssignModulo;
      case "&=": return BinaryOp.AssignBitAnd;
      case "|=": return BinaryOp.AssignBitOr;
      case "^=": return BinaryOp.AssignBitXor;
      case "<<=": return BinaryOp.AssignShiftLeft;
      case ">>=": return BinaryOp.AssignShiftRight;
      case ">>>=": return BinaryOp.AssignShiftLogicalRight;
      default: return null;
    }
  }
  private static ParameterOption getOpt(String id) {
    if(id == null) return ParameterOption.Value;
    switch(id) {
      case "~~": return ParameterOption.Clone;
      case "~": return ParameterOption.Copy;
      case "": return ParameterOption.Value;
      default: return null;
    }
  }
  private static Primitive getNum(String id) {
    if(id == null) return null;
    switch(id) {
      case "b": return Primitive.Byte;
      case "u-": return Primitive.UInt16;
      case "u": return Primitive.UInt32;
      case "u+": return Primitive.UInt64;
      case "i-": return Primitive.Int16;
      case "i": return Primitive.Int32;
      case "i+": return Primitive.Int64;
      case "f": return Primitive.Float32;
      case "f+": return Primitive.Float64;
      default: return null;
    }
  }
  private static String unescape(String string) {
    if(string == null) return null;
    StringBuilder sb = new StringBuilder(string.length());
    for(int i=1;i<string.length()-1;++i) {
      char ch = string.charAt(i);
      if (ch == '\\') {
        char nextChar = string.charAt(++i);
        switch (nextChar) {
          case '\\': ch = '\\'; break;
          case 'n': ch = '\n'; break;
          case 'r': ch = '\r'; break;
          case 't': ch = '\t'; break;
          case '\"': ch = '\"'; break;
          default: throw new IllegalArgumentException(string);
        }
      }
      sb.append(ch);
    }
    return sb.toString();
  }
  private static String unescapeAsm(String string) {
    if(string == null) return null;
    StringBuilder sb = new StringBuilder(string.length());
    for(int i=1;i<string.length()-1;++i) {
      char ch = string.charAt(i);
      if (ch == '\\') {
        char nextChar = string.charAt(++i);
        switch (nextChar) {
          case '\\': ch = '\\'; break;
          case '}': ch = '}'; break;
          default: throw new IllegalArgumentException(string);
        }
      }
      sb.append(ch);
    }
    return sb.toString();
  }
  private String parentId;
}

file returns [List<Declaration> v]: (v_+=declaration | NEWLINE)* EOF {$v = map($v_);};

declaration returns [Declaration v]:
  v0=typeDeclaration {$v = $v0.v;}
| v1=functionDeclaration {$v = $v1.v;}
| v2=variableDeclaration {$v = $v2.v;};


typeDeclaration returns [Declaration v]:
id=classId {parentId = $id.v;} ASSEQ unoverridable=HASH? DOLLAR (extendz+=classId)* LEFT_BRACKET (b0+=functionDeclaration | b1+=variableDeclaration | NEWLINE)* RIGHT_BRACKET
{parentId = null;}
{$v = Declaration.type($id.v, $unoverridable != null, map($extendz), map($b0,$b1));};


functionDeclaration returns [Declaration v]:
hasBody+=HASH? (id1+=classId | id2+=functionId) ASSEQ (params+=parameter)* ARROW instance=PERCENT? returz+=type? (LEFT_BRACKET (body+=functionStatement | NEWLINE)* RIGHT_BRACKET)?
{$v = Declaration.function(or($id1,$id2), parentId, map($params), $instance != null, opt($returz), $hasBody.isEmpty()?map($body):null);};

variableDeclaration returns [Declaration v]:
mutable=HASH? instance=PERCENT? id=variableId COLONCOLON typ=type ASSEQ (UNDERSCORE | value+=expression)
{$v = Declaration.variable($id.v, $mutable != null, $instance != null, opt($value), $typ.v);};

functionStatement returns [Statement v] :
LEFT_SQUARE_BRACKET free=expression RIGHT_SQUARE_BRACKET NEWLINE
{$v = Statement.free($free.v);}
| iz=ifBlock (ez+=elseIfBlock)* elsz+=elseBlock? NEWLINE
{$v = Statement.ifs(chain($iz.v, map($ez), opt($elsz)));}
| AT wcond=expression LEFT_BRACKET (wbody+=functionStatement | NEWLINE)* RIGHT_BRACKET NEWLINE
{$v = Statement.whilz($wcond.v, map($wbody));}
| AT fid=variableId COLON fiter=expression LEFT_BRACKET (fbody+=functionStatement | NEWLINE)* RIGHT_BRACKET NEWLINE
{$v = Statement.foz($fid.v, $fiter.v, map($fbody));}
| PARAGRAPH re=expression NEWLINE
{$v = Statement.returz($re.v);}
| cs=RIGHT_ANGLE+ NEWLINE
{$v = Statement.continuz($cs.text.length());}
| bs=LEFT_ANGLE+ NEWLINE
{$v = Statement.breaz($bs.text.length());}
| var=variableDeclaration NEWLINE
{$v = Statement.variable($var.v);}
| e=expression NEWLINE
{$v = Statement.expression($e.v);};

ifBlock returns [IfBlock v]:
cond=expression INTERRO LEFT_BRACKET (body+=functionStatement | NEWLINE)* RIGHT_BRACKET
{$v = new IfBlock($cond.v, map($body));};

elseIfBlock returns [IfBlock v]:
cond=expression INTERROCOLON LEFT_BRACKET (body+=functionStatement | NEWLINE)* RIGHT_BRACKET
{$v = new IfBlock($cond.v, map($body));};

elseBlock returns [IfBlock v]:
COLON LEFT_BRACKET (body+=functionStatement | NEWLINE)* RIGHT_BRACKET
{$v = new IfBlock(null, map($body));};

expressionList returns [List<Expression> v]:
e+=expression (COMMA e+=expression)*
{$v = map($e);};

expression returns [Expression v]:
LEFT_PAREN expression RIGHT_PAREN
{$v = $expression.v;}
| LEFT_SQUARE_BRACKET cast=numberType EQUALS expression RIGHT_SQUARE_BRACKET
{$v = Expression.cast($cast.v, $expression.v);}
| ASM_START (LEFT_PAREN (ret+=baseType | UNDERSCORE) (COMMA param+=expression)*RIGHT_PAREN)? constr+=STRING_LITERAL? asm=ASM_LITERAL
{$v = Expression.asm(opt($ret), map($param), unescape(optt($constr)), unescapeAsm($asm.text));}
| literal
{$v = Expression.literal($literal.v);}
| HASH (i0+=classId | i1+=functionId | i2+=variableId) LEFT_PAREN fparam+=expressionList? RIGHT_PAREN
{$v = Expression.externalCall(or($i0,$i1,$i2), opt($fparam));}
| (i0+=classId | i1+=functionId | i2+=variableId)
{$v = Expression.unknownId(or($i0,$i1,$i2));}
| PERCENT
{$v = Expression.thiz();}
| base=expression DOLLAR
{$v = Expression.arrayLength($base.v);}
| DOLLAR
{$v = Expression.blockArrayLength();}
| base=expression DOT (m1+=functionId | m2+=variableId)
{$v = Expression.methodOrField($base.v, or($m1,$m2));}
| base=expression LEFT_SQUARE_BRACKET ai=expression RIGHT_SQUARE_BRACKET
{$v = Expression.array($base.v, $ai.v);}
| base=expression LEFT_PAREN fparam+=expressionList? RIGHT_PAREN
{$v = Expression.functionCall($base.v, opt($fparam));
if($base.v.type==Expression.Type.Field) $base.v.type=Expression.Type.Method;}
| base=expression op=(PLUSPLUS|MINUSMINUS)
{$v = Expression.unaryOp($base.v, getPost($op.text));}
| op=(PLUS|MINUS|PLUSPLUS|MINUSMINUS) base=expression
{$v = Expression.unaryOp($base.v, getPre($op.text));}
| op=EXCLA base=expression
{$v = Expression.unaryOp($base.v, getPre($op.text));}
| left=expression op=(ASTERISK|SLASH|PERCENT) right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=(PLUS|MINUS) right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=(LEFT2_ANGLE | RIGHT3_ANGLE | RIGHT2_ANGLE) right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=(LEQ | GEQ | RIGHT_ANGLE | LEFT_ANGLE) right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=(EQUALSEQUALS | NOTEQUALS) right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=ESPER right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=CIRCON right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=PIPE right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=ESPERESPER right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| left=expression op=PIPEPIPE right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));}
| <assoc=right> left=expression
  op=(EQUALS
  |   PLUSE
  |   MINUSE
  |   ASTERISKE
  |   SLASHE
  |   ESPERE
  |   PIPEE
  |   CIRCONE
  |   RIGHT2_E
  |   RIGHT3_E
  |   LEFT2_E
  |   PERCENTE
  )
  right=expression
{$v = Expression.binaryOp($left.v, $right.v, getBin($op.text));};

literal returns [Literal v] :
  v0=arrayLiteral {$v = $v0.v;}
| v1=stringLitteral {$v = $v1.v;}
| v2=numberLiteral {$v = $v2.v;};

arrayLiteral returns [Literal v]:
base+=baseType? arrayLiteralBody
{$v = new Literal(opt($base),$arrayLiteralBody.v);};

arrayLiteralBody returns [ArrayLiteralBody v]:
LEFT_SQUARE_BRACKET list+=expressionList RIGHT_SQUARE_BRACKET
{$v = new ArrayLiteralBody(opt($list));}
| LEFT_SQUARE_BRACKET base=expression (value+=expression | UNDERSCORE) RIGHT_SQUARE_BRACKET
{$v = new ArrayLiteralBody($base.v, opt($value));};

stringLitteral returns [Literal v]:
lit=STRING_LITERAL
{$v = new Literal(unescape($lit.text));};

numberLiteral returns [Literal v]:
(PLUS | neg=MINUS)? num=NUMBER_LITERAL typ+=numberType?
{$v = new Literal($neg != null, $num.text, opt($typ));};

parameter returns [Parameter v]:
id=variableId option+=(TILDATILDA|TILDA)? type
{$v = new Parameter($id.v,$type.v,getOpt(optt($option)));};

type returns [Type v]:
baseType a=SQUARE_BRACKET_PAIR?
{$v = new Type($baseType.v, $a != null);};

baseType returns [BaseType v]:
numberType
{$v = new BaseType($numberType.v);}
| classId
{$v = new BaseType($classId.v);};

classId returns [String v]:
t=MAJ_ID
{$v = $t.text;};

functionId returns [String v]:
t=(NUMBER_TYPE_ALPHANUMERIC | MIN_ID)
{$v = $t.text;};

variableId returns [String v]:
t=(NUMBER_TYPE_ALPHANUMERIC | MAJ_ID | MIN_ID)
{$v = $t.text;};

numberType returns [Primitive v]:
t=(NUMBER_TYPE_ALPHANUMERIC | NUMBER_TYPE)
{$v = getNum($t.text);};

IGNORE_SKIP: {ignore}?
(STRING_LITERAL | NEWLINE | (~[{}])+) -> skip;
IGNORE_LEFT: {ignore}?
'{' {++ignoreBrackets;} -> skip;
IGNORE_RIGHT: {ignore}?
'}' {if(--ignoreBrackets<=0){ignore=false;ignoreBrackets=-1;}} -> skip;

PLATFORM_KEY: {platform}?
('arch' | 'vendor' | 'sys' | 'abi')
{platformKey = getPlatformKey(getText());} -> skip;
PLATFORM_EQUALS: {platform}?
'=' -> skip;
PLATFORM_VALUE: {platform}?
~[ =[\]]+
{checkPlatform(platformKey, getText());platformKey=null;} -> skip;

PLATFORM_START: '#' '['
{platform=true; validSpec=true;} -> skip;
PLATFORM_END: {platform}? ']'
{ignoreBrackets=0;ignore=!validSpec;platform=false;} -> skip;

LEFT_BRACKET_SKIP: {ignoreBrackets==0}? '{' {++ignoreBrackets;} -> skip;
RIGHT_BRACKET_SKIP: {ignoreBrackets==1}? '}' {ignoreBrackets=-1;} -> skip;
LEFT_BRACKET: '{'
{if(ignoreBrackets!=-1) ++ignoreBrackets;};
RIGHT_BRACKET: '}'
{if(ignoreBrackets!=-1) --ignoreBrackets;};

ASM_START: 'ç' {asm = true;};

fragment NUMBER_SUFFIX :
'b' | 'u-' | 'u' | 'u+' | 'i-' | 'i' | 'i+' | 'f-' | 'f' | 'f+';

STRING_LITERAL:
'"' (~["\\] | ('\\' [tnr"\\]))* '"';

ASM_LITERAL: {asm}?
'{' (~[}\\] | ('\\' [}\\]))* '}' {asm = false;};

NUMBER_TYPE_ALPHANUMERIC :
'b' | 'i' | 'u' | 'f';

NUMBER_TYPE :
NUMBER_TYPE_ALPHANUMERIC | 'b' | 'u-' | 'u' | 'u+' | 'i-' | 'i' | 'i+' | 'f-' | 'f' | 'f+';

MAJ_ID:
[A-Z]([a-z0-9A-Z]*);

MIN_ID:
[a-z]([a-z0-9A-Z]*);

NUMBER_LITERAL:
('0' | [1-9][0-9]*) ('.' [0-9]+)?;


WS:  [ \t]+ -> skip;

COMMENT:   '/*' .*? '*/' -> channel(HIDDEN);

LINE_COMMENT:   '//' ~[\r\n]* -> channel(HIDDEN);

NEWLINE: [\r\n]+;

EQUALSEQUALS: '==';
NOTEQUALS: '!=';
ASSEQ: ':=';
EQUALS: '=';
TILDATILDA: '~~';
TILDA: '~';
HASH: '#';
LEQ: '<=';
GEQ: '>=';
PLUSE: '+=';
MINUSE: '-=';
ASTERISKE: '*=';
SLASHE: '/=';
ESPERE: '&=';
PIPEE: '|=';
CIRCONE: '^=';
RIGHT2_E: '>>=';
RIGHT3_E: '>>>=';
LEFT2_E: '<<=';
PERCENTE: '%=';
SQUARE_BRACKET_PAIR: '[]';
LEFT_SQUARE_BRACKET: '[';
RIGHT_SQUARE_BRACKET: ']';
DOLLAR: '$';
ARROW: '->';
CIRCON: '^';
PIPEPIPE: '||';
PIPE: '|';
PERCENT: '%';
SLASH: '/';
ASTERISK: '*';
DOT: '.';
ESPERESPER: '&&';
ESPER: '&';
COLONCOLON: '::';
UNDERSCORE: '_';
AT: '@';
COLON: ':';
PARAGRAPH: '§';
LEFT2_ANGLE: '<<';
RIGHT3_ANGLE: '>>>';
RIGHT2_ANGLE: '>>';
LEFT_ANGLE: '<';
RIGHT_ANGLE: '>';
INTERROCOLON: '?:';
INTERRO: '?';
EXCLA: '!';
COMMA: ',';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
PLUSPLUS: '++';
MINUSMINUS: '--';
PLUS: '+';
MINUS: '-';
