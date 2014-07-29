package com.oops.polymorphism.constructor;

/**
 * Constructor Rules
 * 1. If no explicit constructor is provided, JAVA, by default will insert no-arg constructor, which calls super();
 * 2. Developer can provide no-arg constructor i.e provide explicit implementation.
 * 3. If an explicit argument constructor is provided in the class, then no-arg constructor will not be available for instantiation
 *    Not outside class, or not in a derived class. This is also called as constructor overloading.
 * 4. If Parent class has argument constructor i.e. no-arg constructor is not available i.e Child class can not call super()
 * 5. If developer provides both argument and no-arg constructors in a Parent class, then both constructors are available. i.e Child class can call super() as well as super(argument).
 * 6. If in child class, explicitly super() or super(argument) is not mentioned as a first line, then JAVA will insert super() i.e. call to no-arg constructor.
 *    and if it is not available in the Parent class, compile time error will be thrown with cause as 
 *    "Implicit super constructor Parent() is undefined. Must explicitly invoke another 
 constructor"      
 */
public class NoargConstructorExample {

	public static void main(String[] args) {
		Parent p = new Child(1);
	}
}

class Parent{
	Parent(){}
	
	Parent(int x){
		System.out.println("Parent constructor x : " + x);
	}
	
	String method(){
		return null;
	}
}

// Child class has argument constructor. Following rules are applicable.
// 1. no-arg child constructor can not 
class Child extends Parent{
	Child(){super(1);}
	Child(int i){}
}