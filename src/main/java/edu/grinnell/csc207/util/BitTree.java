package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Your Name Here
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  private final BitTreeInteriorNode<String> root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    root = new BitTreeInteriorNode<String>();
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *
   */
  public void set(String bits, String value) {
    BitTreeNode<String> node = traverse(bits.substring(0, bits.length() - 1));
    char c = bits.charAt(bits.length() - 1);
    if(c == '0') { 
      node.setLeft(new BitTreeLeaf<String>(bits, value));
    } else { 
      node.setRight(new BitTreeLeaf<String>(bits, value));
    }
  } // set(String, String)

  /**
   *
   */
  public String get(String bits) {
    BitTreeNode<String> node = traverse(bits);
    if(node == null) { 
      return null;
    }

    return node.getValue();
  } // get(String, String)

  private BitTreeNode<String> traverse(String bits) { 
    BitTreeNode<String> current = root;
    for(int i = 0; i < bits.length() || current == null; ++i) { 
      char c = bits.charAt(i);
      if(c == '0') { // 0
        if(current.getLeft() == null) { 
          current.setLeft(new BitTreeInteriorNode<String>());
        }
        current = current.getLeft();
      } else { // 1
        if(current.getRight() == null) { 
          current.setRight(new BitTreeInteriorNode<String>());
        }
        current = current.getRight();
      }
    }

    return current;
  }

  /**
   *
   */
  public void dump(PrintWriter pen) {
    pen.println(root.toString());
  } // dump(PrintWriter)

  /**
   * Loads the data in comma separated format.
   * bits, value
   */
  public void load(InputStream source) {
    Scanner scan = new Scanner(source);
    while(scan.hasNextLine()) { 
      String[] keyValuePair = scan.nextLine().split(",");
      String key = keyValuePair[0];
      String value = keyValuePair[1];

      set(key, value);
    }

    scan.close();
  } // load(InputStream)

} // class BitTree
