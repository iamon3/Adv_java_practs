package com.threads.oddEvenSeq.eg2;

public class SeqGeneratorTest {

	public static void main(String[] args) {
		Object monitor = new Object();
		Thread odd = new Thread(new SeqGenerator(1,49, monitor));
		Thread even = new Thread(new SeqGenerator(2,50, monitor));
		
		try {
			even.join();
			odd.join();			
			odd.start();
			Thread.sleep(1000);
			even.start();
						
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	static class SeqGenerator implements Runnable{

		int start ; 
		int end;
		Object monitor;
		
		SeqGenerator(){}
		
		SeqGenerator(int startNo, int endNo, Object inputMonitor){
			this.start = startNo;
			this.end = endNo;
			this.monitor = inputMonitor;
		}
		
		@Override
		public void run() {
			for(int i = start; i <= end; i+= 2){
				synchronized (monitor) {
					System.out.println(i);
					monitor.notify();
					try {
						monitor.wait();
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}				
			}					
		}		
	}
}