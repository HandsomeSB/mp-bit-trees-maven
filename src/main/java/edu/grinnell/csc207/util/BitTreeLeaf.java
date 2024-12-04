package edu.grinnell.csc207.util;

public class BitTreeLeaf<T> implements BitTreeNode<T> {
    String path;
    T value;

    public BitTreeLeaf(String path, T val) {
        this.path = path;
        this.value = val;
    }

    public BitTreeNode<T> getLeft() {
        return null;
    }

    public BitTreeNode<T> getRight() {
        return null;
    }

    public void setLeft(BitTreeNode<T> node){ 
        return;
    }

    public void setRight(BitTreeNode<T> node) {
        return;
    }

    public T getValue() { 
        return value;
    }

    public String toString() { 
        return path + ", " + value + "\n";
    }
}
