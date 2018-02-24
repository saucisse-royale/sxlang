package fr.delthas.sxlang.types;

public class Literal {
  
  public enum Type {
    ArrayLiteral,
    StringLiteral,
    NumberLiteral,
  }
  
  public Type type;
  public BaseType arrayType;
  public ArrayLiteralBody arrayBody;
  public String string;
  public boolean negative;
  public Primitive numberType;
  
  public Literal(BaseType arrayType, ArrayLiteralBody arrayBody) {
    this.arrayType = arrayType;
    this.arrayBody = arrayBody;
    type = Type.ArrayLiteral;
  }
  
  public Literal(String string) {
    this.string = string;
    type = Type.StringLiteral;
  }
  
  public Literal(boolean negative, String number, Primitive numberType) {
    this.negative = negative;
    this.string = number;
    this.numberType = numberType;
    type = Type.NumberLiteral;
  }
}
