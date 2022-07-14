// Generated from me/d3s34/parser/Calc.g4 by ANTLR 4.10.1
package me.d3s34.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(CalcParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddOrSub}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOrSub(CalcParser.AddOrSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalcParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulOrDiv}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOrDiv(CalcParser.MulOrDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthese}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthese(CalcParser.ParentheseContext ctx);
}