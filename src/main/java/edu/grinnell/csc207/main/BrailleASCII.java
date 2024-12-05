package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BrailleAsciiTables;
import java.io.PrintWriter;

/**
 * Main UI for braille to ascii converter.
 *
 * @author Harrison Zhu
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Main method.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    switch (args[0]) {
      case "ascii": // braille to ascii, 6 character substrings
        if (args[1].length() % 6 != 0) {
          pen.print("Invalid length of bit string");
        } else {
          for (int i = 0; i < args[1].length(); i += 6) {
            pen.print(BrailleAsciiTables.toAscii(args[1].substring(i, i + 6)));
          } // for
        } // if else
        break;
      case "unicode": // string to unicode braille
        for (char c : args[1].toCharArray()) {
          String braille = BrailleAsciiTables.toBraille(c);
          String unicode = BrailleAsciiTables.toUnicode(braille);
          pen.print((char) Integer.parseUnsignedInt(unicode, 16));
        } // for
        break;
      case "braille": // ascii to braille
        for (char c : args[1].toCharArray()) {
          try {
            pen.print(BrailleAsciiTables.toBraille(c));
          } catch (Exception e) {
            pen.print("\nTrouble translating because No corresponding value");
            pen.print(e);
            break;
          } // try catch
        } // for
        break;
      default:
        break;
    } // switch

    pen.println();
    pen.close();
  } // main(String[]
} // class BrailleASCII
