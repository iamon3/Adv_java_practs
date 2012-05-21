package com.threads.caveOfProgramming.waitNotify;

public class WaitNotifyMain {

	public static void main(String[] args) {
	  Thread processor = new Thread(new Processor());
	  processor.start();
	}
}
