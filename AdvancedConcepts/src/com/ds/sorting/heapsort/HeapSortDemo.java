package com.ds.sorting.heapsort;

import java.util.Arrays;

public class HeapSortDemo {

	public static void main(String[] args) {
		int[] arr = {5,2,9,1,7,6,4,15,11,3,8,10,14,13};

		System.out.println("HeapSort : Before Sorting :- \n" + Arrays.toString(arr));
		HeapSortDemo heapSortDemo = new HeapSortDemo();
		heapSortDemo.heapSort(arr);
		System.out.println("HeapSort : After Sorting :- \n" + Arrays.toString(arr));
	}
	
	void heapSort(int[] input){
		int low = 0;
		int high = input.length - 1;
		buildMaxHeap(low, high, input);
		for(int k = high-1; k >= 0; k--){
			swap(0, k+1, input);
			maxHeapify(0, k, input );
		}
	}
	
	void buildMaxHeap(int low, int high, int[] input){		
		for(int i = ((low+high)/2); i >= 0; i--){
			maxHeapify(i, input.length -1, input);
		}
	}
	
	void maxHeapify(int parentIndex, int length, int[] input){
		int leftChildIndex = (parentIndex * 2) + 1;
		int rightChildIndex = (parentIndex * 2) + 2;
		//int length = input.length;
		int maxElementIndex =  parentIndex;
		
		if(leftChildIndex <= length && input[maxElementIndex] < input[leftChildIndex]){
			maxElementIndex = leftChildIndex;
		}		
		
		if(rightChildIndex <= length && input[maxElementIndex] < input[rightChildIndex]){
			maxElementIndex = rightChildIndex;
		}
		
		if(maxElementIndex != parentIndex){
			swap(maxElementIndex, parentIndex, input);
			maxHeapify(maxElementIndex, length, input);
		}
	}
	
	void swap(int i, int j, int[] input){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
