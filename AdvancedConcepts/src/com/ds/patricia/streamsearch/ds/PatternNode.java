package com.ds.patricia.streamsearch.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represent a Node in the Patricia tree. 
 */
public class PatternNode {
	private int visitCount; // No of times this node is visited.
	private Character c;
	private boolean isWord = false;
	private Map<Character, PatternNode> patternContinue = new HashMap<Character, PatternNode>();
	
	public static PatternNode getInstance(Character c){
		PatternNode p = new PatternNode();
		p.setC(c);		
		return p;
	}
	
	public void incrementVisitCount(){
		++visitCount;
	}
	
	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public Character getC() {
		return c;
	}
	public void setC(Character c) {
		this.c = c;
	}
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	public Map<Character, PatternNode> getPatternContinue() {
		return patternContinue;
	}
	public void setPatternContinue(Map<Character, PatternNode> patternContinue) {
		this.patternContinue = patternContinue;
	}	
}
