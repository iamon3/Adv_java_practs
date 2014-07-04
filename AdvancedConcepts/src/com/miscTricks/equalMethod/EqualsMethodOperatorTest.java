package com.miscTricks.equalMethod;

public class EqualsMethodOperatorTest {

	public static void main(String[] args) {
	
		EqualsMethodOperatorTest objChild = new EqualsMethodOperatorTest();
		Object obj = objChild;
		
		int i = 0;
		
		if(obj == objChild) i+=10;
		
		if(obj.equals(objChild)) i +=100;
		
		if(objChild.equals(obj)) i+=1000;
		
		System.out.println("i = " + i); // Answer : 1110		
	}
}
