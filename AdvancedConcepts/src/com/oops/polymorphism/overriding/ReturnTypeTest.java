package com.oops.polymorphism.overriding;

// Compile time error. Incompatible return types. Overriding rule in JAVA is 
// 1. Methods should have same signature i.e. same name, same number of parameters with types
// 2. Mehtod return types should be compatible
public class ReturnTypeTest {

	public static void main(String[] args) {
		
	}
}

class Parent{
	String method(){
		return null;
	}
}

class Child extends Parent{
	
	int method(){
		return 0;
	}
}