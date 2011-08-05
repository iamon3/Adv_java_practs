package com.ds.genricCollection.eg1;

import java.util.List;
import java.util.LinkedList;

public class TestClass {

	public static void mtd1(List<Employee> staff){

	}
	public static void mtd2(LinkedList<Employee> staff){

	}
	public static void mtd3(List<? extends Employee> staff){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Employee> staff = new LinkedList<Employee>();
		List<Manager> mStaff = new LinkedList<Manager>();
    
		Employee e = new Employee();
		Manager m = (Manager)e;
		
		mtd1(staff);
		mtd1(mStaff);
		
		mtd2(staff);
		mtd2(mStaff);
		
		mtd3(staff);
		mtd3(mStaff);
	}

}
