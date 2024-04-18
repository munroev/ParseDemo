package zdu.parsdemo;


class ExtendedSRB-MinorGram extends Grammar {
  final NonTerm program = nonTerm("program");
  final NonTerm test_prog =nonTerm("test_program");
  final NonTerm decl = nonTerm("decl");
  final NonTerm ext_decln = nonTerm("ext_decln");
  final NonTerm fun_decln = nonTerm("function_decln");
  final NonTerm decln= nonTerm("decln");

  final NonTerm stmt = nonTerm("stmt");
  final NonTerm print_stmt = nonTerm("print_stmt");
  final NonTerm iter_stmt= nonTerm("iter_stmt");
  final NonTerm jump= nonTerm("jump_stmt");
  final NonTerm cmpnd_stmt = nonTerm("cmpnd_stmt");
  final NonTerm select_stmt = nonTerm("select_stmt");


  final NonTerm print_list = nonTerm("print_list");
  final NonTerm expr_stm = nonTerm("expr_stm");
  final NonTerm expr = nonTerm("expr");

  final NonTerm type= nonTerm("type");
  final NonTerm atomic =nonTerm("atomic_type");
  final NonTerm ret = nonTerm("ret_type");
  final NonTerm array = nonTerm ("array");
  final NonTerm array_list = nonTerm("array_list");

  final NonTerm assign_expr = nonTerm("assign_expr");
  final NonTerm unary_expr = nonTerm("unary_expr");
  final NonTerm postfix_expr = nonTerm("postfix_expr");
  final NonTerm primary_expr = nonTerm("primary_expr");




  final NonTerm prim = nonTerm("primative");
  final NonTerm lval = nonTerm("lvalue");
  final NonTerm suffix = nonTerm("suffix");
  final NonTerm call_suffix = nonTerm("call_suffix");


  final NonTerm subscript= nonTerm("subscript");
  final NonTerm subscript_list=nonTerm("subscript_list");
  final NonTerm decltr = nonTerm("decltr");
  final NonTerm lor_expr = nonTerm("lor_expr");
  

  final Terminal BOOL = terminal("boolean", BMinorScanner.TOKEN_BOOLEAN);
  final Terminal INC = terminal("++", BMinorScanner.TOKEN_INC);
  final Terminal DEC = terminal("--", BMinorScanner.TOKEN_DEC);
  final Terminal SUB = terminal("-", BMinorScanner.TOKEN_SUB);
  final Terminal EXP = terminal("^", BMinorScanner.TOKEN_EXP);
  final Terminal NOT = terminal("!", BMinorScanner.TOKEN_NOT);
  final Terminal MULT = terminal("*", BMinorScanner.TOKEN_MULT);
  final Terminal DIV = terminal("/", BMinorScanner.TOKEN_DIV);
  final Terminal MOD = terminal("%", BMinorScanner.TOKEN_MOD);

  final Terminal LPAR = terminal("(", BMinorScanner.TOKEN_LPAR);
  final Terminal RPAR= terminal(")",BMinorScanner.TOKEN_RPAR);
  final Terminal SEMI= terminal(";", BMinorScanner.TOKEN_SEMI);
  final Terminal COLON = terminal (":", BMinorScanner.TOKEN_COLON);

  final Terminal EOF = terminal("<<EOF>>",BMinorScanner.ToKEN_EOF);




 



  
  
