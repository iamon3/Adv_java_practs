package com.collections.map.hashMap.synchronizedHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedHashMapTest {

	public static void main(String[] args) {
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	Map<Integer, Integer> synchronizedHashMap = Collections.synchronizedMap(map);
	
	if(synchronizedHashMap == map){System.out.println("Same object is synchronized.");} // False
	else{System.out.println("Map is backed by Synchronized object i.e. Different object and not the same object.");} // True

	map.put(1, 1);
	synchronizedHashMap.put(2, 2);
	map.put(3, 3);
	synchronizedHashMap.put(4, 4);
	
	System.out.println("Map : " + map);  // {1=1, 2=2, 3=3, 4=4}
	System.out.println("SynchronizedMap : " + synchronizedHashMap); // {1=1, 2=2, 3=3, 4=4}
	}
}
