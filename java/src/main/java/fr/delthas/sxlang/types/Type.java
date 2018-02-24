package fr.delthas.sxlang.types;

import java.util.Objects;

public class Type {
  
  public BaseType baseType;
  public boolean array;
  
  public Type(BaseType baseType, boolean array) {
    this.baseType = baseType;
    this.array = array;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    Type type = (Type) o;
    return array == type.array &&
            Objects.equals(baseType, type.baseType);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(baseType, array);
  }
}
