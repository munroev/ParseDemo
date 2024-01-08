/*



*/

package zdu.parsdemo;


class ExtendedSRGram extends Grammar {

  ExtendedSRGram() {

    setStartSym(program);

    // Program
    beginRule(program);
    addRHS(stmtlist);
    addRHS(EOF);
    endRule();

    // Statementlist

    beginRule(stmtlist);
    addRHS(stmtlist);
    addRHS(stmt);
    endRule();

    beginRule(stmtlist);
    addRHS(stmt);
    endRule();

    // Statement
    beginRule(stmt);
    addRHS(ID);
    addRHS(ASSGN);
    addRHS(equivalence);
    endRule();

    beginRule(stmt);
    addRHS(READ);
    addRHS(ID);
    endRule();

    beginRule(stmt);
    addRHS(WRITE);
    addRHS(equivalence);
    endRule();

    // Equivalence

    beginRule(equivalence);
    addRHS(tail);
    endRule();

    beginRule(equivalence);
    addRHS(equivalence);
    addRHS(additionop);
    addRHS(tail);
    endRule();

    // Tail

    beginRule(tail);
    addRHS(factor);
    endRule();

    beginRule(tail);
    addRHS(tail);
    addRHS(multop);
    addRHS(factor);
    endRule();

    // Factor

    beginRule(factor);
    addRHS(LPAREN);
    addRHS(equivalence);
    addRHS(RPAREN);
    endRule();

    beginRule(factor);
    addRHS(ID);
    endRule();

    beginRule(factor);
    addRHS(LITERAL);
    endRule();

    // additionop

    beginRule(additionop);
    addRHS(ADD);
    endRule();

    beginRule(additionop);
    addRHS(SUB);
    endRule();

    // multop

    beginRule(multop);
    addRHS(MULT);
    endRule();

    beginRule(multop);
    addRHS(DIVIDE);
    endRule();

  }

  final NonTerm program = nonTerm("program");
  final NonTerm stmtlist = nonTerm("stmtlist");
  final NonTerm stmt = nonTerm("stmt");
  final NonTerm cond = nonTerm("cond");
  final NonTerm equivalence = nonTerm("expr");

  final NonTerm tail = nonTerm("term");
  final NonTerm factor = nonTerm("factor");

  final NonTerm equivalencetail = nonTerm("exprtail");
  final NonTerm truthtail = nonTerm("termtail");

  final NonTerm factortail = nonTerm("factortail");
  final NonTerm relationop = nonTerm("relop");
  final NonTerm additionop = nonTerm("addop");
  final NonTerm multop = nonTerm("multop");

  final Terminal ID = terminal("ID", ExtendedScanner.ID_TOK);

  final Terminal SEMI = terminal("';'");
  final Terminal ASSGN = terminal("':='", ExtendedScanner.ASSGN_TOK);
  final Terminal ADD = terminal("'+'");
  final Terminal SUB = terminal("'-'");
  final Terminal MULT = terminal("'*'");
  final Terminal DIVIDE = terminal("'/'");
  final Terminal LPAREN = terminal("'('");
  final Terminal RPAREN = terminal("')'");

  final Terminal READ = terminal("Read", ExtendedScanner.READ_TOK);
  final Terminal WRITE = terminal("Write", ExtendedScanner.WRITE_TOK);
  final Terminal IF = terminal("If", ExtendedScanner.IF_TOK);
  final Terminal WHILE = terminal("While", ExtendedScanner.WHILE_TOK);
  final Terminal END = terminal("End", ExtendedScanner.END_TOK);

  final Terminal EQUALS = terminal("==", ExtendedScanner.EQUALS_TOK);
  final Terminal NEQUALS = terminal("!=", ExtendedScanner.NEQUALS_TOK);
  final Terminal LESSER = terminal("'<'");
  final Terminal GREATER = terminal("'>'");
  final Terminal LESSEQ = terminal("<=", ExtendedScanner.LESSER_TOK);
  final Terminal GREATEREQ = terminal(">=", ExtendedScanner.GREATER_TOK);
  final Terminal LITERAL = terminal("Literal", ExtendedScanner.LIT_TOK);

}