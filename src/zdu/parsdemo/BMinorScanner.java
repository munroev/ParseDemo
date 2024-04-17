package zdu.parsdemo;

import java.util.Hashtable;

public class BMinorScanner extends Scanner {
     // Reserved word tokens.
  static private final int RESERVED_LO = 256; // Compound token #s > this.
  static private final int N_RESERVED = 2; // # of reserved words.

  public static final int IDENTIFIER_TOK = RESERVED_LO + N_RESERVED;// 258;

public static final int TOKEN_ARRAY=259;
public static final int TOKEN_AUTO=260;
public static final int TOKEN_BOOLEAN=261;
public static final int TOKEN_CHAR=262;
public static final int TOKEN_ELSE=263;
public static final int TOKEN_FOR=264;
public static final int TOKEN_FUNCTION=265;
public static final int TOKEN_IF=266;
public static final int TOKEN_INTEGER=267;
public static final int TOKEN_PRINT=268;
public static final int TOKEN_RETURN=269;
public static final int TOKEN_STRING=270;
public static final int TOKEN_VOID=271;
public static final int TOKEN_WHILE=272;

public static final int TOKEN_IDENT=273;
public static final int TOKEN_BOOL=274;
public static final int TOKEN_NUMBER=275;
public static final int TOKEN_STR=276;
public static final int TOKEN_CH=277;

public static final int TOKEN_INC=278;
public static final int TOKEN_DEC=279;
public static final int TOKEN_SUB=280;
public static final int TOKEN_EXP=281;
public static final int TOKEN_NOT=282;
public static final int TOKEN_MULT=283;
public static final int TOKEN_DIV=284;
public static final int TOKEN_MOD=285;
public static final int TOKEN_ADD=286;
public static final int TOKEN_LEQ=287;
public static final int TOKEN_LESS=288;
public static final int TOKEN_GEQ=289;
public static final int TOKEN_GREAT=290;
public static final int TOKEN_EQ=291;
public static final int TOKEN_NEQ=292;
public static final int TOKEN_AND=293;
public static final int TOKEN_OR=294;
public static final int TOKEN_ASSIGN=295;

public static final int TOKEN_LBRACK=296;
public static final int TOKEN_RBRACK=297;
public static final int TOKEN_LPAR=298;
public static final int TOKEN_RPAR=299;
public static final int TOKEN_LCURL=300;
public static final int TOKEN_RCURL=301;
public static final int TOKEN_COLON=302;
public static final int TOKEN_SEMI=303;
public static final int TOKEN_COMMA=304;

public static final int TOKEN_ERROR=305;
public static final int TOKEN_EOF=306;

  private void initToks(){

    addTok(TOKEN_ARRAY, "array");
    addTok(TOKEN_AUTO, "auto");
    addTok(TOKEN_BOOLEAN, "boolean");
    addTok(TOKEN_CHAR, "char");
    addTok(TOKEN_STRING, "string");
    addTok(TOKEN_ELSE, "else");
    addTok(TOKEN_IF, "if");
    addTok(TOKEN_FUNCTION, "function");
    addTok(TOKEN_INTEGER, "integer");
    addTok(TOKEN_PRINT, "print");
    addTok(TOKEN_RETURN, "return");
    addTok(TOKEN_VOID, "void");
    addTok(TOKEN_WHILE, "while");

    addTok(TOKEN_INC, "++");
    addTok(TOKEN_DEC, "--");
    addTok(TOKEN_SUB, "-");
    addTok(TOKEN_EXP, "^");
    addTok(TOKEN_NOT, "!");
    addTok(TOKEN_MULT, "*");
    addTok(TOKEN_DIV, "/");
    addTok(TOKEN_MOD, "%");

    addTok(TOKEN_GEQ, ">=");
    addTok(TOKEN_LEQ, "<=");
    addTok(TOKEN_EQ, "==");
    addTok(TOKEN_LEQ, "<");
    addTok(TOKEN_GREAT, "<");
    addTok(TOKEN_NEQ, "!=");
    addTok(TOKEN_AND, "&&");
    addTok(TOKEN_OR, "||");
    addTok(TOKEN_ASSIGN, "=");

    addTok(TOKEN_IDENT,"  ");

    addTok(TOKEN_LBRACK, "[");
    addTok(TOKEN_RBRACK, "]");
    addTok(TOKEN_LPAR, "(");
    addTok(TOKEN_RPAR, ")");
    addTok(TOKEN_LCURL, "{");
    addTok(TOKEN_RCURL,"}");
    addTok(TOKEN_COLON,":");
    addTok(TOKEN_SEMI,";");
    addTok(TOKEN_COMMA,",");

    addTok(TOKEN_EOF, "<<EOF>>");



    /* FIXME
     * true|false		{ return check_token(TOKEN_BOOL); }
    [+-]?{DIGIT}+		{ return check_token(TOKEN_NUMBER); }
    CH_CHAR}"'"		{ return format_token(check_token(TOKEN_CH)); }
     */
  }







  @Override
public Token nextTok() {
	// TODO Auto-generated method stub
	throw new UnsupportedOperationException("Unimplemented method 'nextTok'");
}

}
