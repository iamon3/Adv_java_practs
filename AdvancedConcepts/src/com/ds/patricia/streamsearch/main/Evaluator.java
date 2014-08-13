package com.ds.patricia.streamsearch.main;

import com.ds.patricia.streamsearch.iface.Dictionary;
import com.ds.patricia.streamsearch.iface.FileFormat;
import com.ds.patricia.streamsearch.iface.InputCharSource;


public class Evaluator {
	
	private FileFormat ff;
	private InputCharSource ic;
	
	
	public void searchWords(){
		Dictionary d = ff.getWordDictionary();
		StringBuilder streamWindow = new StringBuilder();
		int i = 0;
		
		while(ic.isNext() && i < d.getLongestWordLength()){
			streamWindow.append(ic.getNextChar());
			i++;
		}
		
		d.searchWords(streamWindow.toString());
		
		while(ic.isNext()){
			streamWindow.deleteCharAt(0).append(ic.getNextChar());
			d.searchWords(streamWindow.toString());			
		}
		
		streamWindow.deleteCharAt(0);
		while(streamWindow.length() > 0){
			d.searchWords(streamWindow.toString());
			streamWindow.deleteCharAt(0);
		}
	}
	
	public FileFormat getFf() {
		return ff;
	}
	public void setFf(FileFormat ff) {
		this.ff = ff;
	}
	public InputCharSource getIc() {
		return ic;
	}
	public void setIc(InputCharSource ic) {
		this.ic = ic;
	}
}
