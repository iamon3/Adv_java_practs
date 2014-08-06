package com.ds.sorting.quicksort;

import java.util.Arrays;

public class QuickSortDemo {

	public static void main(String[] args) {
		int[] arr = {5,2,9,1,7,6,4,15,11,3,8,10,14,13};

		System.out.println("Before Sorting :- \n" + Arrays.toString(arr));
		QuickSortDemo quickSortDemo = new QuickSortDemo();
		quickSortDemo.quickSort(0, arr.length-1, arr);
		System.out.println("After Sorting :- \n" + Arrays.toString(arr));
	}

	void quickSort(int low, int high, int[] input){
		if(low < high){
			int partitioningIndex = partition(low, high, input); 
			quickSort(low, partitioningIndex-1, input);
			quickSort(partitioningIndex+1, high, input);
		}
	}

	int partition(int low, int high, int[] input){
		int pivoteElement = input[high];
		int partitionIndex = low-1;		
		for(int i=low; i<high; i++){
			if(input[i] <= pivoteElement){
				partitionIndex ++;
				swap(i, partitionIndex, input);				
			}
		}
		
		swap(partitionIndex+1, high, input);
		return partitionIndex+1;
	}
	
	void swap(int i, int j, int[] input){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}	
}