package fr.delthas.sxlang.types;

public class Parameter {
  
  public String id;
  public Type type;
  public ParameterOption option;
  
  public Parameter(String id, Type type, ParameterOption option) {
    this.id = id;
    this.type = type;
    this.option = option;
  }
}
