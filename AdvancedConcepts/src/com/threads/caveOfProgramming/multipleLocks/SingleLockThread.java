package com.threads.caveOfProgramming.multipleLocks;


/**
 *  This programme is developed by caveofprogramming
 *  Can be found at http://www.caveofprogramming.com/
 * 
 * This explains case when two threads are working on two independent 
 * functionalities which are using common lock.
 * Thus we can see how is this time inefficient in this case.
 * Please Note :- this holds true only when two functionalities are not 
 * related(i.e they are independent) or not working on shared object e.g counter.
 * 
 * For time performance please read comments of process() method 
 */
public class SingleLockThread implements Runnable {

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
		
		System.out.println("Total time taken when common lock is used :- "+(System.currentTimeMillis() - startTime)+" milliseconds");
	}

    /**
     * Calling 2 synchronized methods
     * Each method should take 5 * 500 = 2500 milliseconds
     * Expected Total time = 2500 + 2500 = 5000 milliseconds
     * But Actual Total time = 10000 milliseconds
     * Because of common lock is used in synchronized.
     * So when one thread is using that lock, other thread can't 
     * enter in other independent method because it is also using the same lock
     * So Observed total time = 10000 milliseconds 
     * Because say t1 is using lock in stageOne, t2 will sit idle waiting for lock to get released
     * Assume t1 uses lock completely till it completes loop.
     * then time taken by t1 = 500 * (5 + 5) = 5000 milliseconds
     * and  time taken by t2 = 500 * (5 + 5) = 5000 milliseconds
     * Hence time taken by both t1 and t2 = 5000 + 5000 = 10000 milliseconds
     */
	private void process(){
		for(int i=0; i<500; i++){
			stageOne();
			stageTwo();
		}
	}

	/**
	 * Using intrinsic lock on common object of this class SingleLockThread
	 */
	private synchronized void stageOne(){
		sleep();	
	}

	/**
	 * Using intrinsic lock on common object of this class SingleLockThread
	 */
	private synchronized void stageTwo(){
		sleep();
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
