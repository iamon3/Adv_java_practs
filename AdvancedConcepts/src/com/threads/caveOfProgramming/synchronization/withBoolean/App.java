/**
 * This programme is developed by caveofprogramming
 * Can be found at http://www.caveofprogramming.com/
 * 
 */
package com.threads.caveOfProgramming.synchronization.withBoolean;
import java.util.Scanner;


class Processor extends Thread{

	// volatile is important
	// Otherwise theoretically its possible that 
	// running value is cached by this thread so it always true
	// so thread will keep on running
	private volatile boolean running = true;

	@Override
	public void run() {

		while(running){
			System.out.println("Running ");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Stopped ");
	}

	public void shutdown(){
		running = false;
	}

}

public class App {

	public static void main(String[] args) {
	
	  // Instanciate Thread
      Processor processor = new Processor();
      
      //Start Thread
      processor.start();
      
      //Press "Return" Key to stop running thread, 
      new Scanner(System.in).nextLine();
      processor.shutdown();
	}
}
