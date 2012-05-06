package com.threads.caveOfProgramming.ways2create.threadClass;

/**
 * One way of Thread creation is extend Tread class.
 * Override run method
 */
class Runner extends Thread{

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

/**
 * Interleaved running threads
 */
public class Application {

	public static void main(String[] args) {
    
	Thread thread1 =  new Runner();
    thread1.start();
    
    Thread thread2 =  new Runner();
    thread2.start();
    
	}

}
