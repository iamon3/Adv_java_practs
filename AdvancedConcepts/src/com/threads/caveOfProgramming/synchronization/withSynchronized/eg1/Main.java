package com.threads.caveOfProgramming.synchronization.withSynchronized.eg1;
/**
 * This programme is developed by caveofprogramming
 * Can be found at http://www.caveofprogramming.com/
 */

public class Main {

	/**
	 * Comment and uncomment two thread parts and run this class to see output.
	 */ 
	public static void main(String[] args) {
		
		// Thread without synchronized logic
		// after running Main. Comment following 2 lines and uncomment last commented lines and again run Main to see difference. 
		Thread wwos = new Thread( new WorkerWithoudSynchronized());
		wwos.start();
		
		// Thread with synchronized logic
		//Thread wws = new Thread( new WorkerWithSynchronized());
		//wws.start();
	}

}
