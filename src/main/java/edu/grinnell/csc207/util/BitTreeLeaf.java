package edu.grinnell.csc207.util;

/**
 * The leaf of a bit tree. Contains value and paths. Does not have references to other nodes.
 *
 * @author Harrison Zhu
 * @param <T> The type of data the bit tree contains.
 */
public class BitTreeLeaf<T> implements BitTreeNode<T> {
  /** Path of leaf. */
  String path;

  /** Value of leaf. */
  T value;

  /**
   * Constructs a bit tree leaf.
   *
   * @param path bit path of the leaf
   * @param val values it contains
   */
  public BitTreeLeaf(String path, T val) {
    this.path = path;
    this.value = val;
  } // BitTreeLeaf(String, T)

  /**
   * get the left node.
   *
   * @return left node
   */
  public BitTreeNode<T> getLeft() {
    return null;
  } // getLeft

  /**
   * Gets the right node.
   *
   * @return right node
   */
  public BitTreeNode<T> getRight() {
    return null;
  } // getRight

  /**
   * Set the left node.
   *
   * @param node new node to set
   */
  public void setLeft(BitTreeNode<T> node) {
    return;
  } // setLeft

  /**
   * Set the right node.
   *
   * @param node new node to set
   */
  public void setRight(BitTreeNode<T> node) {
    return;
  } // setRight

  /**
   * Get value contained by the node.
   *
   * @return value
   */
  public T getValue() {
    return value;
  } // getValue

  /**
   * Returns a string representation of the node.
   *
   * @return String
   */
  public String toString() {
    return path + ", " + value + "\n";
  } // toString
} // class BitTreeLeaf
