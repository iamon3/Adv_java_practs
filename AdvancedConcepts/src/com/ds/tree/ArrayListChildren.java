package com.ds.tree;

import com.sun.org.apache.xpath.internal.NodeSet;

import java.util.ArrayList;

/**
 *
 */
public class ArrayListChildren<D,ArrayListChildren> implements Children<D,ArrayListChildren> {
    ArrayList<Node<D,ArrayListChildren>> children = new ArrayList<Node<D,ArrayListChildren>>();

    @Override
    public Node<D,ArrayListChildren> getChild(D data) {
        return null;
    }

    @Override
    public void setChild(D oldData, Node<D,ArrayListChildren> nodeWithNewData) {

    }

    @Override
    public void addChild(Node<D,ArrayListChildren> nodeWithNewData) {

    }
}
