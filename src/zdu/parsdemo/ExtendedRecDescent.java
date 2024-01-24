/*

File:	 SimpCompRecDescent.jpp
Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
Last Update Time-stamp: "97/06/27 20:42:09 umrigar"

This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;




















import java.util.Hashtable;

class ExtendedRecDescent extends RecParser 
{
  
  ExtendedRecDescent(ExtendedLL1Gram grammar, Scanner scanner,
		     ParseDisplay parseDisplay) {
    super(grammar, scanner, parseDisplay);

    prgSyms.put("program", grammar.program);
    prgSyms.put("stmtlist", grammar.stmtlist);
    prgSyms.put("stmt", grammar.stmt);
    prgSyms.put("cond", grammar.cond);
    prgSyms.put("expr", grammar.equivalence);
    prgSyms.put("factor", grammar.factor);
    prgSyms.put("termtail", grammar.truthtail);
    prgSyms.put("factortail", grammar.factortail);
    prgSyms.put("relop", grammar.relationop);
    prgSyms.put("addop", grammar.additionop);
    prgSyms.put("multop", grammar.multop);
    prgSyms.put("term", grammar.tail);

    prgSyms.put("'+'", grammar.ADD);
    prgSyms.put("ASSGN", grammar.ASSGN);
    prgSyms.put("'/'", grammar.DIVIDE);
    prgSyms.put("ID", grammar.ID);
    prgSyms.put("'('", grammar.LPAREN);
    prgSyms.put("'*'", grammar.MULT);
    prgSyms.put("')'", grammar.RPAREN);
    prgSyms.put("';'", grammar.SEMI);
    prgSyms.put("'-'", grammar.SUB);
    
    prgSyms.put("Read", grammar.READ);
    prgSyms.put("Write", grammar.WRITE);
    prgSyms.put("If", grammar.IF);
    prgSyms.put("While", grammar.WHILE);
    prgSyms.put("End", grammar.END);
    prgSyms.put("'='", grammar.EQUALS);
    prgSyms.put("<>", grammar.NEQUALS);
    prgSyms.put("'<'", grammar.LESSER);
    prgSyms.put("'>'", grammar.GREATER);
    prgSyms.put("<=", grammar.LESSEQ);
    prgSyms.put(">=", grammar.GREATEREQ);
    prgSyms.put("Literal", grammar.LITERAL);
    
   
   }


  

  ExtendedRecDescent(ExtendedLL1Gram grammar, Scanner scanner) {
    this(grammar, scanner, null);
  }
  
  

  protected final void parse() throws ParseException, ParseResetException
  {
    
    int ruleN=  0  ;
    do {	call((NonTerm) prgSyms.get("program"), ruleN, 2);	 program ();	} while (false) ;
    do {	accept(ruleN, 176); return;	} while (false) ;
  }

  private void program() throws ParseException, ParseResetException
  {
   
    int ruleN=  1  ;
    do {	call((NonTerm) prgSyms.get("stmtlist"), ruleN, 8);	 stmtlist ();	} while (false) ;
  }

  private void stmtlist() throws ParseException, ParseResetException
  {
    
   if(tok.getTokNum() == ExtendedScanner.READ_TOK|| tok.getTokNum() == ExtendedScanner.WRITE_TOK || tok.getTokNum() == ExtendedScanner.IF_TOK || tok.getTokNum() == ExtendedScanner.WHILE_TOK || tok.getTokNum() == ExtendedScanner.ID_TOK )
   {
    int ruleN=  2  ;
    do {	call((NonTerm) prgSyms.get("stmt"), ruleN, 17);	 stmt ();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("stmtlist"), ruleN, 18);	 stmtlist ();	} while (false) ;
    do {	ret(ruleN, 190); return;	} while (false) ; /* stmt() */
    }
     else {
      int ruleN=  3  ;
      do {	ret(ruleN, 21); return;	} while (false) ; /* epsilon production*/
    }
  }

  private void stmt() throws ParseException, ParseResetException
  {
    
    if (tok.getTokNum() == ExtendedScanner.ID_TOK) {
    
      int ruleN=  4  ;
      do {	match((Terminal) prgSyms.get("ID"), ruleN, 29);	} while (false) ;
      do {	match((Terminal) prgSyms.get("ASSGN"), ruleN, 30);} while (false) ;
      do {	call((NonTerm) prgSyms.get("expr"), ruleN, 31);	expr();	} while (false) ; 
      do {	ret(ruleN, 199); return;	} while (false) ; /* stmt() */
   
    }
    else if (tok.getTokNum() == ExtendedScanner.READ_TOK) {
    
       int ruleN=  5  ;
      do {	match((Terminal) prgSyms.get("Read"), ruleN, 34);	} while (false) ;
      do {	match((Terminal) prgSyms.get("ID"), ruleN, 35);	} while (false) ;
      do {	ret(ruleN, 199); return;	} while (false) ; /* stmt() */
   
    }
     else if (tok.getTokNum() == ExtendedScanner.WRITE_TOK) {
     
      int ruleN=  6  ;
      do {	match((Terminal) prgSyms.get("Write"), ruleN, 38);	} while (false) ;
      do {	call((NonTerm) prgSyms.get("expr"), ruleN, 39);	 expr();	} while (false) ;
      do {	ret(ruleN, 199); return;	} while (false) ; /* stmt() */
  
    }
     
    else if (tok.getTokNum() == ExtendedScanner.IF_TOK) {
    
         int ruleN=  7  ;
      do {	match((Terminal) prgSyms.get("If"), ruleN, 42);	} while (false) ;
      do {	call((NonTerm) prgSyms.get("cond"), ruleN, 43); cond ();} while (false);
      do {	call((NonTerm) prgSyms.get("stmtlist"), ruleN, 44); stmtlist();} while (false);
      do {	match((Terminal) prgSyms.get("End"), ruleN, 45);	} while (false) ;
      do {	ret(ruleN, 199); return;	} while (false) ; /* stmt() */
    
    }
    else {
       
       int ruleN=  8  ;
      do {	match((Terminal) prgSyms.get("While"), ruleN, 48);	} while (false) ;
      do {	call((NonTerm) prgSyms.get("cond"), ruleN, 49); cond();	} while (false) ;
      do {	call((NonTerm) prgSyms.get("stmtlist"), ruleN, 50); stmtlist();	} while (false) ;
      do {	match((Terminal) prgSyms.get("End"), ruleN, 51);	} while (false) ; 
      do {	ret(ruleN, 199); return;	} while (false) ; /* stmt() */
      
    }
   
  }

  private void cond() throws ParseException, ParseResetException
  {
    
    int ruleN=  9  ;
    do {	call((NonTerm) prgSyms.get("expr"), ruleN, 59);	 expr ();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("relop"), ruleN, 60);	 relop();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("expr"), ruleN, 61);	 expr ();	} while (false) ;
    do {	ret(ruleN, 213); return;	} while (false) ; /* cond() */
  }

  private void expr() throws ParseException, ParseResetException
  {
   
    int ruleN=  10  ;
    do {	call((NonTerm) prgSyms.get("term"), ruleN, 69);	 term ();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("termtail"), ruleN, 70);	 termtail ();	} while (false) ;
    do {	ret(ruleN, 221); return;	} while (false) ; /* expr() */
  }
  
  private void term() throws ParseException, ParseResetException
  {
    
    int ruleN=  11  ;
    do {	call((NonTerm) prgSyms.get("factor"), ruleN, 78);	factor();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("factortail"), ruleN, 79);	 factortail();	} while (false) ;
    do {	ret(ruleN, 221); return;	} while (false) ; /* term() */
  }



  private void factor() throws ParseException, ParseResetException
  {
   
    if (tok.getTokNum() == '(') {
      int ruleN=  12  ;
      do {	match((Terminal) prgSyms.get("'('"), ruleN, 87);	} while (false) ;
      do {	call((NonTerm) prgSyms.get("expr"), ruleN, 88);	 expr ();	} while (false) ;
      do {	match((Terminal) prgSyms.get("')'"), ruleN, 89);	} while (false) ;
      do {	ret(ruleN, 297); return;	} while (false) ; /* factor() */
    }
    else if (tok.getTokNum() == ExtendedScanner.ID_TOK) {
      int ruleN=  13  ;
      
      do {	match((Terminal) prgSyms.get("ID"), ruleN, 92);	} while (false) ;
      do {	ret(ruleN, 302); return;	} while (false) ; /* factor() */
    }
    else {
  
      int ruleN=  14  ;
      String v= new String(scanner.lexemeText());
     
      do {	match((Terminal) prgSyms.get("Literal"), ruleN, 95);	} while (false) ;
      do {	ret(ruleN, 308); return;	} while (false) ; /* factor() */
    }
  }
  

  
  
    private void termtail() throws ParseException, ParseResetException
  {
   
    if(tok.getTokNum() == '+' || tok.getTokNum() == '-')
  {
    int ruleN=  15  ;
    do {	call((NonTerm) prgSyms.get("addop"), ruleN, 103);	 addop();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("term"), ruleN, 104);	 term();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("termtail"), ruleN, 105);	 termtail ();	} while (false) ;
    do {	ret(ruleN, 251); return;	} while (false) ; /* termtail() */
  }
  
  else
  {
    int ruleN=  16  ;
    do {	ret(ruleN, 109); return;	} while (false) ; /* epsilon production*/
  
  }
 }
  
  
    private void factortail() throws ParseException, ParseResetException
  {
     
     if(tok.getTokNum() == '*' || tok.getTokNum() == '/')
  {
    int ruleN=  17  ;
    do {	call((NonTerm) prgSyms.get("multop"), ruleN, 117);	 multop();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("factor"), ruleN, 118);	 factor();	} while (false) ;
    do {	call((NonTerm) prgSyms.get("factortail"), ruleN, 119);	 factortail();	} while (false) ;
    do {	ret(ruleN, 251); return;	} while (false) ; /* factortail() */
  }
  
  else
  {
    int ruleN=  18  ;
    do {	ret(ruleN, 123); return;	} while (false) ; /* epsilon production*/
  
  }
  
  }
  
    private void relop() throws ParseException, ParseResetException
  {
 
  if (tok.getTokNum() == ExtendedScanner.EQUALS_TOK) {
      int ruleN=  19  ;
      do {	match((Terminal) prgSyms.get("'='"), ruleN, 131);	} while (false) ;
      do {	ret(ruleN, 261); return;	} while (false) ; /* relop() */
    }
    else if (tok.getTokNum() == ExtendedScanner.NEQUALS_TOK) {
      int ruleN=  20  ;
      do {	match((Terminal) prgSyms.get("<>"), ruleN, 134);	} while (false) ;
      do {	ret(ruleN, 268); return;	} while (false) ; /* relop() */
    }
    else if (tok.getTokNum() == '<') {
      int ruleN=  21  ;
      do {	match((Terminal) prgSyms.get("'<'"), ruleN, 137);	} while (false) ;
      do {	ret(ruleN, 275); return;	} while (false) ; /* relop() */
    }
    else if (tok.getTokNum() == '>') {
      int ruleN=  22  ;
      do {	match((Terminal) prgSyms.get("'>'"), ruleN, 140);	} while (false) ;
      do {	ret(ruleN, 282); return;	} while (false) ; /* relop() */
    }
      else if (tok.getTokNum() == ExtendedScanner.LESSER_TOK) {
      int ruleN=  23  ;
      do {	match((Terminal) prgSyms.get("<="), ruleN, 143);	} while (false) ;
      do {	ret(ruleN, 282); return;	} while (false) ; /* relop() */
    }
    
    else {
      int ruleN=  24  ;
      do {	match((Terminal) prgSyms.get(">="), ruleN, 145);	} while (false) ;
      do {	ret(ruleN, 282); return;	} while (false) ; /* relop() */
    }
    }
    
      private void addop() throws ParseException, ParseResetException
  {
      
      if (tok.getTokNum() == '+') {
      int ruleN=  25  ;
      do {	match((Terminal) prgSyms.get("'+'"), ruleN, 154);	} while (false) ;
      do {	ret(ruleN, 261); return;	} while (false) ; /* addop() */
    }
    else  {
      int ruleN=  26  ;
      do {	match((Terminal) prgSyms.get("'-'"), ruleN, 157);	} while (false) ;
      do {	ret(ruleN, 268); return;	} while (false) ; /* addop() */
    }
  
  }


  private void multop() throws ParseException, ParseResetException
  {
    
    if (tok.getTokNum() == '*') {
      int ruleN=  27  ;
      do {	match((Terminal) prgSyms.get("'*'"), ruleN, 165);	} while (false) ;
      do {	ret(ruleN, 261); return;	} while (false) ; /* multop() */
    }
    else  {
      int ruleN=  28  ;
      do {	match((Terminal) prgSyms.get("'/'"), ruleN, 168);	} while (false) ;
      do {	ret(ruleN, 268); return;	} while (false) ; /* termRest() */
    }
  
  }
  
   private Hashtable prgSyms= new Hashtable();

}