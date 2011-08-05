package com.constructorBlockStuff;

public class Child extends Parent {
	int j;
	
	public Child(int k){
	//super(k);	
	j=k;
	System.out.println("Child Arg Constructor ");
	}
	
	public Child(){
		//super(2);
		System.out.println("No-Arg Constructor Child");
	}
	static
	{
		System.out.println("Static Child");

	}
	{
		System.out.println("Instance child");
	}
	void justChill(){
		System.out.println("Say Hello");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();
	}

}
