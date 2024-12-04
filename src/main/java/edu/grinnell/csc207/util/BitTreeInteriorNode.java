package edu.grinnell.csc207.util;

public class BitTreeInteriorNode<T> implements BitTreeNode<T>{
    BitTreeNode<T> left;
    BitTreeNode<T> right;

    public BitTreeNode<T> getLeft() {
        return left;
    }

    public BitTreeNode<T> getRight() {
        return right;
    }

    public void setLeft(BitTreeNode<T> node) {
        this.left = node;
    }

    public void setRight(BitTreeNode<T> node) {
        this.right = node;
    }

    public T getValue() { 
        return null;
    }

    public String toString() { 
        String str = "";
        if(left != null) { 
            str += this.left.toString();
        }
        if(right != null) { 
            str += this.right.toString();
        }
        return str;
    }
}
