package fr.delthas.sxlang.types;

import java.util.List;

public class Declaration {
  
  public enum Type {
    Type,
    Function,
    Variable,
  }
  
  public Type type;
  public String id;
  public String parentId;
  public boolean finaz;
  public List<String> extendz;
  public List<Declaration> body;
  public List<Statement> statements;
  public List<Parameter> parameters;
  public boolean instance;
  public fr.delthas.sxlang.types.Type returnType;
  public Expression value;
  public fr.delthas.sxlang.types.Type variableType;
  
  private Declaration(Type type) {
    this.type = type;
  }
  
  public static Declaration type(String id, boolean unoverridable, List<String> extendz, List<Declaration> body) {
    Declaration declaration = new Declaration(Type.Type);
    declaration.id = id;
    declaration.finaz = unoverridable;
    declaration.extendz = extendz;
    declaration.body = body;
    return declaration;
  }
  
  public static Declaration function(String id, String parentId, List<Parameter> parameters, boolean instance, fr.delthas.sxlang.types.Type type, List<Statement> body) {
    Declaration declaration = new Declaration(Type.Function);
    declaration.id = id;
    declaration.parentId = parentId;
    declaration.parameters = parameters;
    declaration.instance = instance;
    declaration.returnType = type;
    declaration.statements = body;
    return declaration;
  }
  
  public static Declaration variable(String id, boolean mutable, boolean instance, Expression value, fr.delthas.sxlang.types.Type type) {
    Declaration declaration = new Declaration(Type.Variable);
    declaration.id = id;
    declaration.finaz = mutable;
    declaration.value = value;
    declaration.instance = instance;
    declaration.variableType = type;
    return declaration;
  }
  
}
