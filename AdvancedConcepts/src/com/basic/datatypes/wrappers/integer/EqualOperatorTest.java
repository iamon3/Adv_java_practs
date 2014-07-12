package com.basic.datatypes.wrappers.integer;

public class EqualOperatorTest {

	public EqualOperatorTest(){
		
	}
	public static void main(String[] args) {

		Integer a = 5;
		Integer b = 5;
		Integer c = new Integer(5);
		
		System.out.println("a == b : " + (a == b)); // true
		b +=1;
		System.out.println("After incrementing 'b' a == b : " + (a == b)); //false

		System.out.println("a == c : " + (a == c)); // false
		System.out.println("a.equals(c) : " + a.equals(c)); // true
		c += 1;
		System.out.println("c : " + c); // 6
		
	}
}