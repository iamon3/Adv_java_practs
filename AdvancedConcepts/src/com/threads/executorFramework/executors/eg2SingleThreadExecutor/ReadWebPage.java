package com.threads.executorFramework.executors.eg2SingleThreadExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

/*
 * Demonstrates use of Single Thread Executor.
 * An application reads the contents of an arbitrary web page. It outputs the resulting lines or an error message if the contents aren't available within a maximum of five seconds.
 * 
 * This creates an executor that uses a single worker thread operating off an unbounded queue -- tasks are added to the queue and execute sequentially 
 * (no more than one task is active at any one time). If this thread terminates through failure during execution before shutdown of the executor,
 * a new thread will be created to take its place when subsequent tasks need to be executed.
 * 
 *  More explanation can be found at :
 *  http://www.javaworld.com/article/2078809/java-concurrency/java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html?page=2
 *  
 */
public class ReadWebPage
{
	public static void main(final String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("usage: java ReadWebPage url");
			return;
		}
		
		// 1. Get the executor
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		// Define the Callable task to be executed by the executor
		Callable<List<String>> callable;
		callable = new Callable<List<String>>() {
			
			@Override
			public List<String> call() throws IOException, MalformedURLException
			{
				List<String> lines = new ArrayList<String>();
				
				URL url = new URL(args[0]);
				
				HttpURLConnection con;
				con = (HttpURLConnection) url.openConnection();
				
				InputStreamReader isr;
				isr = new InputStreamReader(con.getInputStream());
				
				BufferedReader br;
				br = new BufferedReader(isr);
				
				String line;
				while ((line = br.readLine()) != null)
					lines.add(line);
				return lines;
			}
		};
			
		// 2. Submit task to the executor
		Future<List<String>> future = executor.submit(callable);
		try
			{
				List<String> lines = future.get(5, TimeUnit.SECONDS);
				for (String line: lines)
					System.out.println(line);
			}
		catch (ExecutionException ee)
			{
				System.err.println("Callable through exception: "+ee.getMessage());
			}
		catch (InterruptedException ite) 
			{
				System.err.println("URL not responding");
			}
		catch( TimeoutException eite){
				System.err.println("URL not responding");
		}
		
		// 3. Shutdown the executor
		// Regardless of whether an exception is thrown or not, the executor must be shut down before the application exits. 
		// If the executor isn't shut down, the application won't exit because the non-daemon thread-pool threads are still executing.
		executor.shutdown();
	}
}