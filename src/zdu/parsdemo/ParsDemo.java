/*

File:	 ParsDemo.java
Original Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
"97/06/27 20:37:26 umrigar"

Update Author: David Gordon Bacon (DBacon89@hotmail.com)
Last Updated: 07/27/22 19:33:00


This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html
      

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;



import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * Play and display different parsing algorithms in action.
 * 
 * /**
 * Accepts a single argument specifying which algorithm to run.
 * While this was once an applet it has been converted to a stand alone app
 * where
 * the user can select grammars to parse with a drop down menu.
 */
public class ParsDemo extends JFrame implements Runnable, ActionListener, WindowListener {

   public ParsDemo(int alg) {

      this.setSize(WIDTH, HEIGHT);

      menuBar = new JMenuBar();
      fileMenu = new JMenu("Algorithm");

      Rec = new JMenuItem("Recursive Descent");
      LL = new JMenuItem("LL");
      SR = new JMenuItem("SR");

      Rec.addActionListener(this);
      LL.addActionListener(this);
      SR.addActionListener(this);

      fileMenu.add(Rec);
      fileMenu.add(LL);
      fileMenu.add(SR);

      menuBar.add(fileMenu);

      Font font = new Font("Plain", Font.ROMAN_BASELINE, 13);

      super.setFont(font);

      setGrammar(alg);

      addWindowListener(this);
      resizeButton = new JButton("increase tree window");
      resizeButton.addActionListener(this);
      updateButton = new JButton("update");
      updateButton.addActionListener(this);
      inputField = new JTextField(INIT_INPUT, 50);
      startStepButton = new JButton("step");
      startStepButton.addActionListener(this);
      runStopButton = new JButton("run");
      runStopButton.addActionListener(this);
      runDelayScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 10, 1, 7, 13);
      updateRunDelay();

