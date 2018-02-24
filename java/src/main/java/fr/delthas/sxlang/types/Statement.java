package fr.delthas.sxlang.types;

import java.util.List;
import java.util.Map;

public class Statement {
  
  public enum Type {
    If,
    While,
    For,
    Return,
    Continue,
    Break,
    Variable,
    Expression,
    Free,
  }
  
  public Type type;
  public List<IfBlock> ifs;
  public Expression condition;
  public List<Statement> body;
  public String variable;
  public Expression iterable;
  public Expression returz;
  public int shift;
  public Declaration variableDeclaration;
  public Expression expression;
  
  private Statement(Type type) {
    this.type = type;
  }
  
  public static Statement ifs(List<IfBlock> ifBlocks) {
    Statement statement = new Statement(Type.If);
    statement.ifs = ifBlocks;
    return statement;
  }
  
  public static Statement whilz(Expression condition, List<Statement> body) {
    Statement statement = new Statement(Type.While);
    statement.condition = condition;
    statement.body = body;
    return statement;
  }
  
  public static Statement foz(String variable, Expression iterable,List<Statement> body) {
    Statement statement = new Statement(Type.For);
    statement.variable = variable;
    statement.iterable = iterable;
    statement.body = body;
    return statement;
  }
  
  public static Statement returz(Expression expression) {
    Statement statement = new Statement(Type.Return);
    statement.returz = expression;
    return statement;
  }
  
  public static Statement continuz(int shift) {
    Statement statement = new Statement(Type.Continue);
    statement.shift = shift;
    return statement;
  }
  
  public static Statement breaz(int shift) {
    Statement statement = new Statement(Type.Break);
    statement.shift = shift;
    return statement;
  }
  
  public static Statement variable(Declaration declaration) {
    Statement statement = new Statement(Type.Variable);
    statement.variableDeclaration = declaration;
    return statement;
  }
  
  public static Statement expression(Expression expression) {
    Statement statement = new Statement(Type.Expression);
    statement.expression = expression;
    return statement;
  }
  
  public static Statement free(Expression expression) {
    Statement statement = new Statement(Type.Free);
    statement.expression = expression;
    return statement;
  }
  
}
