package zdu.parsdemo;

import java.util.Hashtable;

public class ANSICScanner extends Scanner {

  // Reserved word tokens.
  static private final int RESERVED_LO = 256; // Compound token #s > this.
  static private final int N_RESERVED = 2; // # of reserved words.

  // Other compound tokens.
  public static final int IDENTIFIER_TOK = RESERVED_LO + N_RESERVED;// 258;
  public static final int CONSTANT_TOK = 259;
  public static final int STRING_LITERAL_TOK = 260;
  public static final int SIZEOF_TOK = 261;
  public static final int PTR_OP_TOK = 262;
  public static final int INC_OP_TOK = 263;
  public static final int DEC_OP_TOK = 264;
  public static final int LEFT_OP_TOK = 265;
  public static final int RIGHT_OP_TOK = 266;
  public static final int GE_OP_TOK = 267;
  public static final int LE_OP_TOK = 268;
  public static final int EQ_OP_TOK = 269;
  public static final int NE_OP_TOK = 270;
  public static final int AND_OP_TOK = 271;
  public static final int OR_OP_TOK = 272;
  public static final int MUL_ASSIGN_TOK = 273;
  public static final int DIV_ASSIGN_TOK = 274;
  public static final int MOD_ASSIGN_TOK = 275;
  public static final int ADD_ASSIGN_TOK = 276;
  public static final int SUB_ASSIGN_TOK = 277;
  public static final int LEFT_ASSIGN_TOK = 278;
  public static final int RIGHT_ASSIGN_TOK = 279;
  public static final int AND_ASSIGN_TOK = 280;
  public static final int XOR_ASSIGN_TOK = 281;
  public static final int OR_ASSIGN_TOK = 282;
  public static final int TYPEDEF_TOK = 283;
  public static final int EXTERN_TOK = 284;
  public static final int STATIC_TOK = 285;
  public static final int AUTO_TOK = 286;
  public static final int REGISTER_TOK = 287;
  public static final int VOID_TOK = 288;
  public static final int CHAR_TOK = 289;
  public static final int SHORT_TOK = 290;
  public static final int INT_TOK = 291;
  public static final int LONG_TOK = 292;
  public static final int FLOAT_TOK = 293;
  public static final int DOUBLE_TOK = 294;
  public static final int SIGNED_TOK = 295;
  public static final int UNSIGNED_TOK = 296;
  public static final int TYPE_NAME_TOK = 297;
  public static final int STRUCT_TOK = 298;
  public static final int UNION_TOK = 299;
  public static final int ENUM_TOK = 300;
  public static final int CONST_TOK = 301;
  public static final int VOLATILE_TOK = 302;
  public static final int ELLIPSIS_TOK = 303;
  public static final int CASE_TOK = 304;
  public static final int DEFAULT_TOK = 305;
  public static final int ELSE_TOK = 306;
  public static final int SWITCH_TOK = 307;
  public static final int DO_TOK = 308;
  public static final int FOR_TOK = 309;
  public static final int GOTO_TOK = 310;
  public static final int BREAK_TOK = 311;
  public static final int RETURN_TOK = 312;
  public static final int CONTINUE_TOK = 313;
  public static final int WHILE_TOK = 314;
  public static final int IF_TOK = 315;

  // Hashtable for storing reserved words and identifiers.
  private Hashtable ids = new Hashtable();

  ANSICScanner() {
    super();
    // initIDs();
    initToks();
  }

