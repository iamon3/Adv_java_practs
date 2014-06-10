package com.innerClasses.staticInner;

/**
 * Properties in addition to Normal Inner class :
 * 
 * 1. Static members of the outer class are visible to the static inner class, what ever their access level be.
 * 2. Non-static members of the outer class are not available, because there is not instance of the outer class.
 * 3. An inner class may not have static members unless the inner class is itself marked as static.
 * 4. Sometimes static nested class are not referred to as inner class at all, as they don’t require outer classes instance.
 * 5. A static inner class is just like any other inner class, but it dose not have the reference to its outer class object that generated it.
 * 
 * http://docs.oracle.com/javase/tutorial/java/javaOO/whentouse.html
 * USE : Use a non-static nested class (or inner class) if you require access to an enclosing instance's non-public fields and methods. 
 *       Use a static nested class if you don't require this access.
 */

class OuterClass{
	
	private static String staticOuterMember = "staticOuterMember";
	private String instanceOuterMember = "instanceOuterMember";
	
	StaticInnerClass staticInnerClass = new StaticInnerClass("staticInnerClass");
	StaticInnerClass staticInnerClass2 = new StaticInnerClass("staticInnerClass1");
	
	void outerClassMethod(){
		// Not Allowed : Can not create instance using this keyword
		// this.StaticInnerClass staticInnerClass3 = new StaticInnerClass();
		
		System.out.println("staticInnerClass.staticInnerMember : " + staticInnerClass.staticInnerMember);
		System.out.println("staticInnerClass.printMember() :" + staticInnerClass.printMember());
	}

	static class StaticInnerClass{
		
		private static String staticInnerMember = "staticInnerMember";
		private String instanceInnerMember = "instanceOuterMember";
		
		public StaticInnerClass(){}
		
		public StaticInnerClass(String instanceInnerMember){
			this.instanceInnerMember = instanceInnerMember;
		}
		
		void innerClassMethod(){

			// Not Allowed : Can not access instance member of outer class
			// System.out.println("instanceOuterMember :"+ this.instanceOuterMember);

			// Allowed
			System.out.println("staticOuterMember :  " +staticOuterMember );
		}
		
		String printMember(){
			System.out.println("instanceInnerMember : " + instanceInnerMember);
			return instanceInnerMember;
		}
	}
}

public class StaticInnerClassTest {
	public static void main(String[] args) {
		// Note outer class instance is not required.
		OuterClass.StaticInnerClass  staticInnerClass = new OuterClass.StaticInnerClass(); 
		staticInnerClass.printMember();
	}
}

