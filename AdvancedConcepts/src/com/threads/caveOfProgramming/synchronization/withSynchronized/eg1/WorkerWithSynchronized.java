package com.threads.caveOfProgramming.synchronization.withSynchronized.eg1;
/**
 * This is solution to problem with WorkerWithoutSynchronized, that we can see in same package 
 * This example demonstrate need of synchronized keyword.
 * Both Thread1 and thread2 when started, increment counter value.
 * Expected result is 20000 when 2 threads finishes execution.
 * We have synchronized critical section ie where commond code is accessed simultaneously by multiple threads
 * In this case this critical section is counter++ opreation.
 * So now at a time only one thread is operating on counter.
 * and we gets expected result.  
 */
public class WorkerWithSynchronized implements Runnable {

	private static int TEN_THOUSAND = 10000;
	private int counter =0;

	//Critical section, where common code is accessed
	private synchronized void increment(){
		counter++;
	}
	
	@Override
	public void run() {

		// Anonymous Thread 1 instantiated
		Thread thread1 = new Thread( new Runnable(){
			public void run(){
				int i=0;
				for(i=0; i<TEN_THOUSAND;i++){
					increment();
				}
			}
		});

		// Anonymous Thread 2 instantiated
		Thread thread2 = new Thread( new Runnable(){
			public void run(){
				int i=0;
				for(i=0; i<TEN_THOUSAND;i++){
					increment();
				}
			}
		});

		//Threads started.
		thread1.start();
		thread2.start();

		try {
			// Wait worker thread for thread1 to complete execution
			thread1.join();
			// Wait worker thread for thread2 to complete execution
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Counter value :- " + counter);
	}

}
