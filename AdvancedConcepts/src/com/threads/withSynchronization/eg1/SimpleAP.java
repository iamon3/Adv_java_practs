package com.threads.withSynchronization.eg1;

public class SimpleAP implements Runnable{
	int start;
	int diff;
	Synchronizer monitor;

	public SimpleAP(int a, int b, Object obj){
		this.start = a;
		this.diff = b;
		this.monitor = (Synchronizer)obj;
	}
	
	private void generateSeq(int n){
		int i=0;
		int cnt = start;
		System.out.println("Entered in thread");

		for(;i<n;i++){
			synchronized (monitor) {
				System.out.println("Enter in Synch");
				try {
					System.out.println("Enter in Try");
					monitor.wait();
					System.out.println("Wait Over");
					System.out.println(cnt);
					cnt += diff;	
					notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Some Error");
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		generateSeq(5);
	}
}
