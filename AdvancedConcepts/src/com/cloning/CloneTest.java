package com.cloning;

public class CloneTest {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1,"Ajit");
		Employee e2 =(Employee) e1.clone(); 
		System.out.println(e1 + " " + e2);
	}

}
