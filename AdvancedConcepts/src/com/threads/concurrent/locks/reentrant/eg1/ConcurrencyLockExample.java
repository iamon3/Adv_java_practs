package com.threads.concurrent.locks.reentrant.eg1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
/**
 * http://www.journaldev.com/2377/java-lock-example-and-concurrency-lock-vs-synchronized
 */ 
	
public class ConcurrencyLockExample implements Runnable{
 
    private Resource resource;
    private Lock lock;
     
    public ConcurrencyLockExample(Resource r){
        this.resource = r;
        this.lock = new ReentrantLock();
    }
     
    @Override
    public void run() {
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)){
            resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //release lock
            lock.unlock();
        }
        resource.doLogging();
    }
 
}

class Resource {
	 
    public void doSomething(){
        //do some operation, DB read, write etc
    }
     
    public void doLogging(){
        //logging, no need for thread safety
    }
}