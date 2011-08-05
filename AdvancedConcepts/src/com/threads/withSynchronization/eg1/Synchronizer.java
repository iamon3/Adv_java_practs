package com.threads.withSynchronization.eg1;

public class Synchronizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ajit";
		String b= "AjIt";
		String c= new String("ajit");
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode()+" "+a.equals(c)+" "+b.equals(c));
		
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
