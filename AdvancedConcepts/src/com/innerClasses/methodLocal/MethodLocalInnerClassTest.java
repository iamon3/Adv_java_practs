package com.innerClasses.methodLocal;

/**
 * 1. Local classes are never declared with an access specifier (that is, public or private). 
 *    Their scope is always restricted to the block in which they are declared.
 * 2. Local classes have a great advantage: they are completely hidden from the outside world.
 * 3. They can not only access the instance variables but local variables of the method (in which they are defined) as well, 
 *    but the local variable has to be declared final.
 * 4. The only modifier you can apply to a method-local inner class are <b>abstract</b> and <b>final</b>.   
 * 
 * Use : Provide different Comparators. http://docs.oracle.com/javase/tutorial/java/javaOO/whentouse.html
 *       Use it if you need to create more than one instance of a class, access its constructor, 
 *       or introduce a new, named type (because, for example, you need to invoke additional methods later).
 */
class OuterClass{
	
	String instanceMember = "instanceMember";
	
	void method(){
		
		String nonFinalMember = "nonFinalMember";
		
		final String finalMember = "finalMember";
		
		// Not possible : Instantiating the local inner class before it's definition.
		// LocalInnerClass localInnerClass = new LocalInnerClass();
		
		class LocalInnerClass{
			void someMethod(){
				System.out.println("Outer Clss instanceMember : "+ instanceMember +"\nmethod local finalMember : "+finalMember);
				// Not possible : To call non final member of the method
				// System.out.println("Non Final Member : " + nonFinalMember);
			}
		}
		
		new LocalInnerClass().someMethod();
	}
}

public class MethodLocalInnerClassTest {
  
	public static void main(String[] args) {
		new OuterClass().method();		
	}
}
