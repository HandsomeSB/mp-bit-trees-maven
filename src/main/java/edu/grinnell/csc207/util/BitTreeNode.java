package edu.grinnell.csc207.util;

/**
 * Represents a single node in the bit tree.
 *
 * @author Harrison Zhu
 * @param <T> The type of data the tree contains.
 */
public interface BitTreeNode<T> {
  /**
   * Get the left node.
   *
   * @return left node
   */
  public BitTreeNode<T> getLeft();

  /**
   * Gets the right node.
   *
   * @return right node
   */
  public BitTreeNode<T> getRight();

  /**
   * Set the left node.
   *
   * @param node new node to set
   */
  public void setLeft(BitTreeNode<T> node);

  /**
   * Set the right node.
   *
   * @param node new node to set
   */
  public void setRight(BitTreeNode<T> node);

  /**
   * Get value contained by the node.
   *
   * @return value
   */
  public T getValue();
} // class BitTreeNode
