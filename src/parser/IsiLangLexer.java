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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, AP=14, FP=15, SC=16, OP=17, ATTR=18, 
		VIR=19, ACH=20, FCH=21, ASP=22, ACOL=23, FCOL=24, OPREL=25, ID=26, NUMBER=27, 
		WS=28, STRING=29, BOOL=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "AP", "FP", "SC", "OP", "ATTR", "VIR", 
			"ACH", "FCH", "ASP", "ACOL", "FCOL", "OPREL", "ID", "NUMBER", "WS", "STRING", 
			"BOOL"
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


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00df\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00b0"+
		"\n\32\3\33\3\33\7\33\u00b4\n\33\f\33\16\33\u00b7\13\33\3\34\6\34\u00ba"+
		"\n\34\r\34\16\34\u00bb\3\34\3\34\6\34\u00c0\n\34\r\34\16\34\u00c1\5\34"+
		"\u00c4\n\34\3\35\3\35\3\35\3\35\3\36\6\36\u00cb\n\36\r\36\16\36\u00cc"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u00de\n\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= \3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62"+
		";C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00e8\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2"+
		"\5H\3\2\2\2\7Q\3\2\2\2\tW\3\2\2\2\13^\3\2\2\2\rd\3\2\2\2\17i\3\2\2\2\21"+
		"q\3\2\2\2\23t\3\2\2\2\25w\3\2\2\2\27z\3\2\2\2\31\u0080\3\2\2\2\33\u0086"+
		"\3\2\2\2\35\u008f\3\2\2\2\37\u0091\3\2\2\2!\u0093\3\2\2\2#\u0095\3\2\2"+
		"\2%\u0097\3\2\2\2\'\u009a\3\2\2\2)\u009c\3\2\2\2+\u009e\3\2\2\2-\u00a0"+
		"\3\2\2\2/\u00a2\3\2\2\2\61\u00a4\3\2\2\2\63\u00af\3\2\2\2\65\u00b1\3\2"+
		"\2\2\67\u00b9\3\2\2\29\u00c5\3\2\2\2;\u00ca\3\2\2\2=\u00dd\3\2\2\2?@\7"+
		"r\2\2@A\7t\2\2AB\7q\2\2BC\7i\2\2CD\7t\2\2DE\7c\2\2EF\7o\2\2FG\7c\2\2G"+
		"\4\3\2\2\2HI\7h\2\2IJ\7k\2\2JK\7o\2\2KL\7r\2\2LM\7t\2\2MN\7q\2\2NO\7i"+
		"\2\2OP\7=\2\2P\6\3\2\2\2QR\7x\2\2RS\7g\2\2ST\7v\2\2TU\7q\2\2UV\7t\2\2"+
		"V\b\3\2\2\2WX\7p\2\2XY\7w\2\2YZ\7o\2\2Z[\7g\2\2[\\\7t\2\2\\]\7q\2\2]\n"+
		"\3\2\2\2^_\7v\2\2_`\7g\2\2`a\7z\2\2ab\7v\2\2bc\7q\2\2c\f\3\2\2\2de\7n"+
		"\2\2ef\7g\2\2fg\7k\2\2gh\7c\2\2h\16\3\2\2\2ij\7g\2\2jk\7u\2\2kl\7e\2\2"+
		"lm\7t\2\2mn\7g\2\2no\7x\2\2op\7c\2\2p\20\3\2\2\2qr\7-\2\2rs\7-\2\2s\22"+
		"\3\2\2\2tu\7/\2\2uv\7/\2\2v\24\3\2\2\2wx\7u\2\2xy\7g\2\2y\26\3\2\2\2z"+
		"{\7g\2\2{|\7p\2\2|}\7v\2\2}~\7c\2\2~\177\7q\2\2\177\30\3\2\2\2\u0080\u0081"+
		"\7u\2\2\u0081\u0082\7g\2\2\u0082\u0083\7p\2\2\u0083\u0084\7c\2\2\u0084"+
		"\u0085\7q\2\2\u0085\32\3\2\2\2\u0086\u0087\7g\2\2\u0087\u0088\7p\2\2\u0088"+
		"\u0089\7s\2\2\u0089\u008a\7w\2\2\u008a\u008b\7c\2\2\u008b\u008c\7p\2\2"+
		"\u008c\u008d\7v\2\2\u008d\u008e\7q\2\2\u008e\34\3\2\2\2\u008f\u0090\7"+
		"*\2\2\u0090\36\3\2\2\2\u0091\u0092\7+\2\2\u0092 \3\2\2\2\u0093\u0094\7"+
		"=\2\2\u0094\"\3\2\2\2\u0095\u0096\t\2\2\2\u0096$\3\2\2\2\u0097\u0098\7"+
		"<\2\2\u0098\u0099\7?\2\2\u0099&\3\2\2\2\u009a\u009b\7.\2\2\u009b(\3\2"+
		"\2\2\u009c\u009d\7}\2\2\u009d*\3\2\2\2\u009e\u009f\7\177\2\2\u009f,\3"+
		"\2\2\2\u00a0\u00a1\7$\2\2\u00a1.\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3\60\3"+
		"\2\2\2\u00a4\u00a5\7_\2\2\u00a5\62\3\2\2\2\u00a6\u00b0\t\3\2\2\u00a7\u00a8"+
		"\7@\2\2\u00a8\u00b0\7?\2\2\u00a9\u00aa\7>\2\2\u00aa\u00b0\7?\2\2\u00ab"+
		"\u00ac\7?\2\2\u00ac\u00b0\7?\2\2\u00ad\u00ae\7#\2\2\u00ae\u00b0\7?\2\2"+
		"\u00af\u00a6\3\2\2\2\u00af\u00a7\3\2\2\2\u00af\u00a9\3\2\2\2\u00af\u00ab"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\64\3\2\2\2\u00b1\u00b5\t\4\2\2\u00b2"+
		"\u00b4\t\5\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\66\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba"+
		"\t\6\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00c3\3\2\2\2\u00bd\u00bf\7\60\2\2\u00be\u00c0\t"+
		"\6\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c48\3\2\2\2\u00c5\u00c6\t\7\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8"+
		"\b\35\2\2\u00c8:\3\2\2\2\u00c9\u00cb\t\5\2\2\u00ca\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd<\3\2\2\2"+
		"\u00ce\u00cf\7x\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2"+
		"\7f\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7f\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d6\7k\2\2\u00d6\u00d7\7t\2\2\u00d7\u00de\7q\2\2\u00d8\u00d9\7h\2\2"+
		"\u00d9\u00da\7c\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7u\2\2\u00dc\u00de"+
		"\7q\2\2\u00dd\u00ce\3\2\2\2\u00dd\u00d8\3\2\2\2\u00de>\3\2\2\2\f\2\u00af"+
		"\u00b3\u00b5\u00bb\u00c1\u00c3\u00ca\u00cc\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}