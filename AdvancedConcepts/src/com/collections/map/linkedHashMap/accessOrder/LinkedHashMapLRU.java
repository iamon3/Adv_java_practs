package com.collections.map.linkedHashMap.accessOrder;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRU {
	public static void main(String[] args) {
		
		// Initial Capacity, load factor, accessOrder - the ordering mode - true for access-order, false for insertion-order
		Map<Integer, String> map = new LinkedHashMap<Integer, String>(10, 0.75f, true);
		
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
		
		// Default accessOrder : insertion
		System.out.println("\n============== Default accessOrder : Insertion ==============\n");
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		linkedHashMap.put(1, "One");
		linkedHashMap.put(2, "Two");
		linkedHashMap.put(3, "Three");
		linkedHashMap.put(4, "Four");
		
		System.out.println("Map " + linkedHashMap);		
		
		System.out.println("\nAccessed : " + linkedHashMap.get(2));
		System.out.println("Accessed : " + linkedHashMap.get(4));
		System.out.println("Accessed : " + linkedHashMap.get(1));
		System.out.println("Accessed : " + linkedHashMap.get(3));
		
		System.out.println("\nAfter accessing Map elements order : " + linkedHashMap);

	}
}
