package com.basic.datatypes.strings;

public class StringTest {

	public static void main(String[] args) {
      String str = "hello";      
      String str2 = "hel";
      String str3 = "lo";
      String str4 = str2 + str3;
      String str1 = "hel" + "lo";
      String str5 = new String("hello");
      String str6 = str5.intern();
      
      System.out.println( "str==str1 : " + (str==str1));
      System.out.println( "str==str4 : " + (str==str4));
      System.out.println( "str==str5 : " + (str==str5));
      System.out.println( "str==str6 : " + (str==str6));      
	}

}
