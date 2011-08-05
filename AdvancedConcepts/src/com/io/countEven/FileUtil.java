package com.io.countEven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileUtil {

	public static Map<String,Integer> getEvenTokens(String inputFile) throws IOException{

		Map<String,Integer> evenDuplicates = new HashMap<String,Integer>();

		File readFile = new File(inputFile);
		FileReader fileReader = new FileReader(readFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String readLine ; 
		while((readLine = bufferedReader.readLine()) != null){
			System.out.println(readLine);
			String[] words = readLine.split(" ");
			for (String word : words) {
				if(evenDuplicates.containsKey(word)== false){
					evenDuplicates.put(word, 1);
				}
				else{
					evenDuplicates.put(word, evenDuplicates.get(word) + 1);
				}
			}
		}

		bufferedReader.close();
		fileReader.close();
		return removeOdd( evenDuplicates);
	}



	private static Map<String,Integer> removeOdd(Map<String,Integer> evenDuplicates){
		/*// One way Not Worked
		for(Map.Entry<String, Integer> word : evenDuplicates.entrySet()){
			if(word.getValue()%2 == 0){
	         System.out.println(word.getKey());
			//	evenDuplicates.remove(word.getKey());   // Gives concurrentModification Exception
			}
		}
		*/
		
		// Another way. Worked
		Iterator<Map.Entry<String, Integer>> it = evenDuplicates.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> element= it.next();
			if(element.getValue() %2 == 1){
			it.remove();
			}
		}
		return evenDuplicates;
	}
}

