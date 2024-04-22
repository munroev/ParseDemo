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

  final NonTerm for = nonTerm("for");
  final NonTerm block_list = nonTerm("block_list");
  final NonTerm block = nonTerm("block");
  final NonTerm initialization = nonTerm("initialization");



  final NonTerm prim = nonTerm("primative");
  final NonTerm lval = nonTerm("lvalue");
  final NonTerm suffix = nonTerm("suffix");
  final NonTerm call_suffix = nonTerm("call_suffix");


  final NonTerm subscript= nonTerm("subscript");
  final NonTerm subscript_list=nonTerm("subscript_list");
  final NonTerm decltr = nonTerm("decltr");
  final NonTerm lor_expr = nonTerm("lor_expr");



  final NonTerm eq_expr = nonTerm("eq_expr");
  final NonTerm rel_expr = NonTerm("rel_expr");
  final NonTerm add_expr = NonTerm("add_expr");
  final NonTerm mult_expr = NonTerm("mult_expr");
  final NonTerm exp_expr = NonTerm("exp_expr");
  final NonTerm unary_expr = NonTerm("unary_expr");
  

  
  

  final Terminal FUNCTION = terminal("=", BMinorScanner.TOKEN_ASSIGN);
  final Terminal BOOL = terminal("boolean", BMinorScanner.TOKEN_BOOLEAN);
  final Terminal CHAR = terminal("char", BMinorScanner.TOKEN_CHAR);
  final Terminal CHAR = terminal("integer", BMinorScanner.TOKEN_INTEGER);
  final Terminal CHAR = terminal("string", BMinorScanner.TOKEN_STRING);

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
  final Terminal LCURL = terminal ("{", BMinorScanner.TOKEN_LCURL);
  final Terminal RCURL=  terminal ("}", BMinorScanner.TOKEN_RCURL);

  final Terminal FUNCTION = terminal("function", BMinorScanner.TOKEN_FUNCTION);
  final Terminal AUTO = terminal("auto", BMinorScanner.TOKEN_AUTO);
  final Terminal VOID = terminal("void", BMinorScanner.TOKEN_VOID);


  final Terminal IF = terminal("if", BMinorScanner.TOKEN_IF);
  final Terminal ELSE = terminal("else", BMinorScanner.TOKEN_ELSE);

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

    //decltr
    beginRule(decltr);
    addRHS(TOKEN_IDENT);
    endRule();

    beginRule(decltr);
    addRHS(TOKEN_LPAR);
    addRHS(decltr);
    addRHS(TOKEN_RPAR);
    endRule();

    //land_expr
    beginRule(land_expr);
    addRHS(eq_expr);
    endRule();

    beginRule(land_expr);
    addRHS(land_expr);
    addRHS(TOKEN_AND);
    addRHS(eq_expr);
    endRule();

    //eq_expr
    beginRule(eq_expr);
    addRHS(eq_expr);
    addRHS(TOKEN_EQ);
    addRHS(rel_expr);
    endRule();

    beginRule(eq_expr);
    addRHS(eq_expr);
    addRHS(TOKEN_NEQ);
    addRHS(rel_expr);
    endRule();

    beginRule(eq_expr);
    addRHS(rel_expr);
    endRule();


    //rel_eqr
    beginRule(rel_eqr);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(TOKEN_LESS);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(TOKEN_GREAT);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(TOKEN_LEQ);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(TOKEN_GEQ);
    addRHS(add_expr);
    endRule();

    //add_expr
    beginRule(add_expr);
    addRHS(add_expr);
    addRHS(TOKEN_GREAT);
    addRHS(mult_expr);
    endRule();

    beginRule(add_expr);
    addRHS(add_expr);
    addRHS(TOKEN_SUB);
    addRHS(mult_expr);
    endRule();

    beginRule(add_expr);
    addRHS(mult_expr);
    endRule();

    //mult_ex

    beginRule(mult_expr);
    addRHS(mult_expr);
    addRHS(TOKEN_MULT);
    addRHS(exp_expr);
    endRule();

    beginRule(mult_expr);
    addRHS(mult_expr);
    addRHS(TOKEN_DIV);
    addRHS(exp_expr);
    endRule();

    beginRule(mult_expr);
    addRHS(mult_expr);
    addRHS(TOKEN_MOD);
    addRHS(exp_expr);
    endRule();

    beginRule(mult_expr);
    addRHS(exp_expr);
    endRule();

    //exp_expr
    beginRule(exp_expr);
    addRHS(exp_expr);
    addRHS(TOKEN_EXP);
    addRHS(unary_expr);
    endRule();

    beginRule(exp_expr);
    addRHS(unary_expr);
    endRule();

    //select_stmt
    beginRule(select_stmt);
    addRHS(TOKEN_IF);
    addRHS(TOKEN_LPAR);
    addRHS(expr);
    addRHS(TOKEN_RPAR);
    addRHS(stmt);
    endRule();

    beginRule(select_stmt);
    addRHS(TOKEN_IF);
    addRHS(TOKEN_LPAR);
    addRHS(expr);
    addRHS(TOKEN_RPAR);
    addRHS(stmt);
    addRHS(TOKEN_ELSE);
    addRHS(stmt);
    endRule();

    //iter_stmt

    beginRule(iter_stmt);
    addRHS(TOKEN_WHILE);
    addRHS(TOKEN_LPAR);
    addRHS(expr);
    addRHS(TOKEN_RPAR);
    addRHS(stmt);
    endRule();

    beginRule(iter_stmt);
    addRHS(TOKEN_FOR);
    addRHS(TOKEN_LPAR);
    addRHS(for);
    addRHS(TOKEN_RPAR);
    addRHS(stmt);
    endRule();
  
    //for
    beginRule(for);
    addRHS(TOKEN_SEMI);
    addRHS(TOKEN_SEMI);
    addRHS(expr);
    endRule();

    beginRule(for);
    addRHS(TOKEN_SEMI);
    addRHS(TOKEN_SEMI);
    endRule();

    beginRule(for);
    addRHS(TOKEN_SEMI);
    addRHS(expr_stmt);
    endRule();

    beginRule(for);
    addRHS(TOKEN_SEMI);
    addRHS(expr_stmt);
    addRHS(expr);
    endRule();

    beginRule(for);
    addRHS(expr_stmt);
    addRHS(TOKEN_SEMI);
    addRHS(expr);
    endRule();
    
    beginRule(for);
    addRHS(expr_stmt);
    addRHS(TOKEN_SEMI);
    endRule();

    beginRule(for);
    addRHS(decln);
    addRHS(TOKEN_SEMI);
    addRHS(expr);
    endRule();
    
    beginRule(for);
    addRHS(decln);
    addRHS(TOKEN_SEMI);
    endRule();

    beginRule(for);
    addRHS(decln);
    addRHS(expr_stmt);
    addRHS(expr);
    endRule();
    
    beginRule(for);
    addRHS(decln);
    addRHS(expr_stmt);
    endRule();

    //jump
    beginRule(jump_stmt);
    addRHS(TOKEN_RETURN);
    addRHS(expr);
    addRHS(TOKEN_SEMI);
    endRule();

    beginRule(jump_stmt);
    addRHS(TOKEN_RETURN);
    addRHS(TOKEN_SEMI);
    endRule();
  }


}