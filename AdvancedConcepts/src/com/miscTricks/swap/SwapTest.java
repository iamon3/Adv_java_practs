package com.miscTricks.swap;

public class SwapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Integer a = new Integer(5);
     Integer b = new Integer(10);
     swap(a,b);
     System.out.println(a+" "+b+"...Ooopsss !! Failed it did not swap..Try new Trick");
	}
	
	static void swap(Integer a, Integer b){
		Integer temp;
		temp = a;
		a=b;
		b=temp;
	}

}
