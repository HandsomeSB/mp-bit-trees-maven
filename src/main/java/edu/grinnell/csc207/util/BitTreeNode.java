package edu.grinnell.csc207.util;

/**
 * Represents a single node in the bit tree.
 */
public interface BitTreeNode<T> {
    public BitTreeNode<T> getLeft();
    public BitTreeNode<T> getRight();
    public void setLeft(BitTreeNode<T> node);
    public void setRight(BitTreeNode<T> node);
    public T getValue();
    
} 