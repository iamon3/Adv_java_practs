package com.ds.linkedList.myOwn;

public class GenericNode<E> {
	private E data;
	private GenericNode<E> next;

	public boolean hasNext(){
		if(this.next != null)
			return true;
		return false;
	}

	public GenericNode(E element) {
		// TODO Auto-generated constructor stub
		this.data = element;
		this.next = null;
	}
	public E getData(){
		return this.data;
	}
	public GenericNode<E> getNextNode(){
		return this.next;
	}
	public void setNextNode(GenericNode<E> nextNode){
		this.next = nextNode;
	}
	public void setData(E newNode){
		this.data = newNode;
	}
}
