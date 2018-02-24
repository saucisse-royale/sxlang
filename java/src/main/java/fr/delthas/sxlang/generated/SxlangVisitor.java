// Generated from C:/Users/delthas/Java/sxlang/src/main/resources\Sxlang.g4 by ANTLR 4.7
package fr.delthas.sxlang.generated;

import java.util.*;
import fr.delthas.sxlang.types.*;
import static fr.delthas.sxlang.SxlangAux.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SxlangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SxlangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SxlangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(SxlangParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SxlangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(SxlangParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(SxlangParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(SxlangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(SxlangParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(SxlangParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#elseIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfBlock(SxlangParser.ElseIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(SxlangParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(SxlangParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SxlangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SxlangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(SxlangParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#arrayLiteralBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralBody(SxlangParser.ArrayLiteralBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#stringLitteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLitteral(SxlangParser.StringLitteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(SxlangParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SxlangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SxlangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(SxlangParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#classId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassId(SxlangParser.ClassIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#functionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionId(SxlangParser.FunctionIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#variableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableId(SxlangParser.VariableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SxlangParser#numberType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberType(SxlangParser.NumberTypeContext ctx);
}