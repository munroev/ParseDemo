
package zdu.parsdemo;

import zdu.parsdemo.Grammar;
import zdu.parsdemo.SparseTable2;

import java.util.Enumeration;


class ExtendedLL1Table extends LL1Table {

  ExtendedLL1Table(ExtendedLL1Gram g) {
    super(g);

  //PRORAM
  
   put(g.program, g.ID, g.rule(1));
   put(g.program, g.WRITE, g.rule(1));
   put(g.program, g.IF, g.rule(1));
   put(g.program, g.WHILE, g.rule(1));
   put(g.program, g.READ, g.rule(1));
   put(g.program, g.EOF, g.rule(0));
   
   //STMTLIST
   
   put(g.stmtlist, g.ID, g.rule(2));
   put(g.stmtlist, g.WRITE, g.rule(2));
   put(g.stmtlist, g.IF, g.rule(2));
   put(g.stmtlist, g.READ, g.rule(2));
   put(g.stmtlist, g.WHILE, g.rule(2));
   
   //STMTLIST EPSILON PRODUCTION
   
   
   put(g.stmtlist, g.ADD, g.rule(3));
   put(g.stmtlist, g.SUB, g.rule(3));
   put(g.stmtlist, g.GREATER, g.rule(3));
   put(g.stmtlist, g.LESSER, g.rule(3));
   put(g.stmtlist, g.GREATEREQ, g.rule(3));
   put(g.stmtlist, g.LESSEQ, g.rule(3));
   put(g.stmtlist, g.EQUALS, g.rule(3));
   put(g.stmtlist, g.NEQUALS, g.rule(3));
   put(g.stmtlist, g.EOF, g.rule(3));
   put(g.stmtlist, g.LPAREN, g.rule(3));
   put(g.stmtlist, g.RPAREN, g.rule(3));
   put(g.stmtlist, g.MULT, g.rule(3));
   put(g.stmtlist, g.LITERAL, g.rule(3));
   put(g.stmtlist, g.DIVIDE, g.rule(3));
   put(g.stmtlist, g.END, g.rule(3));
   put(g.stmtlist, g.ASSGN, g.rule(3));
   
   
   //STMT
   
   put(g.stmt, g.ID, g.rule(4));
   put(g.stmt, g.READ, g.rule(5));
   put(g.stmt, g.WRITE, g.rule(6));
   put(g.stmt, g.IF, g.rule(7));
   put(g.stmt, g.WHILE, g.rule(8));
   
   //COND
   
   put(g.cond, g.WHILE, g.rule(9));
   put(g.cond, g.IF, g.rule(9));
    put(g.cond, g.ID, g.rule(9));
   
   
   //EXPR
   
   put(g.equivalence, g.LPAREN, g.rule(10));
   put(g.equivalence, g.ID, g.rule(10));
   put(g.equivalence, g.LITERAL, g.rule(10));
   
   //TERM
   
   put(g.tail, g.LPAREN, g.rule(11));
   put(g.tail, g.ID, g.rule(11));
   put(g.tail, g.LITERAL, g.rule(11));
   
   //FACTOR
   
   put(g.factor, g.LPAREN, g.rule(12));
   put(g.factor, g.ID, g.rule(13));
   put(g.factor, g.LITERAL, g.rule(14));
   
   //EXPRTAIL
 /*  
   put(g.equivalencetail, g.EQUALS, g.rule(15));
   put(g.equivalencetail, g.NEQUALS, g.rule(15));
   put(g.equivalencetail, g.LESSER, g.rule(15));
   put(g.equivalencetail, g.GREATER, g.rule(15));
   put(g.equivalencetail, g.LESSEQ, g.rule(15));
   put(g.equivalencetail, g.GREATEREQ, g.rule(15));
   
   //EXPRTAIL **EPSILON PRODUCTION**
   
    put(g.equivalencetail, g.MULT, g.rule(16));
   put(g.equivalencetail, g.DIVIDE, g.rule(16));
   put(g.equivalencetail, g.ADD, g.rule(16));
   put(g.equivalencetail, g.SUB, g.rule(16));
   put(g.equivalencetail, g.EOF, g.rule(16));
   put(g.equivalencetail, g.LPAREN, g.rule(16));
   put(g.equivalencetail, g.RPAREN, g.rule(16));
   put(g.equivalencetail, g.ID, g.rule(16));
   put(g.equivalencetail, g.LITERAL, g.rule(16));
   put(g.equivalencetail, g.WHILE, g.rule(16));
   put(g.equivalencetail, g.IF, g.rule(16));
   put(g.equivalencetail, g.END, g.rule(16));
   put(g.equivalencetail, g.ASSGN, g.rule(16));
   put(g.equivalencetail, g.READ, g.rule(16));
   put(g.equivalencetail, g.WRITE, g.rule(16));
   */
   
   //TERMTAIL
   
   put(g.truthtail, g.ADD, g.rule(15));
   put(g.truthtail, g.SUB, g.rule(15));
   
   //TERMTAIL **EPSILON PRODUCTION**
    
   put(g.truthtail, g.MULT, g.rule(16));
   put(g.truthtail, g.DIVIDE, g.rule(16));
   put(g.truthtail, g.GREATER, g.rule(16));
   put(g.truthtail, g.LESSER, g.rule(16));
   put(g.truthtail, g.GREATEREQ, g.rule(16));
   put(g.truthtail, g.LESSEQ, g.rule(16));
   put(g.truthtail, g.EQUALS, g.rule(16));
   put(g.truthtail, g.NEQUALS, g.rule(16));
   put(g.truthtail, g.EOF, g.rule(16));
   put(g.truthtail, g.LPAREN, g.rule(16));
   put(g.truthtail, g.RPAREN, g.rule(16));
   put(g.truthtail, g.ID, g.rule(16));
   put(g.truthtail, g.LITERAL, g.rule(16));
   put(g.truthtail, g.WHILE, g.rule(16));
   put(g.truthtail, g.IF, g.rule(16));
   put(g.truthtail, g.END, g.rule(16));
   put(g.truthtail, g.ASSGN, g.rule(16));
   put(g.truthtail, g.READ, g.rule(16));
   put(g.truthtail, g.WRITE, g.rule(16));
   
   
   //FACTORTAIL
   
   put(g.factortail, g.MULT, g.rule(17));
   put(g.factortail, g.DIVIDE, g.rule(17));
   
   //FACTORTAIL **EPSILON PRODUCTION**
    
   put(g.factortail, g.ADD, g.rule(18));
   put(g.factortail, g.SUB, g.rule(18));
   put(g.factortail, g.GREATER, g.rule(18));
   put(g.factortail, g.LESSER, g.rule(18));
   put(g.factortail, g.GREATEREQ, g.rule(18));
   put(g.factortail, g.LESSEQ, g.rule(18));
   put(g.factortail, g.EQUALS, g.rule(18));
   put(g.factortail, g.NEQUALS, g.rule(18));
   put(g.factortail, g.EOF, g.rule(18));
   put(g.factortail, g.LPAREN, g.rule(18));
   put(g.factortail, g.RPAREN, g.rule(18));
   put(g.factortail, g.ID, g.rule(18));
   put(g.factortail, g.LITERAL, g.rule(18));
   put(g.factortail, g.WHILE, g.rule(18));
   put(g.factortail, g.IF, g.rule(18));
   put(g.factortail, g.END, g.rule(18));
   put(g.factortail, g.ASSGN, g.rule(18));
   put(g.factortail, g.READ, g.rule(18));
    put(g.factortail, g.WRITE, g.rule(18));
   
   
   //RELOP
   
   put(g.relationop, g.EQUALS, g.rule(19));
   put(g.relationop, g.NEQUALS, g.rule(20));
   put(g.relationop, g.LESSER, g.rule(21));
   put(g.relationop, g.GREATER, g.rule(22));
   put(g.relationop, g.LESSEQ, g.rule(23));
   put(g.relationop, g.GREATEREQ, g.rule(24));
   

  //ADDOP
   
    put(g.additionop, g.ADD, g.rule(25));
    put(g.additionop, g.SUB, g.rule(26));
    
 //MULTOP
    
   put(g.multop, g.MULT, g.rule(27));
   put(g.multop, g.DIVIDE, g.rule(28));
   
   
 
   

  }

  static public void main(String args[]) {
    ExtendedLL1Table tab= 
      new ExtendedLL1Table(new ExtendedLL1Gram());
    System.out.println(tab.toString());
  }

};