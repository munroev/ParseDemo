/*

File:	 ScrollableCanvas.java
Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
Last Update Time-stamp: "97/06/27 20:40:41 umrigar"

This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Implements a scrollable canvas with two scrollbars, which can be controlled
 * directly by subclasses.
 * 
 * IMPORTANT NOTE: When this canvas is to be added to a component, the
 * canvas should not be directly added; instead its getComponent() member
 * should be added
 */
class ScrollableCanvas extends JPanel implements Runnable, MouseListener {

   /**
    * Create a canvas with size width x height pixels.
    * 
    * @param width  width of canvas in pixels.
    * @param height height of canvas in pixels.
    */
   ScrollableCanvas(int width, int height, String mouseHint) {

      super.setFont(UIManager.getFont("fontKey"));
      initSize = new Dimension(width, height);
      setPreferredSize(initSize);

      hScroll = new JScrollBar(Scrollbar.HORIZONTAL, 0, 1, 0, width);
      hScroll.setUnitIncrement(width / 20 < 0 ? 0 : width / 20);
      hScroll.setBlockIncrement(width - SLOP < 0 ? width : width - SLOP);

      vScroll = new JScrollBar(Scrollbar.VERTICAL, 0, 1, 0, height);
      vScroll.setUnitIncrement(height / 20 < 0 ? 0 : height / 20);
      vScroll.setBlockIncrement(height - SLOP < 1 ? height : height - SLOP);
      
      //These event listeners allow free scrolling independent of the parsing animation
      hScroll.addAdjustmentListener(new AdjustmentListener() {
         public void adjustmentValueChanged(AdjustmentEvent ae) {

            repaint();
            invalidate();
            validate();

         }
      });

      vScroll.addAdjustmentListener(new AdjustmentListener() {
         public void adjustmentValueChanged(AdjustmentEvent ae) {

            repaint();
            invalidate();
            validate();

         }
      });

      panel = new ScrollPanel(this, hScroll, vScroll);

      hintMsg = mouseHint;
      addMouseListener(this);
   }

   ScrollableCanvas(int width, int height) {
      this(width, height, null);
   }

   // Return creation size as minimum size if requested by packer.
   public Dimension getMinimumSize() {
      return initSize;
   }

   // Return creation size as preferred size if requested by packer.
   public Dimension getpreferredSize() {
      return initSize;
   }

   public void update(Graphics g) {

      Dimension s = getSize();

      if (buf == null || bufDim.width != s.width || bufDim.height != s.height) {
         bufDim = new Dimension(s.width, s.height);
         buf = createImage(bufDim.width, bufDim.height);
      }

      if (hintThread != null) {
         Image hintImage = getHintImage();
         if (hintImage != null)
            g.drawImage(hintImage, 0, 0, null);
      }

   }

   // IMPORTANT: This is the method which must be used if this is to be
   // added to a container; i.e., if logically, this is to be added to
   // a container, then add this.getComponent().
   public JPanel getComponent() {
      return panel;
   }

   // Entered via a hint thread.
   public void run() {
      try {
         Thread.sleep(HINT_DELAY);
      } catch (InterruptedException e) {
      }
      setHintThread(false, true);
   }

   public void reset() {
   }

   // The somewhat complex logic here ensures that only a single hintThread
   // is being used to paint the hint message and that if a old discarded
   // thread terminates after a new one was spawned, then the termination
   // of the old thread does not also terminate the newer one (until its
   // time has expired).
   private synchronized void setHintThread(boolean doCreate,
         boolean calledFromHintThread) {

      if (doCreate) {
         if (hintThread == null) {
            hintThread = new Thread(this);
            hintThread.start();

            repaint();

         }
      } else {
         if (hintThread != null) {
            if (calledFromHintThread) {
               if (hintThread == Thread.currentThread()) {
                  hintThread = null;

                  repaint();

               }
            } else {
               hintThread.interrupt();
               hintThread = null;

               repaint();

            }
         }
      }
   }

   public void mouseEntered(MouseEvent e) {
      if (hintMsg != null) {
         setHintThread(true, false);

      }

   }

   public void mouseExited(MouseEvent e) {
      if (hintMsg != null) {
         setHintThread(false, false);

      }

   }

   public void mouseReleased(MouseEvent e) {

   }

   public void mousePressed(MouseEvent e) {

   }

   public void mouseClicked(MouseEvent e) {

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

   protected JScrollBar hScroll;
   protected JScrollBar vScroll; // the raison d'etre for this.

   protected static final int SLOP = 10; // # of extra scroll pixels.
   private Image buf; // for double buffering.
   private Dimension bufDim; // dimensions of allocated buf.
   private Image hintBuf; // buffer for hint message.
   private Dimension hintBufDim; // dimensions of allocated hint buf.
   private Dimension initSize; // size requested at creation.
   private ScrollPanel panel; // contains scrollbars + this.
   private Thread hintThread; // non-null if hint being displayed.
   private String hintMsg; // hint msg. to output on top of canvas.
   private static final Color HINT_BG_COLOR = Color.yellow;
   private static final Color HINT_FG_COLOR = Color.black;
   private static final int HINT_DELAY = 10000;

}
