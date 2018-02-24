// Generated from C:/Users/delthas/Java/sxlang/src/main/resources\Sxlang.g4 by ANTLR 4.7
package fr.delthas.sxlang.generated;

import java.util.*;
import fr.delthas.sxlang.types.*;
import static fr.delthas.sxlang.SxlangAux.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SxlangParser extends Parser {
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
	public static final int
		RULE_file = 0, RULE_declaration = 1, RULE_typeDeclaration = 2, RULE_functionDeclaration = 3, 
		RULE_variableDeclaration = 4, RULE_functionStatement = 5, RULE_ifBlock = 6, 
		RULE_elseIfBlock = 7, RULE_elseBlock = 8, RULE_expressionList = 9, RULE_expression = 10, 
		RULE_literal = 11, RULE_arrayLiteral = 12, RULE_arrayLiteralBody = 13, 
		RULE_stringLitteral = 14, RULE_numberLiteral = 15, RULE_parameter = 16, 
		RULE_type = 17, RULE_baseType = 18, RULE_classId = 19, RULE_functionId = 20, 
		RULE_variableId = 21, RULE_numberType = 22;
	public static final String[] ruleNames = {
		"file", "declaration", "typeDeclaration", "functionDeclaration", "variableDeclaration", 
		"functionStatement", "ifBlock", "elseIfBlock", "elseBlock", "expressionList", 
		"expression", "literal", "arrayLiteral", "arrayLiteralBody", "stringLitteral", 
		"numberLiteral", "parameter", "type", "baseType", "classId", "functionId", 
		"variableId", "numberType"
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

	@Override
	public String getGrammarFileName() { return "Sxlang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  private static UnaryOp getPre(String id) {
	    switch(id) {
	      case "++": return UnaryOp.PreIncrement;
	      case "--": return UnaryOp.PreDecrement;
	      case "+": return UnaryOp.PrePlus;
	      case "-": return UnaryOp.PreMinus;
	      case "!": return UnaryOp.Not;
	      default: return null;
	    }
	  }
	  private static UnaryOp getPost(String id) {
	    switch(id) {
	      case "++": return UnaryOp.PostIncrement;
	      case "--": return UnaryOp.PostDecrement;
	      default: return null;
	    }
	  }
	  private static BinaryOp getBin(String id) {
	    switch(id) {
	      case "*": return BinaryOp.Multiplication;
	      case "/": return BinaryOp.Division;
	      case "%": return BinaryOp.Modulo;
	      case "+": return BinaryOp.Addition;
	      case "-": return BinaryOp.Subtraction;
	      case "<": return BinaryOp.LessThan;
	      case "<=": return BinaryOp.LessEqualThan;
	      case ">": return BinaryOp.GreaterThan;
	      case ">=": return BinaryOp.GreaterEqualThan;
	      case "==": return BinaryOp.Equals;
	      case "!=": return BinaryOp.NotEquals;
	      case "<<": return BinaryOp.ShiftLeft;
	      case ">>": return BinaryOp.ShiftRight;
	      case ">>>": return BinaryOp.ShiftLogicalRight;
	      case "&": return BinaryOp.BitAnd;
	      case "^": return BinaryOp.BitXor;
	      case "|": return BinaryOp.BitOr;
	      case "&&": return BinaryOp.And;
	      case "||": return BinaryOp.Or;
	      case "=": return BinaryOp.Assign;
	      case "+=": return BinaryOp.AssignAddition;
	      case "-=": return BinaryOp.AssignSubtraction;
	      case "*=": return BinaryOp.AssignMultiplication;
	      case "/=": return BinaryOp.AssignDivision;
	      case "%=": return BinaryOp.AssignModulo;
	      case "&=": return BinaryOp.AssignBitAnd;
	      case "|=": return BinaryOp.AssignBitOr;
	      case "^=": return BinaryOp.AssignBitXor;
	      case "<<=": return BinaryOp.AssignShiftLeft;
	      case ">>=": return BinaryOp.AssignShiftRight;
	      case ">>>=": return BinaryOp.AssignShiftLogicalRight;
	      default: return null;
	    }
	  }
	  private static ParameterOption getOpt(String id) {
	    if(id == null) return ParameterOption.Value;
	    switch(id) {
	      case "~~": return ParameterOption.Clone;
	      case "~": return ParameterOption.Copy;
	      case "": return ParameterOption.Value;
	      default: return null;
	    }
	  }
	  private static Primitive getNum(String id) {
	    if(id == null) return null;
	    switch(id) {
	      case "b": return Primitive.Byte;
	      case "u-": return Primitive.UInt16;
	      case "u": return Primitive.UInt32;
	      case "u+": return Primitive.UInt64;
	      case "i-": return Primitive.Int16;
	      case "i": return Primitive.Int32;
	      case "i+": return Primitive.Int64;
	      case "f": return Primitive.Float32;
	      case "f+": return Primitive.Float64;
	      default: return null;
	    }
	  }
	  private static String unescape(String string) {
	    if(string == null) return null;
	    StringBuilder sb = new StringBuilder(string.length());
	    for(int i=1;i<string.length()-1;++i) {
	      char ch = string.charAt(i);
	      if (ch == '\\') {
	        char nextChar = string.charAt(++i);
	        switch (nextChar) {
	          case '\\': ch = '\\'; break;
	          case 'n': ch = '\n'; break;
	          case 'r': ch = '\r'; break;
	          case 't': ch = '\t'; break;
	          case '\"': ch = '\"'; break;
	          default: throw new IllegalArgumentException(string);
	        }
	      }
	      sb.append(ch);
	    }
	    return sb.toString();
	  }
	  private static String unescapeAsm(String string) {
	    if(string == null) return null;
	    StringBuilder sb = new StringBuilder(string.length());
	    for(int i=1;i<string.length()-1;++i) {
	      char ch = string.charAt(i);
	      if (ch == '\\') {
	        char nextChar = string.charAt(++i);
	        switch (nextChar) {
	          case '\\': ch = '\\'; break;
	          case '}': ch = '}'; break;
	          default: throw new IllegalArgumentException(string);
	        }
	      }
	      sb.append(ch);
	    }
	    return sb.toString();
	  }
	  private String parentId;

	public SxlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<Declaration> v;
		public DeclarationContext declaration;
		public List<DeclarationContext> v_ = new ArrayList<DeclarationContext>();
		public TerminalNode EOF() { return getToken(SxlangParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NEWLINE) | (1L << HASH) | (1L << PERCENT))) != 0)) {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUMBER_TYPE_ALPHANUMERIC:
				case MAJ_ID:
				case MIN_ID:
				case HASH:
				case PERCENT:
					{
					setState(46);
					((FileContext)_localctx).declaration = declaration();
					((FileContext)_localctx).v_.add(((FileContext)_localctx).declaration);
					}
					break;
				case NEWLINE:
					{
					setState(47);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(EOF);
			((FileContext)_localctx).v =  map(((FileContext)_localctx).v_);
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

	public static class DeclarationContext extends ParserRuleContext {
		public Declaration v;
		public TypeDeclarationContext v0;
		public FunctionDeclarationContext v1;
		public VariableDeclarationContext v2;
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				((DeclarationContext)_localctx).v0 = typeDeclaration();
				((DeclarationContext)_localctx).v =  ((DeclarationContext)_localctx).v0.v;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				((DeclarationContext)_localctx).v1 = functionDeclaration();
				((DeclarationContext)_localctx).v =  ((DeclarationContext)_localctx).v1.v;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				((DeclarationContext)_localctx).v2 = variableDeclaration();
				((DeclarationContext)_localctx).v =  ((DeclarationContext)_localctx).v2.v;
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public Declaration v;
		public ClassIdContext id;
		public Token unoverridable;
		public ClassIdContext classId;
		public List<ClassIdContext> extendz = new ArrayList<ClassIdContext>();
		public FunctionDeclarationContext functionDeclaration;
		public List<FunctionDeclarationContext> b0 = new ArrayList<FunctionDeclarationContext>();
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> b1 = new ArrayList<VariableDeclarationContext>();
		public TerminalNode ASSEQ() { return getToken(SxlangParser.ASSEQ, 0); }
		public TerminalNode DOLLAR() { return getToken(SxlangParser.DOLLAR, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SxlangParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SxlangParser.RIGHT_BRACKET, 0); }
		public List<ClassIdContext> classId() {
			return getRuleContexts(ClassIdContext.class);
		}
		public ClassIdContext classId(int i) {
			return getRuleContext(ClassIdContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public TerminalNode HASH() { return getToken(SxlangParser.HASH, 0); }
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			((TypeDeclarationContext)_localctx).id = classId();
			parentId = ((TypeDeclarationContext)_localctx).id.v;
			setState(69);
			match(ASSEQ);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(70);
				((TypeDeclarationContext)_localctx).unoverridable = match(HASH);
				}
			}

			setState(73);
			match(DOLLAR);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAJ_ID) {
				{
				{
				setState(74);
				((TypeDeclarationContext)_localctx).classId = classId();
				((TypeDeclarationContext)_localctx).extendz.add(((TypeDeclarationContext)_localctx).classId);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(LEFT_BRACKET);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NEWLINE) | (1L << HASH) | (1L << PERCENT))) != 0)) {
				{
				setState(84);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(81);
					((TypeDeclarationContext)_localctx).functionDeclaration = functionDeclaration();
					((TypeDeclarationContext)_localctx).b0.add(((TypeDeclarationContext)_localctx).functionDeclaration);
					}
					break;
				case 2:
					{
					setState(82);
					((TypeDeclarationContext)_localctx).variableDeclaration = variableDeclaration();
					((TypeDeclarationContext)_localctx).b1.add(((TypeDeclarationContext)_localctx).variableDeclaration);
					}
					break;
				case 3:
					{
					setState(83);
					match(NEWLINE);
					}
					break;
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(RIGHT_BRACKET);
			parentId = null;
			((TypeDeclarationContext)_localctx).v =  Declaration.type(((TypeDeclarationContext)_localctx).id.v, ((TypeDeclarationContext)_localctx).unoverridable != null, map(((TypeDeclarationContext)_localctx).extendz), map(((TypeDeclarationContext)_localctx).b0,((TypeDeclarationContext)_localctx).b1));
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public Declaration v;
		public Token HASH;
		public List<Token> hasBody = new ArrayList<Token>();
		public ClassIdContext classId;
		public List<ClassIdContext> id1 = new ArrayList<ClassIdContext>();
		public FunctionIdContext functionId;
		public List<FunctionIdContext> id2 = new ArrayList<FunctionIdContext>();
		public ParameterContext parameter;
		public List<ParameterContext> params = new ArrayList<ParameterContext>();
		public Token instance;
		public TypeContext type;
		public List<TypeContext> returz = new ArrayList<TypeContext>();
		public FunctionStatementContext functionStatement;
		public List<FunctionStatementContext> body = new ArrayList<FunctionStatementContext>();
		public TerminalNode ASSEQ() { return getToken(SxlangParser.ASSEQ, 0); }
		public TerminalNode ARROW() { return getToken(SxlangParser.ARROW, 0); }
		public ClassIdContext classId() {
			return getRuleContext(ClassIdContext.class,0);
		}
		public FunctionIdContext functionId() {
			return getRuleContext(FunctionIdContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(SxlangParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SxlangParser.RIGHT_BRACKET, 0); }
		public TerminalNode HASH() { return getToken(SxlangParser.HASH, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public TerminalNode PERCENT() { return getToken(SxlangParser.PERCENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public List<FunctionStatementContext> functionStatement() {
			return getRuleContexts(FunctionStatementContext.class);
		}
		public FunctionStatementContext functionStatement(int i) {
			return getRuleContext(FunctionStatementContext.class,i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(93);
				((FunctionDeclarationContext)_localctx).HASH = match(HASH);
				((FunctionDeclarationContext)_localctx).hasBody.add(((FunctionDeclarationContext)_localctx).HASH);
				}
			}

			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAJ_ID:
				{
				setState(96);
				((FunctionDeclarationContext)_localctx).classId = classId();
				((FunctionDeclarationContext)_localctx).id1.add(((FunctionDeclarationContext)_localctx).classId);
				}
				break;
			case NUMBER_TYPE_ALPHANUMERIC:
			case MIN_ID:
				{
				setState(97);
				((FunctionDeclarationContext)_localctx).functionId = functionId();
				((FunctionDeclarationContext)_localctx).id2.add(((FunctionDeclarationContext)_localctx).functionId);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(100);
			match(ASSEQ);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << MAJ_ID) | (1L << MIN_ID))) != 0)) {
				{
				{
				setState(101);
				((FunctionDeclarationContext)_localctx).parameter = parameter();
				((FunctionDeclarationContext)_localctx).params.add(((FunctionDeclarationContext)_localctx).parameter);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(ARROW);
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(108);
				((FunctionDeclarationContext)_localctx).instance = match(PERCENT);
				}
				break;
			}
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(111);
				((FunctionDeclarationContext)_localctx).type = type();
				((FunctionDeclarationContext)_localctx).returz.add(((FunctionDeclarationContext)_localctx).type);
				}
				break;
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(114);
				match(LEFT_BRACKET);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << NEWLINE) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AT) | (1L << PARAGRAPH))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LEFT_ANGLE - 67)) | (1L << (RIGHT_ANGLE - 67)) | (1L << (EXCLA - 67)) | (1L << (LEFT_PAREN - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MINUS - 67)))) != 0)) {
					{
					setState(117);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ASM_START:
					case STRING_LITERAL:
					case NUMBER_TYPE_ALPHANUMERIC:
					case NUMBER_TYPE:
					case MAJ_ID:
					case MIN_ID:
					case NUMBER_LITERAL:
					case HASH:
					case LEFT_SQUARE_BRACKET:
					case DOLLAR:
					case PERCENT:
					case AT:
					case PARAGRAPH:
					case LEFT_ANGLE:
					case RIGHT_ANGLE:
					case EXCLA:
					case LEFT_PAREN:
					case PLUSPLUS:
					case MINUSMINUS:
					case PLUS:
					case MINUS:
						{
						setState(115);
						((FunctionDeclarationContext)_localctx).functionStatement = functionStatement();
						((FunctionDeclarationContext)_localctx).body.add(((FunctionDeclarationContext)_localctx).functionStatement);
						}
						break;
					case NEWLINE:
						{
						setState(116);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(RIGHT_BRACKET);
				}
			}

			((FunctionDeclarationContext)_localctx).v =  Declaration.function(or(((FunctionDeclarationContext)_localctx).id1,((FunctionDeclarationContext)_localctx).id2), parentId, map(((FunctionDeclarationContext)_localctx).params), ((FunctionDeclarationContext)_localctx).instance != null, opt(((FunctionDeclarationContext)_localctx).returz), ((FunctionDeclarationContext)_localctx).hasBody.isEmpty()?map(((FunctionDeclarationContext)_localctx).body):null);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public Declaration v;
		public Token mutable;
		public Token instance;
		public VariableIdContext id;
		public TypeContext typ;
		public ExpressionContext expression;
		public List<ExpressionContext> value = new ArrayList<ExpressionContext>();
		public TerminalNode COLONCOLON() { return getToken(SxlangParser.COLONCOLON, 0); }
		public TerminalNode ASSEQ() { return getToken(SxlangParser.ASSEQ, 0); }
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode UNDERSCORE() { return getToken(SxlangParser.UNDERSCORE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode HASH() { return getToken(SxlangParser.HASH, 0); }
		public TerminalNode PERCENT() { return getToken(SxlangParser.PERCENT, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(127);
				((VariableDeclarationContext)_localctx).mutable = match(HASH);
				}
			}

			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERCENT) {
				{
				setState(130);
				((VariableDeclarationContext)_localctx).instance = match(PERCENT);
				}
			}

			setState(133);
			((VariableDeclarationContext)_localctx).id = variableId();
			setState(134);
			match(COLONCOLON);
			setState(135);
			((VariableDeclarationContext)_localctx).typ = type();
			setState(136);
			match(ASSEQ);
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNDERSCORE:
				{
				setState(137);
				match(UNDERSCORE);
				}
				break;
			case ASM_START:
			case STRING_LITERAL:
			case NUMBER_TYPE_ALPHANUMERIC:
			case NUMBER_TYPE:
			case MAJ_ID:
			case MIN_ID:
			case NUMBER_LITERAL:
			case HASH:
			case LEFT_SQUARE_BRACKET:
			case DOLLAR:
			case PERCENT:
			case EXCLA:
			case LEFT_PAREN:
			case PLUSPLUS:
			case MINUSMINUS:
			case PLUS:
			case MINUS:
				{
				setState(138);
				((VariableDeclarationContext)_localctx).expression = expression(0);
				((VariableDeclarationContext)_localctx).value.add(((VariableDeclarationContext)_localctx).expression);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((VariableDeclarationContext)_localctx).v =  Declaration.variable(((VariableDeclarationContext)_localctx).id.v, ((VariableDeclarationContext)_localctx).mutable != null, ((VariableDeclarationContext)_localctx).instance != null, opt(((VariableDeclarationContext)_localctx).value), ((VariableDeclarationContext)_localctx).typ.v);
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

	public static class FunctionStatementContext extends ParserRuleContext {
		public Statement v;
		public ExpressionContext free;
		public IfBlockContext iz;
		public ElseIfBlockContext elseIfBlock;
		public List<ElseIfBlockContext> ez = new ArrayList<ElseIfBlockContext>();
		public ElseBlockContext elseBlock;
		public List<ElseBlockContext> elsz = new ArrayList<ElseBlockContext>();
		public ExpressionContext wcond;
		public FunctionStatementContext functionStatement;
		public List<FunctionStatementContext> wbody = new ArrayList<FunctionStatementContext>();
		public VariableIdContext fid;
		public ExpressionContext fiter;
		public List<FunctionStatementContext> fbody = new ArrayList<FunctionStatementContext>();
		public ExpressionContext re;
		public Token cs;
		public Token bs;
		public VariableDeclarationContext var;
		public ExpressionContext e;
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(SxlangParser.LEFT_SQUARE_BRACKET, 0); }
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(SxlangParser.RIGHT_SQUARE_BRACKET, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public List<ElseIfBlockContext> elseIfBlock() {
			return getRuleContexts(ElseIfBlockContext.class);
		}
		public ElseIfBlockContext elseIfBlock(int i) {
			return getRuleContext(ElseIfBlockContext.class,i);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public TerminalNode AT() { return getToken(SxlangParser.AT, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SxlangParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SxlangParser.RIGHT_BRACKET, 0); }
		public List<FunctionStatementContext> functionStatement() {
			return getRuleContexts(FunctionStatementContext.class);
		}
		public FunctionStatementContext functionStatement(int i) {
			return getRuleContext(FunctionStatementContext.class,i);
		}
		public TerminalNode COLON() { return getToken(SxlangParser.COLON, 0); }
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public TerminalNode PARAGRAPH() { return getToken(SxlangParser.PARAGRAPH, 0); }
		public List<TerminalNode> RIGHT_ANGLE() { return getTokens(SxlangParser.RIGHT_ANGLE); }
		public TerminalNode RIGHT_ANGLE(int i) {
			return getToken(SxlangParser.RIGHT_ANGLE, i);
		}
		public List<TerminalNode> LEFT_ANGLE() { return getTokens(SxlangParser.LEFT_ANGLE); }
		public TerminalNode LEFT_ANGLE(int i) {
			return getToken(SxlangParser.LEFT_ANGLE, i);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionStatementContext functionStatement() throws RecognitionException {
		FunctionStatementContext _localctx = new FunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionStatement);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(LEFT_SQUARE_BRACKET);
				setState(144);
				((FunctionStatementContext)_localctx).free = expression(0);
				setState(145);
				match(RIGHT_SQUARE_BRACKET);
				setState(146);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.free(((FunctionStatementContext)_localctx).free.v);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				((FunctionStatementContext)_localctx).iz = ifBlock();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXCLA - 71)) | (1L << (LEFT_PAREN - 71)) | (1L << (PLUSPLUS - 71)) | (1L << (MINUSMINUS - 71)) | (1L << (PLUS - 71)) | (1L << (MINUS - 71)))) != 0)) {
					{
					{
					setState(150);
					((FunctionStatementContext)_localctx).elseIfBlock = elseIfBlock();
					((FunctionStatementContext)_localctx).ez.add(((FunctionStatementContext)_localctx).elseIfBlock);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(156);
					((FunctionStatementContext)_localctx).elseBlock = elseBlock();
					((FunctionStatementContext)_localctx).elsz.add(((FunctionStatementContext)_localctx).elseBlock);
					}
				}

				setState(159);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.ifs(chain(((FunctionStatementContext)_localctx).iz.v, map(((FunctionStatementContext)_localctx).ez), opt(((FunctionStatementContext)_localctx).elsz)));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(AT);
				setState(163);
				((FunctionStatementContext)_localctx).wcond = expression(0);
				setState(164);
				match(LEFT_BRACKET);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << NEWLINE) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AT) | (1L << PARAGRAPH))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LEFT_ANGLE - 67)) | (1L << (RIGHT_ANGLE - 67)) | (1L << (EXCLA - 67)) | (1L << (LEFT_PAREN - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MINUS - 67)))) != 0)) {
					{
					setState(167);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ASM_START:
					case STRING_LITERAL:
					case NUMBER_TYPE_ALPHANUMERIC:
					case NUMBER_TYPE:
					case MAJ_ID:
					case MIN_ID:
					case NUMBER_LITERAL:
					case HASH:
					case LEFT_SQUARE_BRACKET:
					case DOLLAR:
					case PERCENT:
					case AT:
					case PARAGRAPH:
					case LEFT_ANGLE:
					case RIGHT_ANGLE:
					case EXCLA:
					case LEFT_PAREN:
					case PLUSPLUS:
					case MINUSMINUS:
					case PLUS:
					case MINUS:
						{
						setState(165);
						((FunctionStatementContext)_localctx).functionStatement = functionStatement();
						((FunctionStatementContext)_localctx).wbody.add(((FunctionStatementContext)_localctx).functionStatement);
						}
						break;
					case NEWLINE:
						{
						setState(166);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				match(RIGHT_BRACKET);
				setState(173);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.whilz(((FunctionStatementContext)_localctx).wcond.v, map(((FunctionStatementContext)_localctx).wbody));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(AT);
				setState(177);
				((FunctionStatementContext)_localctx).fid = variableId();
				setState(178);
				match(COLON);
				setState(179);
				((FunctionStatementContext)_localctx).fiter = expression(0);
				setState(180);
				match(LEFT_BRACKET);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << NEWLINE) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AT) | (1L << PARAGRAPH))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LEFT_ANGLE - 67)) | (1L << (RIGHT_ANGLE - 67)) | (1L << (EXCLA - 67)) | (1L << (LEFT_PAREN - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MINUS - 67)))) != 0)) {
					{
					setState(183);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ASM_START:
					case STRING_LITERAL:
					case NUMBER_TYPE_ALPHANUMERIC:
					case NUMBER_TYPE:
					case MAJ_ID:
					case MIN_ID:
					case NUMBER_LITERAL:
					case HASH:
					case LEFT_SQUARE_BRACKET:
					case DOLLAR:
					case PERCENT:
					case AT:
					case PARAGRAPH:
					case LEFT_ANGLE:
					case RIGHT_ANGLE:
					case EXCLA:
					case LEFT_PAREN:
					case PLUSPLUS:
					case MINUSMINUS:
					case PLUS:
					case MINUS:
						{
						setState(181);
						((FunctionStatementContext)_localctx).functionStatement = functionStatement();
						((FunctionStatementContext)_localctx).fbody.add(((FunctionStatementContext)_localctx).functionStatement);
						}
						break;
					case NEWLINE:
						{
						setState(182);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(188);
				match(RIGHT_BRACKET);
				setState(189);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.foz(((FunctionStatementContext)_localctx).fid.v, ((FunctionStatementContext)_localctx).fiter.v, map(((FunctionStatementContext)_localctx).fbody));
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(192);
				match(PARAGRAPH);
				setState(193);
				((FunctionStatementContext)_localctx).re = expression(0);
				setState(194);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.returz(((FunctionStatementContext)_localctx).re.v);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(198); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(197);
					((FunctionStatementContext)_localctx).cs = match(RIGHT_ANGLE);
					}
					}
					setState(200); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==RIGHT_ANGLE );
				setState(202);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.continuz((((FunctionStatementContext)_localctx).cs!=null?((FunctionStatementContext)_localctx).cs.getText():null).length());
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					((FunctionStatementContext)_localctx).bs = match(LEFT_ANGLE);
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LEFT_ANGLE );
				setState(209);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.breaz((((FunctionStatementContext)_localctx).bs!=null?((FunctionStatementContext)_localctx).bs.getText():null).length());
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(211);
				((FunctionStatementContext)_localctx).var = variableDeclaration();
				setState(212);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.variable(((FunctionStatementContext)_localctx).var.v);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(215);
				((FunctionStatementContext)_localctx).e = expression(0);
				setState(216);
				match(NEWLINE);
				((FunctionStatementContext)_localctx).v =  Statement.expression(((FunctionStatementContext)_localctx).e.v);
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

	public static class IfBlockContext extends ParserRuleContext {
		public IfBlock v;
		public ExpressionContext cond;
		public FunctionStatementContext functionStatement;
		public List<FunctionStatementContext> body = new ArrayList<FunctionStatementContext>();
		public TerminalNode INTERRO() { return getToken(SxlangParser.INTERRO, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SxlangParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SxlangParser.RIGHT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public List<FunctionStatementContext> functionStatement() {
			return getRuleContexts(FunctionStatementContext.class);
		}
		public FunctionStatementContext functionStatement(int i) {
			return getRuleContext(FunctionStatementContext.class,i);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((IfBlockContext)_localctx).cond = expression(0);
			setState(222);
			match(INTERRO);
			setState(223);
			match(LEFT_BRACKET);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << NEWLINE) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AT) | (1L << PARAGRAPH))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LEFT_ANGLE - 67)) | (1L << (RIGHT_ANGLE - 67)) | (1L << (EXCLA - 67)) | (1L << (LEFT_PAREN - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MINUS - 67)))) != 0)) {
				{
				setState(226);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ASM_START:
				case STRING_LITERAL:
				case NUMBER_TYPE_ALPHANUMERIC:
				case NUMBER_TYPE:
				case MAJ_ID:
				case MIN_ID:
				case NUMBER_LITERAL:
				case HASH:
				case LEFT_SQUARE_BRACKET:
				case DOLLAR:
				case PERCENT:
				case AT:
				case PARAGRAPH:
				case LEFT_ANGLE:
				case RIGHT_ANGLE:
				case EXCLA:
				case LEFT_PAREN:
				case PLUSPLUS:
				case MINUSMINUS:
				case PLUS:
				case MINUS:
					{
					setState(224);
					((IfBlockContext)_localctx).functionStatement = functionStatement();
					((IfBlockContext)_localctx).body.add(((IfBlockContext)_localctx).functionStatement);
					}
					break;
				case NEWLINE:
					{
					setState(225);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
			match(RIGHT_BRACKET);
			((IfBlockContext)_localctx).v =  new IfBlock(((IfBlockContext)_localctx).cond.v, map(((IfBlockContext)_localctx).body));
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

	public static class ElseIfBlockContext extends ParserRuleContext {
		public IfBlock v;
		public ExpressionContext cond;
		public FunctionStatementContext functionStatement;
		public List<FunctionStatementContext> body = new ArrayList<FunctionStatementContext>();
		public TerminalNode INTERROCOLON() { return getToken(SxlangParser.INTERROCOLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SxlangParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SxlangParser.RIGHT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public List<FunctionStatementContext> functionStatement() {
			return getRuleContexts(FunctionStatementContext.class);
		}
		public FunctionStatementContext functionStatement(int i) {
			return getRuleContext(FunctionStatementContext.class,i);
		}
		public ElseIfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterElseIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitElseIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitElseIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfBlockContext elseIfBlock() throws RecognitionException {
		ElseIfBlockContext _localctx = new ElseIfBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elseIfBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			((ElseIfBlockContext)_localctx).cond = expression(0);
			setState(235);
			match(INTERROCOLON);
			setState(236);
			match(LEFT_BRACKET);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << NEWLINE) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AT) | (1L << PARAGRAPH))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LEFT_ANGLE - 67)) | (1L << (RIGHT_ANGLE - 67)) | (1L << (EXCLA - 67)) | (1L << (LEFT_PAREN - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MINUS - 67)))) != 0)) {
				{
				setState(239);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ASM_START:
				case STRING_LITERAL:
				case NUMBER_TYPE_ALPHANUMERIC:
				case NUMBER_TYPE:
				case MAJ_ID:
				case MIN_ID:
				case NUMBER_LITERAL:
				case HASH:
				case LEFT_SQUARE_BRACKET:
				case DOLLAR:
				case PERCENT:
				case AT:
				case PARAGRAPH:
				case LEFT_ANGLE:
				case RIGHT_ANGLE:
				case EXCLA:
				case LEFT_PAREN:
				case PLUSPLUS:
				case MINUSMINUS:
				case PLUS:
				case MINUS:
					{
					setState(237);
					((ElseIfBlockContext)_localctx).functionStatement = functionStatement();
					((ElseIfBlockContext)_localctx).body.add(((ElseIfBlockContext)_localctx).functionStatement);
					}
					break;
				case NEWLINE:
					{
					setState(238);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			match(RIGHT_BRACKET);
			((ElseIfBlockContext)_localctx).v =  new IfBlock(((ElseIfBlockContext)_localctx).cond.v, map(((ElseIfBlockContext)_localctx).body));
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

	public static class ElseBlockContext extends ParserRuleContext {
		public IfBlock v;
		public FunctionStatementContext functionStatement;
		public List<FunctionStatementContext> body = new ArrayList<FunctionStatementContext>();
		public TerminalNode COLON() { return getToken(SxlangParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SxlangParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SxlangParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SxlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SxlangParser.NEWLINE, i);
		}
		public List<FunctionStatementContext> functionStatement() {
			return getRuleContexts(FunctionStatementContext.class);
		}
		public FunctionStatementContext functionStatement(int i) {
			return getRuleContext(FunctionStatementContext.class,i);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(COLON);
			setState(248);
			match(LEFT_BRACKET);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << NEWLINE) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AT) | (1L << PARAGRAPH))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LEFT_ANGLE - 67)) | (1L << (RIGHT_ANGLE - 67)) | (1L << (EXCLA - 67)) | (1L << (LEFT_PAREN - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MINUS - 67)))) != 0)) {
				{
				setState(251);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ASM_START:
				case STRING_LITERAL:
				case NUMBER_TYPE_ALPHANUMERIC:
				case NUMBER_TYPE:
				case MAJ_ID:
				case MIN_ID:
				case NUMBER_LITERAL:
				case HASH:
				case LEFT_SQUARE_BRACKET:
				case DOLLAR:
				case PERCENT:
				case AT:
				case PARAGRAPH:
				case LEFT_ANGLE:
				case RIGHT_ANGLE:
				case EXCLA:
				case LEFT_PAREN:
				case PLUSPLUS:
				case MINUSMINUS:
				case PLUS:
				case MINUS:
					{
					setState(249);
					((ElseBlockContext)_localctx).functionStatement = functionStatement();
					((ElseBlockContext)_localctx).body.add(((ElseBlockContext)_localctx).functionStatement);
					}
					break;
				case NEWLINE:
					{
					setState(250);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(RIGHT_BRACKET);
			((ElseBlockContext)_localctx).v =  new IfBlock(null, map(((ElseBlockContext)_localctx).body));
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<Expression> v;
		public ExpressionContext expression;
		public List<ExpressionContext> e = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SxlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SxlangParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			((ExpressionListContext)_localctx).expression = expression(0);
			((ExpressionListContext)_localctx).e.add(((ExpressionListContext)_localctx).expression);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(260);
				match(COMMA);
				setState(261);
				((ExpressionListContext)_localctx).expression = expression(0);
				((ExpressionListContext)_localctx).e.add(((ExpressionListContext)_localctx).expression);
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((ExpressionListContext)_localctx).v =  map(((ExpressionListContext)_localctx).e);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression v;
		public ExpressionContext base;
		public ExpressionContext left;
		public ExpressionContext expression;
		public NumberTypeContext cast;
		public BaseTypeContext baseType;
		public List<BaseTypeContext> ret = new ArrayList<BaseTypeContext>();
		public List<ExpressionContext> param = new ArrayList<ExpressionContext>();
		public Token STRING_LITERAL;
		public List<Token> constr = new ArrayList<Token>();
		public Token asm;
		public LiteralContext literal;
		public ClassIdContext classId;
		public List<ClassIdContext> i0 = new ArrayList<ClassIdContext>();
		public FunctionIdContext functionId;
		public List<FunctionIdContext> i1 = new ArrayList<FunctionIdContext>();
		public VariableIdContext variableId;
		public List<VariableIdContext> i2 = new ArrayList<VariableIdContext>();
		public ExpressionListContext expressionList;
		public List<ExpressionListContext> fparam = new ArrayList<ExpressionListContext>();
		public Token op;
		public ExpressionContext right;
		public List<FunctionIdContext> m1 = new ArrayList<FunctionIdContext>();
		public List<VariableIdContext> m2 = new ArrayList<VariableIdContext>();
		public ExpressionContext ai;
		public TerminalNode LEFT_PAREN() { return getToken(SxlangParser.LEFT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SxlangParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(SxlangParser.LEFT_SQUARE_BRACKET, 0); }
		public TerminalNode EQUALS() { return getToken(SxlangParser.EQUALS, 0); }
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(SxlangParser.RIGHT_SQUARE_BRACKET, 0); }
		public NumberTypeContext numberType() {
			return getRuleContext(NumberTypeContext.class,0);
		}
		public TerminalNode ASM_START() { return getToken(SxlangParser.ASM_START, 0); }
		public TerminalNode ASM_LITERAL() { return getToken(SxlangParser.ASM_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SxlangParser.STRING_LITERAL, 0); }
		public TerminalNode UNDERSCORE() { return getToken(SxlangParser.UNDERSCORE, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SxlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SxlangParser.COMMA, i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode HASH() { return getToken(SxlangParser.HASH, 0); }
		public ClassIdContext classId() {
			return getRuleContext(ClassIdContext.class,0);
		}
		public FunctionIdContext functionId() {
			return getRuleContext(FunctionIdContext.class,0);
		}
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode PERCENT() { return getToken(SxlangParser.PERCENT, 0); }
		public TerminalNode DOLLAR() { return getToken(SxlangParser.DOLLAR, 0); }
		public TerminalNode PLUS() { return getToken(SxlangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SxlangParser.MINUS, 0); }
		public TerminalNode PLUSPLUS() { return getToken(SxlangParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(SxlangParser.MINUSMINUS, 0); }
		public TerminalNode EXCLA() { return getToken(SxlangParser.EXCLA, 0); }
		public TerminalNode ASTERISK() { return getToken(SxlangParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SxlangParser.SLASH, 0); }
		public TerminalNode LEFT2_ANGLE() { return getToken(SxlangParser.LEFT2_ANGLE, 0); }
		public TerminalNode RIGHT3_ANGLE() { return getToken(SxlangParser.RIGHT3_ANGLE, 0); }
		public TerminalNode RIGHT2_ANGLE() { return getToken(SxlangParser.RIGHT2_ANGLE, 0); }
		public TerminalNode LEQ() { return getToken(SxlangParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(SxlangParser.GEQ, 0); }
		public TerminalNode RIGHT_ANGLE() { return getToken(SxlangParser.RIGHT_ANGLE, 0); }
		public TerminalNode LEFT_ANGLE() { return getToken(SxlangParser.LEFT_ANGLE, 0); }
		public TerminalNode EQUALSEQUALS() { return getToken(SxlangParser.EQUALSEQUALS, 0); }
		public TerminalNode NOTEQUALS() { return getToken(SxlangParser.NOTEQUALS, 0); }
		public TerminalNode ESPER() { return getToken(SxlangParser.ESPER, 0); }
		public TerminalNode CIRCON() { return getToken(SxlangParser.CIRCON, 0); }
		public TerminalNode PIPE() { return getToken(SxlangParser.PIPE, 0); }
		public TerminalNode ESPERESPER() { return getToken(SxlangParser.ESPERESPER, 0); }
		public TerminalNode PIPEPIPE() { return getToken(SxlangParser.PIPEPIPE, 0); }
		public TerminalNode PLUSE() { return getToken(SxlangParser.PLUSE, 0); }
		public TerminalNode MINUSE() { return getToken(SxlangParser.MINUSE, 0); }
		public TerminalNode ASTERISKE() { return getToken(SxlangParser.ASTERISKE, 0); }
		public TerminalNode SLASHE() { return getToken(SxlangParser.SLASHE, 0); }
		public TerminalNode ESPERE() { return getToken(SxlangParser.ESPERE, 0); }
		public TerminalNode PIPEE() { return getToken(SxlangParser.PIPEE, 0); }
		public TerminalNode CIRCONE() { return getToken(SxlangParser.CIRCONE, 0); }
		public TerminalNode RIGHT2_E() { return getToken(SxlangParser.RIGHT2_E, 0); }
		public TerminalNode RIGHT3_E() { return getToken(SxlangParser.RIGHT3_E, 0); }
		public TerminalNode LEFT2_E() { return getToken(SxlangParser.LEFT2_E, 0); }
		public TerminalNode PERCENTE() { return getToken(SxlangParser.PERCENTE, 0); }
		public TerminalNode DOT() { return getToken(SxlangParser.DOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(270);
				match(LEFT_PAREN);
				setState(271);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(272);
				match(RIGHT_PAREN);
				((ExpressionContext)_localctx).v =  ((ExpressionContext)_localctx).expression.v;
				}
				break;
			case 2:
				{
				setState(275);
				match(LEFT_SQUARE_BRACKET);
				setState(276);
				((ExpressionContext)_localctx).cast = numberType();
				setState(277);
				match(EQUALS);
				setState(278);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(279);
				match(RIGHT_SQUARE_BRACKET);
				((ExpressionContext)_localctx).v =  Expression.cast(((ExpressionContext)_localctx).cast.v, ((ExpressionContext)_localctx).expression.v);
				}
				break;
			case 3:
				{
				setState(282);
				match(ASM_START);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(283);
					match(LEFT_PAREN);
					setState(286);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NUMBER_TYPE_ALPHANUMERIC:
					case NUMBER_TYPE:
					case MAJ_ID:
						{
						setState(284);
						((ExpressionContext)_localctx).baseType = baseType();
						((ExpressionContext)_localctx).ret.add(((ExpressionContext)_localctx).baseType);
						}
						break;
					case UNDERSCORE:
						{
						setState(285);
						match(UNDERSCORE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(288);
						match(COMMA);
						setState(289);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).param.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(294);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(295);
					match(RIGHT_PAREN);
					}
				}

				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_LITERAL) {
					{
					setState(298);
					((ExpressionContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
					((ExpressionContext)_localctx).constr.add(((ExpressionContext)_localctx).STRING_LITERAL);
					}
				}

				setState(301);
				((ExpressionContext)_localctx).asm = match(ASM_LITERAL);
				((ExpressionContext)_localctx).v =  Expression.asm(opt(((ExpressionContext)_localctx).ret), map(((ExpressionContext)_localctx).param), unescape(optt(((ExpressionContext)_localctx).constr)), unescapeAsm((((ExpressionContext)_localctx).asm!=null?((ExpressionContext)_localctx).asm.getText():null)));
				}
				break;
			case 4:
				{
				setState(303);
				((ExpressionContext)_localctx).literal = literal();
				((ExpressionContext)_localctx).v =  Expression.literal(((ExpressionContext)_localctx).literal.v);
				}
				break;
			case 5:
				{
				setState(306);
				match(HASH);
				setState(310);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(307);
					((ExpressionContext)_localctx).classId = classId();
					((ExpressionContext)_localctx).i0.add(((ExpressionContext)_localctx).classId);
					}
					break;
				case 2:
					{
					setState(308);
					((ExpressionContext)_localctx).functionId = functionId();
					((ExpressionContext)_localctx).i1.add(((ExpressionContext)_localctx).functionId);
					}
					break;
				case 3:
					{
					setState(309);
					((ExpressionContext)_localctx).variableId = variableId();
					((ExpressionContext)_localctx).i2.add(((ExpressionContext)_localctx).variableId);
					}
					break;
				}
				setState(312);
				match(LEFT_PAREN);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXCLA - 71)) | (1L << (LEFT_PAREN - 71)) | (1L << (PLUSPLUS - 71)) | (1L << (MINUSMINUS - 71)) | (1L << (PLUS - 71)) | (1L << (MINUS - 71)))) != 0)) {
					{
					setState(313);
					((ExpressionContext)_localctx).expressionList = expressionList();
					((ExpressionContext)_localctx).fparam.add(((ExpressionContext)_localctx).expressionList);
					}
				}

				setState(316);
				match(RIGHT_PAREN);
				((ExpressionContext)_localctx).v =  Expression.externalCall(or(((ExpressionContext)_localctx).i0,((ExpressionContext)_localctx).i1,((ExpressionContext)_localctx).i2), opt(((ExpressionContext)_localctx).fparam));
				}
				break;
			case 6:
				{
				setState(322);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(319);
					((ExpressionContext)_localctx).classId = classId();
					((ExpressionContext)_localctx).i0.add(((ExpressionContext)_localctx).classId);
					}
					break;
				case 2:
					{
					setState(320);
					((ExpressionContext)_localctx).functionId = functionId();
					((ExpressionContext)_localctx).i1.add(((ExpressionContext)_localctx).functionId);
					}
					break;
				case 3:
					{
					setState(321);
					((ExpressionContext)_localctx).variableId = variableId();
					((ExpressionContext)_localctx).i2.add(((ExpressionContext)_localctx).variableId);
					}
					break;
				}
				((ExpressionContext)_localctx).v =  Expression.unknownId(or(((ExpressionContext)_localctx).i0,((ExpressionContext)_localctx).i1,((ExpressionContext)_localctx).i2));
				}
				break;
			case 7:
				{
				setState(326);
				match(PERCENT);
				((ExpressionContext)_localctx).v =  Expression.thiz();
				}
				break;
			case 8:
				{
				setState(328);
				match(DOLLAR);
				((ExpressionContext)_localctx).v =  Expression.blockArrayLength();
				}
				break;
			case 9:
				{
				setState(330);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (PLUSPLUS - 75)) | (1L << (MINUSMINUS - 75)) | (1L << (PLUS - 75)) | (1L << (MINUS - 75)))) != 0)) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(331);
				((ExpressionContext)_localctx).base = ((ExpressionContext)_localctx).expression = expression(13);
				((ExpressionContext)_localctx).v =  Expression.unaryOp(((ExpressionContext)_localctx).base.v, getPre((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
				}
				break;
			case 10:
				{
				setState(334);
				((ExpressionContext)_localctx).op = match(EXCLA);
				setState(335);
				((ExpressionContext)_localctx).base = ((ExpressionContext)_localctx).expression = expression(12);
				((ExpressionContext)_localctx).v =  Expression.unaryOp(((ExpressionContext)_localctx).base.v, getPre((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(424);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(422);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(341);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PERCENT) | (1L << SLASH) | (1L << ASTERISK))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(342);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(12);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(345);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(346);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(347);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(11);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(350);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(351);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LEFT2_ANGLE - 64)) | (1L << (RIGHT3_ANGLE - 64)) | (1L << (RIGHT2_ANGLE - 64)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(352);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(355);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(356);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (LEQ - 32)) | (1L << (GEQ - 32)) | (1L << (LEFT_ANGLE - 32)) | (1L << (RIGHT_ANGLE - 32)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(357);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(360);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(361);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALSEQUALS || _la==NOTEQUALS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(362);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(365);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(366);
						((ExpressionContext)_localctx).op = match(ESPER);
						setState(367);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(370);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(371);
						((ExpressionContext)_localctx).op = match(CIRCON);
						setState(372);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(6);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(375);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(376);
						((ExpressionContext)_localctx).op = match(PIPE);
						setState(377);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(5);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(380);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(381);
						((ExpressionContext)_localctx).op = match(ESPERESPER);
						setState(382);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(4);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(385);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(386);
						((ExpressionContext)_localctx).op = match(PIPEPIPE);
						setState(387);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(3);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(390);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(391);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << PLUSE) | (1L << MINUSE) | (1L << ASTERISKE) | (1L << SLASHE) | (1L << ESPERE) | (1L << PIPEE) | (1L << CIRCONE) | (1L << RIGHT2_E) | (1L << RIGHT3_E) | (1L << LEFT2_E) | (1L << PERCENTE))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(392);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(1);
						((ExpressionContext)_localctx).v =  Expression.binaryOp(((ExpressionContext)_localctx).left.v, ((ExpressionContext)_localctx).right.v, getBin((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.base = _prevctx;
						_localctx.base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(395);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(396);
						match(DOLLAR);
						((ExpressionContext)_localctx).v =  Expression.arrayLength(((ExpressionContext)_localctx).base.v);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.base = _prevctx;
						_localctx.base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(398);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(399);
						match(DOT);
						setState(402);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
						case 1:
							{
							setState(400);
							((ExpressionContext)_localctx).functionId = functionId();
							((ExpressionContext)_localctx).m1.add(((ExpressionContext)_localctx).functionId);
							}
							break;
						case 2:
							{
							setState(401);
							((ExpressionContext)_localctx).variableId = variableId();
							((ExpressionContext)_localctx).m2.add(((ExpressionContext)_localctx).variableId);
							}
							break;
						}
						((ExpressionContext)_localctx).v =  Expression.methodOrField(((ExpressionContext)_localctx).base.v, or(((ExpressionContext)_localctx).m1,((ExpressionContext)_localctx).m2));
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.base = _prevctx;
						_localctx.base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(406);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(407);
						match(LEFT_SQUARE_BRACKET);
						setState(408);
						((ExpressionContext)_localctx).ai = ((ExpressionContext)_localctx).expression = expression(0);
						setState(409);
						match(RIGHT_SQUARE_BRACKET);
						((ExpressionContext)_localctx).v =  Expression.array(((ExpressionContext)_localctx).base.v, ((ExpressionContext)_localctx).ai.v);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.base = _prevctx;
						_localctx.base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(412);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(413);
						match(LEFT_PAREN);
						setState(415);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASM_START) | (1L << STRING_LITERAL) | (1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID) | (1L << MIN_ID) | (1L << NUMBER_LITERAL) | (1L << HASH) | (1L << LEFT_SQUARE_BRACKET) | (1L << DOLLAR) | (1L << PERCENT))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXCLA - 71)) | (1L << (LEFT_PAREN - 71)) | (1L << (PLUSPLUS - 71)) | (1L << (MINUSMINUS - 71)) | (1L << (PLUS - 71)) | (1L << (MINUS - 71)))) != 0)) {
							{
							setState(414);
							((ExpressionContext)_localctx).expressionList = expressionList();
							((ExpressionContext)_localctx).fparam.add(((ExpressionContext)_localctx).expressionList);
							}
						}

						setState(417);
						match(RIGHT_PAREN);
						((ExpressionContext)_localctx).v =  Expression.functionCall(((ExpressionContext)_localctx).base.v, opt(((ExpressionContext)_localctx).fparam));
						          if(((ExpressionContext)_localctx).base.v.type==Expression.Type.Field) ((ExpressionContext)_localctx).base.v.type=Expression.Type.Method;
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.base = _prevctx;
						_localctx.base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(420);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUSPLUS || _la==MINUSMINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						((ExpressionContext)_localctx).v =  Expression.unaryOp(((ExpressionContext)_localctx).base.v, getPost((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)));
						}
						break;
					}
					} 
				}
				setState(426);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Literal v;
		public ArrayLiteralContext v0;
		public StringLitteralContext v1;
		public NumberLiteralContext v2;
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public StringLitteralContext stringLitteral() {
			return getRuleContext(StringLitteralContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_TYPE_ALPHANUMERIC:
			case NUMBER_TYPE:
			case MAJ_ID:
			case LEFT_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				((LiteralContext)_localctx).v0 = arrayLiteral();
				((LiteralContext)_localctx).v =  ((LiteralContext)_localctx).v0.v;
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				((LiteralContext)_localctx).v1 = stringLitteral();
				((LiteralContext)_localctx).v =  ((LiteralContext)_localctx).v1.v;
				}
				break;
			case NUMBER_LITERAL:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				((LiteralContext)_localctx).v2 = numberLiteral();
				((LiteralContext)_localctx).v =  ((LiteralContext)_localctx).v2.v;
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

	public static class ArrayLiteralContext extends ParserRuleContext {
		public Literal v;
		public BaseTypeContext baseType;
		public List<BaseTypeContext> base = new ArrayList<BaseTypeContext>();
		public ArrayLiteralBodyContext arrayLiteralBody;
		public ArrayLiteralBodyContext arrayLiteralBody() {
			return getRuleContext(ArrayLiteralBodyContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << NUMBER_TYPE) | (1L << MAJ_ID))) != 0)) {
				{
				setState(438);
				((ArrayLiteralContext)_localctx).baseType = baseType();
				((ArrayLiteralContext)_localctx).base.add(((ArrayLiteralContext)_localctx).baseType);
				}
			}

			setState(441);
			((ArrayLiteralContext)_localctx).arrayLiteralBody = arrayLiteralBody();
			((ArrayLiteralContext)_localctx).v =  new Literal(opt(((ArrayLiteralContext)_localctx).base),((ArrayLiteralContext)_localctx).arrayLiteralBody.v);
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

	public static class ArrayLiteralBodyContext extends ParserRuleContext {
		public ArrayLiteralBody v;
		public ExpressionListContext expressionList;
		public List<ExpressionListContext> list = new ArrayList<ExpressionListContext>();
		public ExpressionContext base;
		public ExpressionContext expression;
		public List<ExpressionContext> value = new ArrayList<ExpressionContext>();
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(SxlangParser.LEFT_SQUARE_BRACKET, 0); }
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(SxlangParser.RIGHT_SQUARE_BRACKET, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode UNDERSCORE() { return getToken(SxlangParser.UNDERSCORE, 0); }
		public ArrayLiteralBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteralBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterArrayLiteralBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitArrayLiteralBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitArrayLiteralBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralBodyContext arrayLiteralBody() throws RecognitionException {
		ArrayLiteralBodyContext _localctx = new ArrayLiteralBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrayLiteralBody);
		try {
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				match(LEFT_SQUARE_BRACKET);
				setState(445);
				((ArrayLiteralBodyContext)_localctx).expressionList = expressionList();
				((ArrayLiteralBodyContext)_localctx).list.add(((ArrayLiteralBodyContext)_localctx).expressionList);
				setState(446);
				match(RIGHT_SQUARE_BRACKET);
				((ArrayLiteralBodyContext)_localctx).v =  new ArrayLiteralBody(opt(((ArrayLiteralBodyContext)_localctx).list));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				match(LEFT_SQUARE_BRACKET);
				setState(450);
				((ArrayLiteralBodyContext)_localctx).base = expression(0);
				setState(453);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ASM_START:
				case STRING_LITERAL:
				case NUMBER_TYPE_ALPHANUMERIC:
				case NUMBER_TYPE:
				case MAJ_ID:
				case MIN_ID:
				case NUMBER_LITERAL:
				case HASH:
				case LEFT_SQUARE_BRACKET:
				case DOLLAR:
				case PERCENT:
				case EXCLA:
				case LEFT_PAREN:
				case PLUSPLUS:
				case MINUSMINUS:
				case PLUS:
				case MINUS:
					{
					setState(451);
					((ArrayLiteralBodyContext)_localctx).expression = expression(0);
					((ArrayLiteralBodyContext)_localctx).value.add(((ArrayLiteralBodyContext)_localctx).expression);
					}
					break;
				case UNDERSCORE:
					{
					setState(452);
					match(UNDERSCORE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(455);
				match(RIGHT_SQUARE_BRACKET);
				((ArrayLiteralBodyContext)_localctx).v =  new ArrayLiteralBody(((ArrayLiteralBodyContext)_localctx).base.v, opt(((ArrayLiteralBodyContext)_localctx).value));
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

	public static class StringLitteralContext extends ParserRuleContext {
		public Literal v;
		public Token lit;
		public TerminalNode STRING_LITERAL() { return getToken(SxlangParser.STRING_LITERAL, 0); }
		public StringLitteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLitteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterStringLitteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitStringLitteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitStringLitteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLitteralContext stringLitteral() throws RecognitionException {
		StringLitteralContext _localctx = new StringLitteralContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringLitteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			((StringLitteralContext)_localctx).lit = match(STRING_LITERAL);
			((StringLitteralContext)_localctx).v =  new Literal(unescape((((StringLitteralContext)_localctx).lit!=null?((StringLitteralContext)_localctx).lit.getText():null)));
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

	public static class NumberLiteralContext extends ParserRuleContext {
		public Literal v;
		public Token neg;
		public Token num;
		public NumberTypeContext numberType;
		public List<NumberTypeContext> typ = new ArrayList<NumberTypeContext>();
		public TerminalNode NUMBER_LITERAL() { return getToken(SxlangParser.NUMBER_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(SxlangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SxlangParser.MINUS, 0); }
		public NumberTypeContext numberType() {
			return getRuleContext(NumberTypeContext.class,0);
		}
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_numberLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(463);
				match(PLUS);
				}
				break;
			case MINUS:
				{
				setState(464);
				((NumberLiteralContext)_localctx).neg = match(MINUS);
				}
				break;
			case NUMBER_LITERAL:
				break;
			default:
				break;
			}
			setState(467);
			((NumberLiteralContext)_localctx).num = match(NUMBER_LITERAL);
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(468);
				((NumberLiteralContext)_localctx).numberType = numberType();
				((NumberLiteralContext)_localctx).typ.add(((NumberLiteralContext)_localctx).numberType);
				}
				break;
			}
			((NumberLiteralContext)_localctx).v =  new Literal(((NumberLiteralContext)_localctx).neg != null, (((NumberLiteralContext)_localctx).num!=null?((NumberLiteralContext)_localctx).num.getText():null), opt(((NumberLiteralContext)_localctx).typ));
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

	public static class ParameterContext extends ParserRuleContext {
		public Parameter v;
		public VariableIdContext id;
		public Token TILDATILDA;
		public List<Token> option = new ArrayList<Token>();
		public Token TILDA;
		public Token _tset1190;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public TerminalNode TILDATILDA() { return getToken(SxlangParser.TILDATILDA, 0); }
		public TerminalNode TILDA() { return getToken(SxlangParser.TILDA, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			((ParameterContext)_localctx).id = variableId();
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TILDATILDA || _la==TILDA) {
				{
				setState(474);
				((ParameterContext)_localctx)._tset1190 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TILDATILDA || _la==TILDA) ) {
					((ParameterContext)_localctx)._tset1190 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ParameterContext)_localctx).option.add(((ParameterContext)_localctx)._tset1190);
				}
			}

			setState(477);
			((ParameterContext)_localctx).type = type();
			((ParameterContext)_localctx).v =  new Parameter(((ParameterContext)_localctx).id.v,((ParameterContext)_localctx).type.v,getOpt(optt(((ParameterContext)_localctx).option)));
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

	public static class TypeContext extends ParserRuleContext {
		public Type v;
		public BaseTypeContext baseType;
		public Token a;
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode SQUARE_BRACKET_PAIR() { return getToken(SxlangParser.SQUARE_BRACKET_PAIR, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			((TypeContext)_localctx).baseType = baseType();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SQUARE_BRACKET_PAIR) {
				{
				setState(481);
				((TypeContext)_localctx).a = match(SQUARE_BRACKET_PAIR);
				}
			}

			((TypeContext)_localctx).v =  new Type(((TypeContext)_localctx).baseType.v, ((TypeContext)_localctx).a != null);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public BaseType v;
		public NumberTypeContext numberType;
		public ClassIdContext classId;
		public NumberTypeContext numberType() {
			return getRuleContext(NumberTypeContext.class,0);
		}
		public ClassIdContext classId() {
			return getRuleContext(ClassIdContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_baseType);
		try {
			setState(492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_TYPE_ALPHANUMERIC:
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				((BaseTypeContext)_localctx).numberType = numberType();
				((BaseTypeContext)_localctx).v =  new BaseType(((BaseTypeContext)_localctx).numberType.v);
				}
				break;
			case MAJ_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				((BaseTypeContext)_localctx).classId = classId();
				((BaseTypeContext)_localctx).v =  new BaseType(((BaseTypeContext)_localctx).classId.v);
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

	public static class ClassIdContext extends ParserRuleContext {
		public String v;
		public Token t;
		public TerminalNode MAJ_ID() { return getToken(SxlangParser.MAJ_ID, 0); }
		public ClassIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterClassId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitClassId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitClassId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassIdContext classId() throws RecognitionException {
		ClassIdContext _localctx = new ClassIdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_classId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			((ClassIdContext)_localctx).t = match(MAJ_ID);
			((ClassIdContext)_localctx).v =  (((ClassIdContext)_localctx).t!=null?((ClassIdContext)_localctx).t.getText():null);
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

	public static class FunctionIdContext extends ParserRuleContext {
		public String v;
		public Token t;
		public TerminalNode NUMBER_TYPE_ALPHANUMERIC() { return getToken(SxlangParser.NUMBER_TYPE_ALPHANUMERIC, 0); }
		public TerminalNode MIN_ID() { return getToken(SxlangParser.MIN_ID, 0); }
		public FunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterFunctionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitFunctionId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitFunctionId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIdContext functionId() throws RecognitionException {
		FunctionIdContext _localctx = new FunctionIdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			((FunctionIdContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NUMBER_TYPE_ALPHANUMERIC || _la==MIN_ID) ) {
				((FunctionIdContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((FunctionIdContext)_localctx).v =  (((FunctionIdContext)_localctx).t!=null?((FunctionIdContext)_localctx).t.getText():null);
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

	public static class VariableIdContext extends ParserRuleContext {
		public String v;
		public Token t;
		public TerminalNode NUMBER_TYPE_ALPHANUMERIC() { return getToken(SxlangParser.NUMBER_TYPE_ALPHANUMERIC, 0); }
		public TerminalNode MAJ_ID() { return getToken(SxlangParser.MAJ_ID, 0); }
		public TerminalNode MIN_ID() { return getToken(SxlangParser.MIN_ID, 0); }
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitVariableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			((VariableIdContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER_TYPE_ALPHANUMERIC) | (1L << MAJ_ID) | (1L << MIN_ID))) != 0)) ) {
				((VariableIdContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((VariableIdContext)_localctx).v =  (((VariableIdContext)_localctx).t!=null?((VariableIdContext)_localctx).t.getText():null);
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

	public static class NumberTypeContext extends ParserRuleContext {
		public Primitive v;
		public Token t;
		public TerminalNode NUMBER_TYPE_ALPHANUMERIC() { return getToken(SxlangParser.NUMBER_TYPE_ALPHANUMERIC, 0); }
		public TerminalNode NUMBER_TYPE() { return getToken(SxlangParser.NUMBER_TYPE, 0); }
		public NumberTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).enterNumberType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SxlangListener ) ((SxlangListener)listener).exitNumberType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SxlangVisitor ) return ((SxlangVisitor<? extends T>)visitor).visitNumberType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberTypeContext numberType() throws RecognitionException {
		NumberTypeContext _localctx = new NumberTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_numberType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			((NumberTypeContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NUMBER_TYPE_ALPHANUMERIC || _la==NUMBER_TYPE) ) {
				((NumberTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((NumberTypeContext)_localctx).v =  getNum((((NumberTypeContext)_localctx).t!=null?((NumberTypeContext)_localctx).t.getText():null));
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 19);
		case 12:
			return precpred(_ctx, 17);
		case 13:
			return precpred(_ctx, 16);
		case 14:
			return precpred(_ctx, 15);
		case 15:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3P\u01fd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\7\4N\n\4\f\4\16\4Q\13\4"+
		"\3\4\3\4\3\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\3\4\3\4\3\5\5\5a\n\5"+
		"\3\5\3\5\5\5e\n\5\3\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\5\3\5\5\5p\n\5\3\5"+
		"\5\5s\n\5\3\5\3\5\3\5\7\5x\n\5\f\5\16\5{\13\5\3\5\5\5~\n\5\3\5\3\5\3\6"+
		"\5\6\u0083\n\6\3\6\5\6\u0086\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008e\n\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u009a\n\7\f\7\16\7\u009d"+
		"\13\7\3\7\5\7\u00a0\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00aa\n\7"+
		"\f\7\16\7\u00ad\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ba"+
		"\n\7\f\7\16\7\u00bd\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u00c9"+
		"\n\7\r\7\16\7\u00ca\3\7\3\7\3\7\6\7\u00d0\n\7\r\7\16\7\u00d1\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00de\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u00e5"+
		"\n\b\f\b\16\b\u00e8\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t\u00f2\n\t"+
		"\f\t\16\t\u00f5\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00fe\n\n\f\n\16"+
		"\n\u0101\13\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u0109\n\13\f\13\16\13\u010c"+
		"\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u0121\n\f\3\f\3\f\7\f\u0125\n\f\f\f\16\f\u0128\13\f"+
		"\3\f\5\f\u012b\n\f\3\f\5\f\u012e\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0139\n\f\3\f\3\f\5\f\u013d\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0145"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0155"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0195\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01a2\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u01a9"+
		"\n\f\f\f\16\f\u01ac\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01b7"+
		"\n\r\3\16\5\16\u01ba\n\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u01c8\n\17\3\17\3\17\3\17\5\17\u01cd\n\17\3\20\3"+
		"\20\3\20\3\21\3\21\5\21\u01d4\n\21\3\21\3\21\5\21\u01d8\n\21\3\21\3\21"+
		"\3\22\3\22\5\22\u01de\n\22\3\22\3\22\3\22\3\23\3\23\5\23\u01e5\n\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01ef\n\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\2\3\26\31\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\16\3\2MP\3\2\679\3\2OP\3\2BD"+
		"\4\2\"#EF\3\2\33\34\4\2\36\36$.\3\2MN\3\2\37 \4\2\22\22\25\25\4\2\22\22"+
		"\24\25\3\2\22\23\2\u023f\2\64\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\b`\3\2\2\2"+
		"\n\u0082\3\2\2\2\f\u00dd\3\2\2\2\16\u00df\3\2\2\2\20\u00ec\3\2\2\2\22"+
		"\u00f9\3\2\2\2\24\u0105\3\2\2\2\26\u0154\3\2\2\2\30\u01b6\3\2\2\2\32\u01b9"+
		"\3\2\2\2\34\u01cc\3\2\2\2\36\u01ce\3\2\2\2 \u01d3\3\2\2\2\"\u01db\3\2"+
		"\2\2$\u01e2\3\2\2\2&\u01ee\3\2\2\2(\u01f0\3\2\2\2*\u01f3\3\2\2\2,\u01f6"+
		"\3\2\2\2.\u01f9\3\2\2\2\60\63\5\4\3\2\61\63\7\32\2\2\62\60\3\2\2\2\62"+
		"\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66"+
		"\64\3\2\2\2\678\7\2\2\389\b\2\1\29\3\3\2\2\2:;\5\6\4\2;<\b\3\1\2<D\3\2"+
		"\2\2=>\5\b\5\2>?\b\3\1\2?D\3\2\2\2@A\5\n\6\2AB\b\3\1\2BD\3\2\2\2C:\3\2"+
		"\2\2C=\3\2\2\2C@\3\2\2\2D\5\3\2\2\2EF\5(\25\2FG\b\4\1\2GI\7\35\2\2HJ\7"+
		"!\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KO\7\62\2\2LN\5(\25\2ML\3\2\2\2NQ\3"+
		"\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RX\7\r\2\2SW\5\b\5\2TW\5"+
		"\n\6\2UW\7\32\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY"+
		"\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\16\2\2\\]\b\4\1\2]^\b\4\1\2^\7\3\2\2"+
		"\2_a\7!\2\2`_\3\2\2\2`a\3\2\2\2ad\3\2\2\2be\5(\25\2ce\5*\26\2db\3\2\2"+
		"\2dc\3\2\2\2ef\3\2\2\2fj\7\35\2\2gi\5\"\22\2hg\3\2\2\2il\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mo\7\63\2\2np\7\67\2\2on\3\2\2\2op\3"+
		"\2\2\2pr\3\2\2\2qs\5$\23\2rq\3\2\2\2rs\3\2\2\2s}\3\2\2\2ty\7\r\2\2ux\5"+
		"\f\7\2vx\7\32\2\2wu\3\2\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|"+
		"\3\2\2\2{y\3\2\2\2|~\7\16\2\2}t\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080"+
		"\b\5\1\2\u0080\t\3\2\2\2\u0081\u0083\7!\2\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0086\7\67\2\2\u0085\u0084\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5,\27\2\u0088"+
		"\u0089\7=\2\2\u0089\u008a\5$\23\2\u008a\u008d\7\35\2\2\u008b\u008e\7>"+
		"\2\2\u008c\u008e\5\26\f\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\b\6\1\2\u0090\13\3\2\2\2\u0091\u0092\7\60\2"+
		"\2\u0092\u0093\5\26\f\2\u0093\u0094\7\61\2\2\u0094\u0095\7\32\2\2\u0095"+
		"\u0096\b\7\1\2\u0096\u00de\3\2\2\2\u0097\u009b\5\16\b\2\u0098\u009a\5"+
		"\20\t\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\5\22"+
		"\n\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\7\32\2\2\u00a2\u00a3\b\7\1\2\u00a3\u00de\3\2\2\2\u00a4\u00a5\7"+
		"?\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00ab\7\r\2\2\u00a7\u00aa\5\f\7\2\u00a8"+
		"\u00aa\7\32\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00af\7\16\2\2\u00af\u00b0\7\32\2\2\u00b0\u00b1\b"+
		"\7\1\2\u00b1\u00de\3\2\2\2\u00b2\u00b3\7?\2\2\u00b3\u00b4\5,\27\2\u00b4"+
		"\u00b5\7@\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00bb\7\r\2\2\u00b7\u00ba\5\f"+
		"\7\2\u00b8\u00ba\7\32\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\16\2\2\u00bf\u00c0\7\32\2\2\u00c0"+
		"\u00c1\b\7\1\2\u00c1\u00de\3\2\2\2\u00c2\u00c3\7A\2\2\u00c3\u00c4\5\26"+
		"\f\2\u00c4\u00c5\7\32\2\2\u00c5\u00c6\b\7\1\2\u00c6\u00de\3\2\2\2\u00c7"+
		"\u00c9\7F\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7\32\2\2\u00cd"+
		"\u00de\b\7\1\2\u00ce\u00d0\7E\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\7\32\2\2\u00d4\u00de\b\7\1\2\u00d5\u00d6\5\n\6\2\u00d6\u00d7\7"+
		"\32\2\2\u00d7\u00d8\b\7\1\2\u00d8\u00de\3\2\2\2\u00d9\u00da\5\26\f\2\u00da"+
		"\u00db\7\32\2\2\u00db\u00dc\b\7\1\2\u00dc\u00de\3\2\2\2\u00dd\u0091\3"+
		"\2\2\2\u00dd\u0097\3\2\2\2\u00dd\u00a4\3\2\2\2\u00dd\u00b2\3\2\2\2\u00dd"+
		"\u00c2\3\2\2\2\u00dd\u00c8\3\2\2\2\u00dd\u00cf\3\2\2\2\u00dd\u00d5\3\2"+
		"\2\2\u00dd\u00d9\3\2\2\2\u00de\r\3\2\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1"+
		"\7H\2\2\u00e1\u00e6\7\r\2\2\u00e2\u00e5\5\f\7\2\u00e3\u00e5\7\32\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ea\7\16\2\2\u00ea\u00eb\b\b\1\2\u00eb\17\3\2\2\2\u00ec\u00ed\5\26"+
		"\f\2\u00ed\u00ee\7G\2\2\u00ee\u00f3\7\r\2\2\u00ef\u00f2\5\f\7\2\u00f0"+
		"\u00f2\7\32\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3"+
		"\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f7\7\16\2\2\u00f7\u00f8\b\t\1\2\u00f8\21\3\2\2"+
		"\2\u00f9\u00fa\7@\2\2\u00fa\u00ff\7\r\2\2\u00fb\u00fe\5\f\7\2\u00fc\u00fe"+
		"\7\32\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2"+
		"\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u0103\7\16\2\2\u0103\u0104\b\n\1\2\u0104\23\3\2\2\2\u0105"+
		"\u010a\5\26\f\2\u0106\u0107\7J\2\2\u0107\u0109\5\26\f\2\u0108\u0106\3"+
		"\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\b\13\1\2\u010e\25\3\2\2"+
		"\2\u010f\u0110\b\f\1\2\u0110\u0111\7K\2\2\u0111\u0112\5\26\f\2\u0112\u0113"+
		"\7L\2\2\u0113\u0114\b\f\1\2\u0114\u0155\3\2\2\2\u0115\u0116\7\60\2\2\u0116"+
		"\u0117\5.\30\2\u0117\u0118\7\36\2\2\u0118\u0119\5\26\f\2\u0119\u011a\7"+
		"\61\2\2\u011a\u011b\b\f\1\2\u011b\u0155\3\2\2\2\u011c\u012a\7\17\2\2\u011d"+
		"\u0120\7K\2\2\u011e\u0121\5&\24\2\u011f\u0121\7>\2\2\u0120\u011e\3\2\2"+
		"\2\u0120\u011f\3\2\2\2\u0121\u0126\3\2\2\2\u0122\u0123\7J\2\2\u0123\u0125"+
		"\5\26\f\2\u0124\u0122\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2"+
		"\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012b"+
		"\7L\2\2\u012a\u011d\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c"+
		"\u012e\7\20\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3"+
		"\2\2\2\u012f\u0130\7\21\2\2\u0130\u0155\b\f\1\2\u0131\u0132\5\30\r\2\u0132"+
		"\u0133\b\f\1\2\u0133\u0155\3\2\2\2\u0134\u0138\7!\2\2\u0135\u0139\5(\25"+
		"\2\u0136\u0139\5*\26\2\u0137\u0139\5,\27\2\u0138\u0135\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\7K\2\2\u013b"+
		"\u013d\5\24\13\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3"+
		"\2\2\2\u013e\u013f\7L\2\2\u013f\u0140\b\f\1\2\u0140\u0155\3\2\2\2\u0141"+
		"\u0145\5(\25\2\u0142\u0145\5*\26\2\u0143\u0145\5,\27\2\u0144\u0141\3\2"+
		"\2\2\u0144\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\b\f\1\2\u0147\u0155\3\2\2\2\u0148\u0149\7\67\2\2\u0149\u0155\b"+
		"\f\1\2\u014a\u014b\7\62\2\2\u014b\u0155\b\f\1\2\u014c\u014d\t\2\2\2\u014d"+
		"\u014e\5\26\f\17\u014e\u014f\b\f\1\2\u014f\u0155\3\2\2\2\u0150\u0151\7"+
		"I\2\2\u0151\u0152\5\26\f\16\u0152\u0153\b\f\1\2\u0153\u0155\3\2\2\2\u0154"+
		"\u010f\3\2\2\2\u0154\u0115\3\2\2\2\u0154\u011c\3\2\2\2\u0154\u0131\3\2"+
		"\2\2\u0154\u0134\3\2\2\2\u0154\u0144\3\2\2\2\u0154\u0148\3\2\2\2\u0154"+
		"\u014a\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u0150\3\2\2\2\u0155\u01aa\3\2"+
		"\2\2\u0156\u0157\f\r\2\2\u0157\u0158\t\3\2\2\u0158\u0159\5\26\f\16\u0159"+
		"\u015a\b\f\1\2\u015a\u01a9\3\2\2\2\u015b\u015c\f\f\2\2\u015c\u015d\t\4"+
		"\2\2\u015d\u015e\5\26\f\r\u015e\u015f\b\f\1\2\u015f\u01a9\3\2\2\2\u0160"+
		"\u0161\f\13\2\2\u0161\u0162\t\5\2\2\u0162\u0163\5\26\f\f\u0163\u0164\b"+
		"\f\1\2\u0164\u01a9\3\2\2\2\u0165\u0166\f\n\2\2\u0166\u0167\t\6\2\2\u0167"+
		"\u0168\5\26\f\13\u0168\u0169\b\f\1\2\u0169\u01a9\3\2\2\2\u016a\u016b\f"+
		"\t\2\2\u016b\u016c\t\7\2\2\u016c\u016d\5\26\f\n\u016d\u016e\b\f\1\2\u016e"+
		"\u01a9\3\2\2\2\u016f\u0170\f\b\2\2\u0170\u0171\7<\2\2\u0171\u0172\5\26"+
		"\f\t\u0172\u0173\b\f\1\2\u0173\u01a9\3\2\2\2\u0174\u0175\f\7\2\2\u0175"+
		"\u0176\7\64\2\2\u0176\u0177\5\26\f\b\u0177\u0178\b\f\1\2\u0178\u01a9\3"+
		"\2\2\2\u0179\u017a\f\6\2\2\u017a\u017b\7\66\2\2\u017b\u017c\5\26\f\7\u017c"+
		"\u017d\b\f\1\2\u017d\u01a9\3\2\2\2\u017e\u017f\f\5\2\2\u017f\u0180\7;"+
		"\2\2\u0180\u0181\5\26\f\6\u0181\u0182\b\f\1\2\u0182\u01a9\3\2\2\2\u0183"+
		"\u0184\f\4\2\2\u0184\u0185\7\65\2\2\u0185\u0186\5\26\f\5\u0186\u0187\b"+
		"\f\1\2\u0187\u01a9\3\2\2\2\u0188\u0189\f\3\2\2\u0189\u018a\t\b\2\2\u018a"+
		"\u018b\5\26\f\3\u018b\u018c\b\f\1\2\u018c\u01a9\3\2\2\2\u018d\u018e\f"+
		"\25\2\2\u018e\u018f\7\62\2\2\u018f\u01a9\b\f\1\2\u0190\u0191\f\23\2\2"+
		"\u0191\u0194\7:\2\2\u0192\u0195\5*\26\2\u0193\u0195\5,\27\2\u0194\u0192"+
		"\3\2\2\2\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\b\f\1\2\u0197"+
		"\u01a9\3\2\2\2\u0198\u0199\f\22\2\2\u0199\u019a\7\60\2\2\u019a\u019b\5"+
		"\26\f\2\u019b\u019c\7\61\2\2\u019c\u019d\b\f\1\2\u019d\u01a9\3\2\2\2\u019e"+
		"\u019f\f\21\2\2\u019f\u01a1\7K\2\2\u01a0\u01a2\5\24\13\2\u01a1\u01a0\3"+
		"\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\7L\2\2\u01a4"+
		"\u01a9\b\f\1\2\u01a5\u01a6\f\20\2\2\u01a6\u01a7\t\t\2\2\u01a7\u01a9\b"+
		"\f\1\2\u01a8\u0156\3\2\2\2\u01a8\u015b\3\2\2\2\u01a8\u0160\3\2\2\2\u01a8"+
		"\u0165\3\2\2\2\u01a8\u016a\3\2\2\2\u01a8\u016f\3\2\2\2\u01a8\u0174\3\2"+
		"\2\2\u01a8\u0179\3\2\2\2\u01a8\u017e\3\2\2\2\u01a8\u0183\3\2\2\2\u01a8"+
		"\u0188\3\2\2\2\u01a8\u018d\3\2\2\2\u01a8\u0190\3\2\2\2\u01a8\u0198\3\2"+
		"\2\2\u01a8\u019e\3\2\2\2\u01a8\u01a5\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\27\3\2\2\2\u01ac\u01aa\3\2\2"+
		"\2\u01ad\u01ae\5\32\16\2\u01ae\u01af\b\r\1\2\u01af\u01b7\3\2\2\2\u01b0"+
		"\u01b1\5\36\20\2\u01b1\u01b2\b\r\1\2\u01b2\u01b7\3\2\2\2\u01b3\u01b4\5"+
		" \21\2\u01b4\u01b5\b\r\1\2\u01b5\u01b7\3\2\2\2\u01b6\u01ad\3\2\2\2\u01b6"+
		"\u01b0\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b7\31\3\2\2\2\u01b8\u01ba\5&\24"+
		"\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc"+
		"\5\34\17\2\u01bc\u01bd\b\16\1\2\u01bd\33\3\2\2\2\u01be\u01bf\7\60\2\2"+
		"\u01bf\u01c0\5\24\13\2\u01c0\u01c1\7\61\2\2\u01c1\u01c2\b\17\1\2\u01c2"+
		"\u01cd\3\2\2\2\u01c3\u01c4\7\60\2\2\u01c4\u01c7\5\26\f\2\u01c5\u01c8\5"+
		"\26\f\2\u01c6\u01c8\7>\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c6\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01ca\7\61\2\2\u01ca\u01cb\b\17\1\2\u01cb\u01cd\3"+
		"\2\2\2\u01cc\u01be\3\2\2\2\u01cc\u01c3\3\2\2\2\u01cd\35\3\2\2\2\u01ce"+
		"\u01cf\7\20\2\2\u01cf\u01d0\b\20\1\2\u01d0\37\3\2\2\2\u01d1\u01d4\7O\2"+
		"\2\u01d2\u01d4\7P\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\7\26\2\2\u01d6\u01d8\5.\30\2"+
		"\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da"+
		"\b\21\1\2\u01da!\3\2\2\2\u01db\u01dd\5,\27\2\u01dc\u01de\t\n\2\2\u01dd"+
		"\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\5$"+
		"\23\2\u01e0\u01e1\b\22\1\2\u01e1#\3\2\2\2\u01e2\u01e4\5&\24\2\u01e3\u01e5"+
		"\7/\2\2\u01e4\u01e3\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e7\b\23\1\2\u01e7%\3\2\2\2\u01e8\u01e9\5.\30\2\u01e9\u01ea\b\24\1"+
		"\2\u01ea\u01ef\3\2\2\2\u01eb\u01ec\5(\25\2\u01ec\u01ed\b\24\1\2\u01ed"+
		"\u01ef\3\2\2\2\u01ee\u01e8\3\2\2\2\u01ee\u01eb\3\2\2\2\u01ef\'\3\2\2\2"+
		"\u01f0\u01f1\7\24\2\2\u01f1\u01f2\b\25\1\2\u01f2)\3\2\2\2\u01f3\u01f4"+
		"\t\13\2\2\u01f4\u01f5\b\26\1\2\u01f5+\3\2\2\2\u01f6\u01f7\t\f\2\2\u01f7"+
		"\u01f8\b\27\1\2\u01f8-\3\2\2\2\u01f9\u01fa\t\r\2\2\u01fa\u01fb\b\30\1"+
		"\2\u01fb/\3\2\2\29\62\64CIOVX`djorwy}\u0082\u0085\u008d\u009b\u009f\u00a9"+
		"\u00ab\u00b9\u00bb\u00ca\u00d1\u00dd\u00e4\u00e6\u00f1\u00f3\u00fd\u00ff"+
		"\u010a\u0120\u0126\u012a\u012d\u0138\u013c\u0144\u0154\u0194\u01a1\u01a8"+
		"\u01aa\u01b6\u01b9\u01c7\u01cc\u01d3\u01d7\u01dd\u01e4\u01ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}