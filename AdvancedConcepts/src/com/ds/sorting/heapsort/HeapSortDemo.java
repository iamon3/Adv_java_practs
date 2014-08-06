package com.ds.sorting.heapsort;

import java.util.Arrays;

public class HeapSortDemo {

	public static void main(String[] args) {
		int[] arr = {5,2,9,1,7,6,4,15,11,3,8,10,14,13};

		System.out.println("############\nHeapSort : Before Sorting :- \n" + Arrays.toString(arr)+"\n#############");
		HeapSortDemo heapSortDemo = new HeapSortDemo();
		heapSortDemo.heapSort(arr);
		System.out.println("###########\nHeapSort : After Sorting :- \n" + Arrays.toString(arr)+"\n#############");
	}
	
	void heapSort(int[] input){
		int low = 0;
		int high = input.length - 1;
		buildMaxHeap(low, high, input);
		System.out.println("\n###########\nMax Heap is built \n" + Arrays.toString(input)+"\n#########");
		for(int k = high-1; k >= 0; k--){
			System.out.println("\n###########\nBefore swapping max element : " + Arrays.toString(input));
			swap(0, k+1, input);
			System.out.println("After swapping max element : " + Arrays.toString(input));
			maxHeapify(0, k, input );
			System.out.println("After heapifying arr : " + Arrays.toString(input)+"\n###########");
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
