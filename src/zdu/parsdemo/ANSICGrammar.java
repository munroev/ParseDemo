
package zdu.parsdemo;

import zdu.parsdemo.Grammar;
import zdu.parsdemo.NonTerm;
import zdu.parsdemo.Terminal;

public class ANSICGrammar extends Grammar {

    ANSICGrammar() {

        setStartSym(translation_unit);

        // primary_expression
        beginRule(primary_expression);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(primary_expression);
        addRHS(CONSTANT);
        endRule();

        beginRule(primary_expression);
        addRHS(STRING_LITERAL);
        endRule();

        beginRule(primary_expression);
        addRHS(LPAREN);
        addRHS(expression);
        addRHS(RPAREN);
        endRule();

        // postfix_expression

        beginRule(postfix_expression);
        addRHS(primary_expression);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(LBRACK);
        addRHS(expression);
        addRHS(RBRACK);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(LPAREN);
        addRHS(RPAREN);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(LPAREN);
        addRHS(argument_expression_list);
        addRHS(RPAREN);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(PERIOD);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(PERIOD);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(PTR_OP);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(INC_OP);
        endRule();

        beginRule(postfix_expression);
        addRHS(postfix_expression);
        addRHS(DEC_OP);
        endRule();

        // argument_expression_list

        beginRule(argument_expression_list);
        addRHS(assignment_expression);
        endRule();

        beginRule(argument_expression_list);
        addRHS(COMMA);
        addRHS(assignment_expression);
        endRule();

        // unary_expression

        beginRule(unary_expression);
        addRHS(postfix_expression);
        endRule();

        beginRule(unary_expression);
        addRHS(INC_OP);
        addRHS(unary_expression);
        endRule();

        beginRule(unary_expression);
        addRHS(DEC_OP);
        addRHS(unary_expression);
        endRule();

        beginRule(unary_expression);
        addRHS(unary_operator);
        addRHS(cast_expression);
        endRule();

        beginRule(unary_expression);
        addRHS(SIZEOF);
        addRHS(unary_expression);
        endRule();

        beginRule(unary_expression);
        addRHS(SIZEOF);
        addRHS(LPAREN);
        addRHS(type_name);
        addRHS(RPAREN);
        endRule();

        // unary_operator

        beginRule(unary_operator);
        addRHS(AMP);
        endRule();

        beginRule(unary_operator);
        addRHS(AST);
        endRule();

        beginRule(unary_operator);
        addRHS(PLUS);
        endRule();

        beginRule(unary_operator);
        addRHS(MINUS);
        endRule();

        beginRule(unary_operator);
        addRHS(TILDE);
        endRule();

        beginRule(unary_operator);
        addRHS(EXCLAMATION);
        endRule();

        // cast_expression

        beginRule(cast_expression);
        addRHS(LPAREN);
        addRHS(type_name);
        addRHS(RPAREN);
        addRHS(cast_expression);
        endRule();

        // multiplicative_expression

        beginRule(multiplicative_expression);
        addRHS(multiplicative_expression);
        addRHS(AST);
        addRHS(cast_expression);
        endRule();

        beginRule(multiplicative_expression);
        addRHS(multiplicative_expression);
        addRHS(AST);
        addRHS(cast_expression);
        endRule();

        beginRule(multiplicative_expression);
        addRHS(multiplicative_expression);
        addRHS(BACKSLASH);
        addRHS(cast_expression);
        endRule();

        beginRule(multiplicative_expression);
        addRHS(multiplicative_expression);
        addRHS(PERCENT);
        addRHS(cast_expression);
        endRule();

        // additive_expression

        beginRule(additive_expression);
        addRHS(additive_expression);
        addRHS(PLUS);
        addRHS(multiplicative_expression);
        endRule();

        beginRule(additive_expression);
        addRHS(additive_expression);
        addRHS(MINUS);
        addRHS(multiplicative_expression);
        endRule();

        // shift_expression

        beginRule(shift_expression);
        addRHS(additive_expression);
        endRule();

        beginRule(shift_expression);
        addRHS(shift_expression);
        addRHS(LEFT_OP);
        addRHS(additive_expression);
        endRule();

        beginRule(shift_expression);
        addRHS(shift_expression);
        addRHS(RIGHT_OP);
        addRHS(additive_expression);
        endRule();

        // relational_expression

        beginRule(relational_expression);
        addRHS(shift_expression);
        endRule();

        beginRule(relational_expression);
        addRHS(relational_expression);
        addRHS(LESSER);
        addRHS(shift_expression);
        endRule();

        beginRule(relational_expression);
        addRHS(relational_expression);
        addRHS(GREATER);
        addRHS(shift_expression);
        endRule();

        beginRule(relational_expression);
        addRHS(relational_expression);
        addRHS(LE_OP);
        addRHS(shift_expression);
        endRule();

        beginRule(relational_expression);
        addRHS(relational_expression);
        addRHS(GE_OP);
        addRHS(shift_expression);
        endRule();

        // equality_expression

        beginRule(equality_expression);
        addRHS(relational_expression);
        endRule();

        beginRule(equality_expression);
        addRHS(equality_expression);
        addRHS(EQ_OP);
        addRHS(relational_expression);
        endRule();

        beginRule(equality_expression);
        addRHS(equality_expression);
        addRHS(NE_OP);
        addRHS(relational_expression);
        endRule();

        // and_expression

        beginRule(and_expression);
        addRHS(equality_expression);
        endRule();

        beginRule(and_expression);
        addRHS(and_expression);
        addRHS(AMP);
        addRHS(equality_expression);
        endRule();

        // exclusive_or_expression

        beginRule(exclusive_or_expression);
        addRHS(and_expression);
        endRule();

        beginRule(exclusive_or_expression);
        addRHS(exclusive_or_expression);
        endRule();

        beginRule(exclusive_or_expression);
        addRHS(exclusive_or_expression);
        addRHS(CARAT);
        addRHS(and_expression);
        endRule();

        // inclusive_or_expression

        beginRule(inclusive_or_expression);
        addRHS(exclusive_or_expression);
        endRule();

        beginRule(inclusive_or_expression);
        addRHS(inclusive_or_expression);
        addRHS(LINE);
        addRHS(exclusive_or_expression);
        endRule();

        // logical_and_expression

        beginRule(logical_and_expression);
        addRHS(inclusive_or_expression);
        endRule();

        beginRule(logical_and_expression);
        addRHS(logical_and_expression);
        addRHS(AND_OP);
        addRHS(inclusive_or_expression);
        endRule();

        // logical_or_expression

        beginRule(logical_or_expression);
        addRHS(logical_and_expression);
        endRule();

        beginRule(logical_or_expression);
        addRHS(logical_or_expression);
        addRHS(logical_and_expression);
        addRHS(OR_OP);
        endRule();

        // conditional_expression

        beginRule(conditional_expression);
        addRHS(logical_or_expression);
        endRule();

        beginRule(conditional_expression);
        addRHS(logical_or_expression);
        addRHS(QM);
        addRHS(expression);
        addRHS(COLON);
        addRHS(conditional_expression);
        endRule();

        // assignment_expression

        beginRule(assignment_expression);
        addRHS(conditional_expression);
        endRule();

        beginRule(assignment_expression);
        addRHS(unary_expression);
        addRHS(assignment_operator);
        addRHS(assignment_expression);
        endRule();

        // assignment_operator

        beginRule(assignment_operator);
        addRHS(EQUALS);
        endRule();

        beginRule(assignment_operator);
        addRHS(MUL_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(DIV_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(MOD_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(ADD_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(SUB_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(LEFT_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(RIGHT_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(AND_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(XOR_ASSIGN);
        endRule();

        beginRule(assignment_operator);
        addRHS(OR_ASSIGN);
        endRule();

        // expression

        beginRule(expression);
        addRHS(assignment_expression);
        endRule();

        beginRule(expression);
        addRHS(expression);
        addRHS(COMMA);
        addRHS(assignment_expression);
        endRule();

        // constant_expression

        beginRule(constant_expression);
        addRHS(conditional_expression);
        endRule();

        // declaration

        beginRule(declaration);
        addRHS(declaration_specifiers);
        addRHS(SEMICOLON);
        endRule();

        beginRule(declaration);
        addRHS(declaration_specifiers);
        addRHS(init_declarator_list);
        addRHS(SEMICOLON);
        endRule();

        // declaration_specifiers

        beginRule(declaration_specifiers);
        addRHS(storage_class_specifier);
        endRule();

        beginRule(declaration_specifiers);
        addRHS(storage_class_specifier);
        addRHS(declaration_specifiers);
        endRule();

        beginRule(declaration_specifiers);
        addRHS(type_specifier);
        endRule();

        beginRule(declaration_specifiers);
        addRHS(type_specifier);
        addRHS(declaration_specifiers);
        endRule();

        beginRule(declaration_specifiers);
        addRHS(type_qualifier);
        endRule();

        beginRule(declaration_specifiers);
        addRHS(type_qualifier);
        addRHS(declaration_specifiers);
        endRule();

        // init_declarator_list

        beginRule(init_declarator_list);
        addRHS(init_declarator);
        endRule();

        beginRule(init_declarator_list);
        addRHS(init_declarator_list);
        addRHS(COMMA);
        addRHS(init_declarator);
        endRule();

        // init_declarator

        beginRule(init_declarator_list);
        addRHS(declarator);
        endRule();

        beginRule(init_declarator_list);
        addRHS(declarator);
        addRHS(EQUALS);
        addRHS(initializer);
        endRule();

        // storage_class_specifier

        beginRule(storage_class_specifier);
        addRHS(TYPEDEF);
        endRule();

        beginRule(storage_class_specifier);
        addRHS(EXTERN);
        endRule();

        beginRule(storage_class_specifier);
        addRHS(STATIC);
        endRule();

        beginRule(storage_class_specifier);
        addRHS(AUTO);
        endRule();

        beginRule(storage_class_specifier);
        addRHS(REGISTER);
        endRule();

        // type_specifier

        beginRule(type_specifier);
        addRHS(VOID);
        endRule();

        beginRule(type_specifier);
        addRHS(CHAR);
        endRule();

        beginRule(type_specifier);
        addRHS(SHORT);
        endRule();

        beginRule(type_specifier);
        addRHS(INT);
        endRule();

        beginRule(type_specifier);
        addRHS(LONG);
        endRule();

        beginRule(type_specifier);
        addRHS(FLOAT);
        endRule();

        beginRule(type_specifier);
        addRHS(DOUBLE);
        endRule();

        beginRule(type_specifier);
        addRHS(SIGNED);
        endRule();

        beginRule(type_specifier);
        addRHS(UNSIGNED);
        endRule();

        beginRule(type_specifier);
        addRHS(struct_or_union_specifier);
        endRule();

        beginRule(type_specifier);
        addRHS(enum_specifier);
        endRule();

        beginRule(type_specifier);
        addRHS(TYPE_NAME);
        endRule();

        // struct_or_union_specifier

        beginRule(struct_or_union_specifier);
        addRHS(struct_or_union);
        addRHS(IDENTIFIER);
        addRHS(LBRACE);
        addRHS(struct_declaration_list);
        addRHS(RBRACE);
        endRule();

        beginRule(struct_or_union_specifier);
        addRHS(struct_or_union);
        addRHS(LBRACE);
        addRHS(struct_declaration_list);
        addRHS(RBRACE);
        endRule();

        beginRule(struct_or_union_specifier);
        addRHS(struct_or_union);
        addRHS(IDENTIFIER);
        endRule();

        // struct_or_union

        beginRule(struct_or_union);
        addRHS(STRUCT);
        endRule();

        beginRule(struct_or_union);
        addRHS(UNION);
        endRule();

        // struct_declaration_list

        beginRule(struct_declaration_list);
        addRHS(struct_declaration);
        endRule();

        beginRule(struct_declaration_list);
        addRHS(struct_declaration);
        addRHS(struct_declaration_list);
        endRule();

        // struct_declaration

        beginRule(struct_declaration);
        addRHS(specifier_qualifier_list);
        addRHS(SEMICOLON);
        endRule();

        // specifier_qualifier_list

        beginRule(specifier_qualifier_list);
        addRHS(type_specifier);
        addRHS(specifier_qualifier_list);
        endRule();

        beginRule(specifier_qualifier_list);
        addRHS(type_specifier);
        endRule();

        beginRule(specifier_qualifier_list);
        addRHS(type_qualifier);
        addRHS(specifier_qualifier_list);
        endRule();

        beginRule(specifier_qualifier_list);
        addRHS(type_qualifier);
        endRule();

        // struct_declarator_list

        beginRule(struct_declarator_list);
        addRHS(struct_declarator);
        endRule();

        beginRule(struct_declarator_list);
        addRHS(struct_declarator_list);
        addRHS(COMMA);
        addRHS(struct_declarator);
        endRule();

        // struct_declarator

        beginRule(struct_declarator);
        addRHS(declarator);
        endRule();

        beginRule(struct_declarator);
        addRHS(COLON);
        addRHS(constant_expression);
        endRule();

        beginRule(struct_declarator);
        addRHS(declaration);
        addRHS(COLON);
        addRHS(constant_expression);
        endRule();

        // enum_specifier

        beginRule(enum_specifier);
        addRHS(ENUM);
        addRHS(LBRACE);
        addRHS(enumerator_list);
        addRHS(RBRACE);
        endRule();

        beginRule(enum_specifier);
        addRHS(ENUM);
        addRHS(IDENTIFIER);
        addRHS(LBRACE);
        addRHS(enumerator_list);
        addRHS(RBRACE);
        endRule();

        beginRule(enum_specifier);
        addRHS(ENUM);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(enum_specifier);
        addRHS(ENUM);
        addRHS(IDENTIFIER);
        endRule();

        // enumerator_list

        beginRule(enumerator_list);
        addRHS(enumerator);
        endRule();

        beginRule(enumerator_list);
        addRHS(enumerator_list);
        addRHS(COMMA);
        addRHS(enumerator);
        endRule();

        // enumerator

        beginRule(enumerator);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(enumerator);
        addRHS(IDENTIFIER);
        addRHS(EQUALS);
        addRHS(constant_expression);
        endRule();

        // type_qualifier

        beginRule(type_qualifier);
        addRHS(CONST);
        endRule();

        beginRule(type_qualifier);
        addRHS(VOLATILE);
        endRule();

        // declarator

        beginRule(declarator);
        addRHS(pointer);
        addRHS(direct_declarator);
        endRule();

        beginRule(declarator);
        addRHS(direct_declarator);
        endRule();

        // direct_declarator

        beginRule(direct_declarator);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(direct_declarator);
        addRHS(LPAREN);
        addRHS(declarator);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_declarator);
        addRHS(direct_declarator);
        addRHS(LBRACK);
        addRHS(constant_expression);
        addRHS(RBRACK);
        endRule();

        beginRule(direct_declarator);
        addRHS(direct_declarator);
        addRHS(LBRACK);
        addRHS(RBRACK);
        endRule();

        beginRule(direct_declarator);
        addRHS(direct_declarator);
        addRHS(LPAREN);
        addRHS(parameter_type_list);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_declarator);
        addRHS(direct_declarator);
        addRHS(LPAREN);
        addRHS(identifier_list);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_declarator);
        addRHS(direct_declarator);
        addRHS(LPAREN);
        addRHS(RPAREN);
        endRule();

        // pointer

        beginRule(pointer);
        addRHS(AST);
        endRule();

        beginRule(pointer);
        addRHS(AST);
        addRHS(type_qualifier_list);
        endRule();

        beginRule(pointer);
        addRHS(AST);
        addRHS(pointer);
        endRule();

        beginRule(pointer);
        addRHS(AST);
        addRHS(type_qualifier_list);
        addRHS(pointer);
        endRule();

        // type_qualifier_list

        beginRule(type_qualifier_list);
        addRHS(type_qualifier);
        endRule();

        beginRule(type_qualifier_list);
        addRHS(type_qualifier_list);
        addRHS(type_qualifier);
        endRule();

        // parameter_type_list

        beginRule(parameter_type_list);
        addRHS(parameter_list);
        endRule();

        beginRule(parameter_type_list);
        addRHS(parameter_list);
        addRHS(COMMA);
        addRHS(ELLIPSIS);
        endRule();

        // parameter_list

        beginRule(parameter_list);
        addRHS(parameter_declaration);
        endRule();

        beginRule(parameter_list);
        addRHS(parameter_list);
        addRHS(COMMA);
        addRHS(parameter_declaration);
        endRule();

        // parameter_declaration

        beginRule(parameter_declaration);
        addRHS(declaration_specifiers);
        addRHS(declarator);
        endRule();

        beginRule(parameter_declaration);
        addRHS(declaration_specifiers);
        addRHS(abstract_declarator);
        endRule();

        beginRule(parameter_declaration);
        addRHS(declaration_specifiers);
        endRule();

        // identifier_list

        beginRule(identifier_list);
        addRHS(IDENTIFIER);
        endRule();

        beginRule(identifier_list);
        addRHS(identifier_list);
        addRHS(COMMA);
        addRHS(IDENTIFIER);
        endRule();

        // type_name

        beginRule(type_name);
        addRHS(specifier_qualifier_list);
        endRule();

        beginRule(type_name);
        addRHS(specifier_qualifier_list);
        addRHS(abstract_declarator);
        endRule();

        // abstract_declarator

        beginRule(abstract_declarator);
        addRHS(pointer);
        endRule();

        beginRule(abstract_declarator);
        addRHS(direct_abstract_declarator);
        endRule();

        beginRule(abstract_declarator);
        addRHS(pointer);
        addRHS(direct_abstract_declarator);
        endRule();

        // direct_abstract_declarator

        beginRule(direct_abstract_declarator);
        addRHS(LPAREN);
        addRHS(abstract_declarator);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(LBRACK);
        addRHS(RBRACK);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(LPAREN);
        addRHS(constant_expression);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(direct_abstract_declarator);
        addRHS(LBRACK);
        addRHS(RBRACK);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(direct_abstract_declarator);
        addRHS(LBRACK);
        addRHS(constant_expression);
        addRHS(RBRACK);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(LPAREN);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(LPAREN);
        addRHS(parameter_type_list);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(direct_abstract_declarator);
        addRHS(LPAREN);
        addRHS(RPAREN);
        endRule();

        beginRule(direct_abstract_declarator);
        addRHS(direct_abstract_declarator);
        addRHS(LPAREN);
        addRHS(parameter_type_list);
        addRHS(RPAREN);
        endRule();

        // initializer

        beginRule(initializer);
        addRHS(assignment_expression);
        endRule();

        beginRule(initializer);
        addRHS(LBRACE);
        addRHS(initializer_list);
        addRHS(RBRACE);
        endRule();

        beginRule(initializer);
        addRHS(LBRACE);
        addRHS(initializer_list);
        addRHS(COMMA);
        addRHS(RBRACE);
        endRule();

        // initializer_list

        beginRule(initializer_list);
        addRHS(initializer);
        endRule();

        beginRule(initializer_list);
        addRHS(initializer_list);
        addRHS(COMMA);
        addRHS(initializer);
        endRule();

        // statement

        beginRule(statement);
        addRHS(labeled_statement);
        endRule();

        beginRule(statement);
        addRHS(compound_statement);
        endRule();

        beginRule(statement);
        addRHS(expression_statement);
        endRule();

        beginRule(statement);
        addRHS(selection_statement);
        endRule();

        beginRule(statement);
        addRHS(iteration_statement);
        endRule();

        beginRule(statement);
        addRHS(jump_statement);
        endRule();

        // labeled_statement

        beginRule(labeled_statement);
        addRHS(IDENTIFIER);
        addRHS(COLON);
        addRHS(statement);
        endRule();

        beginRule(labeled_statement);
        addRHS(CASE);
        addRHS(constant_expression);
        addRHS(COLON);
        addRHS(statement);
        endRule();

        beginRule(labeled_statement);
        addRHS(DEFAULT);
        addRHS(COLON);
        addRHS(statement);
        endRule();

        // compound_statement

        beginRule(compound_statement);
        addRHS(LBRACE);
        addRHS(RBRACE);
        endRule();

        beginRule(compound_statement);
        addRHS(LBRACE);
        addRHS(statement_list);
        addRHS(RBRACE);
        endRule();

        beginRule(compound_statement);
        addRHS(LBRACE);
        addRHS(declaration_list);
        addRHS(RBRACE);
        endRule();

        beginRule(compound_statement);
        addRHS(LBRACE);
        addRHS(declaration_list);
        addRHS(statement_list);
        addRHS(RBRACE);
        endRule();

        beginRule(compound_statement);
        addRHS(LBRACE);
        addRHS(declaration_list);
        addRHS(RBRACE);
        endRule();

        // declaration_list

        beginRule(declaration_list);
        addRHS(declaration);
        endRule();

        beginRule(declaration_list);
        addRHS(declaration_list);
        addRHS(declaration);
        endRule();

        // statement_list

        beginRule(statement_list);
        addRHS(statement);
        endRule();

        beginRule(statement_list);
        addRHS(statement_list);
        addRHS(statement);
        endRule();

        // expression_statement

        beginRule(expression_statement);
        addRHS(SEMICOLON);
        endRule();

        beginRule(expression_statement);
        addRHS(expression);
        addRHS(SEMICOLON);
        endRule();

        // selection_statement

        beginRule(selection_statement);
        addRHS(IF);
        addRHS(LPAREN);
        addRHS(expression);
        addRHS(RPAREN);
        addRHS(statement);
        endRule();

        beginRule(selection_statement);
        addRHS(IF);
        addRHS(LPAREN);
        addRHS(expression);
        addRHS(RPAREN);
        addRHS(statement);
        addRHS(ELSE);
        addRHS(statement);
        endRule();

        beginRule(selection_statement);
        addRHS(SWITCH);
        addRHS(LPAREN);
        addRHS(expression);
        addRHS(RPAREN);
        addRHS(statement);
        endRule();

        // iteration_statement

        beginRule(iteration_statement);
        addRHS(WHILE);
        addRHS(LPAREN);
        addRHS(expression);
        addRHS(RPAREN);
        addRHS(statement);
        endRule();

        beginRule(iteration_statement);
        addRHS(DO);
        addRHS(statement);
        addRHS(WHILE);
        addRHS(LPAREN);
        addRHS(expression);
        addRHS(RPAREN);
        addRHS(SEMICOLON);
        endRule();

        beginRule(iteration_statement);
        addRHS(FOR);
        addRHS(LPAREN);
        addRHS(expression_statement);
        addRHS(expression_statement);
        addRHS(RPAREN);
        addRHS(statement);
        endRule();

        beginRule(iteration_statement);
        addRHS(FOR);
        addRHS(LPAREN);
        addRHS(expression_statement);
        addRHS(expression_statement);
        addRHS(expression);
        addRHS(RPAREN);
        addRHS(statement);
        endRule();

        // jump_statement

        beginRule(jump_statement);
        addRHS(GOTO);
        addRHS(IDENTIFIER);
        addRHS(SEMICOLON);
        endRule();

        beginRule(jump_statement);
        addRHS(CONTINUE);
        addRHS(SEMICOLON);
        endRule();

        beginRule(jump_statement);
        addRHS(BREAK);
        addRHS(SEMICOLON);
        endRule();

        beginRule(jump_statement);
        addRHS(RETURN);
        addRHS(SEMICOLON);
        endRule();

        beginRule(jump_statement);
        addRHS(RETURN);
        addRHS(expression);
        addRHS(SEMICOLON);
        endRule();

        // translation_unit

        beginRule(translation_unit);
        addRHS(external_declaration);
        endRule();

        beginRule(translation_unit);
        addRHS(translation_unit);
        addRHS(external_declaration);
        endRule();

        // external_declaration

        beginRule(external_declaration);
        addRHS(function_definition);
        endRule();

        beginRule(external_declaration);
        addRHS(declaration);
        endRule();

        // function_definition

        beginRule(function_definition);
        addRHS(declaration_specifiers);
        addRHS(declarator);
        addRHS(declaration_list);
        addRHS(compound_statement);
        endRule();

        beginRule(function_definition);
        addRHS(declaration_specifiers);
        addRHS(declarator);
        addRHS(compound_statement);
        endRule();

        beginRule(function_definition);
        addRHS(declarator);
        addRHS(declaration_list);
        addRHS(compound_statement);
        endRule();

        beginRule(function_definition);
        addRHS(declarator);
        addRHS(compound_statement);
        endRule();

    }

    final NonTerm primary_expression = nonTerm("primary_expression");
    final NonTerm expression = nonTerm("expression");
    final NonTerm postfix_expression = nonTerm("postfix_expression");
    final NonTerm argument_expression_list = nonTerm("argument_expression_list ");
    final NonTerm assignment_expression = nonTerm("assignment_expression");
    final NonTerm unary_operator = nonTerm("unary_operator");
    final NonTerm unary_expression = nonTerm("unary_expression");
    final NonTerm cast_expression = nonTerm("cast_expression");
    final NonTerm type_name = nonTerm("type_name");
    final NonTerm multiplicative_expression = nonTerm("multiplicative_expression");
    final NonTerm additive_expression = nonTerm("additive_expression");
    final NonTerm shift_expression = nonTerm(" shift_expression");
    final NonTerm relational_expression = nonTerm(" relational_expression");
    final NonTerm equality_expression = nonTerm("equality_expression");
    final NonTerm and_expression = nonTerm("and_expression");
    final NonTerm exclusive_or_expression = nonTerm("exclusive_or_expression");
    final NonTerm inclusive_or_expression = nonTerm("inclusive_or_expression");
    final NonTerm logical_and_expression = nonTerm("logical_and_expression");
    final NonTerm logical_or_expression = nonTerm("logical_or_expression");
    final NonTerm conditional_expression = nonTerm("conditional_expression");
    final NonTerm assignment_operator = nonTerm("assignment_operator");
    final NonTerm constant_expression = nonTerm("constant_expression");
    final NonTerm declaration = nonTerm("declaration");
    final NonTerm declaration_specifiers = nonTerm("declaration_specifiers");
    final NonTerm init_declarator_list = nonTerm("init_declarator_list");
    final NonTerm storage_class_specifier = nonTerm("storage_class_specifier");
    final NonTerm type_specifier = nonTerm("type_specifier");
    final NonTerm type_qualifier = nonTerm("type_qualifier");
    final NonTerm init_declarator = nonTerm("init_declarator");
    final NonTerm declarator = nonTerm("declarator");
    final NonTerm initializer = nonTerm("initializer");
    final NonTerm struct_or_union_specifier = nonTerm("struct_or_union_specifier");
    final NonTerm enum_specifier = nonTerm("enum_specifier");
    final NonTerm struct_or_union = nonTerm("struct_or_union");
    final NonTerm struct_declaration_list = nonTerm("struct_declaration_list");
    final NonTerm struct_declaration = nonTerm("struct_declaration");
    final NonTerm specifier_qualifier_list = nonTerm("specifier_qualifier_list");
    final NonTerm struct_declarator_list = nonTerm("struct_declarator_list");
    final NonTerm struct_declarator = nonTerm("struct_declarator");
    final NonTerm enumerator_list = nonTerm("enumerator_list");
    final NonTerm enumerator = nonTerm("enumerator");
    final NonTerm pointer = nonTerm("pointer");
    final NonTerm direct_declarator = nonTerm("direct_declarator");
    final NonTerm identifier_list = nonTerm("identifier_list");
    final NonTerm parameter_type_list = nonTerm("parameter_type_list");
    final NonTerm type_qualifier_list = nonTerm("type_qualifier_list");
    final NonTerm parameter_list = nonTerm("parameter_list");
    final NonTerm parameter_declaration = nonTerm("parameter_declaration");
    final NonTerm abstract_declarator = nonTerm("abstract_declarator");
    final NonTerm direct_abstract_declarator = nonTerm("direct_abstract_declarator");
    final NonTerm initializer_list = nonTerm("initializer_list");
    final NonTerm statement = nonTerm("statement");
    final NonTerm labeled_statement = nonTerm("labeled_statement");
    final NonTerm compound_statement = nonTerm("compound_statement");
    final NonTerm expression_statement = nonTerm("expression_statement");
    final NonTerm selection_statement = nonTerm("selection_statement");
    final NonTerm iteration_statement = nonTerm("iteration_statement");
    final NonTerm jump_statement = nonTerm("jump_statement");
    final NonTerm declaration_list = nonTerm("declaration_list");
    final NonTerm statement_list = nonTerm("statement_list");
    final NonTerm translation_unit = nonTerm("translation_unit");
    final NonTerm external_declaration = nonTerm("external_declaration");

    final NonTerm function_definition = nonTerm("function_definition");

    final Terminal IDENTIFIER = terminal("IDENTIFIER", ANSICScanner.IDENTIFIER_TOK);
    final Terminal CONSTANT = terminal("CONSTANT", ANSICScanner.CONSTANT_TOK);
    final Terminal STRING_LITERAL = terminal("STRING_LITERAL",ANSICScanner.STRING_LITERAL_TOK);
    
    final Terminal SIZEOF = terminal("sizeof", ANSICScanner.SIZEOF_TOK);
    final Terminal PTR_OP = terminal("->", ANSICScanner.PTR_OP_TOK);
    final Terminal INC_OP = terminal("++", ANSICScanner.INC_OP_TOK);
    final Terminal DEC_OP = terminal("--", ANSICScanner.DEC_OP_TOK);
    final Terminal LEFT_OP = terminal("<<", ANSICScanner.LEFT_OP_TOK);
    final Terminal RIGHT_OP = terminal(">>", ANSICScanner.RIGHT_OP_TOK);
    final Terminal GE_OP = terminal(">=", ANSICScanner.GE_OP_TOK);
    final Terminal LE_OP = terminal("<=", ANSICScanner.LE_OP_TOK);
    final Terminal EQ_OP = terminal("==", ANSICScanner.EQ_OP_TOK);
    final Terminal NE_OP = terminal("!=", ANSICScanner.NE_OP_TOK);
    final Terminal AND_OP = terminal("&&", ANSICScanner.AND_OP_TOK);
    final Terminal OR_OP = terminal("||", ANSICScanner.OR_OP_TOK);

    final Terminal MUL_ASSIGN = terminal("*=", ANSICScanner.MUL_ASSIGN_TOK);
    final Terminal DIV_ASSIGN = terminal("/=", ANSICScanner.DIV_ASSIGN_TOK);
    final Terminal MOD_ASSIGN = terminal("%=", ANSICScanner.MOD_ASSIGN_TOK);
    final Terminal ADD_ASSIGN = terminal("+=", ANSICScanner.ADD_ASSIGN_TOK);
    final Terminal SUB_ASSIGN = terminal("-=", ANSICScanner.SUB_ASSIGN_TOK);
    final Terminal LEFT_ASSIGN = terminal("<<=", ANSICScanner.LEFT_ASSIGN_TOK);
    final Terminal RIGHT_ASSIGN = terminal(">>=", ANSICScanner.RIGHT_ASSIGN_TOK);
    final Terminal AND_ASSIGN = terminal("&=", ANSICScanner.AND_ASSIGN_TOK);
    final Terminal XOR_ASSIGN = terminal("^=", ANSICScanner.XOR_ASSIGN_TOK);
    final Terminal OR_ASSIGN = terminal("|=", ANSICScanner.OR_ASSIGN_TOK);

    final Terminal TYPEDEF = terminal("typedef", ANSICScanner.TYPEDEF_TOK);
    final Terminal EXTERN = terminal("extern", ANSICScanner.EXTERN_TOK);
    final Terminal STATIC = terminal("static", ANSICScanner.STATIC_TOK);
    final Terminal AUTO = terminal("auto", ANSICScanner.AUTO_TOK);
    final Terminal REGISTER = terminal("register", ANSICScanner.REGISTER_TOK);

    final Terminal VOID = terminal(" void", ANSICScanner.VOID_TOK);
    final Terminal CHAR = terminal("char", ANSICScanner.CHAR_TOK);
    final Terminal SHORT = terminal("short", ANSICScanner.SHORT_TOK);
    final Terminal INT = terminal("int", ANSICScanner.INT_TOK);
    final Terminal LONG = terminal("long", ANSICScanner.LONG_TOK);
    final Terminal FLOAT = terminal("float", ANSICScanner.FLOAT_TOK);
    final Terminal DOUBLE = terminal("double", ANSICScanner.DOUBLE_TOK);
    final Terminal SIGNED = terminal("signed", ANSICScanner.SIGNED_TOK);
    final Terminal UNSIGNED = terminal("unsigned", ANSICScanner.UNSIGNED_TOK);
    final Terminal TYPE_NAME = terminal("TYPE_NAME", ANSICScanner.TYPE_NAME_TOK);

    final Terminal STRUCT = terminal("struct", ANSICScanner.STRUCT_TOK);
    final Terminal UNION = terminal("union", ANSICScanner.UNION_TOK);

    final Terminal ENUM = terminal("enum", ANSICScanner.ENUM_TOK);

    final Terminal CONST = terminal("const", ANSICScanner.CONST_TOK);
    final Terminal VOLATILE = terminal("volatile", ANSICScanner.VOLATILE_TOK);
    final Terminal ELLIPSIS = terminal("...", ANSICScanner.ELLIPSIS_TOK);
    final Terminal CASE = terminal("case", ANSICScanner.CASE_TOK);
    final Terminal DEFAULT = terminal("default", ANSICScanner.DEFAULT_TOK);

    final Terminal IF = terminal("if", ANSICScanner.IF_TOK);
    final Terminal ELSE = terminal("else", ANSICScanner.ELSE_TOK);
    final Terminal SWITCH = terminal("switch", ANSICScanner.SWITCH_TOK);

    final Terminal WHILE = terminal("while", ANSICScanner.WHILE_TOK);
    final Terminal DO = terminal("do", ANSICScanner.DO_TOK);
    final Terminal FOR = terminal("for", ANSICScanner.FOR_TOK);

    final Terminal GOTO = terminal("goto", ANSICScanner.GOTO_TOK);
    final Terminal BREAK = terminal("break", ANSICScanner.BREAK_TOK);
    final Terminal RETURN = terminal("return", ANSICScanner.RETURN_TOK);
    final Terminal CONTINUE = terminal("continue", ANSICScanner.CONTINUE_TOK);

    final Terminal LPAREN = terminal("'('");
    final Terminal RPAREN = terminal("')'");
    final Terminal LBRACK = terminal("'['");
    final Terminal RBRACK = terminal("']'");
    final Terminal LBRACE = terminal("'{'");
    final Terminal RBRACE = terminal("'}'");
    final Terminal PERIOD = terminal("'.'");
    final Terminal COMMA = terminal("','");
    final Terminal AMP = terminal("'&'");
    final Terminal AST = terminal("'*'");
    final Terminal PLUS = terminal("'+'");
    final Terminal MINUS = terminal("'-'");
    final Terminal TILDE = terminal("'~'");
    final Terminal EXCLAMATION = terminal("'!'");
    final Terminal PERCENT = terminal("'%'");
    final Terminal BACKSLASH = terminal("'/'");
    final Terminal LESSER = terminal("'<'");
    final Terminal GREATER = terminal("'>'");
    final Terminal CARAT = terminal("'^'");
    final Terminal LINE = terminal("'|'");
    final Terminal QM = terminal("'?'");
    final Terminal COLON = terminal("':'");
    final Terminal EQUALS = terminal("'='");
    final Terminal SEMICOLON = terminal("';'");

}