      setComponents();

   }

   @Override
   public void paint(Graphics g) {
      Dimension d = getSize();
      Dimension m = getMaximumSize();
      boolean resize = d.width > m.width || d.height > m.height;
      d.width = Math.min(m.width, d.width);
      d.height = Math.min(m.height, d.height);
      if (resize) {
         Point p = getLocation();
         setVisible(false);
         setSize(d);
         setLocation(p);
         setVisible(true);
      }
      super.paint(g);
   }

   private void updateRunDelay() {
      runDelay = 1000 * (1 << 10) / (1 << runDelayScrollbar.getValue());
   }

   private void doRun() {
      startStepButton.setEnabled(false);
      runStopButton.setText("stop");
      if (!isStarted)
         doStart();
      Thread loopThread = new Thread(this);
      loopThread.start();
   }

   public void run() {
      if (Thread.currentThread() == flashThread) {
         doFlash();
      } else {
         doLoop();
      }
   }

   void doLoop() {
      do {
         try {
            Thread.sleep(runDelay);
         } catch (InterruptedException e) {
         }
         doStep();
      } while (isStarted && runStopButton.getText().equals("stop"));
      startStepButton.setEnabled(true);
      startStepButton.setText("start");
      runStopButton.setText("run");

   }

   void doFlash() {
      startStepButton.setEnabled(false);
      runStopButton.setEnabled(false);

      for (int i = 0; i < N_FLASH; i++) {
         try {

            startStepButton.setEnabled(false);
            ;
            repaint();
            Thread.sleep(FLASH_DELAY);
            startStepButton.setEnabled(false);
            repaint();
            Thread.sleep(FLASH_DELAY);
         } catch (InterruptedException e) {
         }
      }
      startStepButton.setEnabled(true);
      runStopButton.setEnabled(true);
      ;
   }

   private void doStart() {
      if (isStarted) {
         parser.reset();
         prgTableCanvas.reset();

      }
      startStepButton.setText("step");
      parseDisplay.reset();
      scanner.reset(inputField.getText());
      isStarted = true;
      runStopButton.setEnabled(true);
      parserThread = new Thread(parser, "Parser");
      parserThread.start();
   }

   private void doStop() {
      runStopButton.setText("run");
   }

   private void doStep() {
      isStarted = parser.step();
      if (!isStarted) {
         flashThread = new Thread(this);
         flashThread.start();
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == startStepButton && startStepButton.getText().equals("step")) {
         doStep();
      } else if (e.getSource() == startStepButton && startStepButton.getText().equals("start")) {
         doStart();
      } else if (e.getSource() == runStopButton && runStopButton.getText().equals("run")) {
         doRun();
      } else if (e.getSource() == runStopButton && runStopButton.getText().equals("stop")) {
         doStop();
      } else if (e.getSource() == Rec) {

         removeComponents();
         setGrammar(REC_DESCENT_PARSER);
         setComponents();
         doStart();

      } else if (e.getSource() == LL) {

         removeComponents();
         setGrammar(LL_PARSER);
         setComponents();
         doStart();

      } else if (e.getSource() == SR) {

         removeComponents();
         setGrammar(SR_PARSER);
         setComponents();
         doStart();

      } else if (e.getSource() == updateButton) {

         doStart();
         parser.reset();
         doStep();
      }
      else if (e.getSource()==resizeButton){
         resizeTree();
      }
      

   }

  

   public void windowClosing(WindowEvent e) {
      System.exit(0);

   }

   public void windowClosed(WindowEvent e) {

   }

   public void windowOpened(WindowEvent e) {

   }

   public void windowIconified(WindowEvent e) {

   }

   public void windowDeiconified(WindowEvent e) {

   }

   public void windowActivated(WindowEvent e) {

   }

   public void windowDeactivated(WindowEvent e) {

   }

   public void windowGainedFocus(WindowEvent e) {

   }

   public void windowLostFocus(WindowEvent e) {

   }

   public void windowStateChanged(WindowEvent e) {

   }

   private void removeComponents() {

      this.getContentPane().remove(treeCanvas.getComponent());
      this.getContentPane().remove(traceCanvas.getComponent());
      this.getContentPane().remove(prgTableCanvas.getComponent());

      this.getContentPane().remove(updateButton);
      this.getContentPane().remove(resizeButton);
      this.getContentPane().remove(inputField);
      this.getContentPane().remove(startStepButton);

      this.getContentPane().remove(runStopButton);
      this.getContentPane().remove(runDelayScrollbar);
      this.getContentPane().remove(menuBar);
      this.getContentPane().remove(menuBar);

      this.invalidate();
      this.validate();
   }

   private void setComponents() {

      GridBagLayout layout = new GridBagLayout();
      this.setLayout(layout);
      GridBagConstraints c = new GridBagConstraints();
  
      c.gridx = 0;
      c.gridy = 5;
      c.weightx = 100;
      c.weighty = 25;
      c.gridheight = 100;
      c.gridwidth = GridBagConstraints.REMAINDER;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.NORTH;
      layout.setConstraints(treeCanvas.getComponent(), c);
      add(treeCanvas.getComponent());

      c.gridx = 0;
      c.gridy = 50;
      c.weightx = 100;
      c.weighty = 25;
      c.gridheight = 40;
      c.gridwidth = 50;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.SOUTHWEST;
      layout.setConstraints(prgTableCanvas.getComponent(), c);
      add(prgTableCanvas.getComponent());

      c.gridx = 55;
      c.gridy = 50;
      c.weightx = 100;
      c.weighty = 25;
      c.gridheight = 40;
      c.gridwidth = GridBagConstraints.REMAINDER;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.SOUTHEAST;
      layout.setConstraints(traceCanvas.getComponent(), c);
      add(traceCanvas.getComponent());

      c.gridx = 0;
      c.gridy = 95;
      c.weightx = 0;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 8;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(updateButton, c);
      add(updateButton);

      c.gridx = 10;
      c.gridy = 95;
      c.weightx = 0;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 8;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(resizeButton, c);
      add(resizeButton);

      c.gridx = 45;
      c.gridy = 95;
      c.weightx = 100;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 65;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(inputField, c);
      add(inputField);

      c.gridx = 70;
      c.gridy = 95;
      c.weightx = 0;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 8;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(startStepButton, c);
      add(startStepButton);

      c.gridx = 80;
      c.gridy = 95;
      c.weightx = 0;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 8;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(runStopButton, c);
      add(runStopButton);

      c.gridx = 90;
      c.gridy = 95;
      c.weightx = 0;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 8;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(runDelayScrollbar, c);
      add(runDelayScrollbar);

      c.gridx = 98;
      c.gridy = 95;
      c.weightx = 0;
      c.weighty = 0;
      c.gridheight = 5;
      c.gridwidth = 8;
      c.fill = GridBagConstraints.RELATIVE;
      c.anchor = GridBagConstraints.WEST;
      layout.setConstraints(menuBar, c);
      
      add(menuBar);
      this.invalidate();
      this.validate();

      
   }

   private void resizeTree() {
      if (TREE_HEIGHT == .4)
          TREE_HEIGHT =.8;
       else  
          TREE_HEIGHT=.4;

      SELECT_HEIGHT=(1-TREE_HEIGHT);
      TRACE_HEIGHT=(1-TREE_HEIGHT);
       //To-Do add update canvas height
      //  treeCanvas.repaint();
    }
   private void setGrammar(int algorithm) {
      scanner = new ExtendedScanner();

      if (algorithm == REC_DESCENT_PARSER) {
         InputStream i = System.in;

         try {
            i = new FileInputStream(fName);
         } catch (IOException e) {
            System.err.println("Could not open file " + fName);
            System.exit(1);
         }
         scanner = new ExtendedScanner();

         BufferedReader d = new BufferedReader(new InputStreamReader(i));

         prgTableCanvas = new FileCanvas(d, (int) (SELECT_WIDTH * WIDTH), (int) (SELECT_HEIGHT * HEIGHT),
               "Recursive-Descent Parsing Program");
         treeCanvas = new TreeCanvas((int) (TREE_WIDTH * WIDTH), (int) (TREE_HEIGHT * HEIGHT),
               "Recursive Descent Parse Tree");
         traceCanvas = new TraceCanvas((int) (TRACE_WIDTH * WIDTH), (int) (TRACE_HEIGHT * HEIGHT),
               "Recursive Descent Trace Stack");

         ExtendedLL1Gram grammar = new ExtendedLL1Gram();

         parseDisplay = new ParseDisplay(treeCanvas, prgTableCanvas, traceCanvas);
         parser = new ExtendedRecDescent(grammar, scanner, parseDisplay);
         this.setTitle("Recursive Descent Parser");

      } else if (algorithm == LL_PARSER) {

         ExtendedLL1Gram grammar = new ExtendedLL1Gram();
         Table2 llTab = new ExtendedLL1Table(grammar);
         prgTableCanvas = new Table2Canvas(llTab,
               (int) (SELECT_WIDTH * WIDTH), (int) (SELECT_HEIGHT * HEIGHT),
               "LL(1) Parsing Table");
         treeCanvas = new TreeCanvas((int) (TREE_WIDTH * WIDTH), (int) (TREE_HEIGHT * HEIGHT), "LL1 Parse Tree");
         traceCanvas = new TraceCanvas((int) (TRACE_WIDTH * WIDTH), (int) (TRACE_HEIGHT * HEIGHT), "LL1 Trace Stack");

         parseDisplay = new ParseDisplay(treeCanvas, prgTableCanvas, traceCanvas);
         parser = new LL1Parser(grammar, llTab, scanner, parseDisplay);
         this.setTitle("LL1 Parser");

      } else if (algorithm == SR_PARSER) {

         ExtendedSRGram grammar = new ExtendedSRGram();
         SRTable srTab = new ExtendedSRTable(grammar);
         prgTableCanvas = new Table2Canvas(srTab,
               (int) (SELECT_WIDTH * WIDTH), (int) (SELECT_HEIGHT * HEIGHT),
               "Shift-Reduce Parsing Table");
         treeCanvas = new TreeCanvas((int) (TREE_WIDTH * WIDTH), (int) (TREE_HEIGHT * HEIGHT), "SR Parse Tree");
         traceCanvas = new TraceCanvas((int) (TRACE_WIDTH * WIDTH), (int) (TRACE_HEIGHT * HEIGHT), "SR Trace Stack");

         parseDisplay = new ParseDisplay(treeCanvas, prgTableCanvas, traceCanvas);
         parser = new SRParser(grammar, srTab, scanner, parseDisplay);
         this.setTitle("SR Parser");

      } else {
         System.out.print("Error No algorithm specified.\n");
      }
   }

   static public void main(String args[]) {

     

      ParsDemo app = new ParsDemo(1);
      app.doStart();
      app.setVisible(true);

   }

   private int runDelay;
   private ScrollableCanvas prgTableCanvas;
   private TreeCanvas treeCanvas;
   private TraceCanvas traceCanvas;
   private JButton updateButton;
    private JButton resizeButton;
   private JTextField inputField;
   private JButton startStepButton;
   private JButton runStopButton;
   private JScrollBar runDelayScrollbar;
   private StepParser parser;
   private Thread parserThread;
   private zdu.parsdemo.Scanner scanner;
   private ParseDisplay parseDisplay;
   private boolean isStarted;
   private Thread flashThread;
   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenuItem Rec, LL, SR;
   private int REC_DESCENT_PARSER = 0;
   private int LL_PARSER = 1;
   private int SR_PARSER = 2;
   private final String fName = "SimpCompRecDescent.txt";
   private static  double TREE_WIDTH = 0.9;
   private   double TREE_HEIGHT = 0.4;
   private   double SELECT_WIDTH = 0.6;
   private static  double SELECT_HEIGHT = 0.4;
   private static  double TRACE_WIDTH = 0.3;
   private   double TRACE_HEIGHT = 0.4;
   private static final String INIT_INPUT = "Read A Read B sum := A+B Write sum Write sum/2";
   private static final int FLASH_DELAY = 1000;
   private static final int N_FLASH = 2;
   private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   private static final int HEIGHT = (int) screenSize.getHeight();
   private static final int WIDTH = (int) screenSize.getWidth();
}
