package zdu.parsdemo;


class ExtendedSRB-MinorGram extends Grammar {
  final NonTerm program = nonTerm("program");
  final NonTerm test_prog =nonTerm("test_program");
  final NonTerm decl = nonTerm("decl");
  final NonTerm ext_decln = nonTerm("ext_decln");
  final NonTerm fun_decln = nonTerm("function_decln");
  final NonTerm fun_decl = nonTerm("function_decl");
  final NonTerm decln= nonTerm("decln");
  final NonTerm int_decln = nonTerm("int_decln");

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
  final NonTerm decl_list = nonTerm("decl_list");

  final NonTerm for = nonTerm("for");
  final NonTerm block_list = nonTerm("block_list");
  final NonTerm block = nonTerm("block");
  final NonTerm initialization = nonTerm("initialization");
  final NonTerm init = nonTerm("init");



  final NonTerm prim = nonTerm("primative");
  final NonTerm lval = nonTerm("lvalue");
  final NonTerm suffix = nonTerm("suffix");
  final NonTerm call_suffix = nonTerm("call_suffix");


  final NonTerm subscript= nonTerm("subscript");
  final NonTerm subscript_list=nonTerm("subscript_list");
  final NonTerm decltr = nonTerm("decltr");
  final NonTerm lor_expr = nonTerm("lor_expr");
  final NonTerm param_list = nonTerm("param_list");
  final NonTerm init_list = nonTerm("init_list");



  final NonTerm eq_expr = nonTerm("eq_expr");
  final NonTerm rel_expr = NonTerm("rel_expr");
  final NonTerm add_expr = NonTerm("add_expr");
  final NonTerm mult_expr = NonTerm("mult_expr");
  final NonTerm exp_expr = NonTerm("exp_expr");
  final NonTerm unary_expr = NonTerm("unary_expr");
  

  
  

  final Terminal FUNCTION = terminal("=", BMinorScanner.TOKEN_ASSIGN);
  final Terminal BOOL = terminal("boolean", BMinorScanner.TOKEN_BOOLEAN);
  final Terminal CHAR = terminal("char", BMinorScanner.TOKEN_CHAR);
  final Terminal INT = terminal("integer", BMinorScanner.TOKEN_INTEGER);
  final Terminal STRING = terminal("string", BMinorScanner.TOKEN_STRING);
  final Terminal ARRAY = terminal("array", BMinorScanner.TOKEN_ARRAY);
  final Terminal CHAR = terminal("string", BMinorScanner.TOKEN_PRINT);
  final Terminal NUM = terminal ("number")//fixme question?

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
    addRHS(PRINT);
    addRHS(print_list);
    addRHS(SEMI);
    endRule();

    //print list
    beginRule(print_list);
    addRHS(assign_expr);
    addRHS(COMMA);
    addRHS(print_list);
    endRule();

    beginRule(print_list);
    addRHS(assign_expr);
    endRule();

    //exprStmt
    beginRule(expr_stm)
    addRHS(expr)
    addRHS(SEMI);
    endRule();

    //printList
    beginRule(print_list);
    addRHS(PRINT);
    addRHS(print_list);
    addRHS(SEMI);
    endRule();

    beginRule(print_list);
    addRHS(assign_expr);
    endRule();

    //expr_stmt
    beginRule(expr_stmt);
    addRHS(expr);
    addRHS(SEMI);
    endRule();

    //expr
    beginRule(expr);
    addRHS(assign_expr);
    endRule();

    beginRule(expr);
    addRHS(expr);
    addRHS(COMMA);
    addRHS(assign_expr);
    endRule();

    //assign_expr
    beginRule(assign_expr);
    addRHS(lor_expr);
    endRule();

    beginRule(assign_expr);
    addRHS(unary_expr);
    addRHS(ASSGN);
    addRHS(assign_expr);
    endRule();

    //unary_expr
    beginRule(unary_expr);
    addRHS(postfix_expr);
    endRule();

    beginRule(unary_expr);
    addRHS(ADD);
    addRHS(unary_expr);
    endRule();

    beginRule(unary_expr);
    addRHS(TOKEN_NOT);
    addRHS(unary_expr);
    endRule();
    
    beginRule(unary_expr);
    addRHS(SUB);
    addRHS(unary_expr);
    endRule();
    

    //postfix_expr
    beginRule(postfix_expr);
    addRHS(primary_expr);
    endRule();

