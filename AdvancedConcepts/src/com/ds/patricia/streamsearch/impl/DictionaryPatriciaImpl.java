package com.ds.patricia.streamsearch.impl;

import java.util.HashMap;
import java.util.Map;

import com.ds.patricia.streamsearch.ds.PatternNode;
import com.ds.patricia.streamsearch.iface.Dictionary;

public class DictionaryPatriciaImpl implements Dictionary{

	private Map<Character, PatternNode> rootPatternNodes = new HashMap<Character, PatternNode>();
	private int longestWordLenth;

	@Override
	public void initDictionary(String[] input) {
		for(String word : input){
			addWord(word);	
			int wordLength = word.length();
			if(longestWordLenth < wordLength){
				longestWordLenth = wordLength;
			}
		}
	}

	@Override
	public void addWord(String word) {		
		char[] wordToChar = word.toCharArray();
		if(!rootPatternNodes.containsKey(wordToChar[0])){
			PatternNode pn = PatternNode.getInstance(wordToChar[0]);					;
			rootPatternNodes.put(wordToChar[0], pn);
		}

		int i=0;
		PatternNode parentNode = rootPatternNodes.get(wordToChar[i]);
		PatternNode childNode = null;
		while( ++i < wordToChar.length){
			if(!parentNode.getPatternContinue().containsKey(wordToChar[i])){
				childNode = PatternNode.getInstance(wordToChar[i]);
				parentNode.getPatternContinue().put(wordToChar[i], childNode);
			}else{
				childNode = parentNode.getPatternContinue().get(wordToChar[i]);
			}
			parentNode = childNode;
		}		
		parentNode.setWord(true);
		
		int wordLength = word.length();
		if(longestWordLenth < wordLength){
			longestWordLenth = wordLength;
		}
	}

	@Override
	public void searchWords(String pattern) {
		char[] patternCharArr = pattern.toCharArray();

		if(rootPatternNodes.containsKey(patternCharArr[0])){

			StringBuilder sb = new StringBuilder();			
			PatternNode patternNode = rootPatternNodes.get(patternCharArr[0]);			
			sb.append(patternNode.getC());

			if(patternNode.isWord()){
				patternNode.incrementVisitCount();
				System.out.println("Word found : " + sb.toString() + " count : " + patternNode.getVisitCount());
			}			

			int i= 0;			
			while( ++i < patternCharArr.length && patternNode.getPatternContinue().containsKey(patternCharArr[i])){
				patternNode = patternNode.getPatternContinue().get(patternCharArr[i]);
				sb.append(patternNode.getC());
				if(patternNode.isWord()){
					patternNode.incrementVisitCount();
					System.out.println("Word found : " + sb.toString() + " count : " + patternNode.getVisitCount());
				}			

			}
			sb.delete(0, sb.length());
		}		
	}

	@Override
	public int getLongestWordLength() {
		return longestWordLenth;
	}
}
