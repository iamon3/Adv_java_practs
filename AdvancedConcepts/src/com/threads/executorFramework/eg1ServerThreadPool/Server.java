package com.threads.executorFramework.eg1ServerThreadPool;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * Detail Example and explanation can be found at :
 * http://www.javaworld.com/article/2078809/java-concurrency/java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html
 */
class Server
{
	private static int nThreads = 5;
	
	// Different Executors are available
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
	}

	static void doWork(Socket s)
	{
	}
}