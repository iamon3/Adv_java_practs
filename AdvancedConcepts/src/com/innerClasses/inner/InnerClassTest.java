package com.innerClasses.inner;

/**
 * 1. The outer class (the class containing the inner class) can instantiate as many number of inner class objects as it wishes, inside it’s code.
 * 
 * 2. If the inner class is public & the containing class as well, then code in some other unrelated class can as well create an instance of the inner class.
 * 
 * 3. No inner class objects are automatically instantiated with an outer class object
 * 
 * 4. If the inner class is static, then static inner class can be instantiated without an outer class instance, otherwise, 
 *    the inner class object must be associated with an instance of the outer class.
 *    
 *    		<OuterClassName>.this.<variableName>
 *    
 * 5. Inner class code has free access to all elements of the outer class object that contains it, 
 *    by name (no matter what the access level of the elements is), 
 *    if the inner class has a variable with same name then the outer class’s variable can be access like this
 *    
 * 6. The outer class can call even the private methods of the inner class.
 * 
 */
class OuterClass{
	String outerMember = "Outer";
	String sameNameMember = "outer";
	private InnerClass innerClass = new InnerClass();	
	
	{
		innerClass.setInnerClassMember("outerInner");
	}
	
	public void outerMethod(){
	   	System.out.println("this.innerClass's innerClassMember : "+ this.innerClass.getInnerClassMember() );	   	
	}
	
	class InnerClass{
		String innerMember = "Inner";
		String sameNameMember = "inner";
		private String innerClassMember = "innerPrivate";
		
		public void printOuterMember(){
			System.out.println("Our class member : " + OuterClass.this.sameNameMember);			
		}
		
		public void printInnerMember(){
			System.out.println("Our class member : " + this.sameNameMember);
		}

		public String getInnerClassMember() {
			System.out.println("inner class private member :" + innerClassMember);
			return innerClassMember;
		}

		public void setInnerClassMember(String innerClassMember) {
			this.innerClassMember = innerClassMember;
		}

	}
}

public class InnerClassTest {

	/**
	 * Output : 
	 * 
	 * 	Our class member : outer
		Our class member : inner
		inner class private member :innerPrivate
		inner class private member :outerInner
		this.innerClass's innerClassMember : outerInner
	 */
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.printOuterMember();
		innerClass.printInnerMember();
		innerClass.getInnerClassMember();
		outerClass.outerMethod();
	}
}
