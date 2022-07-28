/*


P

→ 

SL $$

SL

→ 

S SL  |  ε

S

→ 

id := E  |  read id  |  write E  |  if C SL end  |  while C SL end

C

→ 

E ro E

E

→ 

T TT

T

→ 

F FT

F

→ 

( E )  |  id  |  lit

TT

→ 

ao T TT  |  ε

FT

→ 

mo F FT  |  ε

ro

→ 

==  |  !=  |  <  |  >  |  <=  |  >=

ao

→ 

+  |  -

mo

→ 

*  |  /

*/

package zdu.parsdemo;

import zdu.parsdemo.GramSym;
import zdu.parsdemo.Grammar;
import zdu.parsdemo.NonTerm;
import zdu.parsdemo.Rule;
import zdu.parsdemo.SRAct;
import zdu.parsdemo.ExtendedSRGram;
import zdu.parsdemo.SparseTable2;
import zdu.parsdemo.Terminal;

class ExtendedSRTable extends SRTable {

  ExtendedSRTable(ExtendedSRGram g) {

    super(N_STATES, g);

    SRState[] states = new SRState[N_STATES];

    for (int i = 0; i < N_STATES; i++) {
      states[i] = (SRState) getRow(i);
    }

    // shift/reduce/goto acts follow.

    // State 0

    put(states[0], g.stmtlist, new SRAct(SRAct.SHIFT, states[2]));
    put(states[0], g.stmt, new SRAct(SRAct.SHIFT, states[15]));
    put(states[0], g.ID, new SRAct(SRAct.SHIFT, states[3]));
    put(states[0], g.READ, new SRAct(SRAct.SHIFT, states[1]));
    put(states[0], g.WRITE, new SRAct(SRAct.SHIFT, states[4]));
    put(states[0], g.program, new SRAct(SRAct.SHIFT, states[29]));

    // State 1

    put(states[1], g.ID, new SRAct(SRAct.SHIFT, states[16]));

    // State 2

    put(states[2], g.stmt, new SRAct(SRAct.SHIFT, states[17]));
    put(states[2], g.ID, new SRAct(SRAct.SHIFT, states[3]));
    put(states[2], g.READ, new SRAct(SRAct.SHIFT, states[1]));
    put(states[2], g.WRITE, new SRAct(SRAct.SHIFT, states[4]));
    put(states[2], g.EOF, new SRAct(SRAct.SHIFT, states[18]));
    put(states[2], g.program, new SRAct(SRAct.SHIFT, states[28]));

    // State 3

    put(states[3], g.ASSGN, new SRAct(SRAct.SHIFT, states[5]));

    // State 4

    put(states[4], g.equivalence, new SRAct(SRAct.SHIFT, states[6]));
    put(states[4], g.tail, new SRAct(SRAct.SHIFT, states[7]));
    put(states[4], g.factor, new SRAct(SRAct.SHIFT, states[19]));
    put(states[4], g.ID, new SRAct(SRAct.SHIFT, states[20]));
    put(states[4], g.LITERAL, new SRAct(SRAct.SHIFT, states[21]));
    put(states[4], g.LPAREN, new SRAct(SRAct.SHIFT, states[8]));

    // State 5

    put(states[5], g.equivalence, new SRAct(SRAct.SHIFT, states[9]));
    put(states[5], g.tail, new SRAct(SRAct.SHIFT, states[7]));
    put(states[5], g.factor, new SRAct(SRAct.SHIFT, states[19]));
    put(states[5], g.ID, new SRAct(SRAct.SHIFT, states[20]));
    put(states[5], g.LITERAL, new SRAct(SRAct.SHIFT, states[21]));
    put(states[5], g.LPAREN, new SRAct(SRAct.SHIFT, states[8]));

    // State 6

    put(states[6], g.additionop, new SRAct(SRAct.SHIFT, states[10]));
    put(states[6], g.ID, new SRAct(SRAct.REDUCE, g.rule(6)));
    put(states[6], g.READ, new SRAct(SRAct.REDUCE, g.rule(6)));
    put(states[6], g.WRITE, new SRAct(SRAct.REDUCE, g.rule(6)));
    put(states[6], g.ADD, new SRAct(SRAct.SHIFT, states[22]));
    put(states[6], g.SUB, new SRAct(SRAct.SHIFT, states[23]));
    put(states[6], g.EOF, new SRAct(SRAct.REDUCE, g.rule(6)));

    // State 7

    put(states[7], g.multop, new SRAct(SRAct.SHIFT, states[11]));
    put(states[7], g.ID, new SRAct(SRAct.REDUCE, g.rule(7)));
    put(states[7], g.READ, new SRAct(SRAct.REDUCE, g.rule(7)));
    put(states[7], g.WRITE, new SRAct(SRAct.REDUCE, g.rule(7)));
    put(states[7], g.RPAREN, new SRAct(SRAct.REDUCE, g.rule(7)));
    put(states[7], g.ADD, new SRAct(SRAct.REDUCE, g.rule(7)));
    put(states[7], g.SUB, new SRAct(SRAct.REDUCE, g.rule(7)));
    put(states[7], g.MULT, new SRAct(SRAct.SHIFT, states[24]));
    put(states[7], g.DIVIDE, new SRAct(SRAct.SHIFT, states[25]));
    put(states[7], g.EOF, new SRAct(SRAct.REDUCE, g.rule(7)));

    // State 8

    put(states[8], g.equivalence, new SRAct(SRAct.SHIFT, states[12]));
    put(states[8], g.tail, new SRAct(SRAct.SHIFT, states[7]));
    put(states[8], g.factor, new SRAct(SRAct.SHIFT, states[19]));
    put(states[8], g.ID, new SRAct(SRAct.SHIFT, states[20]));
    put(states[8], g.LITERAL, new SRAct(SRAct.SHIFT, states[21]));
    put(states[5], g.LPAREN, new SRAct(SRAct.SHIFT, states[8]));

    // State 9

    put(states[9], g.additionop, new SRAct(SRAct.SHIFT, states[10]));
    put(states[9], g.ID, new SRAct(SRAct.REDUCE, g.rule(4)));
    put(states[9], g.READ, new SRAct(SRAct.REDUCE, g.rule(4)));
    put(states[9], g.WRITE, new SRAct(SRAct.REDUCE, g.rule(4)));
    put(states[9], g.ADD, new SRAct(SRAct.SHIFT, states[22]));
    put(states[9], g.SUB, new SRAct(SRAct.SHIFT, states[23]));
    put(states[9], g.EOF, new SRAct(SRAct.REDUCE, g.rule(4)));

    // State 10

    put(states[10], g.tail, new SRAct(SRAct.SHIFT, states[13]));
    put(states[10], g.factor, new SRAct(SRAct.SHIFT, states[19]));
    put(states[10], g.ID, new SRAct(SRAct.SHIFT, states[20]));
    put(states[10], g.LITERAL, new SRAct(SRAct.SHIFT, states[21]));
    put(states[10], g.LPAREN, new SRAct(SRAct.SHIFT, states[8]));

    // State 11

    put(states[11], g.factor, new SRAct(SRAct.SHIFT, states[26]));
    put(states[11], g.ID, new SRAct(SRAct.SHIFT, states[20]));
    put(states[11], g.LITERAL, new SRAct(SRAct.SHIFT, states[21]));
    put(states[11], g.LPAREN, new SRAct(SRAct.SHIFT, states[8]));

    // State 12

    put(states[12], g.additionop, new SRAct(SRAct.SHIFT, states[10]));
    put(states[12], g.RPAREN, new SRAct(SRAct.SHIFT, states[27]));
    put(states[12], g.ADD, new SRAct(SRAct.SHIFT, states[22]));
    put(states[12], g.SUB, new SRAct(SRAct.SHIFT, states[23]));

    // State 13

    put(states[13], g.multop, new SRAct(SRAct.SHIFT, states[11]));
    put(states[13], g.ID, new SRAct(SRAct.REDUCE, g.rule(8)));
    put(states[13], g.READ, new SRAct(SRAct.REDUCE, g.rule(8)));
    put(states[13], g.WRITE, new SRAct(SRAct.REDUCE, g.rule(8)));
    put(states[13], g.RPAREN, new SRAct(SRAct.REDUCE, g.rule(8)));
    put(states[13], g.ADD, new SRAct(SRAct.REDUCE, g.rule(8)));
    put(states[13], g.SUB, new SRAct(SRAct.REDUCE, g.rule(8)));
    put(states[13], g.MULT, new SRAct(SRAct.SHIFT, states[24]));
    put(states[13], g.DIVIDE, new SRAct(SRAct.SHIFT, states[25]));
    put(states[13], g.EOF, new SRAct(SRAct.REDUCE, g.rule(8)));

    // REDUCE ONLY STATES

    // State 15

    defaults.put(states[15], new SRAct(SRAct.REDUCE, g.rule(3)));

    // State 16

    defaults.put(states[16], new SRAct(SRAct.REDUCE, g.rule(5)));

    // State 17

    defaults.put(states[17], new SRAct(SRAct.REDUCE, g.rule(2)));

    // State 18

    defaults.put(states[18], new SRAct(SRAct.REDUCE, g.rule(1)));

    // State 19

    defaults.put(states[19], new SRAct(SRAct.REDUCE, g.rule(9)));

    // State 20

    defaults.put(states[20], new SRAct(SRAct.REDUCE, g.rule(12)));

    // State 21

    defaults.put(states[21], new SRAct(SRAct.REDUCE, g.rule(13)));

    // State 22

    defaults.put(states[22], new SRAct(SRAct.REDUCE, g.rule(14)));

    // State 23

    defaults.put(states[23], new SRAct(SRAct.REDUCE, g.rule(15)));

    // State 24

    defaults.put(states[24], new SRAct(SRAct.REDUCE, g.rule(16)));

    // State 25

    defaults.put(states[25], new SRAct(SRAct.REDUCE, g.rule(17)));

    // State 26

    defaults.put(states[26], new SRAct(SRAct.REDUCE, g.rule(10)));

    // State 27

    defaults.put(states[27], new SRAct(SRAct.REDUCE, g.rule(11)));

    // State 28

    defaults.put(states[28], new SRAct(SRAct.REDUCE, g.rule(1)));

    // State 29

    defaults.put(states[29], new SRAct(SRAct.REDUCE, g.rule(0)));

  }

  static final int N_STATES = 30;
}