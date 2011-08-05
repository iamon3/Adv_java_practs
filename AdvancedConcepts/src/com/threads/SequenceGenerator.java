package com.threads;

public class SequenceGenerator implements Runnable {

	protected int diff;
	protected int start;
	protected int end;
	private TestClass monitor ;
	public SequenceGenerator(int d, int start, int end, Object o){
		this.diff = d;
		this.start = start;
		this.end= end;
		this.monitor =(TestClass)o;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		printSequence();
	}
    public void printSequence(){
    	int i=this.start;
	for(;i<this.end;i+=diff){
		synchronized (monitor) {
			System.out.println(i+" ");
		}
		notify();
	}
    }
}
