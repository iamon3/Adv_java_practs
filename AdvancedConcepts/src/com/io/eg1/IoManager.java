package com.io.eg1;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IoManager {
	public static  void main(String [] args) throws IOException{
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter File name");
		String fileName = ip.next();
	//	System.out.println("You entered :- "+ fileName);
		
		File file = new File(fileName);
		file.createNewFile();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
	while((line = br.readLine()) != null){
		System.out.println(line);
	}
	br.close();
		/*
		Console c = System.console();
		System.out.println("enter Password");
		char[] passwd = c.readPassword();
		System.out.println("ur Password "+ passwd);
		*/
	}
}
