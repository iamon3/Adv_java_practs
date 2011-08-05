package com.threads.withSynchronization.eg2;

public class Synchronizer {
	boolean odd=false;


	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Synchronizer monitor = new Synchronizer();
	SimpleAP evenSeq = new SimpleAP(0,2,monitor);
	SimpleAP oddSeq = new SimpleAP(1,2,monitor);

	Thread evenGen = new Thread(evenSeq);
	evenGen.setName("Even");
	Thread oddGen = new Thread(oddSeq);
	oddGen.setName("Odd");

	evenGen.start();
	oddGen.start();
	}
	}

