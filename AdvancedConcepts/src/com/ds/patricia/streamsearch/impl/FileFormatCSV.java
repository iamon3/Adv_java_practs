package com.ds.patricia.streamsearch.impl;

import com.ds.patricia.streamsearch.iface.Dictionary;
import com.ds.patricia.streamsearch.iface.FileFormat;

public class FileFormatCSV implements FileFormat {
	
	Dictionary dictionary;
	
	FileFormatCSV(){		
		
	}

	public FileFormatCSV(String[] input, Dictionary d){
		this.dictionary = d;
		d.initDictionary(input);
	}
		
	@Override
	public Dictionary getWordDictionary() {		
		return dictionary;
	}

	public void setDictionary(Dictionary d) {
		this.dictionary = d;
	}
}
