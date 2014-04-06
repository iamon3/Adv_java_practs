package com.threads.executorFramework.eg1ServerThreadPool;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * This examples demonstrates  example of "Fixed Thread Pool Executor"
 * creates a thread pool that re-uses a fixed number of threads operating off a shared unbounded queue. 
 * At most nThreads threads are actively processing tasks. If additional tasks are submitted when all threads are active, they wait in the queue until a thread is available. 
 * If any thread terminates through failure during execution before shutdown, a new thread will be created to take its place when subsequent tasks need to be executed. 
 * The pool's threads exist until the executor is shut down.
 * 
 * Detail Example and explanation can be found at :
 * http://www.javaworld.com/article/2078809/java-concurrency/java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html
 */
class Server
{
	private static int nThreads = 5;
	
	// Fixed Thread Pool Executor
	static Executor pool = Executors.newFixedThreadPool(nThreads);

	public static void main(String[] args) throws IOException
	{
		ServerSocket socket = new ServerSocket(9000);
		
		// Server will listen incoming HTTP requests.
		while (true)
		{
			final Socket s = socket.accept();
			Runnable r = new Runnable()
			{
				@Override
				public void run()
				{
					doWork(s);
				}
			};
			
			pool.execute(r);
		}
		
		// TODO Figure out how and when to shutdown the Executor
	}

	static void doWork(Socket s)
	{
	}
}