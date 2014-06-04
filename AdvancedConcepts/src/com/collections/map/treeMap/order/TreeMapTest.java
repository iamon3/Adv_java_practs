package com.collections.map.treeMap.order;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		
		// Initial Capacity, load factor, accessOrder - the ordering mode - true for access-order, false for insertion-order
		Map<Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		
		System.out.println("Map " + map);		
		
		System.out.println("\nAccessed : " + map.get(2));
		System.out.println("Accessed : " + map.get(4));
		System.out.println("Accessed : " + map.get(1));
		System.out.println("Accessed : " + map.get(3));
		
		System.out.println("\nAfter accessing Map elements order : " + map);
		
	}
}
