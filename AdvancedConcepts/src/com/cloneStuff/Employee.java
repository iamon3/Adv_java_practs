package com.cloneStuff;

public class Employee implements Cloneable{
	private int id ;
	public String name;
	Employee(int empId, String empName){
		this.id= empId;
		this.name=empName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (this.name + this.id);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		return super.clone();
	}
}
