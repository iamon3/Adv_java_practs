package com.ds.linkedList.myOwn;

public class GenericLinkedList<E> {

	private GenericNode<E> head=null;
	private GenericNode<E> tail=null;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		GenericNode<E> temp = this.head;
		
		while(temp != null){
		 sb.append(temp.getData().toString()+" ");
		 temp = temp.getNextNode();
		}
		return sb.toString();
	}

	public GenericNode<E> getHead() {
		return head;
	}

	public void setHead(GenericNode<E> head) {
		this.head = head;
	}

	public GenericNode<E> getTail() {
		return tail;
	}

	public void setTail(GenericNode<E> tail) {
		this.tail = tail;
	}

	public boolean add(E newElementNode) {
		GenericNode<E> newNode = new GenericNode<E>(newElementNode);
		if(isLinkedListEmpty() == true){
			this.head = newNode;
			this.tail = this.head;
		}
		else{
			appendNodeAtEnd(newNode);
		}
		return true;
	}

	private void appendNodeAtEnd(GenericNode<E> newElementNode){
		this.tail.setNextNode(newElementNode);
		this.tail = newElementNode;
	}

	private boolean isLinkedListEmpty(){
		if (this.head ==null){
			return true;
		}
		return false;
	}

}
