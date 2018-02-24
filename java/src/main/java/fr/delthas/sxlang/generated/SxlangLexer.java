// Generated from C:/Users/delthas/Java/sxlang/src/main/resources\Sxlang.g4 by ANTLR 4.7
package fr.delthas.sxlang.generated;

import java.util.*;
import fr.delthas.sxlang.types.*;
import static fr.delthas.sxlang.SxlangAux.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SxlangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IGNORE_SKIP=1, IGNORE_LEFT=2, IGNORE_RIGHT=3, PLATFORM_KEY=4, PLATFORM_EQUALS=5, 
		PLATFORM_VALUE=6, PLATFORM_START=7, PLATFORM_END=8, LEFT_BRACKET_SKIP=9, 
		RIGHT_BRACKET_SKIP=10, LEFT_BRACKET=11, RIGHT_BRACKET=12, ASM_START=13, 
		STRING_LITERAL=14, ASM_LITERAL=15, NUMBER_TYPE_ALPHANUMERIC=16, NUMBER_TYPE=17, 
		MAJ_ID=18, MIN_ID=19, NUMBER_LITERAL=20, WS=21, COMMENT=22, LINE_COMMENT=23, 
		NEWLINE=24, EQUALSEQUALS=25, NOTEQUALS=26, ASSEQ=27, EQUALS=28, TILDATILDA=29, 
		TILDA=30, HASH=31, LEQ=32, GEQ=33, PLUSE=34, MINUSE=35, ASTERISKE=36, 
		SLASHE=37, ESPERE=38, PIPEE=39, CIRCONE=40, RIGHT2_E=41, RIGHT3_E=42, 
		LEFT2_E=43, PERCENTE=44, SQUARE_BRACKET_PAIR=45, LEFT_SQUARE_BRACKET=46, 
		RIGHT_SQUARE_BRACKET=47, DOLLAR=48, ARROW=49, CIRCON=50, PIPEPIPE=51, 
		PIPE=52, PERCENT=53, SLASH=54, ASTERISK=55, DOT=56, ESPERESPER=57, ESPER=58, 
		COLONCOLON=59, UNDERSCORE=60, AT=61, COLON=62, PARAGRAPH=63, LEFT2_ANGLE=64, 
		RIGHT3_ANGLE=65, RIGHT2_ANGLE=66, LEFT_ANGLE=67, RIGHT_ANGLE=68, INTERROCOLON=69, 
		INTERRO=70, EXCLA=71, COMMA=72, LEFT_PAREN=73, RIGHT_PAREN=74, PLUSPLUS=75, 
		MINUSMINUS=76, PLUS=77, MINUS=78;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IGNORE_SKIP", "IGNORE_LEFT", "IGNORE_RIGHT", "PLATFORM_KEY", "PLATFORM_EQUALS", 
		"PLATFORM_VALUE", "PLATFORM_START", "PLATFORM_END", "LEFT_BRACKET_SKIP", 
		"RIGHT_BRACKET_SKIP", "LEFT_BRACKET", "RIGHT_BRACKET", "ASM_START", "NUMBER_SUFFIX", 
		"STRING_LITERAL", "ASM_LITERAL", "NUMBER_TYPE_ALPHANUMERIC", "NUMBER_TYPE", 
		"MAJ_ID", "MIN_ID", "NUMBER_LITERAL", "WS", "COMMENT", "LINE_COMMENT", 
		"NEWLINE", "EQUALSEQUALS", "NOTEQUALS", "ASSEQ", "EQUALS", "TILDATILDA", 
		"TILDA", "HASH", "LEQ", "GEQ", "PLUSE", "MINUSE", "ASTERISKE", "SLASHE", 
		"ESPERE", "PIPEE", "CIRCONE", "RIGHT2_E", "RIGHT3_E", "LEFT2_E", "PERCENTE", 
		"SQUARE_BRACKET_PAIR", "LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", 
		"DOLLAR", "ARROW", "CIRCON", "PIPEPIPE", "PIPE", "PERCENT", "SLASH", "ASTERISK", 
		"DOT", "ESPERESPER", "ESPER", "COLONCOLON", "UNDERSCORE", "AT", "COLON", 
		"PARAGRAPH", "LEFT2_ANGLE", "RIGHT3_ANGLE", "RIGHT2_ANGLE", "LEFT_ANGLE", 
		"RIGHT_ANGLE", "INTERROCOLON", "INTERRO", "EXCLA", "COMMA", "LEFT_PAREN", 
		"RIGHT_PAREN", "PLUSPLUS", "MINUSMINUS", "PLUS", "MINUS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "'{'", 
		"'}'", "'\u00E7'", null, null, null, null, null, null, null, null, null, 
		null, null, "'=='", "'!='", "':='", "'='", "'~~'", "'~'", "'#'", "'<='", 
		"'>='", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'>>='", 
		"'>>>='", "'<<='", "'%='", "'[]'", "'['", "']'", "'$'", "'->'", "'^'", 
		"'||'", "'|'", "'%'", "'/'", "'*'", "'.'", "'&&'", "'&'", "'::'", "'_'", 
		"'@'", "':'", "'\u00A7'", "'<<'", "'>>>'", "'>>'", "'<'", "'>'", "'?:'", 
		"'?'", "'!'", "','", "'('", "')'", "'++'", "'--'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IGNORE_SKIP", "IGNORE_LEFT", "IGNORE_RIGHT", "PLATFORM_KEY", "PLATFORM_EQUALS", 
		"PLATFORM_VALUE", "PLATFORM_START", "PLATFORM_END", "LEFT_BRACKET_SKIP", 
		"RIGHT_BRACKET_SKIP", "LEFT_BRACKET", "RIGHT_BRACKET", "ASM_START", "STRING_LITERAL", 
		"ASM_LITERAL", "NUMBER_TYPE_ALPHANUMERIC", "NUMBER_TYPE", "MAJ_ID", "MIN_ID", 
		"NUMBER_LITERAL", "WS", "COMMENT", "LINE_COMMENT", "NEWLINE", "EQUALSEQUALS", 
		"NOTEQUALS", "ASSEQ", "EQUALS", "TILDATILDA", "TILDA", "HASH", "LEQ", 
		"GEQ", "PLUSE", "MINUSE", "ASTERISKE", "SLASHE", "ESPERE", "PIPEE", "CIRCONE", 
		"RIGHT2_E", "RIGHT3_E", "LEFT2_E", "PERCENTE", "SQUARE_BRACKET_PAIR", 
		"LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", "DOLLAR", "ARROW", "CIRCON", 
		"PIPEPIPE", "PIPE", "PERCENT", "SLASH", "ASTERISK", "DOT", "ESPERESPER", 
		"ESPER", "COLONCOLON", "UNDERSCORE", "AT", "COLON", "PARAGRAPH", "LEFT2_ANGLE", 
		"RIGHT3_ANGLE", "RIGHT2_ANGLE", "LEFT_ANGLE", "RIGHT_ANGLE", "INTERROCOLON", 
		"INTERRO", "EXCLA", "COMMA", "LEFT_PAREN", "RIGHT_PAREN", "PLUSPLUS", 
		"MINUSMINUS", "PLUS", "MINUS"
	};
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


	  public String[] target;
	  private boolean asm;
	  private boolean platform;
	  private boolean ignore;
	  private int ignoreBrackets=-1;
	  private boolean validSpec;
	  private PlatformKey platformKey;
	  int lastTokenType = 0;
	  public void emit(Token token) {
	      super.emit(token);
	      lastTokenType = token.getType();
	  }
	  private static PlatformKey getPlatformKey(String id) {
	    if(id == null) return null;
	    switch(id) {
	      case "arch": return PlatformKey.Arch;
	      case "vendor": return PlatformKey.Vendor;
	      case "sys": return PlatformKey.Sys;
	      case "abi": return PlatformKey.Abi;
	      default: return null;
	    }
	  }
	  private void checkPlatform(PlatformKey key, String value) {
	    if(!validSpec) return;
	    switch(key) {
	      case Arch:
	        if(!target[0].startsWith(value)) validSpec=false;
	        return;
	      case Vendor:
	        if(!target[1].equals(value)) validSpec=false;
	        return;
	      case Sys:
	        if(!target[2].equals(value)) validSpec=false;
	        return;
	      case Abi:
	        if(!target[3].equals(value)) validSpec=false;
	        return;
	      default: throw new IllegalArgumentException("invalid platform key");
	    }
	  }


	public SxlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sxlang.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			IGNORE_LEFT_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			IGNORE_RIGHT_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			PLATFORM_KEY_action((RuleContext)_localctx, actionIndex);
			break;
		case 5:
			PLATFORM_VALUE_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			PLATFORM_START_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			PLATFORM_END_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			LEFT_BRACKET_SKIP_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			RIGHT_BRACKET_SKIP_action((RuleContext)_localctx, actionIndex);
			break;
		case 10:
			LEFT_BRACKET_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
			RIGHT_BRACKET_action((RuleContext)_localctx, actionIndex);
			break;
		case 12:
			ASM_START_action((RuleContext)_localctx, actionIndex);
			break;
		case 15:
			ASM_LITERAL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void IGNORE_LEFT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			++ignoreBrackets;
			break;
		}
	}
	private void IGNORE_RIGHT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			if(--ignoreBrackets<=0){ignore=false;ignoreBrackets=-1;}
			break;
		}
	}
	private void PLATFORM_KEY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			platformKey = getPlatformKey(getText());
			break;
		}
	}
	private void PLATFORM_VALUE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			checkPlatform(platformKey, getText());platformKey=null;
			break;
		}
	}
	private void PLATFORM_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			platform=true; validSpec=true;
			break;
		}
	}
	private void PLATFORM_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			ignoreBrackets=0;ignore=!validSpec;platform=false;
			break;
		}
	}
	private void LEFT_BRACKET_SKIP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			++ignoreBrackets;
			break;
		}
	}
	private void RIGHT_BRACKET_SKIP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			ignoreBrackets=-1;
			break;
		}
	}
	private void LEFT_BRACKET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			if(ignoreBrackets!=-1) ++ignoreBrackets;
			break;
		}
	}
	private void RIGHT_BRACKET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			if(ignoreBrackets!=-1) --ignoreBrackets;
			break;
		}
	}
	private void ASM_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			asm = true;
			break;
		}
	}
	private void ASM_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			asm = false;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return IGNORE_SKIP_sempred((RuleContext)_localctx, predIndex);
		case 1:
			return IGNORE_LEFT_sempred((RuleContext)_localctx, predIndex);
		case 2:
			return IGNORE_RIGHT_sempred((RuleContext)_localctx, predIndex);
		case 3:
			return PLATFORM_KEY_sempred((RuleContext)_localctx, predIndex);
		case 4:
			return PLATFORM_EQUALS_sempred((RuleContext)_localctx, predIndex);
		case 5:
			return PLATFORM_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 7:
			return PLATFORM_END_sempred((RuleContext)_localctx, predIndex);
		case 8:
			return LEFT_BRACKET_SKIP_sempred((RuleContext)_localctx, predIndex);
		case 9:
			return RIGHT_BRACKET_SKIP_sempred((RuleContext)_localctx, predIndex);
		case 15:
			return ASM_LITERAL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean IGNORE_SKIP_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return ignore;
		}
		return true;
	}
	private boolean IGNORE_LEFT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return ignore;
		}
		return true;
	}
	private boolean IGNORE_RIGHT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return ignore;
		}
		return true;
	}
	private boolean PLATFORM_KEY_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return platform;
		}
		return true;
	}
	private boolean PLATFORM_EQUALS_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return platform;
		}
		return true;
	}
	private boolean PLATFORM_VALUE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return platform;
		}
		return true;
	}
	private boolean PLATFORM_END_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return platform;
		}
		return true;
	}
	private boolean LEFT_BRACKET_SKIP_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return ignoreBrackets==0;
		}
		return true;
	}
	private boolean RIGHT_BRACKET_SKIP_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return ignoreBrackets==1;
		}
		return true;
	}
	private boolean ASM_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return asm;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2P\u0211\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3\2\3\2\3\2\3\2\6\2\u00a6"+
		"\n\2\r\2\16\2\u00a7\5\2\u00aa\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u00cb\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\6\7\u00d8\n\7\r\7\16\7\u00d9\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0111\n\17\3\20\3\20\3\20\3\20\7\20\u0117\n\20\f\20\16\20\u011a\13\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u0123\n\21\f\21\16\21\u0126\13"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u013e\n\23\3\24\3\24"+
		"\7\24\u0142\n\24\f\24\16\24\u0145\13\24\3\25\3\25\7\25\u0149\n\25\f\25"+
		"\16\25\u014c\13\25\3\26\3\26\3\26\7\26\u0151\n\26\f\26\16\26\u0154\13"+
		"\26\5\26\u0156\n\26\3\26\3\26\6\26\u015a\n\26\r\26\16\26\u015b\5\26\u015e"+
		"\n\26\3\27\6\27\u0161\n\27\r\27\16\27\u0162\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\7\30\u016b\n\30\f\30\16\30\u016e\13\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\7\31\u0179\n\31\f\31\16\31\u017c\13\31\3\31\3\31\3"+
		"\32\6\32\u0181\n\32\r\32\16\32\u0182\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3"+
		"$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\3"+
		"\67\38\38\39\39\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A"+
		"\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F\3G\3G\3G\3H\3H\3I\3I\3J\3J"+
		"\3K\3K\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3P\3P\3\u016c\2Q\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#\22%\23"+
		"\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I"+
		"%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63g\64i\65k\66m\67o8q9s:u;w<y={>}"+
		"?\177@\u0081A\u0083B\u0085C\u0087D\u0089E\u008bF\u008dG\u008fH\u0091I"+
		"\u0093J\u0095K\u0097L\u0099M\u009bN\u009dO\u009fP\3\2\17\4\2}}\177\177"+
		"\6\2\"\"??]]__\4\2$$^^\7\2$$^^ppttvv\4\2^^\177\177\6\2ddhhkkww\3\2C\\"+
		"\5\2\62;C\\c|\3\2c|\3\2\63;\3\2\62;\4\2\13\13\"\"\4\2\f\f\17\17\2\u0237"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}"+
		"\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2"+
		"\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\3\u00a1"+
		"\3\2\2\2\5\u00ad\3\2\2\2\7\u00b3\3\2\2\2\t\u00b9\3\2\2\2\13\u00d0\3\2"+
		"\2\2\r\u00d5\3\2\2\2\17\u00df\3\2\2\2\21\u00e5\3\2\2\2\23\u00eb\3\2\2"+
		"\2\25\u00f1\3\2\2\2\27\u00f7\3\2\2\2\31\u00fa\3\2\2\2\33\u00fd\3\2\2\2"+
		"\35\u0110\3\2\2\2\37\u0112\3\2\2\2!\u011d\3\2\2\2#\u012a\3\2\2\2%\u013d"+
		"\3\2\2\2\'\u013f\3\2\2\2)\u0146\3\2\2\2+\u0155\3\2\2\2-\u0160\3\2\2\2"+
		"/\u0166\3\2\2\2\61\u0174\3\2\2\2\63\u0180\3\2\2\2\65\u0184\3\2\2\2\67"+
		"\u0187\3\2\2\29\u018a\3\2\2\2;\u018d\3\2\2\2=\u018f\3\2\2\2?\u0192\3\2"+
		"\2\2A\u0194\3\2\2\2C\u0196\3\2\2\2E\u0199\3\2\2\2G\u019c\3\2\2\2I\u019f"+
		"\3\2\2\2K\u01a2\3\2\2\2M\u01a5\3\2\2\2O\u01a8\3\2\2\2Q\u01ab\3\2\2\2S"+
		"\u01ae\3\2\2\2U\u01b1\3\2\2\2W\u01b5\3\2\2\2Y\u01ba\3\2\2\2[\u01be\3\2"+
		"\2\2]\u01c1\3\2\2\2_\u01c4\3\2\2\2a\u01c6\3\2\2\2c\u01c8\3\2\2\2e\u01ca"+
		"\3\2\2\2g\u01cd\3\2\2\2i\u01cf\3\2\2\2k\u01d2\3\2\2\2m\u01d4\3\2\2\2o"+
		"\u01d6\3\2\2\2q\u01d8\3\2\2\2s\u01da\3\2\2\2u\u01dc\3\2\2\2w\u01df\3\2"+
		"\2\2y\u01e1\3\2\2\2{\u01e4\3\2\2\2}\u01e6\3\2\2\2\177\u01e8\3\2\2\2\u0081"+
		"\u01ea\3\2\2\2\u0083\u01ec\3\2\2\2\u0085\u01ef\3\2\2\2\u0087\u01f3\3\2"+
		"\2\2\u0089\u01f6\3\2\2\2\u008b\u01f8\3\2\2\2\u008d\u01fa\3\2\2\2\u008f"+
		"\u01fd\3\2\2\2\u0091\u01ff\3\2\2\2\u0093\u0201\3\2\2\2\u0095\u0203\3\2"+
		"\2\2\u0097\u0205\3\2\2\2\u0099\u0207\3\2\2\2\u009b\u020a\3\2\2\2\u009d"+
		"\u020d\3\2\2\2\u009f\u020f\3\2\2\2\u00a1\u00a9\6\2\2\2\u00a2\u00aa\5\37"+
		"\20\2\u00a3\u00aa\5\63\32\2\u00a4\u00a6\n\2\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2"+
		"\2\2\u00a9\u00a2\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\b\2\2\2\u00ac\4\3\2\2\2\u00ad\u00ae\6\3\3\2"+
		"\u00ae\u00af\7}\2\2\u00af\u00b0\b\3\3\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2"+
		"\b\3\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\6\4\4\2\u00b4\u00b5\7\177\2\2\u00b5"+
		"\u00b6\b\4\4\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\4\2\2\u00b8\b\3\2\2\2"+
		"\u00b9\u00ca\6\5\5\2\u00ba\u00bb\7c\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd"+
		"\7e\2\2\u00bd\u00cb\7j\2\2\u00be\u00bf\7x\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\u00c1\7p\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3\7q\2\2\u00c3\u00cb\7t\2\2"+
		"\u00c4\u00c5\7u\2\2\u00c5\u00c6\7{\2\2\u00c6\u00cb\7u\2\2\u00c7\u00c8"+
		"\7c\2\2\u00c8\u00c9\7d\2\2\u00c9\u00cb\7k\2\2\u00ca\u00ba\3\2\2\2\u00ca"+
		"\u00be\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\b\5\5\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b\5\2\2\u00cf"+
		"\n\3\2\2\2\u00d0\u00d1\6\6\6\2\u00d1\u00d2\7?\2\2\u00d2\u00d3\3\2\2\2"+
		"\u00d3\u00d4\b\6\2\2\u00d4\f\3\2\2\2\u00d5\u00d7\6\7\7\2\u00d6\u00d8\n"+
		"\3\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\7\6\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\u00de\b\7\2\2\u00de\16\3\2\2\2\u00df\u00e0\7%\2\2\u00e0\u00e1"+
		"\7]\2\2\u00e1\u00e2\b\b\7\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\b\2\2\u00e4"+
		"\20\3\2\2\2\u00e5\u00e6\6\t\b\2\u00e6\u00e7\7_\2\2\u00e7\u00e8\b\t\b\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\t\2\2\u00ea\22\3\2\2\2\u00eb\u00ec"+
		"\6\n\t\2\u00ec\u00ed\7}\2\2\u00ed\u00ee\b\n\t\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\b\n\2\2\u00f0\24\3\2\2\2\u00f1\u00f2\6\13\n\2\u00f2\u00f3\7\177"+
		"\2\2\u00f3\u00f4\b\13\n\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\13\2\2\u00f6"+
		"\26\3\2\2\2\u00f7\u00f8\7}\2\2\u00f8\u00f9\b\f\13\2\u00f9\30\3\2\2\2\u00fa"+
		"\u00fb\7\177\2\2\u00fb\u00fc\b\r\f\2\u00fc\32\3\2\2\2\u00fd\u00fe\7\u00e9"+
		"\2\2\u00fe\u00ff\b\16\r\2\u00ff\34\3\2\2\2\u0100\u0111\7d\2\2\u0101\u0102"+
		"\7w\2\2\u0102\u0111\7/\2\2\u0103\u0111\7w\2\2\u0104\u0105\7w\2\2\u0105"+
		"\u0111\7-\2\2\u0106\u0107\7k\2\2\u0107\u0111\7/\2\2\u0108\u0111\7k\2\2"+
		"\u0109\u010a\7k\2\2\u010a\u0111\7-\2\2\u010b\u010c\7h\2\2\u010c\u0111"+
		"\7/\2\2\u010d\u0111\7h\2\2\u010e\u010f\7h\2\2\u010f\u0111\7-\2\2\u0110"+
		"\u0100\3\2\2\2\u0110\u0101\3\2\2\2\u0110\u0103\3\2\2\2\u0110\u0104\3\2"+
		"\2\2\u0110\u0106\3\2\2\2\u0110\u0108\3\2\2\2\u0110\u0109\3\2\2\2\u0110"+
		"\u010b\3\2\2\2\u0110\u010d\3\2\2\2\u0110\u010e\3\2\2\2\u0111\36\3\2\2"+
		"\2\u0112\u0118\7$\2\2\u0113\u0117\n\4\2\2\u0114\u0115\7^\2\2\u0115\u0117"+
		"\t\5\2\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011b\u011c\7$\2\2\u011c \3\2\2\2\u011d\u011e\6\21\13\2\u011e\u0124"+
		"\7}\2\2\u011f\u0123\n\6\2\2\u0120\u0121\7^\2\2\u0121\u0123\t\6\2\2\u0122"+
		"\u011f\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u0128\7\177\2\2\u0128\u0129\b\21\16\2\u0129\"\3\2\2\2\u012a\u012b\t\7"+
		"\2\2\u012b$\3\2\2\2\u012c\u013e\5#\22\2\u012d\u013e\7d\2\2\u012e\u012f"+
		"\7w\2\2\u012f\u013e\7/\2\2\u0130\u013e\7w\2\2\u0131\u0132\7w\2\2\u0132"+
		"\u013e\7-\2\2\u0133\u0134\7k\2\2\u0134\u013e\7/\2\2\u0135\u013e\7k\2\2"+
		"\u0136\u0137\7k\2\2\u0137\u013e\7-\2\2\u0138\u0139\7h\2\2\u0139\u013e"+
		"\7/\2\2\u013a\u013e\7h\2\2\u013b\u013c\7h\2\2\u013c\u013e\7-\2\2\u013d"+
		"\u012c\3\2\2\2\u013d\u012d\3\2\2\2\u013d\u012e\3\2\2\2\u013d\u0130\3\2"+
		"\2\2\u013d\u0131\3\2\2\2\u013d\u0133\3\2\2\2\u013d\u0135\3\2\2\2\u013d"+
		"\u0136\3\2\2\2\u013d\u0138\3\2\2\2\u013d\u013a\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013e&\3\2\2\2\u013f\u0143\t\b\2\2\u0140\u0142\t\t\2\2\u0141\u0140"+
		"\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"(\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u014a\t\n\2\2\u0147\u0149\t\t\2\2"+
		"\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014b*\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0156\7\62\2\2\u014e"+
		"\u0152\t\13\2\2\u014f\u0151\t\f\2\2\u0150\u014f\3\2\2\2\u0151\u0154\3"+
		"\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0156\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u014d\3\2\2\2\u0155\u014e\3\2\2\2\u0156\u015d\3\2"+
		"\2\2\u0157\u0159\7\60\2\2\u0158\u015a\t\f\2\2\u0159\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2"+
		"\2\2\u015d\u0157\3\2\2\2\u015d\u015e\3\2\2\2\u015e,\3\2\2\2\u015f\u0161"+
		"\t\r\2\2\u0160\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\b\27\2\2\u0165.\3\2\2\2"+
		"\u0166\u0167\7\61\2\2\u0167\u0168\7,\2\2\u0168\u016c\3\2\2\2\u0169\u016b"+
		"\13\2\2\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016d\3\2\2\2"+
		"\u016c\u016a\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170"+
		"\7,\2\2\u0170\u0171\7\61\2\2\u0171\u0172\3\2\2\2\u0172\u0173\b\30\17\2"+
		"\u0173\60\3\2\2\2\u0174\u0175\7\61\2\2\u0175\u0176\7\61\2\2\u0176\u017a"+
		"\3\2\2\2\u0177\u0179\n\16\2\2\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2"+
		"\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017d\u017e\b\31\17\2\u017e\62\3\2\2\2\u017f\u0181\t\16\2\2\u0180"+
		"\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\64\3\2\2\2\u0184\u0185\7?\2\2\u0185\u0186\7?\2\2\u0186\66\3"+
		"\2\2\2\u0187\u0188\7#\2\2\u0188\u0189\7?\2\2\u01898\3\2\2\2\u018a\u018b"+
		"\7<\2\2\u018b\u018c\7?\2\2\u018c:\3\2\2\2\u018d\u018e\7?\2\2\u018e<\3"+
		"\2\2\2\u018f\u0190\7\u0080\2\2\u0190\u0191\7\u0080\2\2\u0191>\3\2\2\2"+
		"\u0192\u0193\7\u0080\2\2\u0193@\3\2\2\2\u0194\u0195\7%\2\2\u0195B\3\2"+
		"\2\2\u0196\u0197\7>\2\2\u0197\u0198\7?\2\2\u0198D\3\2\2\2\u0199\u019a"+
		"\7@\2\2\u019a\u019b\7?\2\2\u019bF\3\2\2\2\u019c\u019d\7-\2\2\u019d\u019e"+
		"\7?\2\2\u019eH\3\2\2\2\u019f\u01a0\7/\2\2\u01a0\u01a1\7?\2\2\u01a1J\3"+
		"\2\2\2\u01a2\u01a3\7,\2\2\u01a3\u01a4\7?\2\2\u01a4L\3\2\2\2\u01a5\u01a6"+
		"\7\61\2\2\u01a6\u01a7\7?\2\2\u01a7N\3\2\2\2\u01a8\u01a9\7(\2\2\u01a9\u01aa"+
		"\7?\2\2\u01aaP\3\2\2\2\u01ab\u01ac\7~\2\2\u01ac\u01ad\7?\2\2\u01adR\3"+
		"\2\2\2\u01ae\u01af\7`\2\2\u01af\u01b0\7?\2\2\u01b0T\3\2\2\2\u01b1\u01b2"+
		"\7@\2\2\u01b2\u01b3\7@\2\2\u01b3\u01b4\7?\2\2\u01b4V\3\2\2\2\u01b5\u01b6"+
		"\7@\2\2\u01b6\u01b7\7@\2\2\u01b7\u01b8\7@\2\2\u01b8\u01b9\7?\2\2\u01b9"+
		"X\3\2\2\2\u01ba\u01bb\7>\2\2\u01bb\u01bc\7>\2\2\u01bc\u01bd\7?\2\2\u01bd"+
		"Z\3\2\2\2\u01be\u01bf\7\'\2\2\u01bf\u01c0\7?\2\2\u01c0\\\3\2\2\2\u01c1"+
		"\u01c2\7]\2\2\u01c2\u01c3\7_\2\2\u01c3^\3\2\2\2\u01c4\u01c5\7]\2\2\u01c5"+
		"`\3\2\2\2\u01c6\u01c7\7_\2\2\u01c7b\3\2\2\2\u01c8\u01c9\7&\2\2\u01c9d"+
		"\3\2\2\2\u01ca\u01cb\7/\2\2\u01cb\u01cc\7@\2\2\u01ccf\3\2\2\2\u01cd\u01ce"+
		"\7`\2\2\u01ceh\3\2\2\2\u01cf\u01d0\7~\2\2\u01d0\u01d1\7~\2\2\u01d1j\3"+
		"\2\2\2\u01d2\u01d3\7~\2\2\u01d3l\3\2\2\2\u01d4\u01d5\7\'\2\2\u01d5n\3"+
		"\2\2\2\u01d6\u01d7\7\61\2\2\u01d7p\3\2\2\2\u01d8\u01d9\7,\2\2\u01d9r\3"+
		"\2\2\2\u01da\u01db\7\60\2\2\u01dbt\3\2\2\2\u01dc\u01dd\7(\2\2\u01dd\u01de"+
		"\7(\2\2\u01dev\3\2\2\2\u01df\u01e0\7(\2\2\u01e0x\3\2\2\2\u01e1\u01e2\7"+
		"<\2\2\u01e2\u01e3\7<\2\2\u01e3z\3\2\2\2\u01e4\u01e5\7a\2\2\u01e5|\3\2"+
		"\2\2\u01e6\u01e7\7B\2\2\u01e7~\3\2\2\2\u01e8\u01e9\7<\2\2\u01e9\u0080"+
		"\3\2\2\2\u01ea\u01eb\7\u00a9\2\2\u01eb\u0082\3\2\2\2\u01ec\u01ed\7>\2"+
		"\2\u01ed\u01ee\7>\2\2\u01ee\u0084\3\2\2\2\u01ef\u01f0\7@\2\2\u01f0\u01f1"+
		"\7@\2\2\u01f1\u01f2\7@\2\2\u01f2\u0086\3\2\2\2\u01f3\u01f4\7@\2\2\u01f4"+
		"\u01f5\7@\2\2\u01f5\u0088\3\2\2\2\u01f6\u01f7\7>\2\2\u01f7\u008a\3\2\2"+
		"\2\u01f8\u01f9\7@\2\2\u01f9\u008c\3\2\2\2\u01fa\u01fb\7A\2\2\u01fb\u01fc"+
		"\7<\2\2\u01fc\u008e\3\2\2\2\u01fd\u01fe\7A\2\2\u01fe\u0090\3\2\2\2\u01ff"+
		"\u0200\7#\2\2\u0200\u0092\3\2\2\2\u0201\u0202\7.\2\2\u0202\u0094\3\2\2"+
		"\2\u0203\u0204\7*\2\2\u0204\u0096\3\2\2\2\u0205\u0206\7+\2\2\u0206\u0098"+
		"\3\2\2\2\u0207\u0208\7-\2\2\u0208\u0209\7-\2\2\u0209\u009a\3\2\2\2\u020a"+
		"\u020b\7/\2\2\u020b\u020c\7/\2\2\u020c\u009c\3\2\2\2\u020d\u020e\7-\2"+
		"\2\u020e\u009e\3\2\2\2\u020f\u0210\7/\2\2\u0210\u00a0\3\2\2\2\27\2\u00a7"+
		"\u00a9\u00ca\u00d9\u0110\u0116\u0118\u0122\u0124\u013d\u0143\u014a\u0152"+
		"\u0155\u015b\u015d\u0162\u016c\u017a\u0182\20\b\2\2\3\3\2\3\4\3\3\5\4"+
		"\3\7\5\3\b\6\3\t\7\3\n\b\3\13\t\3\f\n\3\r\13\3\16\f\3\21\r\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}