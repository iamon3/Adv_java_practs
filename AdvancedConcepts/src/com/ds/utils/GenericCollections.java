package com.ds.utils;

import com.ds.linkedList.myOwn.GenericLinkedList;
import com.ds.linkedList.myOwn.GenericNode;
import com.ds.linkedList.myOwn.Student;

public class GenericCollections {

	public static <E> GenericLinkedList<E> reverseGenricLinkedList(GenericLinkedList<E> genericLinkedListToBeReversed){
        Student s1 = new Student(11,"Stud1");
		genericLinkedListToBeReversed.add(s1);
		genericLinkedListToBeReversed.setTail(genericLinkedListToBeReversed.getHead());
		genericLinkedListToBeReversed.setHead(reverseList(genericLinkedListToBeReversed.getHead()));
		return genericLinkedListToBeReversed;
	}		

	private static <E> GenericNode<E> reverseList(GenericNode<E>  head) {
		if(head == null || head.getNextNode() == null){
		 return head;	
		}
		GenericNode<E> reverseLLHead = reverseList(head.getNextNode());
		head.getNextNode().setNextNode(head);
		head.setNextNode(null);
		return reverseLLHead;
	}
	
	public static GenericLinkedList reverseGenricLinkedList2(GenericLinkedList genericLinkedListToBeReversed){
		Student s1 = new Student(11,"Stud1");
		genericLinkedListToBeReversed.add(s1);
		genericLinkedListToBeReversed.setTail(genericLinkedListToBeReversed.getHead());
		genericLinkedListToBeReversed.setHead(reverseList(genericLinkedListToBeReversed.getHead()));
		return genericLinkedListToBeReversed;
	}		

}
