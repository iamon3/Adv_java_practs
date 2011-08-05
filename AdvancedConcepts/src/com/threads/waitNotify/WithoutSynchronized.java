package com.threads.waitNotify;

// Note Here that wait and notify can be call from anywhere
//Caliing in Synchronized Block is not compulsion
// But Wait should always be surrounded by try/catch Or Throws
// with InterruptedException

public class WithoutSynchronized {
	void justChill(){
		System.out.println("Say Hello");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait();
	    notify();
		notifyAll();
	}
}
