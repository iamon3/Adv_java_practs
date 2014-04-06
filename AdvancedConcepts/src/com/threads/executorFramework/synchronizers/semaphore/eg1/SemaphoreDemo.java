package com.threads.executorFramework.synchronizers.semaphore.eg1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

/*
 * Refer : http://www.javaworld.com/article/2078809/java-concurrency/java-101-the-next-generation-java-concurrency-without-the-pain-part-1.html?page=2
 * 
 * This example demonstrates this capability by using a semaphore to control access to a pool of string items 
 * -- the source code is based on Semaphore's Javadoc example code.
 * presents SemaphoreDemo and Pool classes. SemaphoreDemo drives the application by creating executors 
 * and having them execute a runnable that repeatedly acquires string item resources from a pool (implemented by Pool) and then returns them.
 * Pool provides String getItem() and void putItem(String item) methods for obtaining and returning resources. 
 * Before obtaining an item in getItem(), a thread must acquire a permit from the semaphore, guaranteeing that an item is available for use. 
 * When the thread has finished with the item, it calls putItem(String), which returns the item to the pool and then returns a permit to the semaphore, 
 * which lets another thread acquire that item.
 * No synchronization lock is held when acquire() is called because that would prevent an item from being returned to the pool. 
 * However, String getNextAvailableItem() and boolean markAsUnused(String item) are synchronized to maintain pool consistency. 
 * (The semaphore encapsulates the synchronization needed to restrict access to the pool separately from the synchronization needed to maintain pool consistency.)
 * 
 * eleven threads compete for ten resources. Thread pool-11-thread-1 is forced to wait when it attempts to acquire a resource. 
 * It resumes with the ITEM7 resource when thread pool-5-thread-1 returns this resource to the pool.
 */
public class SemaphoreDemo
{
	public static void main(String[] args)
	{
		final Pool pool = new Pool();
		
		Runnable r = new Runnable()
		{
			@Override
			public void run()
			{
				String name = Thread.currentThread().getName();
				try
				{
					while (true)
					{
						String item;						
						System.out.printf("%s acquiring %s%n", name, item = pool.getItem());
						
						Thread.sleep(200+(int)(Math.random()*100));
						
						System.out.printf("%s putting back %s%n", name, item);
						pool.putItem(item);
					}
				}
				catch (InterruptedException ie)
				{
					System.out.printf("%s interrupted%n", name);
				}
			}
		};
		
		ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE+1];
		for (int i = 0; i < executors.length; i++)
		{
			executors[i] = Executors.newSingleThreadExecutor();
			executors[i].execute(r);
		}
	}
}

final class Pool
{
	public static final int MAX_AVAILABLE = 10;

	private Semaphore available = new Semaphore(MAX_AVAILABLE, true);
	private String[] items;
	private boolean[] used = new boolean[MAX_AVAILABLE];

	Pool()
	{
		items = new String[MAX_AVAILABLE];
		for (int i = 0; i < items.length; i++)
			items[i] = "ITEM"+i;
	}

	String getItem() throws InterruptedException
	{
		available.acquire();
		return getNextAvailableItem();
	}

	void putItem(String item)
	{
		if (markAsUnused(item))
			available.release();
	}

	private synchronized String getNextAvailableItem()
	{
		for (int i = 0; i < MAX_AVAILABLE; ++i)
		{
			if (!used[i])
			{
				used[i] = true;
				return items[i];
			}
		}
		return null; // not reached
	}

	private synchronized boolean markAsUnused(String item)
	{
		for (int i = 0; i < MAX_AVAILABLE; ++i)
		{
			if (item == items[i])
			{
				if (used[i])
				{
					used[i] = false;
					return true;
				}
				else{
					return false;
				}
			}
		}
		return false;
	}
}