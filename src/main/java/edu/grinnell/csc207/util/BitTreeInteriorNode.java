package edu.grinnell.csc207.util;

/**
 * This is a interior node of a BitTree. It does not contain any values, but contains references to
 * other nodes.
 *
 * @author Harrison Zhu
 * @param <T> The type of data the bit tree contains.
 */
public class BitTreeInteriorNode<T> implements BitTreeNode<T> {
  /** left node. */
  BitTreeNode<T> left;

  /** right node. */
  BitTreeNode<T> right;

  /**
   * Get the left node.
   *
   * @return left node
   */
  public BitTreeNode<T> getLeft() {
    return left;
  } // getLeft

  /**
   * Gets the right node.
   *
   * @return right node
   */
  public BitTreeNode<T> getRight() {
    return right;
  } // getRight

  /**
   * Set the left node.
   *
   * @param node new node to set
   */
  public void setLeft(BitTreeNode<T> node) {
    this.left = node;
  } // setLeft

  /**
   * Set the right node.
   *
   * @param node new node to set
   */
  public void setRight(BitTreeNode<T> node) {
    this.right = node;
  } // setRight

  /**
   * Get value contained by the node.
   *
   * @return value
   */
  public T getValue() {
    return null;
  } // getValue

  /**
   * Returns a string representation of the node.
   *
   * @return String
   */
  public String toString() {
    String str = "";
    if (left != null) {
      str += this.left.toString();
    } // if
    if (right != null) {
      str += this.right.toString();
    } // if
    return str;
  } // toString
} // class BitTreeInteriorNode
