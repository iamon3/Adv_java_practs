package com.ds.patricia.streamsearch.main;

import com.ds.patricia.streamsearch.impl.DictionaryPatriciaImpl;
import com.ds.patricia.streamsearch.impl.FileFormatCSV;
import com.ds.patricia.streamsearch.impl.InputSourceCharArray;

/**
 * Problem Statement :
 * You will be receiving a Live InputStream and from where characters will be flowing in. 
 * You will receive a list of words from a file which is comma separated. 
 * From a live stream you will have to find out when you encountered particular word that you have received in an input file.
 * 
 * Assume Input Data as: helloiaminpunewhereiwillbewatchingamovieiwillalsoliketohavealunchafterwatchingamovie
 * Words to search: will like chaf
 * 
 * Evaluation:
 * 1) Try and implement in a single pass.
 * 
 * Description :
 * The solution developed by me uses the dictionary which is backed by the particia data structure. 
 * Although, I am not doing the search in a single pass, solution is still bit efficient in terms of time and memory complexity.
 * Another solution for the same problem can be found at : https://github.com/yuvitag/DirectorySearch

 */
public class Main {
	public static void main(String[] args) {
		
		Evaluator e = new Evaluator();
		
		String [] inputWords = {"abcd", "will", "inpune", "ill", "like", "inga" };
		String inputChar = "helloiaminpunewhereiwillbewatchingamovieiwillalsoliketohavealunchafterwatchingamovie";
		
		
		e.setFf(new FileFormatCSV(inputWords, new DictionaryPatriciaImpl()));
		e.setIc(new InputSourceCharArray(inputChar));
		final long startTime = System.currentTimeMillis();
		e.searchWords();
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
}
