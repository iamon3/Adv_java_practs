package com.collections.map.hashMap.keyAutboxing;

import java.util.HashMap;
import java.util.Map;

/**
 * Key in map can be primitive data type only when declaration includes corresponding wrapper function.
 * Auto-boxing takes care of primitive to Wrapper conversion. 
 */
public class TestAutoboxingKey {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		
		System.out.println("Map " + map);		
		
	}

}
