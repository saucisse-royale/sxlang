package fr.delthas.sxlang.types;

import java.util.List;

public class ArrayLiteralBody {
  
  public enum Type {
    Count,
    Values
  }
  
  public Type type;
  public Expression count;
  public Expression value;
  public List<Expression> values;
  
  public ArrayLiteralBody(Expression count, Expression value) {
    this.count = count;
    this.value = value;
    type = Type.Count;
  }
  
  public ArrayLiteralBody(List<Expression> values) {
    this.values = values;
    type = Type.Values;
  }
  
}
