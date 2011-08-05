package com.ds.linkedList.myOwn;

import java.util.Comparator;

public class Employee {
	private String name ;
	private int id;
	public Employee(int newId, String newName) {
		this.id = newId;
		this.name=newName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.id+" "+this.name;
	}
    
	/**
	 * This is good example of use of Static Inner class with Comparator.
	 * Since sorting of employees based on employee id doesn't need instance of 
	 * Separate class, we created inner class 
	 */
	public static class EmployeeIdSorter implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {
			// TODO Auto-generated method stub
			if(e1.id < e2.id)
				return -1;
			else if(e1.id > e2.id)
			    return 1;
			return 0;
		}
		
	}
}
