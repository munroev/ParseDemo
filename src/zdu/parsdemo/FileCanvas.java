/*

File:	 FileCanvas.java
Author:  zerksis d. umrigar (zdu@acm.org)
Copyright (C) 1997 Zerksis D. Umrigar
Last Update Time-stamp: "97/06/27 20:33:01 umrigar"

This code is distributed under the terms of the GNU General Public License.
See the file COPYING with this distribution, or

		http://www.fsf.org/copyleft/gpl.html

THERE IS ABSOLUTELY NO WARRANTY FOR THIS PROGRAM.

*/

package zdu.parsdemo;

import zdu.parsdemo.TextCanvas;

import java.awt.*;
import java.io.*;

/** Displays the contents of a text-file in a scrollable text-canvas.  The
 * contents are initialized from the file during construction.
 */
class FileCanvas extends TextCanvas {

  /** Create a file-canvas of dimension width x height pixels, with
   * contents initialized by the input-stream d.
   * @param d		input stream for initializing contents.
   * @param width	width of the canvas in pixels.
   * @param height	height of the canvas in pixels.
   */
  FileCanvas(BufferedReader  d, int width, int height, String mouseHint) {
    super(width, height, mouseHint);
    try {
      String line;
      while ((line= d.readLine()) != null)
      { 
     
      addLine(line);
      }
    }
    catch (IOException e) {
      System.err.println("IO Exception");
      System.exit(1);
    }
  }

  FileCanvas(BufferedReader  d, int width, int height) {
    this(d, width, height, null);
  }
  }
