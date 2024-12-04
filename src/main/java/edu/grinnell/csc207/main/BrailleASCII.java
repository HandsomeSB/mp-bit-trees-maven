package edu.grinnell.csc207.main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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

    switch (args[0]) {
      case "ascii": // braille to ascii, 6 character substrings
        if(args[1].length() % 6 != 0) { 
          pen.print("Invalid length of bit string");
        } else {
          for(int i = 0; i < args[1].length(); i+=6) { 
            pen.print(BrailleAsciiTables.toAscii(args[1].substring(i, i+6)));
          }
        }
        break;
      case "unicode": // string to unicode braille
        for(char c : args[1].toCharArray()) { 
          String braille = BrailleAsciiTables.toBraille(c);
          String unicode = BrailleAsciiTables.toUnicode(braille);
          pen.print((char) Integer.parseUnsignedInt(unicode, 16));
        }
        break;
      case "braille": // ascii to braille
        for(char c : args[1].toCharArray()) { 
          try {
            pen.print(BrailleAsciiTables.toBraille(c));
          } catch (Exception e) {
            pen.print("\nTrouble translating because No corresponding value");
            pen.print(e);
            break;
          } // try catch
        }
        break;
      default:
        break;
    }

    pen.println();
    pen.close();
  } // main(String[]

} // class BrailleASCII
