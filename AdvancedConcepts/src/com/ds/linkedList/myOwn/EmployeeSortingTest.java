package com.ds.linkedList.myOwn;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeSortingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> staff = new ArrayList<Employee>(5);
		staff.add(new Employee(3,"e3"));
		staff.add(new Employee(1,"e1"));
		staff.add(new Employee(4,"e4"));
		staff.add(new Employee(5,"e5"));
		staff.add(new Employee(2,"e2"));
		
		System.out.println("Before sorting :- " + staff);
		Collections.sort(staff, new Employee.EmployeeIdSorter());
		System.out.println("After Sorting :- "+staff);
	}

}
