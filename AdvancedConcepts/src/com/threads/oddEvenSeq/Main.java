package com.threads.oddEvenSeq;

public class Main {

	public static void main(String[] args) {
		
		Thread evenSeqThread = new Thread(new SequenceGenerator(2,false));
		Thread oddSeqThread = new Thread(new SequenceGenerator(1,true));
		
		SequenceGenerator.LOOP_COUNT = 10;
		
		evenSeqThread.setName("even");
		oddSeqThread.setName("odd");
		
		evenSeqThread.start();
		oddSeqThread.start();
	}

}
