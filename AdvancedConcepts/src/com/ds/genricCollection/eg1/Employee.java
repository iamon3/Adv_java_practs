package com.ds.genricCollection.eg1;

public class Employee {
	int empId;
	public Employee(){
		System.out.println("Employee no-arg constructor");
	}
	public Employee(int i) {
		this.empId = i;
		System.out.println(" Employee arg constructor");
	}
}
