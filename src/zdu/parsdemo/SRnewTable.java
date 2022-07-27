package zdu.parsdemo;

import zdu.parsdemo.GramSym;
import zdu.parsdemo.Grammar;
import zdu.parsdemo.NonTerm;
import zdu.parsdemo.Rule;
import zdu.parsdemo.SRAct;
import zdu.parsdemo.SRnewGram;
import zdu.parsdemo.SparseTable2;
import zdu.parsdemo.Terminal;


class SRnewTable extends SRTable {

  SRnewTable(SRnewGram g) {
    
    super(N_STATES, g);

    SRState[] states= new SRState[N_STATES];

    for (int i= 0; i < N_STATES; i++) {
      states[i]= (SRState) getRow(i);
    }

    //shift/reduce/goto acts follow.
    
   //State 0
   
   
    put(states[0], g.ID, new SRAct(SRAct.SHIFT, states[1]));
    put(states[0], g.READ, new SRAct(SRAct.SHIFT, states[2]));
    put(states[0], g.WRITE, new SRAct(SRAct.SHIFT, states[3]));
    put(states[0], g.IF, new SRAct(SRAct.SHIFT, states[4]));
    put(states[0], g.WHILE, new SRAct(SRAct.SHIFT, states[5]));
    put(states[0], g.stmt, new SRAct(SRAct.SHIFT, states[7]));
    put(states[0], g.stmtlist, new SRAct(SRAct.SHIFT, states[8]));
 
  //State 2
  
     put(states[2], g.ID, new SRAct(SRAct.SHIFT, states[6]));
     
  //State 6
    
  defaults.put(states[6], new SRAct(SRAct.REDUCE, g.rule(5))); 
    
  
  //State 7
   put(states[7], g.READ, new SRAct(SRAct.REDUCE, g.rule(3)));
   
  //State 8
   put(states[8], g.READ, new SRAct(SRAct.SHIFT,states[9]));
   put(states[8], g.stmt, new SRAct(SRAct.SHIFT,states[11]));
   put(states[8], g.ID, new SRAct(SRAct.SHIFT,states[12]));
   put(states[8], g.ADD, new SRAct(SRAct.SHIFT,states[18]));
   put(states[8], g.additionop, new SRAct(SRAct.SHIFT,states[19]));
   
 //State 9
 
   put(states[9], g.ID, new SRAct(SRAct.SHIFT,states[10]));
   
 
 //State 10
 
   defaults.put(states[10], new SRAct(SRAct.REDUCE, g.rule(5))); 
   
 //State 11
 
   defaults.put(states[11], new SRAct(SRAct.REDUCE, g.rule(2))); 
   
//State 12
  
 put(states[12], g.ASSGN, new SRAct(SRAct.SHIFT,states[13]));
 
//State 13

 put(states[13], g.ID, new SRAct(SRAct.SHIFT,states[14]));
 put(states[13], g.factor, new SRAct(SRAct.SHIFT,states[15]));
 put(states[13], g.tail, new SRAct(SRAct.SHIFT,states[16]));
 put(states[13], g.equivalence, new SRAct(SRAct.SHIFT,states[17]));
 
 //State 14
 
 defaults.put(states[14], new SRAct(SRAct.REDUCE, g.rule(15))); 
 
 //State 15
 
 put(states[15], g.ADD, new SRAct(SRAct.REDUCE,g.rule(13)));
 put(states[15], g.WRITE, new SRAct(SRAct.REDUCE,g.rule(13)));

 
 //State 16
 
 defaults.put(states[16], new SRAct(SRAct.REDUCE, g.rule(11)));
 
 
 //State 17
 
 defaults.put(states[17], new SRAct(SRAct.REDUCE, g.rule(4)));
 
// State 18
 
 defaults.put(states[18], new SRAct(SRAct.REDUCE, g.rule(27)));
 
// State 19

 put(states[19], g.ID, new SRAct(SRAct.SHIFT,states[14]));
 put(states[19], g.factor, new SRAct(SRAct.SHIFT,states[15]));
 put(states[19], g.tail, new SRAct(SRAct.SHIFT,states[20]));
 
//State 20

 put(states[20], g.WRITE, new SRAct(SRAct.REDUCE,g.rule(18)));
 put(states[20], g.truthtail, new SRAct(SRAct.SHIFT,states[21]));
 
//State 21

 defaults.put(states[21], new SRAct(SRAct.REDUCE, g.rule(17)));


  }


  static public void main(String args[]) {
    SRnewTable tab= 
      new SRnewTable(new SRnewGram());

    System.out.print(tab.toString());

  }
  
  static final int N_STATES= 30;
}