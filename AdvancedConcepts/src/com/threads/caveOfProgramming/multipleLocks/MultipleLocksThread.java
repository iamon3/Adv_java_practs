package com.threads.caveOfProgramming.multipleLocks;

/**
 *  This programme is developed by caveofprogramming
 *  Can be found at http://www.caveofprogramming.com/
 * 
 * This explains case when two threads are working on two independent 
 * functionalities which are using different locks.
 * Thus we can see how is this time efficient in this case.
 * Please Note :- this holds true only when two functionalities are not 
 * related(i.e they are independent) or not working on shared object e.g counter.
 * 
 * For time performance please read comments of process() method 
 */
public class MultipleLocksThread implements Runnable {

	Object lock1 = new Object();
	Object lock2 = new Object();

	@Override
	public void run() {

		long startTime = System.currentTimeMillis();

		Thread t1 = new Thread(new SingleLockThread(){
			public void run(){
				process();
			}
		});

		Thread t2 = new Thread(new SingleLockThread(){
			public void run(){
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Total time taken when multiple locks are used :- "+(System.currentTimeMillis() - startTime)+" milliseconds");
	}

	/**
	 * Calling 2 synchronized methods
	 * Each method should take 5 * 500 = 2500 milliseconds
	 * Expected Total time = 2500 + 2500 = 5000 milliseconds
	 * Since 2 independent methods  are using 2 different locks
	 * when 1 thread is using lock1 other thread can enter in another method
	 * using lock2
	 * So two threads working simultaneously independently
	 * Thus time taken will be somewhere around expected i.e. 5000 milliseconds
	 */
	private void process(){
		for(int i=0; i<500; i++){
			stageOne();
			stageTwo();
		}
	}

	/**
	 * Using intrinsic lock1 on  object 1
	 */
	private void stageOne(){
		synchronized(lock1){
			sleep();	
		}
	}

	/**
	 * Using intrinsic lock2 on common object 2
	 */
	private synchronized void stageTwo(){
		synchronized(lock2){
			sleep();	
		}
	}

	/**
	 * Sleep for 5 milliseconds
	 */
	private void sleep(){
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