    beginRule(postfix_expr);
    addRHS(postfix_expr);
    addRHS(LPAR);
    addRHS(expr);
    addRHS(RPAR);
    endRule();

    beginRule(postfix_expr);
    addRHS(postfix_expr);
    addRHS(INC);
    endRule();

    beginRule(postfix_expr);
    addRHS(postfix_expr);
    addRHS(DEC);
    endRule();

    //primary exp
    beginRule(primary_expr);
    addRHS(primative);
    endRule();
    
    beginRule(primary_expr);
    addRHS(LPAR);
    addRHS(expr);
    addRHS(RPAR);
    endRule();

    beginRule(primary_expr);
    addRHS(lval);
    endRule();

    //primative
    beginRule(primative);
    addRHS(BOOL);
    endRule();

    beginRule(primative);
    addRHS(TOKEN_CH);
    endRule();

    beginRule(primative);
    addRHS(NUM); 
    endRule();

    beginRule(primative);
    addRHS(STRING);
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
    addRHS(LPAR);
    addRHS(expr);
    addRHS(RPAR);

    beginRule(call_suffix);
    addRHS(LPAR);
    addRHS(RPAR);

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
    addRHS(LPAR);
    addRHS(decltr);
    addRHS(RPAR);
    endRule();

    //land_expr
    beginRule(land_expr);
    addRHS(eq_expr);
    endRule();

    beginRule(land_expr);
    addRHS(land_expr);
    addRHS(AND);
    addRHS(eq_expr);
    endRule();

    //eq_expr
    beginRule(eq_expr);
    addRHS(eq_expr);
    addRHS(EQ);
    addRHS(rel_expr);
    endRule();

    beginRule(eq_expr);
    addRHS(eq_expr);
    addRHS(NEQ);
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
    addRHS(LESS);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(GREATER);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(LEQ);
    addRHS(add_expr);
    endRule();

    beginRule(rel_eqr);
    addRHS(rel_eqr);
    addRHS(GEQ);
    addRHS(add_expr);
    endRule();

    //add_expr
    beginRule(add_expr);
    addRHS(add_expr);
    addRHS(GREATER);
    addRHS(mult_expr);
    endRule();

    beginRule(add_expr);
    addRHS(add_expr);
    addRHS(SUB);
    addRHS(mult_expr);
    endRule();

    beginRule(add_expr);
    addRHS(mult_expr);
    endRule();

    //mult_ex

    beginRule(mult_expr);
    addRHS(mult_expr);
    addRHS(MULT);
    addRHS(exp_expr);
    endRule();

    beginRule(mult_expr);
    addRHS(mult_expr);
    addRHS(DIV);
    addRHS(exp_expr);
    endRule();

    beginRule(mult_expr);
    addRHS(mult_expr);
    addRHS(MOD);
    addRHS(exp_expr);
    endRule();

    beginRule(mult_expr);
    addRHS(exp_expr);
    endRule();

    //exp_expr
    beginRule(exp_expr);
    addRHS(exp_expr);
    addRHS(EXP);
    addRHS(unary_expr);
    endRule();

    beginRule(exp_expr);
    addRHS(unary_expr);
    endRule();

    //select_stmt
    beginRule(select_stmt);
    addRHS(IF);
    addRHS(LPAR);
    addRHS(expr);
    addRHS(RPAR);
    addRHS(stmt);
    endRule();

    beginRule(select_stmt);
    addRHS(IF);
    addRHS(LPAR);
    addRHS(expr);
    addRHS(RPAR);
    addRHS(stmt);
    addRHS(ELSE);
    addRHS(stmt);
    endRule();

    //iter_stmt

    beginRule(iter_stmt);
    addRHS(WHILE);
    addRHS(LPAR);
    addRHS(expr);
    addRHS(RPAR);
    addRHS(stmt);
    endRule();

    beginRule(iter_stmt);
    addRHS(FOR);
    addRHS(LPAR);
    addRHS(for);
    addRHS(RPAR);
    addRHS(stmt);
    endRule();
  
    //for
    beginRule(for);
    addRHS(SEMI);
    addRHS(SEMI);
    addRHS(expr);
    endRule();

    beginRule(for);
    addRHS(SEMI);
    addRHS(SEMI);
    endRule();

    beginRule(for);
    addRHS(SEMI);
    addRHS(expr_stmt);
    endRule();

