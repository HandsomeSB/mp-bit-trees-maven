package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Harrison Zhu
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /** Root of bit tree. */
  private final BitTreeInteriorNode<String> root;

  /** Max depth of the tree. */
  private final int depth;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructs a bit tree of depths n.
   *
   * @param n max depth
   */
  public BitTree(int n) {
    root = new BitTreeInteriorNode<String>();
    depth = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Helper method to check if the bits path is valid. Bits is not valid if it is not the valid
   * length, or it contains characters other than 0 or 1.
   *
   * @param bits the path to check
   * @throws IndexOutOfBoundsException
   */
  private void checkValidBits(String bits) throws IndexOutOfBoundsException {
    if (bits.length() != depth) {
      throw new IndexOutOfBoundsException("Incorrect length");
    } // if
    // https://stackoverflow.com/questions/10575624/how-do-i-check-if-a-string-contains-only-numbers-and-not-letters
    if (!bits.matches("[0-1]+")) {
      throw new IndexOutOfBoundsException("Invalid bits: " + bits);
    } // if
  } // checkValidBits(String)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) and adds or
   * replaces the value at the end with value. set should throw an IndexOutOfBoundsException if bits
   * is the inappropriate length or contains values other than 0 or 1.
   *
   * @param bits the bits path
   * @param value the value to set
   * @throws IndexOutOfBoundsException
   */
  public void set(String bits, String value) throws IndexOutOfBoundsException {
    checkValidBits(bits);

    BitTreeNode<String> node = traverse(bits.substring(0, bits.length() - 1));
    char c = bits.charAt(bits.length() - 1);
    if (c == '0') {
      node.setLeft(new BitTreeLeaf<String>(bits, value));
    } else {
      node.setRight(new BitTreeLeaf<String>(bits, value));
    } // if else
  } // set(String, String)

  /**
   * Follows the path through the tree given by bits, returning the value at the end. If there is no
   * such path, or if bits is the incorrect length, get should throw an IndexOutOfBoundsException.
   *
   * @param bits the bits path
   * @return the value of the node
   * @throws IndexOutOfBoundsException
   */
  public String get(String bits) throws IndexOutOfBoundsException {
    checkValidBits(bits);

    BitTreeNode<String> node = traverse(bits);
    if (node.getValue() == null) {
      throw new IndexOutOfBoundsException("Value does not exist");
    } // if

    return node.getValue();
  } // get(String, String)

  /**
   * Helper method that traverses based on the bits path passed in. Creates interior nodes as it
   * traverses
   *
   * @param bits The bits path
   * @return The end node it traverses to
   */
  private BitTreeNode<String> traverse(String bits) {
    BitTreeNode<String> current = root;
    for (int i = 0; i < bits.length() || current == null; ++i) {
      char c = bits.charAt(i);
      if (c == '0') { // 0
        if (current.getLeft() == null) {
          current.setLeft(new BitTreeInteriorNode<String>());
        } // if
        current = current.getLeft();
      } else { // 1
        if (current.getRight() == null) {
          current.setRight(new BitTreeInteriorNode<String>());
        } // if
        current = current.getRight();
      } // if else
    } // for

    return current;
  } // traverse(String)

  /**
   * Prints out all the values within the BitTree from left most to the right most.
   *
   * @param pen PrintWriter
   */
  public void dump(PrintWriter pen) {
    pen.println(root.toString());
  } // dump(PrintWriter)

  /**
   * Loads the data in comma separated format. bits, value
   *
   * @param source source of input
   */
  public void load(InputStream source) {
    Scanner scan = new Scanner(source);
    while (scan.hasNextLine()) {
      String[] keyValuePair = scan.nextLine().split(",");
      String key = keyValuePair[0];
      String value = keyValuePair[1];

      set(key, value);
    } // while

    scan.close();
  } // load(InputStream)
} // class BitTree
