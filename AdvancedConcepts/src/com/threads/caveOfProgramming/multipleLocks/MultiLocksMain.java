package com.threads.caveOfProgramming.multipleLocks;

public class MultiLocksMain {

	public static void main(String[] args) {

		//Thread using common lock
		Thread singleLockThread = new Thread(new SingleLockThread());
		singleLockThread.start();
		
		//Thread using multiple locks
		Thread multipleLockThread = new Thread(new MultipleLocksThread());
		multipleLockThread.start();
		
		try {
			singleLockThread.join();
			multipleLockThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
