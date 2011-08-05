package com.constructorBlockStuff;

public class Parent {
	int i;

	public Parent(int k){
		i=k;
		System.out.println("Arg Constructor Parent");
	}
	public Parent(){
		System.out.println("No-Arg Constructor Parent");
	}
	static
	{
		System.out.println("Static Parent");

	}
	{
		System.out.println("Instance Parent");
	}

}
