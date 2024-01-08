/*

File:	 ParseDisplay.java
Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
Last Update Time-stamp: "97/06/27 20:37:58 umrigar"

This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;
import javax.swing.JComponent;


class ParseDisplay {

  ParseDisplay(TreeCanvas treeCanvas, ScrollableCanvas prgTableCanvas,
	       TraceCanvas traceCanvas) {
         
    this.treeCanvas= treeCanvas;
    this.prgTableCanvas= prgTableCanvas;
    this.traceCanvas= traceCanvas;

  }

  void update(OffsetForest forest, Object xSelect, Object ySelect,
	      OffsetTree treeSelect, 
	      String stk, String input, String extFrameTag) {
        
    treeCanvas.setForest(forest);
    ((Selectable)treeCanvas).select(treeSelect, null);
    ((Selectable)prgTableCanvas).select(xSelect, ySelect);
    traceCanvas.addTrace(stk, input);
    
    treeCanvas.repaint();
    prgTableCanvas.repaint();
    traceCanvas.repaint();
  }

  void reset() {
   
    traceCanvas.reset();
    treeCanvas.reset();
    prgTableCanvas.reset();
  }

  private TreeCanvas treeCanvas;
  private ScrollableCanvas prgTableCanvas;
  private TraceCanvas traceCanvas;
 
}
