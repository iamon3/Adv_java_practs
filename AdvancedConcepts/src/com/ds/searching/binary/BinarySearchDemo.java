package com.ds.searching.binary;

import com.ds.sorting.quicksort.QuickSortDemo;

public class BinarySearchDemo {

	public static void main(String[] args) {
		int[] arr = {5,2,9,1,7,6,4,15,11,3,8,10,14,13};
		
		// Sort the array
		QuickSortDemo quickSort = new QuickSortDemo();		
		quickSort.quickSort(arr);
		
		// Search the element in the sorted array
		int elementToBeSearched = -11;
		BinarySearchDemo binarySearchDemo = new BinarySearchDemo();	
		System.out.println("Is element  " + elementToBeSearched + " present : " +   binarySearchDemo.binarySearch(elementToBeSearched, arr));
		elementToBeSearched = 15;
		System.out.println("Is element  " + elementToBeSearched + " present : " +   binarySearchDemo.binarySearch(elementToBeSearched, arr));
	}
	
	boolean binarySearch(int element, int[] sortedArray){
		boolean found = false;
		
		int low = 0;
		int high  = sortedArray.length - 1;
		
		while(low <= high){
			
			int mid = (low + high) / 2;
			
			if(element == sortedArray[mid]){
				found  = true;
				break;
			}
			else if(element < sortedArray[mid]){
				high = mid -1;
			}
			else if (element > sortedArray[mid]){
				low = mid +1;
			}
		}
		
		return found;
	}
}
