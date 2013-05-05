package com.ds.tree;

/**
 *
 */
public interface Children<D,C> {
    Node<D,C> getChild(D data);
    void setChild(D oldData, Node<D,C> nodeWithNewData);
}
