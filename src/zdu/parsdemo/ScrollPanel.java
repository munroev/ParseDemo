/*

File:	 ScrollPanel.java
Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
Last Update Time-stamp: "97/06/27 20:40:32 umrigar"

This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * A panel containing a canvas, a south and east scrollbars.
 * This class is necessary solely to handle scroll events.
 */
class ScrollPanel extends JPanel {

  ScrollPanel(JPanel canvas, JScrollBar hScroll, JScrollBar vScroll) {
    this.canvas = canvas;
    this.hScroll = hScroll;
    this.vScroll = vScroll;

    setLayout(new BorderLayout());
    add(canvas, BorderLayout.CENTER);
    add(vScroll, BorderLayout.WEST);
    add(hScroll, BorderLayout.SOUTH);

  }

  private JPanel canvas;
  private JScrollBar hScroll;
  private JScrollBar vScroll;

}
