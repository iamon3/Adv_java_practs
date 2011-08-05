package com.io.readNwriteFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String inputFile="E:\\ReadFile.txt";
		File readFile = new File(inputFile);
		FileReader fileReader = new FileReader(readFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String outputFile="E:\\WriteFile.txt";
		File writeFile = new File(outputFile);
		System.out.println(writeFile.createNewFile());
		FileWriter fileWriter = new FileWriter(writeFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		String readLine; 
		while((readLine = bufferedReader.readLine()) != null){
			System.out.println(readLine);
			bufferedWriter.write(readLine);
			bufferedWriter.newLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
		fileReader.close();
		fileWriter.close();
	}

}
