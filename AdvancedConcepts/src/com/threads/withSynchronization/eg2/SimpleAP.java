package com.threads.withSynchronization.eg2;

class SimpleAP implements Runnable{
	int start;
	int diff;
	Synchronizer monitor;

	public SimpleAP(int a, int b, Object obj){
		this.start = a;
		this.diff = b;
		this.monitor = (Synchronizer)obj;
	}

	private void generateSeq(int n){

		int cnt = start;

		// System.out.println("Entered in thread");

		synchronized (monitor) {
			for(int i=0;i<n;i++){

				//System.out.println("Enter in Synch");

				try {
					//System.out.println("Enter in Try");
					if(Thread.currentThread().getName().equalsIgnoreCase("even")) {
						if(monitor.odd==false) {

							System.out.println(cnt);
							cnt += diff;
							monitor.odd=true;
							monitor.notify();
						}
						else {
							monitor.wait();
							i--;
						}
					}
					else {
						if(monitor.odd==true) {

							System.out.println(cnt);
							cnt += diff;
							monitor.odd=false;
							monitor.notify();
						}
						else {
							monitor.wait();
							i--;
						}
					}

					//System.out.println("Wait Over");



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