  private void initToks() {

    addTok(IDENTIFIER_TOK, "IDENTIFIER");
    addTok(CONSTANT_TOK, "CONSTANT");
    addTok(STRING_LITERAL_TOK, "STRING_LITERAL");

    addTok(SIZEOF_TOK, "sizeof");
    addTok(PTR_OP_TOK, "->");

    addTok(INC_OP_TOK, "++");
    addTok(DEC_OP_TOK, "--");

    addTok(LEFT_OP_TOK, "<<");
    addTok(RIGHT_OP_TOK, ">>");
    addTok(GE_OP_TOK, ">=");
    addTok(LE_OP_TOK, "<=");
    addTok(EQ_OP_TOK, "==");
    addTok(NE_OP_TOK, "!=");
    addTok(AND_OP_TOK, "&&");
    addTok(OR_OP_TOK, "||");

    addTok(MUL_ASSIGN_TOK, "*=");
    addTok(DIV_ASSIGN_TOK, "/=");
    addTok(MOD_ASSIGN_TOK, "%=");
    addTok(ADD_ASSIGN_TOK, "+=");
    addTok(SUB_ASSIGN_TOK, "-=");
    addTok(LEFT_ASSIGN_TOK, "<<=");
    addTok(RIGHT_ASSIGN_TOK, ">>=");
    addTok(XOR_ASSIGN_TOK, "^=");
    addTok(AND_ASSIGN_TOK, "&=");
    addTok(OR_ASSIGN_TOK, "|=");

    addTok(TYPEDEF_TOK, "typedef");
    addTok(EXTERN_TOK, "extern");
    addTok(STATIC_TOK, "static");
    addTok(AUTO_TOK, "auto");
    addTok(REGISTER_TOK, "register");
    addTok(VOID_TOK, "void");
    addTok(CHAR_TOK, "char");
    addTok(SHORT_TOK, "short");

    addTok(INT_TOK, "int");
    addTok(LONG_TOK, "long");
    addTok(FLOAT_TOK, "float");
    addTok(DOUBLE_TOK, "double");
    addTok(SIGNED_TOK, "signed");
    addTok(UNSIGNED_TOK, "unsigned");
    addTok(TYPE_NAME_TOK, "TYPE_NAME");
    addTok(STRUCT_TOK, "struct");

    addTok(UNION_TOK, "union");
    addTok(ENUM_TOK, "enum");
    addTok(CONST_TOK, "const");
    addTok(VOLATILE_TOK, "volatile");
    addTok(ELLIPSIS_TOK, "...");
    addTok(DEFAULT_TOK, "default");
    addTok(ELSE_TOK, "else");

    addTok(SWITCH_TOK, "switch");
    addTok(DO_TOK, "do");
    addTok(FOR_TOK, "for");
    addTok(GOTO_TOK, "goto");
    addTok(BREAK_TOK, "break");
    addTok(CASE_TOK, "case");
    addTok(RETURN_TOK, "return");
    addTok(CONTINUE_TOK, "continue");
    addTok(WHILE_TOK, "while");
    addTok(IF_TOK, "if");
  }

  // private void initIDs() {
  //   ids.put("div", new Integer(ids.size()));
  //   ids.put("mod", new Integer(ids.size()));
  // }

  public int getID(String text) {
    Integer val = (Integer) ids.get(text);
    if (val == null) {
      val = Integer.valueOf(ids.size());
      ids.put(text, val);
    }
    return val.intValue();
  }

  private int getIDTok(String text) {
    int id = getID(text);
    if (id < N_RESERVED) {
      return id + RESERVED_LO;
    } else {
      return IDENTIFIER_TOK;
    }
  }

