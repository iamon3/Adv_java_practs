package com.ds.tree;

/**
 *
 */
public class Node<D, C> {
    D data;
    C children;

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public C getChildren() {
        return children;
    }

    public void setChildren(C children) {
        this.children = children;
    }
}
