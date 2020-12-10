// Generated from IsiLang.g4 by ANTLR 4.7.2
package src.parser;

	import src.datastructures.IsiSymbol;
	import src.datastructures.IsiVariable;
	import src.datastructures.IsiSymbolTable;
	import src.exceptions.IsiSemanticException;
	import src.ast.IsiProgram;
	import src.ast.AbstractCommand;
	import src.ast.CommandLeitura;
	import src.ast.CommandEscrita;
	import src.ast.CommandAtribuicao;
	import src.ast.CommandDecisao;
	import src.ast.CommandRepeticao;
	import src.ast.CommandIncrementa;
	import src.ast.CommandDecrementa;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#vetor}.
	 * @param ctx the parse tree
	 */
	void enterVetor(IsiLangParser.VetorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#vetor}.
	 * @param ctx the parse tree
	 */
	void exitVetor(IsiLangParser.VetorContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdincrementa}.
	 * @param ctx the parse tree
	 */
	void enterCmdincrementa(IsiLangParser.CmdincrementaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdincrementa}.
	 * @param ctx the parse tree
	 */
	void exitCmdincrementa(IsiLangParser.CmdincrementaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmddecrementa}.
	 * @param ctx the parse tree
	 */
	void enterCmddecrementa(IsiLangParser.CmddecrementaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmddecrementa}.
	 * @param ctx the parse tree
	 */
	void exitCmddecrementa(IsiLangParser.CmddecrementaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void enterCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void exitCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void enterCmdrepeticao(IsiLangParser.CmdrepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void exitCmdrepeticao(IsiLangParser.CmdrepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
}