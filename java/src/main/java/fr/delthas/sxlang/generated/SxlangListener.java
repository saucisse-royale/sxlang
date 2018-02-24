// Generated from C:/Users/delthas/Java/sxlang/src/main/resources\Sxlang.g4 by ANTLR 4.7
package fr.delthas.sxlang.generated;

import java.util.*;
import fr.delthas.sxlang.types.*;
import static fr.delthas.sxlang.SxlangAux.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SxlangParser}.
 */
public interface SxlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SxlangParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(SxlangParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(SxlangParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SxlangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SxlangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(SxlangParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(SxlangParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(SxlangParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(SxlangParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(SxlangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(SxlangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(SxlangParser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(SxlangParser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(SxlangParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(SxlangParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(SxlangParser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(SxlangParser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(SxlangParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(SxlangParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SxlangParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SxlangParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SxlangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SxlangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SxlangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SxlangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(SxlangParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(SxlangParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#arrayLiteralBody}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralBody(SxlangParser.ArrayLiteralBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#arrayLiteralBody}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralBody(SxlangParser.ArrayLiteralBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#stringLitteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLitteral(SxlangParser.StringLitteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#stringLitteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLitteral(SxlangParser.StringLitteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(SxlangParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(SxlangParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SxlangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SxlangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SxlangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SxlangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(SxlangParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(SxlangParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#classId}.
	 * @param ctx the parse tree
	 */
	void enterClassId(SxlangParser.ClassIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#classId}.
	 * @param ctx the parse tree
	 */
	void exitClassId(SxlangParser.ClassIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#functionId}.
	 * @param ctx the parse tree
	 */
	void enterFunctionId(SxlangParser.FunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#functionId}.
	 * @param ctx the parse tree
	 */
	void exitFunctionId(SxlangParser.FunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#variableId}.
	 * @param ctx the parse tree
	 */
	void enterVariableId(SxlangParser.VariableIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#variableId}.
	 * @param ctx the parse tree
	 */
	void exitVariableId(SxlangParser.VariableIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SxlangParser#numberType}.
	 * @param ctx the parse tree
	 */
	void enterNumberType(SxlangParser.NumberTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SxlangParser#numberType}.
	 * @param ctx the parse tree
	 */
	void exitNumberType(SxlangParser.NumberTypeContext ctx);
}