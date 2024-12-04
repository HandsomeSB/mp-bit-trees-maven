package edu.grinnell.csc207.main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import edu.grinnell.csc207.util.BitTree;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   *
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // letter -> bits/ASCII -> braille
    // STUB
    BitTree bt = new BitTree(6);
    //https://stackoverflow.com/questions/782178/how-do-i-convert-a-string-to-an-inputstream-in-java
    InputStream inputStream = new ByteArrayInputStream(BrailleAsciiTables.getA2BTable().getBytes(StandardCharsets.UTF_8));
    bt.load(inputStream);
    bt.dump(pen);
    pen.println(bt.get("00100000"));

    pen.println(BrailleAsciiTables.toBraille('h')); 
    pen.println(BrailleAsciiTables.toAscii("110010"));
    pen.println(BrailleAsciiTables.toUnicode("110010"));








    
    pen.close();
  } // main(String[]

} // class BrailleASCII
