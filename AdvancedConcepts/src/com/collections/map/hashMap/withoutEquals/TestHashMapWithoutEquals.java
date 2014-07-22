package com.collections.map.hashMap.withoutEquals;

import java.util.HashMap;
import java.util.Map;

public class TestHashMapWithoutEquals {

	public static void main(String[] args) {
		
		HashMap<Employee, Employee> emps = new HashMap<Employee, Employee>();
		Employee e1 = new Employee("1", "Arun");
		Employee e2 = new Employee("2", "Varun");
		Employee e3 = new Employee("3", "Tarun");
		Employee e4 = new Employee("4", "Karun");
		//emps.put(e1,e1);
		//emps.put(e2,e2);
		//emps.put(e3,e3 );
		//System.out.println("Before Size : " + emps.size() +", elements : " + emps);
		
		//emps.put(e4,e4);	
		//System.out.println("After Size : " + emps.size() +", elements : " + emps);
		
		//System.out.println("E4 : " + emps.get(e4));
		
		HashMap<Integer, Employee> emp2 = new HashMap<Integer, Employee>();
		emp2.put(1, e1);
		emp2.put(2, e2);
		emp2.put(3, e3);
		System.out.println("Before Size : " + emp2.size() +", elements : " + emp2);		
		emp2.put(1, e4);
		System.out.println("After Size : " + emp2.size() +", elements : " + emp2);
		
	}
}

class Employee{
	String deptId;
	String name;
	
	public Employee(String deptId, String name){
		this.deptId = deptId;
		this.name = name;
	}
	
	@Override
	public int hashCode(){
		return Integer.parseInt(this.deptId);
	}
	
	@Override	
	public boolean equals(Object o){
		//Employee e = (Employee) o;
		  //return this.name.equals(e.name);
		return true;
	}
	
	@Override	
	public String toString(){
		return this.deptId +" <=> " + this.name;
	}
}