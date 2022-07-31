package zdu.parsdemo;
import java.util.Hashtable;

public class ANSICScanner extends Scanner {

   

      // Reserved word tokens.
  static private final int RESERVED_LO = 256; // Compound token #s > this.
  static private final int N_RESERVED = 2; // # of reserved words.
  static final int DIV_TOK = RESERVED_LO; // 256
  static final int MOD_TOK = DIV_TOK + 1;// 257

  // Other compound tokens.
  static final int ASSGN_TOK = RESERVED_LO + N_RESERVED;// 258
  static final int ID_TOK = ASSGN_TOK + 1;// 259
  static final int NUM_TOK = ID_TOK + 1;// 260
  static final int READ_TOK = 261;
  static final int WRITE_TOK = 262;
  static final int IF_TOK = 263;
  static final int END_TOK = 264;
  static final int WHILE_TOK = 265;
  static final int OD_TOK = 266;
  static final int EQUALS_TOK = 267;
  static final int NEQUALS_TOK = 268;
  static final int LESSER_TOK = 269;
  static final int GREATER_TOK = 270;
  static final int LIT_TOK = 271;
  public static final int IDENTIFIER_TOK = 0;
  public static final int CONSTANT_TOK = 0;
public static final int STRING_LITERAL_TOK = 0;
public static final int SIZEOF_TOK = 0;
public static final int PTR_OP_TOK = 0;
public static final int INC_OP_TOK = 0;
public static final int DEC_OP_TOK = 0;
public static final int LEFT_OP_TOK = 0;
public static final int RIGHT_OP_TOK = 0;
public static final int GE_OP_TOK = 0;
public static final int LE_OP_TOK = 0;
public static final int EQ_OP_TOK = 0;
public static final int NE_OP_TOK = 0;
public static final int AND_OP_TOK = 0;
public static final int OR_OP_TOK = 0;
public static final int MUL_ASSIGN_TOK = 0;
public static final int DIV_ASSIGN_TOK = 0;
public static final int MOD_ASSIGN_TOK = 0;
public static final int ADD_ASSIGN_TOK = 0;
public static final int SUB_ASSIGN_TOK = 0;
public static final int LEFT_ASSIGN_TOK = 0;
public static final int RIGHT_ASSIGN_TOK = 0;
public static final int AND_ASSIGN_TOK = 0;
public static final int XOR_ASSIGN_TOK = 0;
public static final int OR_ASSIGN_TOK = 0;
public static final int TYPEDEF_TOK = 0;
public static final int EXTERN_TOK = 0;
public static final int STATIC_TOK = 0;
public static final int AUTO_TOK = 0;
public static final int REGISTER_TOK = 0;
public static final int VOID_TOK = 0;
public static final int CHAR_TOK = 0;
public static final int SHORT_TOK = 0;
public static final int INT_TOK = 0;
public static final int LONG_TOK = 0;
public static final int FLOAT_TOK = 0;
public static final int DOUBLE_TOK = 0;
public static final int SIGNED_TOK = 0;
public static final int UNSIGNED_TOK = 0;
public static final int TYPE_NAME_TOK = 0;
public static final int STRUCT_TOK = 0;
public static final int UNION_TOK = 0;
public static final int ENUM_TOK = 0;
public static final int CONST_TOK = 0;
public static final int VOLATILE_TOK = 0;
public static final int ELLIPSIS_TOK = 0;
public static final int CASE_TOK = 0;
public static final int DEFAULT_TOK = 0;
public static final int ELSE_TOK = 0;
public static final int SWITCH_TOK = 0;
public static final int DO_TOK = 0;
public static final int FOR_TOK = 0;
public static final int GOTO_TOK = 0;
public static final int BREAK_TOK = 0;
public static final int RETURN_TOK = 0;
public static final int CONTINUE_TOK = 0;

  // Hashtable for storing reserved words and identifiers.
  private Hashtable ids = new Hashtable();

  ANSICScanner() {
    super();
    initIDs();
    initToks();
  }

  private void initToks() {

    addTok(ASSGN_TOK, ":=");
    addTok(ID_TOK, "ID");
    addTok(READ_TOK, "Read");
    addTok(WRITE_TOK, "Write");
    addTok(IF_TOK, "If");

    addTok(WHILE_TOK, "While");
    addTok(END_TOK, "End");

    
    addTok(NEQUALS_TOK, "<>");
    addTok(LESSER_TOK, "<=");
    addTok(GREATER_TOK, ">=");
    addTok(LIT_TOK, "Literal");

  }

  private void initIDs() {
    ids.put("div", new Integer(ids.size()));
    ids.put("mod", new Integer(ids.size()));
  }

  public int getID(String text) {
    Integer val = (Integer) ids.get(text);
    if (val == null) {
      val = new Integer(ids.size());
      ids.put(text, val);
    }
    return val.intValue();
  }

  private int getIDTok(String text) {
    int id = getID(text);
    if (id < N_RESERVED) {
      return id + RESERVED_LO;
    } else {
      return ID_TOK;
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
      for (c = peek(); Character.isSpace(c); advance(), c = peek()) {
      }
      if (Character.isLetter(c)) {
        do {
          tokBuf.append(c);
          advance();
          c = peek();
        } while (Character.isLetterOrDigit(c));

        if (tokBuf.toString().equals("Read")) {

          t = READ_TOK;
          break;

        } else if (tokBuf.toString().equals("Write")) {
          t = WRITE_TOK;
          break;

        } else if (tokBuf.toString().equals("If")) {

          t = IF_TOK;
          break;
        }

        else if (tokBuf.toString().equals("While")) {
          t = WHILE_TOK;
          break;

        } else if (tokBuf.toString().equals("End")) {

          t = END_TOK;
          break;

        } else {

          t = getIDTok(tokBuf.toString());
          break;
        }
      } else if (Character.isDigit(c)) {
        do {
          tokBuf.append(c);
          advance();
          c = peek();
        } while (Character.isDigit(c));
        t = LIT_TOK;
        break;
      } else if (c == ':' && peek(1) == '=') {
        tokBuf.append(":=");
        advance();
        advance();
        t = ASSGN_TOK;
        break;
      }

      else if (c == '<' && peek(1) == '>') {
        tokBuf.append("!=");
        advance();
        advance();
        t = NEQUALS_TOK;
        break;
      } else if (c == '<' && peek(1) == '=') {
        tokBuf.append("<=");
        advance();
        advance();
        t = LESSER_TOK;
        break;
      } else if (c == '>' && peek(1) == '=') {
        tokBuf.append(">=");
        advance();
        advance();
        t = GREATER_TOK;
        break;
      } else if (c == '#') {
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
