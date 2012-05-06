package com.threads.caveOfProgramming.synchronization.withSynchronized.eg1;
/**
 * This example demonstrate need of synchronized keyword.
 * Both Thread1 and thread2 when started, increment counter value.
 * Expected result is 20000 when 2 threads finishes execution.
 * But we see unexpected result at every run. 
 * One thread load counter value. at the same time another thread increments counter value.
 * So by the time another thread have incremented counter value, first thread is still seeing previous value of counter.
 * And it increments previous value. 
 * So counter++ should be  atomic operation. ie. when thread is operating on counter, another thread should not operate on it or she should wait.  
 * So we need synchronized. 
 */
public class WorkerWithoudSynchronized implements Runnable {

	private static int TEN_THOUSAND = 10000;
	private int counter =0;

	@Override
	public void run() {

		// Anonymous Thread 1 instantiated
		Thread thread1 = new Thread( new Runnable(){
			public void run(){
				int i=0;
				for(i=0; i<TEN_THOUSAND;i++){
					counter++;
				}
			}
		});

		// Anonymous Thread 2 instantiated
		Thread thread2 = new Thread( new Runnable(){
			public void run(){
				int i=0;
				for(i=0; i<TEN_THOUSAND;i++){
					counter++;
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
