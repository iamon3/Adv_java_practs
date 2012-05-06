package com.threads.caveOfProgramming.ways2create.runnableIface;

/**
 * Second way of Thread creation is implement runnable interface.
 * Implement run method
 */
class Runner implements Runnable{

	@Override
	public void run() {
		int i;
		for(i=1; i<6; i++){
			System.out.println("Hello :- " + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

/** Note :- Here to thread method we pass Runnable object.
 * ie class which has implemented runnable interface 
 *  Interleaved running threads
 */
public class Application {

	public static void main(String[] args) {

		Thread thread1 =  new Thread(new Runner());
		thread1.start();

		Thread thread2 =  new Thread(new Runner());
		thread2.start();

	}

}