    beginRule(for);
    addRHS(SEMI);
    addRHS(expr_stmt);
    addRHS(expr);
    endRule();

    beginRule(for);
    addRHS(expr_stmt);
    addRHS(SEMI);
    addRHS(expr);
    endRule();
    
    beginRule(for);
    addRHS(expr_stmt);
    addRHS(SEMI);
    endRule();

    beginRule(for);
    addRHS(decln);
    addRHS(SEMI);
    addRHS(expr);
    endRule();
    
    beginRule(for);
    addRHS(decln);
    addRHS(SEMI);
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
    addRHS(RETURN);
    addRHS(expr);
    addRHS(SEMI);
    endRule();

    beginRule(jump_stmt);
    addRHS(RETURN);
    addRHS(SEMI);
    endRule();

    //cmpd_stm
    beginRule(cmpnd_stmt);
    addRHS(LCURL);
    addRHS(block_list);
    addRHS(RCURL);
    endRule();


    beginRule(cmpnd_stmt);
    addRHS(LCURL);
    addRHS(RCURL);
    endRule();

    //blckList
    beginRule(block_list);
    addRHS(block_list);
    addRHS(block);
    endRule();


    beginRule(block_list);
    addRHS(block);
    endRule();

    //block
    beginRule(block);
    addRHS(int_decln);
    endRule();

    beginRule(block);
    addRHS(stmt);
    endRule();

    //intialize
    beginRule(initialization);
    addRHS(ASSGN);
    addRHS(init);
    addRHS(ASSGN);
    endRule();

    //decln
    beginRule(decln);
    addRHS(decl);
    addRHS(SEMI);
    endRule();

    beginRule(decln);
    addRHS(decl);
    addRHS(initialization);
    endRule();

    //fun_decl
    beginRule(fun_decl);
    addRHS(decltr);
    addRHS(COLON);
    addRHS(FUNCTION);
    addRHS(ret_type);
    endRule();

    //fun_suffix
    beginRule(fun_suffix);
    addRHS(ASSGN);
    addRHS(cmpnd_stmt);
    endRule();

    beginRule(fun_suffix);
    addRHS(TOKEN_SEMI);
    endRule();

    //fun_decl
    beginRule(fun_decl);
    addRHS(LPAR);
    addRHS(VOID);
    addRHS(RPAR);
    addRHS(fun_suffix);
    endRule();

    beginRule(fun_decl);
    addRHS(LPAR);
    addRHS(RPAR);
    addRHS(fun_suffix);
    endRule();

    beginRule(fun_decl);
    addRHS(LPAR);
    addRHS(param_list);
    addRHS(RPAR);
    addRHS(fun_suffix);
    endRule();

    //param_list
    beginRule(param_list);
    addRHS(decl_list);
    endRule();

    //decl_list
    beginRule(decl_list);
    addRHS(decl);
    addRHS(COMMA);
    addRHS(decl_list);
    endRule();

    beginRule(decl_list);
    addRHS(decl);
    endRule();

    //init
    beginRule(init);
    addRHS(LCURL);
    addRHS(init_list);
    addRHS(RCURL);
    endRule();

    beginRule(init);
    addRHS(assign_expr);
    endRule();


  //init_list
  beginRule(init_list);
  addRHS(init);
  addRHS(COMMA);
  addRHS(init);
  endRule();

  beginRule(init_list);
  addRHS(init);
  endRule();

  //type
  beginRule(type);
  addRHS(array_list)
  addRHS(atomic_type);
  endRule();

  beginRule(type);
  addRHS(atomic_type);
  endRule();
  
  beginRule(type);
  addRHS(AUTO);
  endRule();

  beginRule(ret_type);
  addRHS(array_list);
  addRHS(atomic_type);
  endRule();

  beginRule(ret_type);
  addRHS(atomic_type);
  endRule();

  beginRule(ret_type);
  addRHS(VOID);
  endRule();

  //arryList
  beginRule(array_list);
  addRHS(array_list);
  addRHS(array);
  endRule();

  beginRule(array_list);
  addRHS(array);
  endRule();

  //array
  beginRule(array);
  addRHS(ARRAY);
  addRHS(TOKEN_LBRACK);
  addRHS(assign_expr);
  addRHS(TOKEN_RBRACK);
  endRule();

  beginRule(array);
  addRHS(ARRAY);
  addRHS(TOKEN_LBRACK);
  addRHS(TOKEN_RBRACK);
  endRule();


  }


}