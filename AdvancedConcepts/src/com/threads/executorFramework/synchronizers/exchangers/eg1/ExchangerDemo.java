package com.threads.executorFramework.synchronizers.exchangers.eg1;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Exchanger;

/*
 * Refer : http://www.javaworld.com/article/2078809/java-concurrency/java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html?page=3
 * 
 * This class is based on the example code in Exchanger's Javadoc. One thread fills one buffer with strings while another thread empties another buffer. 
 * When the respective buffer is full or empty, these threads meet at an exchange point and swap buffers.
 * For example, when the filling thread's currentBuffer.isFull() expression is true, it executes currentBuffer = exchanger.exchange(currentBuffer) and waits. 
 * The emptying thread continues until currentBuffer.isEmpty() evaluates to true, and also invokes exchange(currentBuffer). 
 * At this point, the buffers are swapped and the threads continue.
 */
public class ExchangerDemo
{
	static Exchanger<DataBuffer> exchanger = new
			Exchanger<DataBuffer>();
	static DataBuffer initialEmptyBuffer = new DataBuffer();
	static DataBuffer initialFullBuffer = new DataBuffer("ITEM");

	public static void main(String[] args)
	{
		class FillingLoop implements Runnable
		{
			int count = 0;

			@Override
			public void run()
			{
				DataBuffer currentBuffer = initialEmptyBuffer;
				try
				{
					while (true)
					{
						addToBuffer(currentBuffer);
						if (currentBuffer.isFull())
						{
							System.out.println("filling loop thread wants to exchange");
							currentBuffer = exchanger.exchange(currentBuffer);
							System.out.println("filling loop thread observes an exchange");
						}
					}
				}
				catch (InterruptedException ie)
				{
					System.out.println("filling loop thread interrupted");
				}
			}

			void addToBuffer(DataBuffer buffer)
			{
				String item = "NEWITEM"+count++;
				System.out.printf("Adding %s%n", item);
				buffer.add(item);
			}
		}

		class EmptyingLoop implements Runnable
		{
			@Override
			public void run()
			{
				DataBuffer currentBuffer = initialFullBuffer;
				try
				{
					while (true)
					{
						takeFromBuffer(currentBuffer);
						if (currentBuffer.isEmpty())
						{
							System.out.println("emptying loop thread wants to exchange");
							currentBuffer = exchanger.exchange(currentBuffer);
							System.out.println("emptying loop thread observes an exchange");
						}
					}
				}
				catch (InterruptedException ie)
				{
					System.out.println("emptying loop thread interrupted");
				}
			}

			void takeFromBuffer(DataBuffer buffer)
			{
				System.out.printf("taking %s%n", buffer.remove());
			}
		}

		new Thread(new EmptyingLoop()).start();
		new Thread(new FillingLoop()).start();
	}
}

class DataBuffer
{
	private final static int MAX = 10;
	private List<String> items = new ArrayList<String>();

	DataBuffer()
	{
	}

	DataBuffer(String prefix)
	{
		for (int i = 0; i < MAX; i++)
		{
			String item = prefix+i;
			System.out.printf("Adding %s%n", item);
			items.add(item);
		}
	}

	void add(String s)
	{
		if (!isFull())
			items.add(s);
	}

	boolean isEmpty()
	{
		return items.size() == 0;
	}

	boolean isFull()
	{
		return items.size() == MAX;
	}

	String remove()
	{
		if (!isEmpty())
			return items.remove(0);
		return null;
	}
}