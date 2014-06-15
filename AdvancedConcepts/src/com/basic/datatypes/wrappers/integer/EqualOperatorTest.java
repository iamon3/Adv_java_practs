package com.basic.datatypes.wrappers.integer;

import java.util.HashMap;

public class EqualOperatorTest {

	public EqualOperatorTest(){
		
	}
	public static void main(String[] args) {

		Integer a = 5;
		Integer b = 5;
		Integer c = new Integer(5);
		
		System.out.println("a == b : " + (a == b));
		b +=1;
		System.out.println("After incrementing 'b' a == b : " + (a == b));

		System.out.println("a == c : " + (a == c));
		c += 1;
		System.out.println("c : " + c);
		
	}
}