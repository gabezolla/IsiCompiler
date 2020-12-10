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
		WS=28, STRING=29, BOOL=30;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_vetor = 8, 
		RULE_cmdattrib = 9, RULE_cmdincrementa = 10, RULE_cmddecrementa = 11, 
		RULE_cmdif = 12, RULE_cmdrepeticao = 13, RULE_expr = 14, RULE_termo = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"vetor", "cmdattrib", "cmdincrementa", "cmddecrementa", "cmdif", "cmdrepeticao", 
			"expr", "termo"
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
			"ACOL", "FCOL", "OPREL", "ID", "NUMBER", "WS", "STRING", "BOOL"
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
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Variável "+id+" nao foi declarada.");
			}
		}

		public void varUsed(String id) {
	        if(symbolTable.exists(id)){
	            IsiVariable var = (IsiVariable)symbolTable.get(id);
	            var.setUsed(true);
	        }
	    }

	    public boolean isVarUsed(String id) {
	        if(symbolTable.exists(id)){
				IsiVariable var = (IsiVariable)symbolTable.get(id);
	            return var.isUsed();
	        }
	        return false;
	    }
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
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
			setState(32);
			match(T__0);
			setState(33);
			decl();
			setState(34);
			bloco();
			setState(35);
			match(T__1);
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
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				declaravar();
				}
				}
				setState(41); 
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
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				{
				{
				setState(43);
				tipo();
				setState(44);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
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
			case T__2:
				{
				{
				setState(47);
				match(T__2);
				 _tipo = IsiVariable.ARRAY; 
				setState(49);
				match(ACOL);
				setState(50);
				((DeclaravarContext)_localctx).size = match(NUMBER);
				setState(51);
				match(FCOL);
				setState(52);
				((DeclaravarContext)_localctx).vectorName = match(ID);
				 _varName = (((DeclaravarContext)_localctx).vectorName!=null?((DeclaravarContext)_localctx).vectorName.getText():null);
					                  _varValue = (((DeclaravarContext)_localctx).size!=null?((DeclaravarContext)_localctx).size.getText():null);
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
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(56);
				match(VIR);
				setState(57);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
					                  }
				                    
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
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
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(T__3);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
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
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);
			          
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				cmd();
				}
				}
				setState(76); 
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
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				cmdleitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				cmdescrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				cmdattrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				cmdif();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				cmdrepeticao();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				cmdincrementa();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
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
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			match(AP);
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(89);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                     	_readID = _input.LT(-1).getText();
										IsiVariable var = (IsiVariable)symbolTable.get(_readID);
										varUsed(_readID);
				              			CommandLeitura cmd = new CommandLeitura(_readID, var);
				              			stack.peek().add(cmd);
				                    
				}
				break;
			case 2:
				{
				{
				setState(91);
				((CmdleituraContext)_localctx).varName = match(ID);
				setState(92);
				match(ACOL);
				setState(93);
				((CmdleituraContext)_localctx).position = match(NUMBER);
				setState(94);
				match(FCOL);

										verificaID((((CmdleituraContext)_localctx).varName!=null?((CmdleituraContext)_localctx).varName.getText():null));
				        				_readID = (((CmdleituraContext)_localctx).varName!=null?((CmdleituraContext)_localctx).varName.getText():null)+"["+(((CmdleituraContext)_localctx).position!=null?((CmdleituraContext)_localctx).position.getText():null)+"]"; 
										IsiVariable var = new IsiVariable((((CmdleituraContext)_localctx).varName!=null?((CmdleituraContext)_localctx).varName.getText():null), 2, null);
										varUsed(_readID);
										CommandLeitura cmd = new CommandLeitura(_readID, var);
				              			stack.peek().add(cmd); 
				}
				}
				break;
			}
			setState(98);
			match(FP);
			setState(99);
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
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__6);
			setState(103);
			match(AP);
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(104);
				match(ID);
				  verificaID(_input.LT(-1).getText());
					                	_writeID = _input.LT(-1).getText();
										CommandEscrita cmd = new CommandEscrita(_writeID, 0);
				            			stack.peek().add(cmd); 
				}
				break;
			case 2:
				{
				setState(106);
				match(ASP);
				setState(107);
				((CmdescritaContext)_localctx).a = match(STRING);
				setState(108);
				match(ASP);
				 
										CommandEscrita cmd = new CommandEscrita(((CmdescritaContext)_localctx).a.getText(), 1);
				            			stack.peek().add(cmd);  
				}
				break;
			case 3:
				{
				setState(110);
				vetor();
										
										CommandEscrita cmd = new CommandEscrita(_exprID, 0);
										stack.peek().add(cmd);
									
				}
				break;
			}
			setState(115);
			match(FP);
			setState(116);
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
		enterRule(_localctx, 16, RULE_vetor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(118);
			((VetorContext)_localctx).varName = match(ID);
			setState(119);
			match(ACOL);
			setState(120);
			((VetorContext)_localctx).position = match(NUMBER);
			setState(121);
			match(FCOL);

					verificaID((((VetorContext)_localctx).varName!=null?((VetorContext)_localctx).varName.getText():null));
			        _exprID = (((VetorContext)_localctx).varName!=null?((VetorContext)_localctx).varName.getText():null)+"["+(((VetorContext)_localctx).position!=null?((VetorContext)_localctx).position.getText():null)+"]";
					if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");
					
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
		enterRule(_localctx, 18, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(124);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    _exprID = _input.LT(-1).getText();
				                   
				}
				}
				break;
			case 2:
				{
				setState(126);
				vetor();
				}
				break;
			}
			setState(129);
			match(ATTR);
			 _exprContent = ""; 
			setState(131);
			expr();
			setState(132);
			match(SC);
							   	
							   	varUsed(_exprID);
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
		enterRule(_localctx, 20, RULE_cmdincrementa);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(135);
					match(ID);
					 verificaID(_input.LT(-1).getText());
										if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");
					                    _exprID = _input.LT(-1).getText();
					                   
					}
					break;
				case 2:
					{
					setState(137);
					vetor();
					}
					break;
				}
				setState(140);
				match(T__7);
				setState(141);
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
				setState(143);
				match(T__7);
				{
				setState(144);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                _exprID = _input.LT(-1).getText();
				                
				setState(146);
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
		enterRule(_localctx, 22, RULE_cmddecrementa);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(150);
					match(ID);
					 verificaID(_input.LT(-1).getText());
					                    _exprID = _input.LT(-1).getText();
										if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");

					                   
					}
					break;
				case 2:
					{
					setState(152);
					vetor();
					}
					break;
				}
				setState(155);
				match(T__8);
				setState(156);
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
				setState(158);
				match(T__8);
				setState(159);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    _exprID = _input.LT(-1).getText();
				                   
				setState(161);
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
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
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
		enterRule(_localctx, 24, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__9);
			setState(166);
			match(AP);
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(167);
				match(ID);
				 
										verificaID(_input.LT(-1).getText());
										_exprDecision = _input.LT(-1).getText(); 
										if(isVarUsed(_exprDecision)==false) throw new IsiSemanticException("Variavel nao utilizada"); 
				}
				break;
			case 2:
				{
				{
				setState(169);
				((CmdifContext)_localctx).varName = match(ID);
				setState(170);
				match(ACOL);
				setState(171);
				((CmdifContext)_localctx).position = match(NUMBER);
				setState(172);
				match(FCOL);

										if(isVarUsed(_exprDecision)==false) throw new IsiSemanticException("Variavel nao utilizada");
										verificaID((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null));
				       					_exprDecision = (((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)+"["+(((CmdifContext)_localctx).position!=null?((CmdifContext)_localctx).position.getText():null)+"]";
				}
				}
				break;
			}
			setState(176);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(178);
					((CmdifContext)_localctx).varName = match(ID);
					}
					break;
				case NUMBER:
					{
					setState(179);
					match(NUMBER);

											verificaID((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null));
											_exprDecision += _input.LT(-1).getText(); 
											if(isVarUsed((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null))==false) throw new IsiSemanticException("Variavel nao utilizada");
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				{
				setState(183);
				((CmdifContext)_localctx).varName = match(ID);
				setState(184);
				match(ACOL);
				setState(185);
				((CmdifContext)_localctx).position = match(NUMBER);
				setState(186);
				match(FCOL);
				 
										verificaID((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null));
				       					_exprDecision += (((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null)+"["+(((CmdifContext)_localctx).position!=null?((CmdifContext)_localctx).position.getText():null)+"]";
										if(isVarUsed((((CmdifContext)_localctx).varName!=null?((CmdifContext)_localctx).varName.getText():null))==false) throw new IsiSemanticException("Variavel nao utilizada");
										
				}
				}
				break;
			}
			setState(190);
			match(FP);
			setState(191);
			match(T__10);
			setState(192);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				cmd();
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(199);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(201);
				match(T__11);
				setState(202);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					cmd();
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
				}
				setState(209);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
				}
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

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public Token varName;
		public Token position;
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
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
		enterRule(_localctx, 26, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__12);
			setState(215);
			match(AP);
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				{
				setState(216);
				match(ID);

											verificaID(_input.LT(-1).getText());
											if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");
											_exprID = _input.LT(-1).getText();
				}
				}
				break;
			case 2:
				{
				{
				setState(218);
				((CmdrepeticaoContext)_localctx).varName = match(ID);
				setState(219);
				match(ACOL);
				setState(220);
				((CmdrepeticaoContext)_localctx).position = match(NUMBER);
				setState(221);
				match(FCOL);

												verificaID((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null));
												if(isVarUsed((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null))==false) throw new IsiSemanticException("Variavel nao utilizada");
												_exprID = (((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)+"["+(((CmdrepeticaoContext)_localctx).position!=null?((CmdrepeticaoContext)_localctx).position.getText():null)+"]";
											
				}
				}
				break;
			}
			setState(225);
			match(OPREL);
			 
											_exprDecision = "";
											_exprDecision += _input.LT(-1).getText(); 
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(230);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(227);
					((CmdrepeticaoContext)_localctx).varName = match(ID);
					}
					break;
				case NUMBER:
					{
					setState(228);
					match(NUMBER);

													verificaID((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null));
													if(isVarUsed((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null))==false) throw new IsiSemanticException("Variavel nao utilizada");
													_exprDecision += _input.LT(-1).getText(); 
													
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				{
				setState(232);
				((CmdrepeticaoContext)_localctx).varName = match(ID);
				setState(233);
				match(ACOL);
				setState(234);
				((CmdrepeticaoContext)_localctx).position = match(NUMBER);
				setState(235);
				match(FCOL);
				 
												verificaID((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null));
												if(isVarUsed((((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null))==false) throw new IsiSemanticException("Variavel nao utilizada");
				       							_exprDecision += (((CmdrepeticaoContext)_localctx).varName!=null?((CmdrepeticaoContext)_localctx).varName.getText():null)+"["+(((CmdrepeticaoContext)_localctx).position!=null?((CmdrepeticaoContext)_localctx).position.getText():null)+"]";
				}
				}
				break;
			}
			setState(239);
			match(FP);
			setState(240);
			match(ACH);
			 	curThread = new ArrayList<AbstractCommand>(); 
			                      			stack.push(curThread);
			                    		
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				cmd();
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(247);
			match(FCH);

											listaTrue = stack.pop();
											CommandRepeticao cmd = new CommandRepeticao(_exprID, _exprDecision, listaTrue);
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
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			termo();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(251);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(253);
				termo();
				}
				}
				setState(258);
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
		enterRule(_localctx, 30, RULE_termo);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u010c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\49\n\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\5I\n\5\3\6\3\6\6\6M\n\6\r\6\16\6N\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7X\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bc\n\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tt\n\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u0082\n\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u008d\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0097\n\f\3\r\3\r\3\r\5\r\u009c\n\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u00a6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u00b1\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b8\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00bf\n\16\3\16\3\16\3\16\3\16\3\16\6\16\u00c6\n\16\r"+
		"\16\16\16\u00c7\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00d0\n\16\r\16\16"+
		"\16\u00d1\3\16\3\16\3\16\5\16\u00d7\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00e2\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e9\n"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f0\n\17\3\17\3\17\3\17\3\17\6\17"+
		"\u00f6\n\17\r\17\16\17\u00f7\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0101"+
		"\n\20\f\20\16\20\u0104\13\20\3\21\3\21\3\21\3\21\5\21\u010a\n\21\3\21"+
		"\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u011a\2\"\3\2\2"+
		"\2\4)\3\2\2\2\68\3\2\2\2\bH\3\2\2\2\nJ\3\2\2\2\fW\3\2\2\2\16Y\3\2\2\2"+
		"\20h\3\2\2\2\22x\3\2\2\2\24\u0081\3\2\2\2\26\u0096\3\2\2\2\30\u00a5\3"+
		"\2\2\2\32\u00a7\3\2\2\2\34\u00d8\3\2\2\2\36\u00fc\3\2\2\2 \u0109\3\2\2"+
		"\2\"#\7\3\2\2#$\5\4\3\2$%\5\n\6\2%&\7\4\2\2&\'\b\2\1\2\'\3\3\2\2\2(*\5"+
		"\6\4\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-.\5\b\5\2./"+
		"\7\34\2\2/\60\b\4\1\2\609\3\2\2\2\61\62\7\5\2\2\62\63\b\4\1\2\63\64\7"+
		"\31\2\2\64\65\7\35\2\2\65\66\7\32\2\2\66\67\7\34\2\2\679\b\4\1\28-\3\2"+
		"\2\28\61\3\2\2\29?\3\2\2\2:;\7\25\2\2;<\7\34\2\2<>\b\4\1\2=:\3\2\2\2>"+
		"A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\22\2\2C\7\3\2\2"+
		"\2DE\7\6\2\2EI\b\5\1\2FG\7\7\2\2GI\b\5\1\2HD\3\2\2\2HF\3\2\2\2I\t\3\2"+
		"\2\2JL\b\6\1\2KM\5\f\7\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\13\3"+
		"\2\2\2PX\5\16\b\2QX\5\20\t\2RX\5\24\13\2SX\5\32\16\2TX\5\34\17\2UX\5\26"+
		"\f\2VX\5\30\r\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3"+
		"\2\2\2WV\3\2\2\2X\r\3\2\2\2YZ\7\b\2\2Zb\7\20\2\2[\\\7\34\2\2\\c\b\b\1"+
		"\2]^\7\34\2\2^_\7\31\2\2_`\7\35\2\2`a\7\32\2\2ac\b\b\1\2b[\3\2\2\2b]\3"+
		"\2\2\2cd\3\2\2\2de\7\21\2\2ef\7\22\2\2fg\b\b\1\2g\17\3\2\2\2hi\7\t\2\2"+
		"is\7\20\2\2jk\7\34\2\2kt\b\t\1\2lm\7\30\2\2mn\7\37\2\2no\7\30\2\2ot\b"+
		"\t\1\2pq\5\22\n\2qr\b\t\1\2rt\3\2\2\2sj\3\2\2\2sl\3\2\2\2sp\3\2\2\2tu"+
		"\3\2\2\2uv\7\21\2\2vw\7\22\2\2w\21\3\2\2\2xy\7\34\2\2yz\7\31\2\2z{\7\35"+
		"\2\2{|\7\32\2\2|}\b\n\1\2}\23\3\2\2\2~\177\7\34\2\2\177\u0082\b\13\1\2"+
		"\u0080\u0082\5\22\n\2\u0081~\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3"+
		"\2\2\2\u0083\u0084\7\24\2\2\u0084\u0085\b\13\1\2\u0085\u0086\5\36\20\2"+
		"\u0086\u0087\7\22\2\2\u0087\u0088\b\13\1\2\u0088\25\3\2\2\2\u0089\u008a"+
		"\7\34\2\2\u008a\u008d\b\f\1\2\u008b\u008d\5\22\n\2\u008c\u0089\3\2\2\2"+
		"\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\n\2\2\u008f\u0090"+
		"\7\22\2\2\u0090\u0097\b\f\1\2\u0091\u0092\7\n\2\2\u0092\u0093\7\34\2\2"+
		"\u0093\u0094\b\f\1\2\u0094\u0095\7\22\2\2\u0095\u0097\b\f\1\2\u0096\u008c"+
		"\3\2\2\2\u0096\u0091\3\2\2\2\u0097\27\3\2\2\2\u0098\u0099\7\34\2\2\u0099"+
		"\u009c\b\r\1\2\u009a\u009c\5\22\n\2\u009b\u0098\3\2\2\2\u009b\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\13\2\2\u009e\u009f\7\22\2\2\u009f"+
		"\u00a6\b\r\1\2\u00a0\u00a1\7\13\2\2\u00a1\u00a2\7\34\2\2\u00a2\u00a3\b"+
		"\r\1\2\u00a3\u00a4\7\22\2\2\u00a4\u00a6\b\r\1\2\u00a5\u009b\3\2\2\2\u00a5"+
		"\u00a0\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a8\7\f\2\2\u00a8\u00b0\7\20\2"+
		"\2\u00a9\u00aa\7\34\2\2\u00aa\u00b1\b\16\1\2\u00ab\u00ac\7\34\2\2\u00ac"+
		"\u00ad\7\31\2\2\u00ad\u00ae\7\35\2\2\u00ae\u00af\7\32\2\2\u00af\u00b1"+
		"\b\16\1\2\u00b0\u00a9\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\u00b2\3\2\2\2"+
		"\u00b2\u00b3\7\33\2\2\u00b3\u00be\b\16\1\2\u00b4\u00b8\7\34\2\2\u00b5"+
		"\u00b6\7\35\2\2\u00b6\u00b8\b\16\1\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b8\u00bf\3\2\2\2\u00b9\u00ba\7\34\2\2\u00ba\u00bb\7\31\2\2\u00bb"+
		"\u00bc\7\35\2\2\u00bc\u00bd\7\32\2\2\u00bd\u00bf\b\16\1\2\u00be\u00b7"+
		"\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\21\2\2"+
		"\u00c1\u00c2\7\r\2\2\u00c2\u00c3\7\26\2\2\u00c3\u00c5\b\16\1\2\u00c4\u00c6"+
		"\5\f\7\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7\27\2\2\u00ca\u00d6\b"+
		"\16\1\2\u00cb\u00cc\7\16\2\2\u00cc\u00cd\7\26\2\2\u00cd\u00cf\b\16\1\2"+
		"\u00ce\u00d0\5\f\7\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\27\2\2"+
		"\u00d4\u00d5\b\16\1\2\u00d5\u00d7\3\2\2\2\u00d6\u00cb\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\33\3\2\2\2\u00d8\u00d9\7\17\2\2\u00d9\u00e1\7\20\2\2\u00da"+
		"\u00db\7\34\2\2\u00db\u00e2\b\17\1\2\u00dc\u00dd\7\34\2\2\u00dd\u00de"+
		"\7\31\2\2\u00de\u00df\7\35\2\2\u00df\u00e0\7\32\2\2\u00e0\u00e2\b\17\1"+
		"\2\u00e1\u00da\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4"+
		"\7\33\2\2\u00e4\u00ef\b\17\1\2\u00e5\u00e9\7\34\2\2\u00e6\u00e7\7\35\2"+
		"\2\u00e7\u00e9\b\17\1\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00f0\3\2\2\2\u00ea\u00eb\7\34\2\2\u00eb\u00ec\7\31\2\2\u00ec\u00ed\7"+
		"\35\2\2\u00ed\u00ee\7\32\2\2\u00ee\u00f0\b\17\1\2\u00ef\u00e8\3\2\2\2"+
		"\u00ef\u00ea\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\7\21\2\2\u00f2\u00f3"+
		"\7\26\2\2\u00f3\u00f5\b\17\1\2\u00f4\u00f6\5\f\7\2\u00f5\u00f4\3\2\2\2"+
		"\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fa\7\27\2\2\u00fa\u00fb\b\17\1\2\u00fb\35\3\2\2\2\u00fc"+
		"\u0102\5 \21\2\u00fd\u00fe\7\23\2\2\u00fe\u00ff\b\20\1\2\u00ff\u0101\5"+
		" \21\2\u0100\u00fd\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\37\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\34\2"+
		"\2\u0106\u010a\b\21\1\2\u0107\u0108\7\35\2\2\u0108\u010a\b\21\1\2\u0109"+
		"\u0105\3\2\2\2\u0109\u0107\3\2\2\2\u010a!\3\2\2\2\33+8?HNWbs\u0081\u008c"+
		"\u0096\u009b\u00a5\u00b0\u00b7\u00be\u00c7\u00d1\u00d6\u00e1\u00e8\u00ef"+
		"\u00f7\u0102\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}