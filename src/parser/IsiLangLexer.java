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
		WS=28, STRING=29;
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
			"ACH", "FCH", "ASP", "ACOL", "FCOL", "OPREL", "ID", "NUMBER", "WS", "STRING"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00cc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00ae"+
		"\n\32\3\33\3\33\7\33\u00b2\n\33\f\33\16\33\u00b5\13\33\3\34\6\34\u00b8"+
		"\n\34\r\34\16\34\u00b9\3\34\3\34\6\34\u00be\n\34\r\34\16\34\u00bf\5\34"+
		"\u00c2\n\34\3\35\3\35\3\35\3\35\3\36\6\36\u00c9\n\36\r\36\16\36\u00ca"+
		"\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13"+
		"\f\17\17\"\"\2\u00d4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5F\3\2\2\2\7O\3\2\2\2\tU\3\2\2\2"+
		"\13\\\3\2\2\2\rb\3\2\2\2\17g\3\2\2\2\21o\3\2\2\2\23r\3\2\2\2\25u\3\2\2"+
		"\2\27x\3\2\2\2\31~\3\2\2\2\33\u0084\3\2\2\2\35\u008d\3\2\2\2\37\u008f"+
		"\3\2\2\2!\u0091\3\2\2\2#\u0093\3\2\2\2%\u0095\3\2\2\2\'\u0098\3\2\2\2"+
		")\u009a\3\2\2\2+\u009c\3\2\2\2-\u009e\3\2\2\2/\u00a0\3\2\2\2\61\u00a2"+
		"\3\2\2\2\63\u00ad\3\2\2\2\65\u00af\3\2\2\2\67\u00b7\3\2\2\29\u00c3\3\2"+
		"\2\2;\u00c8\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7i\2\2AB\7t\2\2BC\7c"+
		"\2\2CD\7o\2\2DE\7c\2\2E\4\3\2\2\2FG\7h\2\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2"+
		"JK\7t\2\2KL\7q\2\2LM\7i\2\2MN\7=\2\2N\6\3\2\2\2OP\7x\2\2PQ\7g\2\2QR\7"+
		"v\2\2RS\7q\2\2ST\7t\2\2T\b\3\2\2\2UV\7p\2\2VW\7w\2\2WX\7o\2\2XY\7g\2\2"+
		"YZ\7t\2\2Z[\7q\2\2[\n\3\2\2\2\\]\7v\2\2]^\7g\2\2^_\7z\2\2_`\7v\2\2`a\7"+
		"q\2\2a\f\3\2\2\2bc\7n\2\2cd\7g\2\2de\7k\2\2ef\7c\2\2f\16\3\2\2\2gh\7g"+
		"\2\2hi\7u\2\2ij\7e\2\2jk\7t\2\2kl\7g\2\2lm\7x\2\2mn\7c\2\2n\20\3\2\2\2"+
		"op\7-\2\2pq\7-\2\2q\22\3\2\2\2rs\7/\2\2st\7/\2\2t\24\3\2\2\2uv\7u\2\2"+
		"vw\7g\2\2w\26\3\2\2\2xy\7g\2\2yz\7p\2\2z{\7v\2\2{|\7c\2\2|}\7q\2\2}\30"+
		"\3\2\2\2~\177\7u\2\2\177\u0080\7g\2\2\u0080\u0081\7p\2\2\u0081\u0082\7"+
		"c\2\2\u0082\u0083\7q\2\2\u0083\32\3\2\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7p\2\2\u0086\u0087\7s\2\2\u0087\u0088\7w\2\2\u0088\u0089\7c\2\2\u0089"+
		"\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\u008c\7q\2\2\u008c\34\3\2\2\2\u008d"+
		"\u008e\7*\2\2\u008e\36\3\2\2\2\u008f\u0090\7+\2\2\u0090 \3\2\2\2\u0091"+
		"\u0092\7=\2\2\u0092\"\3\2\2\2\u0093\u0094\t\2\2\2\u0094$\3\2\2\2\u0095"+
		"\u0096\7<\2\2\u0096\u0097\7?\2\2\u0097&\3\2\2\2\u0098\u0099\7.\2\2\u0099"+
		"(\3\2\2\2\u009a\u009b\7}\2\2\u009b*\3\2\2\2\u009c\u009d\7\177\2\2\u009d"+
		",\3\2\2\2\u009e\u009f\7$\2\2\u009f.\3\2\2\2\u00a0\u00a1\7]\2\2\u00a1\60"+
		"\3\2\2\2\u00a2\u00a3\7_\2\2\u00a3\62\3\2\2\2\u00a4\u00ae\t\3\2\2\u00a5"+
		"\u00a6\7@\2\2\u00a6\u00ae\7?\2\2\u00a7\u00a8\7>\2\2\u00a8\u00ae\7?\2\2"+
		"\u00a9\u00aa\7?\2\2\u00aa\u00ae\7?\2\2\u00ab\u00ac\7#\2\2\u00ac\u00ae"+
		"\7?\2\2\u00ad\u00a4\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ad"+
		"\u00a9\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\64\3\2\2\2\u00af\u00b3\t\4\2"+
		"\2\u00b0\u00b2\t\5\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\66\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6"+
		"\u00b8\t\6\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00c1\3\2\2\2\u00bb\u00bd\7\60\2\2\u00bc"+
		"\u00be\t\6\2\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c28\3\2\2\2\u00c3\u00c4\t\7\2\2\u00c4\u00c5\3\2\2\2"+
		"\u00c5\u00c6\b\35\2\2\u00c6:\3\2\2\2\u00c7\u00c9\t\5\2\2\u00c8\u00c7\3"+
		"\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"<\3\2\2\2\13\2\u00ad\u00b1\u00b3\u00b9\u00bf\u00c1\u00c8\u00ca\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}