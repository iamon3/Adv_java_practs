package com.collections.list.arrayList.eg1;

import java.util.ArrayList;
import java.util.List;

public class TestAddRemove {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<Integer>();
		
		// Elements are added as 1, 2, 3, 4
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);		
		System.out.println(intList); // [1, 2, 3, 4]

		// After removal of 0th index element, rest of the elements are shifted to left.
		intList.remove(0);
		System.out.println(intList + " Element at 0th index : "+intList.get(0)); // [2, 3, 4]
		intList.remove(0);
		System.out.println(intList + " Element at 0th index : "+intList.get(0)); // [3, 4]	
		
		// If elements are added at the zero index, already present elements are shifted to right.
		intList.add(0, 5);
		intList.add(0, 6);
		System.out.println(intList + " Element at 0th index : "+intList.get(0)); // [6, 5, 3, 4]
		
	}
}
