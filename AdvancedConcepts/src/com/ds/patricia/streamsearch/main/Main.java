package com.ds.patricia.streamsearch.main;

import com.ds.patricia.streamsearch.impl.DictionaryPatriciaImpl;
import com.ds.patricia.streamsearch.impl.FileFormatCSV;
import com.ds.patricia.streamsearch.impl.InputSourceCharArray;

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
