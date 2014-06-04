package com.collections.queue.priorityQueue.eg1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


/**
 * As per JAVA DOC: http://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
 * The Queue interface has following methods.
 * 
 * 				Throws exception	Returns special value
 * Insert			add(e)				offer(e)
 * Remove			remove()			poll()
 * Examine			element()			peek()
*/
public class PriorityQueueExample {

	public static void main(String[] args) {

		//natural ordering example of priority queue
		Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(7);
		Random rand = new Random();
		for(int i=0;i<7;i++){
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		for(int i=0;i<7;i++){
			Integer in = integerPriorityQueue.poll();
			System.out.println("Processing Integer:"+in);
		}
		
		System.out.println("\n================ Priority Queue with comparator ========== \n");
		// PriorityQueue example with Comparator
		// If we wonÕt provide comparator while creating customerPriorityQueue, 
		// it will throw ClassCastException at runtime.
		Queue<Customer> customerPriorityQueue = new PriorityQueue<Customer>(7, idComparator);
		addDataToQueue(customerPriorityQueue);

		pollDataFromQueue(customerPriorityQueue);

	}

	//Comparator anonymous class implementation
	public static Comparator<Customer> idComparator = new Comparator<Customer>(){

		@Override
		public int compare(Customer c1, Customer c2) {
			return (int) (c1.getId() - c2.getId());
		}
	};

	//utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for(int i=0; i<7; i++){
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
		}
	}

	//utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while(true){
			Customer cust = customerPriorityQueue.poll();
			if(cust == null) break;
			System.out.println("Processing Customer with ID="+cust.getId());
		}
	}

}