  public Token nextTok() {
    int t;
    char c = peek();
    StringBuffer tokBuf = new StringBuffer();
    while (true) {
      if (c == SENTINEL_CHAR) {
        t = EOF_TOK;
        tokBuf.append(eofName);
        break;
      }
      for (c = peek(); Character.isWhitespace(c); advance(), c = peek()) {
      }
      if (Character.isLetter(c)) {
        do {
          tokBuf.append(c);
          advance();
          c = peek();
        } while (Character.isLetterOrDigit(c));

        if (tokBuf.toString().equals("if")) {

          t = IF_TOK;
          break;

        } else if (tokBuf.toString().equals("do")) {
          t = DO_TOK;
          break;

        } else if (tokBuf.toString().equals("else")) {

          t = ELSE_TOK;
          break;
        }

        else if (tokBuf.toString().equals("while")) {
          t = WHILE_TOK;
          break;

        } else if (tokBuf.toString().equals("for")) {

          t = FOR_TOK;
          break;
        }
        else if(tokBuf.toString().equals("switch")){

          t = SWITCH_TOK;
          break;
        
        }
        else if(tokBuf.toString().equals("goto"))
        {
          t = GOTO_TOK;
          break;
        }
        else if(tokBuf.toString().equals("break"))
        {
          t = BREAK_TOK;
          break;
        }
        else if(tokBuf.toString().equals("case"))
        {
          t = CASE_TOK;
          break;
        }
        else if(tokBuf.toString().equals("return"))
        {
          t = RETURN_TOK;
          break;
        }
        else if(tokBuf.toString().equals("continue"))
        {
          t = CONTINUE_TOK;
          break;
        }
        else if(tokBuf.toString().equals("typedef"))
        {
          t = TYPEDEF_TOK;
          break;
        }
        else if(tokBuf.toString().equals("extern"))
        {
          t = EXTERN_TOK;
          break;
        }
        else if(tokBuf.toString().equals("static"))
        {
          t = STATIC_TOK;
          break;
        }
        else if(tokBuf.toString().equals("auto"))
        {
          t = AUTO_TOK;
          break;
        }
        else if(tokBuf.toString().equals("register"))
        {
          t = REGISTER_TOK;
          break;
        }
        else if(tokBuf.toString().equals("void"))
        {
          t = VOID_TOK;
          break;
        }
        else if(tokBuf.toString().equals("char"))
        {
          t = CHAR_TOK;
          break;
        }
        else if(tokBuf.toString().equals("short"))
        {
          t = SHORT_TOK;
          break;
        }
        else if(tokBuf.toString().equals("int"))
        {
          t = INT_TOK;
          break;
        }
        else if(tokBuf.toString().equals("long"))
        {
          t = LONG_TOK;
          break;
        }
        else if(tokBuf.toString().equals("float"))
        {
          t = FLOAT_TOK;
          break;
        }
        else if(tokBuf.toString().equals("double"))
        {
          t = DOUBLE_TOK;
          break;
        }
        else if(tokBuf.toString().equals("signed"))
        {
          t = SIGNED_TOK;
          break;
        }
        else if(tokBuf.toString().equals("unsigned"))
        {
          t = UNSIGNED_TOK;
          break;
        }
        else if(tokBuf.toString().equals("type_name"))
        {
          t = TYPE_NAME_TOK;
          break;
        }
        else if(tokBuf.toString().equals("struct"))
        {
          t = STRUCT_TOK;
          break;
        }
        else if(tokBuf.toString().equals("union"))
        {
          t = UNION_TOK;
          break;
        }
        else if(tokBuf.toString().equals("enum"))
        {
          t = ENUM_TOK;
          break;
        }
        else if(tokBuf.toString().equals("const"))
        {
          t = CONSTANT_TOK;
          break;
        }
        else if(tokBuf.toString().equals("volatile"))
        {
          t = VOLATILE_TOK;
          break;
        }
        else if(tokBuf.toString().equals("..."))
        {
          t = ELLIPSIS_TOK;
          break;
        }
        else if(tokBuf.toString().equals("default"))
        {
          t = DEFAULT_TOK;
          break;
        }
        else if(tokBuf.toString().equals("sizeof"))
        {
          t = SIZEOF_TOK;
          break;
        }
         else {

          t = getIDTok(tokBuf.toString());
          break;
        }
        
      } else if (Character.isDigit(c)) {
        do {
          tokBuf.append(c);
          advance();
          c = peek();
        } while (Character.isDigit(c));
        t = STRING_LITERAL_TOK;
        break;
      } else if (c == '=' && peek(1) == '=') {
        tokBuf.append("==");
        advance();
        advance();
        t = EQ_OP_TOK;
        break;
      }

      else if (c == '!' && peek(1) == '=') {
        tokBuf.append("!=");
        advance();
        advance();
        t = NE_OP_TOK;
        break;
      } else if (c == '<' && peek(1) == '=') {
        tokBuf.append("<=");
        advance();
        advance();
        t = LE_OP_TOK;
        break;
      } else if (c == '>' && peek(1) == '=') {
        tokBuf.append(">=");
        advance();
        advance();
        t = GE_OP_TOK;
        break;
      } 
      else if (c == '-' && peek(1) == '>') {
        tokBuf.append("->");
        advance();
        advance();
        t = PTR_OP_TOK;
        break;
      }
      else if (c == '+' && peek(1) == '+') {
        tokBuf.append("++");
        advance();
        advance();
        t = INC_OP_TOK;
        break;
      }
      else if (c == '-' && peek(1) == '-') {
        tokBuf.append("<=");
        advance();
        advance();
        t = DEC_OP_TOK;
        break;
      }
      else if (c == '&' && peek(1) == '&') {
        tokBuf.append("&&");
        advance();
        advance();
        t = AND_OP_TOK;
        break;
      }
      else if (c == '|' && peek(1) == '|') {
        tokBuf.append("||");
        advance();
        advance();
        t = OR_OP_TOK;
        break;
      }
      else if (c == '<' && peek(1) == '<' && peek(2)!='=') {
        tokBuf.append("<<");
        advance();
        advance();
        t = LEFT_OP_TOK;
        break;
      }
      else if (c == '>' && peek(1) == '>' && peek(2)!= '=') {
        tokBuf.append(">>");
        advance();
        advance();
        t = RIGHT_OP_TOK;
        break;
      }
      else if (c == '<' && peek(1) == '<' && peek(2) =='=') {
        tokBuf.append("<<=");
        advance();
        advance();
        t = LEFT_ASSIGN_TOK;
        break;
      }
      else if (c == '>' && peek(1) == '>' && peek(2) == '=') {
        tokBuf.append(">>=");
        advance();
        advance();
        t = RIGHT_ASSIGN_TOK;
        break;
      }
      else if (c == '>' && peek(1) == '>' && peek(2)!= '=') {
        tokBuf.append(">>");
        advance();
        advance();
        t = RIGHT_OP_TOK;
        break;
      }
      else if (c == '*' && peek(1) == '=') {
        tokBuf.append("*=");
        advance();
        advance();
        t = MUL_ASSIGN_TOK;
        break;
      }
      else if (c == '/' && peek(1) == '=') {
        tokBuf.append("<=");
        advance();
        advance();
        t = DIV_ASSIGN_TOK;
        break;
      }
      else if (c == '%' && peek(1) == '=') {
        tokBuf.append("%=");
        advance();
        advance();
        t = MOD_ASSIGN_TOK;
        break;
      }
      else if (c == '+' && peek(1) == '=') {
        tokBuf.append("+=");
        advance();
        advance();
        t = ADD_ASSIGN_TOK;
        break;
      }
      else if (c == '-' && peek(1) == '=') {
        tokBuf.append("-=");
        advance();
        advance();
        t = SUB_ASSIGN_TOK;
        break;
      }
      else if (c == '^' && peek(1) == '=') {
        tokBuf.append("^=");
        advance();
        advance();
        t = XOR_ASSIGN_TOK;
        break;
      }
      else if (c == '&' && peek(1) == '=') {
        tokBuf.append("&=");
        advance();
        advance();
        t = AND_ASSIGN_TOK;
        break;
      }
      else if (c == '|' && peek(1) == '=') {
        tokBuf.append("|=");
        advance();
        advance();
        t = OR_ASSIGN_TOK;
        break;
      }
      else if (c == '#') {
        do {
          advance();
        } while (peek() != '\n');
        advance();
      } else {
        tokBuf.append(c);
        t = c;
        advance();
        break;
      }
    }
    setText(tokBuf.toString());
    return new Token(t, yytext);
  }

}



