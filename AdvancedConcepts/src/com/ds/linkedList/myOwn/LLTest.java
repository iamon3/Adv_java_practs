package com.ds.linkedList.myOwn;
 import com.ds.utils.GenericCollections;
 
public class LLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1, "One");
		Employee e2 = new Employee(2, "Two");
		Employee e3 = new Employee(3, "Three");
		Employee e4 = new Employee(4, "Four");
		
		GenericLinkedList<Employee> staff = new  GenericLinkedList<Employee>();
		staff.add(e1);
		staff.add(e2);
		staff.add(e3);
		staff.add(e4);
		
		System.out.println(staff);
        GenericCollections.reverseGenricLinkedList(staff);
        System.out.println("After Reversing");
        System.out.println(staff);
		GenericCollections.reverseGenricLinkedList2(staff);
		System.out.println("After Reversing");
        System.out.println(staff);
	}
}
