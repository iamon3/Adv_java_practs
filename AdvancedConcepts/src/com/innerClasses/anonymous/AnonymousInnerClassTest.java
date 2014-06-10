package com.innerClasses.anonymous;

/**
 * 1. Anonymous inner class can extend one subclass OR implement one interface.
 *    i.e. It can't both extend a class and implement an interface, not can it implement more than one interface.   
 * 2. An anonymous inner class cannot have constructors because the name of a constructor must be the same as the name of a class, and the class has no name.
 * 
 * Use : In writing unit test cases, we can override unwanted methods. Instances not required and scope of instance is limited to particular case.
 *       http://docs.oracle.com/javase/tutorial/java/javaOO/whentouse.html
 *       Use it if you need to declare fields or additional methods.   
 */

class A{
	void methodA(){
		System.out.println("methodA() in class A.");
	}
}

interface B{
	void methodB();
}

interface C{
	void methodC();
}

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		A a = new A(){			
			void methodA(){
				System.out.println("methodA() in anonymous inner subclass of class A.");
			}	
		};		
		a.methodA();

		B b = new B(){
			@Override
			public void methodB() {				
				System.out.println("methodA() in class A.");
			}};
			
		b.methodB();	
	}
}