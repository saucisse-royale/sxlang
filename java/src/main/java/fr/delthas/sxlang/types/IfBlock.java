package fr.delthas.sxlang.types;

import java.util.List;

public class IfBlock {
  
  public Expression condition;
  public List<Statement> body;
  
  public IfBlock(Expression condition, List<Statement> body) {
    this.condition = condition;
    this.body = body;
  }
}
