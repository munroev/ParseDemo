/*

File:	 TraceCanvas.java
Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
Last Update Time-stamp: "97/06/27 20:41:00 umrigar"

This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;

import zdu.parsdemo.ScrollableCanvas;
import zdu.parsdemo.Trace;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This canvas displays successive trace lines. Each trace line consists
 * of a stack dump followed by a dump of the remaining input. The canvas
 * tries to center the boundary between the stack and input in the canvas.
 * BUG: breaks if tabs are displayed, since the FontMetrics class seems
 * to return a wrong width for tabs.
 */
class TraceCanvas extends ScrollableCanvas {

  TraceCanvas(int width, int height, String mouseHint) {
    super(width, height, mouseHint == null ? null : ""); // non-null hint message to enable hints.
    hintMsg= mouseHint; 
    reset();
  }

  public void setFont(Font f) {
    super.setFont(f);
    updateFlags |= (SCROLL_UPDATE | PARAM_UPDATE);
  }

  public void reset() {

    lines = new ArrayList();
    stkWidth = inputWidth = 0;
    updateFlags |= (SCROLL_UPDATE | PARAM_UPDATE);
  }

  // Recompute max. stkWidth and max. inputWidth by iterating over all lines.
  private void updateParams(FontMetrics m) {

    int nLines = lines.size();
    stkWidth = inputWidth = 0;
    for (int i = 0; i < nLines; i++) {
      Trace trace = (Trace) (lines.get(i));
      int sWidth = m.stringWidth(trace.stk);
      int iWidth = m.stringWidth(trace.input);
      if (sWidth > stkWidth)
        stkWidth = sWidth;
      if (iWidth > inputWidth)
        inputWidth = iWidth;
    }
  }

  private void updateScrollbars(FontMetrics m) {

    Dimension s = getSize();
    int nLines = lines.size();

    hScroll.setUnitIncrement(m.stringWidth("M"));
    hScroll.setBlockIncrement(s.width - SLOP);
    int x = (stkWidth > s.width / 2) ? stkWidth - s.width / 2 : 0;
    hScroll.setValue(x);

    vScroll.setUnitIncrement(m.getHeight());
    vScroll.setBlockIncrement(s.height - m.getHeight());

    if (nLines % 22 == 0) {
      vScroll.setValue(22 + vScroll.getValue());

    }

  }

  // Add a trace line to the canvas, incrementally updating the stkWidth
  // and inputWidth parameters, and set a flag to update scrollbars.
  void addTrace(String stk, String input) {

    lines.add(new Trace(stk, input));
    int nLines = lines.size();
    FontMetrics m = getFontMetrics(getFont());

    int sWidth = m.stringWidth(stk);

    int iWidth = m.stringWidth(input);

    if (sWidth > stkWidth)
      stkWidth = sWidth;
    if (iWidth > inputWidth)
      inputWidth = iWidth;
    int maxH = (lines.size() + 1) * m.getHeight();

    updateFlags |= SCROLL_UPDATE;
  }

  // Return # of trace-lines.
  int nLines() {
    return lines.size();
  }

  // Paint the canvas in the position dictated by the scrollbar values
  // (after updating them if requested via updateFlags).
  public void paintComponent(Graphics g) {

    FontMetrics m = g.getFontMetrics(g.getFont());
    if ((updateFlags & PARAM_UPDATE) != 0) {

      updateParams(m);
      updateFlags &= ~PARAM_UPDATE;
    }
    if ((updateFlags & SCROLL_UPDATE) != 0) {

      updateScrollbars(m);
      updateFlags &= ~SCROLL_UPDATE;
    }
    int fontHeight = m.getHeight();
    Dimension s = getSize();
    g.setColor(contentsBGColor);
    g.fillRect(0, 0, s.width, s.height);

    int nLines = s.height / fontHeight; // # of visible lines.
    int lineLo = vScroll.getValue();
    int lineHi = (lineLo + nLines < lines.size()) ? lineLo + nLines : lines.size();
    g.translate(-hScroll.getValue(), -lineLo * fontHeight);
    Color saveColor = g.getColor();
    for (int i = lineLo; i < lineHi; i++) {
      int y = i * fontHeight + m.getAscent();
      Trace trace = (Trace) lines.get(i);
      String stk = trace.stk;
      String input = trace.input;
      g.setColor(STK_COLOR);
      g.drawString(stk, stkWidth - m.stringWidth(stk), y);
      g.setColor(INPUT_COLOR);
      g.drawString(input, stkWidth, y);
    }
    g.setColor(saveColor);
    update(g);
  }

  Image getHintImage() {

    FontMetrics m = getFontMetrics(getFont());
    Dimension s = getSize();
    if (hintMsg != null && hintMsg.length() > 0 &&
          (hintBuf == null || hintBufDim.width != s.width ||
                hintBufDim.height != m.getHeight())) {
       hintBufDim = new Dimension(s.width, m.getHeight());
       hintBuf = createImage(hintBufDim.width, hintBufDim.height);
       Graphics g = hintBuf.getGraphics();
       g.setColor(HINT_BG_COLOR);
       g.fillRect(0, 0, s.width, m.getHeight());
       g.setColor(HINT_FG_COLOR);
       int x = (s.width - m.stringWidth(hintMsg)) / 2;
       g.drawString(hintMsg, x, m.getAscent());
    }
    return hintBuf;
  }

  private int updateFlags; // nonzero if update needed.
  private ArrayList lines; // trace lines.
  private int stkWidth; // max. stk width (in pixels).
  private int inputWidth; // max. input width (in pixels).
  private Image hintBuf; // buffer for hint message.
  private Dimension hintBufDim; // dimensions of allocated hint buf.
  private String hintMsg;	
  // update flags.
  static final private int SCROLL_UPDATE = 0x1;
  static final private int PARAM_UPDATE = 0x2;

  // fixed colors used for display.
  static final private Color STK_COLOR = Color.green;
  static final private Color INPUT_COLOR = Color.black;
  private int scroll = 0;
  // String used for hints.
  static final private String STK_HINT = "Stack";
  static final private String INPUT_HINT = "Rest Input";
  static final private String ALT_INPUT_HINT = "Input";
  private static final Color HINT_BG_COLOR = Color.yellow;
  private static final Color HINT_FG_COLOR = Color.black;
  static private final Color contentsBGColor = Color.white;

}
