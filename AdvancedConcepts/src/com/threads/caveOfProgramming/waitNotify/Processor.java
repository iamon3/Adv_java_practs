package com.threads.caveOfProgramming.waitNotify;

import java.util.Scanner;

/**
 * This is example of wait() and notify()
 * wait() is efficient than checking in the while loop
 * wait releases the lock and wait for getting notified by other thread 
 * which holds the lock.
 * 
 * notify() notifies any single thread amongst the set of threads
 * which are waiting for the release of the lock which is being held by
 * this thread. 
 * 
 * Please note that notify() does not immediately releases the lock after the notify() call.
 */
public class Processor implements Runnable {

	@Override
	public void run() {
		//Create 2 threads
		Thread producer = new Thread(new Runnable(){
			@Override
			public void run() {
				producer();
			}    	  
		});
		Thread consumer = new Thread(new Runnable(){
			@Override
			public void run() {
				consumer();
			}    	  
		});

		//Start 2 threads
		producer.start();
		consumer.start();

		//Wait for these threads 2 complete
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}


	private void producer(){
		synchronized(this){
			System.out.println("In producer : going to wait now. Relinquishing lock. ");
			try {
				wait();
				System.out.println("Wait complete. Got notified. Woke up now. Producer resumed.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Complete.");
		}
	}


	private void consumer(){

		// Sleep to give producer the first turn
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(this){
			Scanner sc = new Scanner(System.in);
			System.out.println("In the consumer. Press return key to proceed ");
			sc.nextLine();
			System.out.println("In the consumer. Releasing lock now. Going to notify now.");
			// notify does not immediately releases lock. to test this uncomment sleep() line
			notify(); 
/**
			try {
				System.out.println("Consumer Going to sleep.");
				Thread.sleep(5000);
				System.out.println("Consumer going to sleep.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
*/
		}
	}
}
