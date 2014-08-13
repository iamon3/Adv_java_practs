package com.ds.patricia.streamsearch.impl;

import com.ds.patricia.streamsearch.iface.InputCharSource;

public class InputSourceCharArray implements InputCharSource {

	char[] inputCharStream;
	private int count = 0;
	
	public InputSourceCharArray(String input){
		inputCharStream = input.toCharArray();
	}
	
	@Override
	public Character getNextChar() {
		return  inputCharStream[count++];
	}

	@Override
	public boolean isNext() {
		if(count < inputCharStream.length){
			return true;
		}
		return false;
	}

}
