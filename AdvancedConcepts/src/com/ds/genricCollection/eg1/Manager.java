package com.ds.genricCollection.eg1;

public class Manager extends Employee{
	public Manager(){
		System.out.println(" Manager no-arg constructor");
	}
	public Manager(int i) {
		super(i);
		System.out.println(" Manager arg constructor");
	}

	void call(){

	}
}
