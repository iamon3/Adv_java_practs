package com.io.countEven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile="E:\\ReadFile.txt";   
		Map<String, Integer> evenDuplicates=null;

		try {
			evenDuplicates = FileUtil.getEvenTokens(inputFile);
			System.out.println("Even Tokens------");
			System.out.println(evenDuplicates);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
