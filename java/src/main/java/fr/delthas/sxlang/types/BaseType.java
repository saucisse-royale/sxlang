package fr.delthas.sxlang.types;

import java.util.Objects;

public class BaseType {
  
  public enum Type {
    Primitive,
    Class,
  }
  
  public Primitive primitive;
  public String clazz;
  public Type type;
  
  public BaseType(Primitive primitive) {
    this.primitive = primitive;
    type = Type.Primitive;
  }
  
  public BaseType(String clazz) {
    this.clazz = clazz;
    type = Type.Class;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    BaseType baseType = (BaseType) o;
    return primitive == baseType.primitive &&
            Objects.equals(clazz, baseType.clazz) &&
            type == baseType.type;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(primitive, clazz, type);
  }
}
