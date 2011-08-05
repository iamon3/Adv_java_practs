package com.Strings.equalsCheckEg;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s2);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s2));
	}

}
