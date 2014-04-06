package com.threads.executorFramework.synchronizers.countdownLatch.eg1;

import java.util.concurrent.CountDownLatch;

/*
 * Refer : http://www.javaworld.com/article/2078809/java-concurrency/java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html?page=3
 * This demo class presents CountDownLatchDemo and Worker classes. CountDownLatchDemo's main() method creates a startSignal countdown latch initialized to 1 
 * and a doneSignal countdown latch initialized to 3, the number of worker threads. main() proceeds to create three worker threads described by Worker and then start these threads. 
 * After outputting a message, main() executes startSignal.countDown() to tell the worker threads that they can proceed.
 * After outputting a few more messages, main() executes doneSignal.await() to wait until all worker threads have finished.
 * Worker's constructor saves these latches, and its run() method performs some work. Before performing this work, 
 * the thread executes startSignal.await() to block until the main thread allows it to proceed (by executing startSignal.countDown()).
 * The worker then enters a loop to simulate doing some work by alternately outputting messages and sleeping for random amounts of time. 
 * It then executes doneSignal.countDown() to decrement the doneSignal countdown latch so that the main thread will eventually wake up.
 */
public class CountDownLatchDemo
{
	final static int N = 3;

	public static void main(String[] args) throws InterruptedException
	{
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);
		for (int i = 0; i < N; ++i) {// create and start threads
			new Thread(new Worker(startSignal, doneSignal)).start();
		}
		System.out.println("about to let threads proceed");
		startSignal.countDown(); // let all threads proceed
		System.out.println("doing work");
		System.out.println("waiting for threads to finish");
		doneSignal.await(); // wait for all threads to finish
		System.out.println("main thread terminating");
	}
}

class Worker implements Runnable
{
	private final static int N = 5;

	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal)
	{
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	@Override
	public void run()
	{
		try
		{
			String name = Thread.currentThread().getName();
			startSignal.await();
			for (int i = 0; i < N; i++)
			{
				System.out.printf("thread %s is working%n", name);
				try
				{
					Thread.sleep((int)(Math.random()*300));
				}
				catch (InterruptedException ie)
				{
				}
			}
			System.out.printf("thread %s finishing%n", name);
			doneSignal.countDown();
		}
		catch (InterruptedException ie)
		{
			System.out.println("interrupted");
		}
	}
}