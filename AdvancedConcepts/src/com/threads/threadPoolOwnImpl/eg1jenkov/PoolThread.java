package com.threads.threadPoolOwnImpl.eg1jenkov;

import java.util.concurrent.BlockingQueue;

/**
 * Refer : http://tutorials.jenkov.com/java-concurrency/thread-pools.html
 */
public class PoolThread extends Thread {

	private BlockingQueue taskQueue = null;
	private boolean       isStopped = false;

	public PoolThread(BlockingQueue queue){
		taskQueue = queue;
	}

	public void run(){
		while(!isStopped()){
			try{
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			} catch(Exception e){
				//log or otherwise report exception,
				//but keep pool thread alive.
			}
		}
	}

	public synchronized void stopExecution(){
		isStopped = true;
		this.interrupt(); //break pool thread out of dequeue() call.
	}

	public synchronized boolean isStopped(){
		return isStopped;
	}
}