  ExtendedSRB-MinorGram() {

    setStartSym(program);


    

    //prog
    beginRule(program);
    addRHS(ext_decln);
    endRule();

    beginRule(program);
    addRHS(program);
    addRHS(ext_decln);
    endRule();

    beginRule(program);
    addRHS(MOD);
    addRHS(MOD);
    addRHS(test_prog);
    endRule();

    beginRule(program);
    addRHS(EOF);
    endRule();

    //test_prog
    beginRule(test_prog);
    addRHS(stmt);
    addRHS(EOF);

    beginRule(test_prog);
    addRHS(ext_decln);
    endRule();

    //decl 
    beginRule(decl);
    addRHS(decltr);
    addRHS(COLON);
    addRHS(type);
    endRule();

    //decl_ext
    beginRule(ext_decln);
    addRHS(fun_decln);
    endRule();

    beginRule(ext_decln);
    addRHS(decln);
    endRule();

    //stmt
    beginRule(stmt);
    addRHS(print_stmt);
    endRule();

    beginRule(stmt);
    addRHS(expr_stm);
    endRule();

    beginRule(stmt);
    addRHS(iter_stmt);
    endRule();

    beginRule(stmt);
    addRHS(jump_stmt);
    endRule();

    beginRule(stmt);
    addRHS(cmpnd_stmt);
    endRule();

    beginRule(stmt);
    addRHS(select_stmt);
    endRule();

    
    //printStmt
    beginRule(print_stmt);
    addRHS(TOKEN_PRINT);
    addRHS(print_list);
    addRHS(TOKEN_SEMI);
    endRule();

    //print list
    beginRule(print_list);
    addRHS(assign_expr);
    addRHS(TOKEN_COMMA);
    addRHS(print_list);
    endRule();

    beginRule(print_list);
    addRHS(assign_expr);
    endRule();

    //exprStmt
    beginRule(expr_stm)
    addRHS(expr)
    addRHS(TOKEN_SEMI);
    endRule();

    //printList
    beginRule(print_list);
    addRHS(TOKEN_PRINT);
    addRHS(print_list);
    addRHS(TOKEN_SEMI);
    endRule();

    beginRule(print_list);
    addRHS(assign_expr);
    endRule();

    //expr_stmt
    beginRule(expr_stmt);
    addRHS(expr);
    addRHS(TOKEN_SEMI);
    endRule();

    //expr
    beginRule(expr);
    addRHS(assign_expr);
    endRule();

    beginRule(expr);
    addRHS(expr);
    addRHS(TOKEN_COMMA);
    addRHS(assign_expr);
    endRule();

    //assign_expr
    beginRule(assign_expr);
    addRHS(lor_expr);
    endRule();

    beginRule(assign_expr);
    addRHS(unary_expr);
    addRHS(TOKEN_ASSIGN);
    addRHS(assign_expr);
    endRule();

    //unary_expr
    beginRule(unary_expr);
    addRHS(postfix_expr);
    endRule();

    beginRule(unary_expr);
    addRHS(TOKEN_ADD);
    addRHS(unary_expr);
    endRule();

    beginRule(unary_expr);
    addRHS(TOKEN_NOT);
    addRHS(unary_expr);
    endRule();
    
    beginRule(unary_expr);
    addRHS(TOKEN_SUB);
    addRHS(unary_expr);
    endRule();
    

    //postfix_expr
    beginRule(postfix_expr);
    addRHS(primary_expr);
    endRule();

    beginRule(postfix_expr);
    addRHS(postfix_expr);
    addRHS(TOKEN_LPAR);
    addRHS(expr);
    addRHS(TOKEN_RPAR);
    endRule();

    beginRule(postfix_expr);
    addRHS(postfix_expr);
    addRHS(TOKEN_INC);
    endRule();

    beginRule(postfix_expr);
    addRHS(postfix_expr);
    addRHS(TOKEN_DEC);
    endRule();

    //primary exp
    beginRule(primary_expr);
    addRHS(primative);
    endRule();
    
    beginRule(primary_expr);
    addRHS(TOKEN_LPAR);
    addRHS(expr);
    addRHS(TOKEN_RPAR);
    endRule();

    beginRule(primary_expr);
    addRHS(lval);
    endRule();

    //primative
    beginRule(primative);
    addRHS(TOKEN_BOOL);
    endRule();

    beginRule(primative);
    addRHS(TOKEN_CH);
    endRule();

    beginRule(primative);
    addRHS(TOKEN_NUMBER);
    endRule();

    beginRule(primative);
    addRHS(TOKEN_STR);
    endRule();

    //lvalue
    beginRule(lval);
    addRHS(decltr);
    addRHS(suffix);
    endRule();

    //suffix
    beginRule(suffix);
    addRHS(call_suffix);
    endRule();

    beginRule(suffix);
    addRHS(subscript_list);
    endRule();

    //fixme question?
    beginRule(suffix);
    addRHS( %empty);
    endRule();

    //call-suffix
    beginRule(call_suffix);
    addRHS(TOKEN_LPAR);
    addRHS(expr);
    addRHS(TOKEN_RPAR);

    beginRule(call_suffix);
    addRHS(TOKEN_LPAR);
    addRHS(TOKEN_RPAR);

    //subscript
    beginRule(subscript_list);
    addRHS(subscript_list);
    addRHS(subscript);
    endRule();

    beginRule(subscript_list);
    addRHS(subscript);
    endRule();





    ///beginRule(term)
    //addRHS(term)
    //addRHS(mult_op)
    //addRHS (factor)
    //endRule();

    //beginRule(factor)
    //addRHS(lparen)
    //addRHS(expr)
    //addRHS(rparen)
    //endRule();

    //beginRule(stmt)
    //addRHS(print_stmt)
    //endRule()

    //beginRule(stmt)
    //addRHS(expr_stm  t)
    //endRule
  }


}