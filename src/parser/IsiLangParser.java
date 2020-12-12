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
	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, AP=14, FP=15, SC=16, OP=17, ATTR=18, 
		VIR=19, ACH=20, FCH=21, ASP=22, ACOL=23, FCOL=24, OPREL=25, ID=26, NUMBER=27, 
		WS=28, STRING=29;
	public static final int
		RULE_prog = 0, RULE_fimprog = 1, RULE_decl = 2, RULE_declaravar = 3, RULE_tipo = 4, 
		RULE_bloco = 5, RULE_cmd = 6, RULE_cmdleitura = 7, RULE_cmdescrita = 8, 
		RULE_vetor = 9, RULE_cmdattrib = 10, RULE_cmdincrementa = 11, RULE_cmddecrementa = 12, 
		RULE_cmdif = 13, RULE_cmdrepeticao = 14, RULE_expr = 15, RULE_termo = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "fimprog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", 
			"cmdescrita", "vetor", "cmdattrib", "cmdincrementa", "cmddecrementa", 
			"cmdif", "cmdrepeticao", "expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'vetor'", "'numero'", "'texto'", "'leia'", 
			"'escreva'", "'++'", "'--'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'('", "')'", "';'", null, "':='", "','", "'{'", "'}'", "'\"'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "ASP", 
			"ACOL", "FCOL", "OPREL", "ID", "NUMBER", "WS", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private String a;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<String> allVariables = new ArrayList<String>();
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Variável "+id+" nao foi declarada.");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}

		public void allVariablesUsed() {
			Collection.sort(allVariables);
			if(!allVariables.isEmpty()) throw new IsiSemanticException("Variavel "+allVariables.get(0)+" nao utilizada");
		}

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public FimprogContext fimprog() {
			return getRuleContext(FimprogContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(35);
			decl();
			setState(36);
			bloco();
			setState(37);
			fimprog();
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());           	 
			           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FimprogContext extends ParserRuleContext {
		public FimprogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fimprog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFimprog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFimprog(this);
		}
	}

	public final FimprogContext fimprog() throws RecognitionException {
		FimprogContext _localctx = new FimprogContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fimprog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__1);
					
					if(!allVariables.isEmpty()) throw new IsiSemanticException("Variavel "+allVariables.get(0)+" nao utilizada");
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				declaravar();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public Token size;
		public Token vectorName;
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ACOL() { return getToken(IsiLangParser.ACOL, 0); }
		public TerminalNode FCOL() { return getToken(IsiLangParser.FCOL, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				{
				{
				setState(48);
				tipo();
				setState(49);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
									  allVariables.add(_varName);
					                  if (!symbolTable.exists(_varName)){
					            		symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
					                  }
				                    
				}
				}
				break;
			case T__2:
				{
				{
				setState(52);
				match(T__2);
				 _tipo = IsiVariable.ARRAY; 
				setState(54);
				match(ACOL);
				setState(55);
				((DeclaravarContext)_localctx).size = match(NUMBER);
				setState(56);
				match(FCOL);
				setState(57);
				((DeclaravarContext)_localctx).vectorName = match(ID);
				 _varName = (((DeclaravarContext)_localctx).vectorName!=null?((DeclaravarContext)_localctx).vectorName.getText():null);
					                  _varValue = (((DeclaravarContext)_localctx).size!=null?((DeclaravarContext)_localctx).size.getText():null);
									  allVariables.add(_varName);
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					            		symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
					                  } 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(61);
				match(VIR);
				setState(62);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
									  allVariables.add(_varName);
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
					                  }
				                    
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(T__3);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(T__4);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);
			          
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				cmd();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdincrementaContext cmdincrementa() {
			return getRuleContext(CmdincrementaContext.class,0);
		}
		public CmddecrementaContext cmddecrementa() {
			return getRuleContext(CmddecrementaContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				cmdleitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				cmdescrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				cmdattrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				cmdif();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				cmdrepeticao();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				cmdincrementa();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(89);
				cmddecrementa();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public Token varName;
		public Token position;
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ACOL() { return getToken(IsiLangParser.ACOL, 0); }
		public TerminalNode FCOL() { return getToken(IsiLangParser.FCOL, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__5);
			setState(93);
			match(AP);
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(94);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                     	_readID = _input.LT(-1).getText();
										IsiVariable var = (IsiVariable)symbolTable.get(_readID);
				              			CommandLeitura cmd = new CommandLeitura(_readID, var);
				              			stack.peek().add(cmd);
				                    
				}
				break;
			case 2:
				{
				{
				setState(96);
				((CmdleituraContext)_localctx).varName = match(ID);
				setState(97);
				match(ACOL);
				setState(98);
				((CmdleituraContext)_localctx).position = match(NUMBER);
				setState(99);
				match(FCOL);

										verificaID((((CmdleituraContext)_localctx).varName!=null?((CmdleituraContext)_localctx).varName.getText():null));
				        				_readID = (((CmdleituraContext)_localctx).varName!=null?((CmdleituraContext)_localctx).varName.getText():null)+"["+(((CmdleituraContext)_localctx).position!=null?((CmdleituraContext)_localctx).position.getText():null)+"]"; 
										IsiVariable var = new IsiVariable((((CmdleituraContext)_localctx).varName!=null?((CmdleituraContext)_localctx).varName.getText():null), 2, null);
										CommandLeitura cmd = new CommandLeitura(_readID, var);
				              			stack.peek().add(cmd); 
				}
				}
				break;
			}
			setState(103);
			match(FP);
			setState(104);
			match(SC);

			              	
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public Token a;
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public List<TerminalNode> ASP() { return getTokens(IsiLangParser.ASP); }
		public TerminalNode ASP(int i) {
			return getToken(IsiLangParser.ASP, i);
		}
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public TerminalNode STRING() { return getToken(IsiLangParser.STRING, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__6);
			setState(108);
			match(AP);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(109);
				match(ID);
				  verificaID(_input.LT(-1).getText());
					                	_writeID = _input.LT(-1).getText();
										if(allVariables.contains(_writeID)) allVariables.remove(allVariables.indexOf(_writeID));
										CommandEscrita cmd = new CommandEscrita(_writeID, 0);
				            			stack.peek().add(cmd); 
										
				}
				break;
			case 2:
				{
				setState(111);
				match(ASP);
				setState(112);
				((CmdescritaContext)_localctx).a = match(STRING);
				setState(113);
				match(ASP);
				 
										CommandEscrita cmd = new CommandEscrita(((CmdescritaContext)_localctx).a.getText(), 1);
				            			stack.peek().add(cmd);  
				}
				break;
			case 3:
				{
				setState(115);
				vetor();
										
										CommandEscrita cmd = new CommandEscrita(_exprID, 0);
										stack.peek().add(cmd);
									
				}
				break;
			}
			setState(120);
			match(FP);
			setState(121);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VetorContext extends ParserRuleContext {
		public Token varName;
		public Token position;
		public TerminalNode ACOL() { return getToken(IsiLangParser.ACOL, 0); }
		public TerminalNode FCOL() { return getToken(IsiLangParser.FCOL, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public VetorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vetor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterVetor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitVetor(this);
		}
	}

	public final VetorContext vetor() throws RecognitionException {
		VetorContext _localctx = new VetorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vetor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(123);
			((VetorContext)_localctx).varName = match(ID);
			setState(124);
			match(ACOL);
			setState(125);
			((VetorContext)_localctx).position = match(NUMBER);
			setState(126);
			match(FCOL);

					verificaID((((VetorContext)_localctx).varName!=null?((VetorContext)_localctx).varName.getText():null));
			        _exprID = (((VetorContext)_localctx).varName!=null?((VetorContext)_localctx).varName.getText():null)+"["+(((VetorContext)_localctx).position!=null?((VetorContext)_localctx).position.getText():null)+"]";
					
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(129);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    _exprID = _input.LT(-1).getText();
				                   
				}
				}
				break;
			case 2:
				{
				setState(131);
				vetor();
				}
				break;
			}
			setState(134);
			match(ATTR);
			 _exprContent = ""; 
			setState(136);
			expr();
			setState(137);
			match(SC);
							   	
			               		CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			               		stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdincrementaContext extends ParserRuleContext {
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public CmdincrementaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdincrementa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdincrementa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdincrementa(this);
		}
	}

	public final CmdincrementaContext cmdincrementa() throws RecognitionException {
		CmdincrementaContext _localctx = new CmdincrementaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdincrementa);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(140);
					match(ID);
					 verificaID(_input.LT(-1).getText());
					                    _exprID = _input.LT(-1).getText();
					                
					}
					break;
				case 2:
					{
					setState(142);
					vetor();
					}
					break;
				}
				setState(145);
				match(T__7);
				setState(146);
				match(SC);

									CommandIncrementa cmd = new CommandIncrementa(_exprID, CommandIncrementa.posIncrementa);
									stack.peek().add(cmd);					
								
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(148);
				match(T__7);
				{
				setState(149);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                _exprID = _input.LT(-1).getText();
				                
				setState(151);
				match(SC);

									CommandIncrementa cmd = new CommandIncrementa(_exprID, CommandIncrementa.preIncrementa);
									stack.peek().add(cmd);					
								
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmddecrementaContext extends ParserRuleContext {
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public CmddecrementaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmddecrementa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmddecrementa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmddecrementa(this);
		}
	}

	public final CmddecrementaContext cmddecrementa() throws RecognitionException {
		CmddecrementaContext _localctx = new CmddecrementaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmddecrementa);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(158);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(155);
					match(ID);
					 verificaID(_input.LT(-1).getText());
					                    _exprID = _input.LT(-1).getText();
					                   
					}
					break;
				case 2:
					{
					setState(157);
					vetor();
					}
					break;
				}
				setState(160);
				match(T__8);
				setState(161);
				match(SC);

									CommandDecrementa cmd = new CommandDecrementa(_exprID, CommandDecrementa.posDecrementa);
									stack.peek().add(cmd);					
								
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(163);
				match(T__8);
				setState(164);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    _exprID = _input.LT(-1).getText();
				                   
				setState(166);
				match(SC);

									CommandDecrementa cmd = new CommandDecrementa(_exprID, CommandDecrementa.preDecrementa);
									stack.peek().add(cmd);					
								
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdifContext extends ParserRuleContext {
		public Token varName;
		public Token position;
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> ACOL() { return getTokens(IsiLangParser.ACOL); }
		public TerminalNode ACOL(int i) {
			return getToken(IsiLangParser.ACOL, i);
		}
		public List<TerminalNode> FCOL() { return getTokens(IsiLangParser.FCOL); }
		public TerminalNode FCOL(int i) {
			return getToken(IsiLangParser.FCOL, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__9);
			setState(171);
			match(AP);
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(172);
				match(ID);
				 
										verificaID(_input.LT(-1).getText());						
										_exprDecision = _input.LT(-1).getText(); 
										if(allVariables.contains(_exprDecision)) allVariables.remove(allVariables.indexOf(_exprDecision));
										
				}
				break;
			case 2:
				{
				{
				setState(174);
				((CmdifContext)_localctx).varName = match(ID);
				setState(175);
				match(ACOL);
				setState(176);
				((CmdifContext)_localctx).position = match(NUMBER);
				setState(177);
				match(FCOL);
										
										verificaID((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null));
										if(allVariables.contains((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null))) allVariables.remove(allVariables.indexOf((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)));
				       					_exprDecision = (((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)+"["+(((CmdifContext)_localctx).position!=null?((CmdifContext)_localctx).position.getText():null)+"]";
				}
				}
				break;
			}
			setState(181);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(183);
				((CmdifContext)_localctx).varName = match(ID);

										verificaID((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null));
										if(allVariables.contains((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null))) allVariables.remove(allVariables.indexOf((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)));
										_exprDecision += _input.LT(-1).getText(); 
										
				}
				break;
			case 2:
				{
				setState(185);
				((CmdifContext)_localctx).varName = match(ID);
				setState(186);
				match(ACOL);
				setState(187);
				((CmdifContext)_localctx).position = match(NUMBER);
				setState(188);
				match(FCOL);
				 
										verificaID((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null));
										if(allVariables.contains((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null))) allVariables.remove(allVariables.indexOf((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)));
				       					_exprDecision += (((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)+"["+(((CmdifContext)_localctx).position!=null?((CmdifContext)_localctx).position.getText():null)+"]";						
										
				}
				break;
			case 3:
				{
				setState(190);
				match(NUMBER);

										_exprDecision += _input.LT(-1).getText();
									
				}
				break;
			}
			setState(194);
			match(FP);
			setState(195);
			match(T__10);
			setState(196);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(199); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(198);
				cmd();
				}
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(203);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(205);
				match(T__11);
				setState(206);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(208);
					cmd();
					}
					}
					setState(211); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
				}
				setState(213);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   	
				}
			}

								   
									CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			                   		stack.peek().add(cmd);
								  
							   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public Token varName;
		public Token position;
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> ACOL() { return getTokens(IsiLangParser.ACOL); }
		public TerminalNode ACOL(int i) {
			return getToken(IsiLangParser.ACOL, i);
		}
		public List<TerminalNode> FCOL() { return getTokens(IsiLangParser.FCOL); }
		public TerminalNode FCOL(int i) {
			return getToken(IsiLangParser.FCOL, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__12);
			setState(221);
			match(AP);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(222);
				match(ID);

											verificaID(_input.LT(-1).getText());
											_exprDecision = _input.LT(-1).getText();
											if(allVariables.contains(_exprDecision)) allVariables.remove(allVariables.indexOf(_exprDecision));
											
				}
				break;
			case 2:
				{
				setState(224);
				((CmdrepeticaoContext)_localctx).varName = match(ID);
				setState(225);
				match(ACOL);
				setState(226);
				((CmdrepeticaoContext)_localctx).position = match(NUMBER);
				setState(227);
				match(FCOL);

												verificaID((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null));
												_exprDecision = (((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)+"["+(((CmdrepeticaoContext)_localctx).position!=null?((CmdrepeticaoContext)_localctx).position.getText():null)+"]";
												if(allVariables.contains((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null))) allVariables.remove(allVariables.indexOf((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)));
											
				}
				break;
			}
			setState(231);
			match(OPREL);
			 
											_exprDecision += _input.LT(-1).getText(); 
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(233);
				((CmdrepeticaoContext)_localctx).varName = match(ID);

												verificaID((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null));
												_exprDecision += _input.LT(-1).getText(); 
												if(allVariables.contains((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null))) allVariables.remove(allVariables.indexOf((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)));
												
				}
				break;
			case 2:
				{
				setState(235);
				((CmdrepeticaoContext)_localctx).varName = match(ID);
				setState(236);
				match(ACOL);
				setState(237);
				((CmdrepeticaoContext)_localctx).position = match(NUMBER);
				setState(238);
				match(FCOL);
				 
												verificaID((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null));
				       							_exprDecision += (((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)+"["+(((CmdrepeticaoContext)_localctx).position!=null?((CmdrepeticaoContext)_localctx).position.getText():null)+"]";
												if(allVariables.contains((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null))) allVariables.remove(allVariables.indexOf((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)));
												
				}
				break;
			case 3:
				{
				setState(240);
				match(NUMBER);
				 
												_exprDecision += _input.LT(-1).getText();
												
				}
				break;
			}
			setState(244);
			match(FP);
			setState(245);
			match(ACH);
			 	curThread = new ArrayList<AbstractCommand>(); 
			                      			stack.push(curThread);
			                    		
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(247);
				cmd();
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(252);
			match(FCH);

											listaTrue = stack.pop();
											CommandRepeticao cmd = new CommandRepeticao(_exprDecision, listaTrue);
											stack.peek().add(cmd);
										
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			termo();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(256);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(258);
				termo();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_termo);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0111\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\6\4/\n\4\r\4\16\4\60\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5>\n\5\3\5\3\5\3\5\7\5C\n\5\f\5"+
		"\16\5F\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6N\n\6\3\7\3\7\6\7R\n\7\r\7\16\7"+
		"S\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\th\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\ny\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5"+
		"\f\u0087\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u0092\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009c\n\r\3\16\3\16\3\16\5\16\u00a1\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ab\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b6\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c3\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\6\17\u00ca\n\17\r\17\16\17\u00cb\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00d4"+
		"\n\17\r\17\16\17\u00d5\3\17\3\17\3\17\5\17\u00db\n\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e8\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f5\n\20\3\20\3\20\3\20"+
		"\3\20\6\20\u00fb\n\20\r\20\16\20\u00fc\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\7\21\u0106\n\21\f\21\16\21\u0109\13\21\3\22\3\22\3\22\3\22\5\22\u010f"+
		"\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\2\u011e"+
		"\2$\3\2\2\2\4*\3\2\2\2\6.\3\2\2\2\b=\3\2\2\2\nM\3\2\2\2\fO\3\2\2\2\16"+
		"\\\3\2\2\2\20^\3\2\2\2\22m\3\2\2\2\24}\3\2\2\2\26\u0086\3\2\2\2\30\u009b"+
		"\3\2\2\2\32\u00aa\3\2\2\2\34\u00ac\3\2\2\2\36\u00de\3\2\2\2 \u0101\3\2"+
		"\2\2\"\u010e\3\2\2\2$%\7\3\2\2%&\5\6\4\2&\'\5\f\7\2\'(\5\4\3\2()\b\2\1"+
		"\2)\3\3\2\2\2*+\7\4\2\2+,\b\3\1\2,\5\3\2\2\2-/\5\b\5\2.-\3\2\2\2/\60\3"+
		"\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\7\3\2\2\2\62\63\5\n\6\2\63\64\7\34"+
		"\2\2\64\65\b\5\1\2\65>\3\2\2\2\66\67\7\5\2\2\678\b\5\1\289\7\31\2\29:"+
		"\7\35\2\2:;\7\32\2\2;<\7\34\2\2<>\b\5\1\2=\62\3\2\2\2=\66\3\2\2\2>D\3"+
		"\2\2\2?@\7\25\2\2@A\7\34\2\2AC\b\5\1\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2D"+
		"E\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\22\2\2H\t\3\2\2\2IJ\7\6\2\2JN\b\6\1"+
		"\2KL\7\7\2\2LN\b\6\1\2MI\3\2\2\2MK\3\2\2\2N\13\3\2\2\2OQ\b\7\1\2PR\5\16"+
		"\b\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\r\3\2\2\2U]\5\20\t\2V]\5"+
		"\22\n\2W]\5\26\f\2X]\5\34\17\2Y]\5\36\20\2Z]\5\30\r\2[]\5\32\16\2\\U\3"+
		"\2\2\2\\V\3\2\2\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2"+
		"\2]\17\3\2\2\2^_\7\b\2\2_g\7\20\2\2`a\7\34\2\2ah\b\t\1\2bc\7\34\2\2cd"+
		"\7\31\2\2de\7\35\2\2ef\7\32\2\2fh\b\t\1\2g`\3\2\2\2gb\3\2\2\2hi\3\2\2"+
		"\2ij\7\21\2\2jk\7\22\2\2kl\b\t\1\2l\21\3\2\2\2mn\7\t\2\2nx\7\20\2\2op"+
		"\7\34\2\2py\b\n\1\2qr\7\30\2\2rs\7\37\2\2st\7\30\2\2ty\b\n\1\2uv\5\24"+
		"\13\2vw\b\n\1\2wy\3\2\2\2xo\3\2\2\2xq\3\2\2\2xu\3\2\2\2yz\3\2\2\2z{\7"+
		"\21\2\2{|\7\22\2\2|\23\3\2\2\2}~\7\34\2\2~\177\7\31\2\2\177\u0080\7\35"+
		"\2\2\u0080\u0081\7\32\2\2\u0081\u0082\b\13\1\2\u0082\25\3\2\2\2\u0083"+
		"\u0084\7\34\2\2\u0084\u0087\b\f\1\2\u0085\u0087\5\24\13\2\u0086\u0083"+
		"\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\24\2\2"+
		"\u0089\u008a\b\f\1\2\u008a\u008b\5 \21\2\u008b\u008c\7\22\2\2\u008c\u008d"+
		"\b\f\1\2\u008d\27\3\2\2\2\u008e\u008f\7\34\2\2\u008f\u0092\b\r\1\2\u0090"+
		"\u0092\5\24\13\2\u0091\u008e\3\2\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3"+
		"\2\2\2\u0093\u0094\7\n\2\2\u0094\u0095\7\22\2\2\u0095\u009c\b\r\1\2\u0096"+
		"\u0097\7\n\2\2\u0097\u0098\7\34\2\2\u0098\u0099\b\r\1\2\u0099\u009a\7"+
		"\22\2\2\u009a\u009c\b\r\1\2\u009b\u0091\3\2\2\2\u009b\u0096\3\2\2\2\u009c"+
		"\31\3\2\2\2\u009d\u009e\7\34\2\2\u009e\u00a1\b\16\1\2\u009f\u00a1\5\24"+
		"\13\2\u00a0\u009d\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\7\13\2\2\u00a3\u00a4\7\22\2\2\u00a4\u00ab\b\16\1\2\u00a5\u00a6"+
		"\7\13\2\2\u00a6\u00a7\7\34\2\2\u00a7\u00a8\b\16\1\2\u00a8\u00a9\7\22\2"+
		"\2\u00a9\u00ab\b\16\1\2\u00aa\u00a0\3\2\2\2\u00aa\u00a5\3\2\2\2\u00ab"+
		"\33\3\2\2\2\u00ac\u00ad\7\f\2\2\u00ad\u00b5\7\20\2\2\u00ae\u00af\7\34"+
		"\2\2\u00af\u00b6\b\17\1\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2\7\31\2\2\u00b2"+
		"\u00b3\7\35\2\2\u00b3\u00b4\7\32\2\2\u00b4\u00b6\b\17\1\2\u00b5\u00ae"+
		"\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\33\2\2"+
		"\u00b8\u00c2\b\17\1\2\u00b9\u00ba\7\34\2\2\u00ba\u00c3\b\17\1\2\u00bb"+
		"\u00bc\7\34\2\2\u00bc\u00bd\7\31\2\2\u00bd\u00be\7\35\2\2\u00be\u00bf"+
		"\7\32\2\2\u00bf\u00c3\b\17\1\2\u00c0\u00c1\7\35\2\2\u00c1\u00c3\b\17\1"+
		"\2\u00c2\u00b9\3\2\2\2\u00c2\u00bb\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c5\7\21\2\2\u00c5\u00c6\7\r\2\2\u00c6\u00c7\7\26\2\2"+
		"\u00c7\u00c9\b\17\1\2\u00c8\u00ca\5\16\b\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\7\27\2\2\u00ce\u00da\b\17\1\2\u00cf\u00d0\7\16\2\2\u00d0\u00d1"+
		"\7\26\2\2\u00d1\u00d3\b\17\1\2\u00d2\u00d4\5\16\b\2\u00d3\u00d2\3\2\2"+
		"\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d8\7\27\2\2\u00d8\u00d9\b\17\1\2\u00d9\u00db\3\2\2\2"+
		"\u00da\u00cf\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\b\17\1\2\u00dd\35\3\2\2\2\u00de\u00df\7\17\2\2\u00df\u00e7\7\20\2\2\u00e0"+
		"\u00e1\7\34\2\2\u00e1\u00e8\b\20\1\2\u00e2\u00e3\7\34\2\2\u00e3\u00e4"+
		"\7\31\2\2\u00e4\u00e5\7\35\2\2\u00e5\u00e6\7\32\2\2\u00e6\u00e8\b\20\1"+
		"\2\u00e7\u00e0\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea"+
		"\7\33\2\2\u00ea\u00f4\b\20\1\2\u00eb\u00ec\7\34\2\2\u00ec\u00f5\b\20\1"+
		"\2\u00ed\u00ee\7\34\2\2\u00ee\u00ef\7\31\2\2\u00ef\u00f0\7\35\2\2\u00f0"+
		"\u00f1\7\32\2\2\u00f1\u00f5\b\20\1\2\u00f2\u00f3\7\35\2\2\u00f3\u00f5"+
		"\b\20\1\2\u00f4\u00eb\3\2\2\2\u00f4\u00ed\3\2\2\2\u00f4\u00f2\3\2\2\2"+
		"\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\21\2\2\u00f7\u00f8\7\26\2\2\u00f8\u00fa"+
		"\b\20\1\2\u00f9\u00fb\5\16\b\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2"+
		"\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff"+
		"\7\27\2\2\u00ff\u0100\b\20\1\2\u0100\37\3\2\2\2\u0101\u0107\5\"\22\2\u0102"+
		"\u0103\7\23\2\2\u0103\u0104\b\21\1\2\u0104\u0106\5\"\22\2\u0105\u0102"+
		"\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"!\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7\34\2\2\u010b\u010f\b\22\1"+
		"\2\u010c\u010d\7\35\2\2\u010d\u010f\b\22\1\2\u010e\u010a\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f#\3\2\2\2\31\60=DMS\\gx\u0086\u0091\u009b\u00a0\u00aa"+
		"\u00b5\u00c2\u00cb\u00d5\u00da\u00e7\u00f4\u00fc\u0107\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}