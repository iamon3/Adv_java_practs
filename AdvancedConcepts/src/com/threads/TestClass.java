package com.threads;

public class TestClass {
public static void main(String[] args){
	TestClass t1 =new TestClass();
	SequenceGenerator evenSequence = new SequenceGenerator(1, 0, 12,t1);
	SequenceGenerator oddSequence = new SequenceGenerator(1, 1, 11,t1);
	
	Thread evenThread = new Thread(evenSequence);
	Thread oddThread = new Thread(oddSequence);
	
	evenThread.start();
	oddThread.start();
}
}
