package com.threads.caveOfProgramming.ways2create.anonymous;

/** Note :- Here to thread method we pass Runnable object.
 * We don't want to create instance of Runnable interface.
 * We just simply want to start thread as soon as it is created
 * so in this case we can use Anonymous class on the fly
 */
public class Application {

	public static void main(String[] args) {

		Thread thread1 =  new Thread(new Runnable(){

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

		});
		thread1.start();

	}

}
