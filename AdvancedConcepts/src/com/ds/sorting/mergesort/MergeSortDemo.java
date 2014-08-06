package com.ds.sorting.mergesort;

import java.util.Arrays;

public class MergeSortDemo {

	public static void main(String[] args) {
		int[] arr = {5,2,9,1,7,6,4,15,11,3,8,10,14,13,12};
		int[] arr1 = {2, 1};
		System.out.println("\n######################### \n MergeSort : Before Sorting :- \n" + Arrays.toString(arr) + "\n ################");
		MergeSortDemo mergeSortDemo = new MergeSortDemo();
		mergeSortDemo.mergeSort(arr);		
		System.out.println("\n######################### \n MergeSort : After Sorting :- \n" + Arrays.toString(arr)+ "\n ################");
	}

	void mergeSort(int[] arr){
		int low = 0;
		int high = arr.length -1;
		mergeSort(low, high, arr);
	}

	void mergeSort(int low, int high, int[] arr){
		if(low < high){
			int mid = (low + high)/2;
			mergeSort(low, mid, arr);
			mergeSort(mid+1, high, arr);
			merge(low, mid, high, arr);			
		}
	}

	void merge(int low, int mid,int high, int[] arr){
		System.out.println("\n###############\nlow : " + low + ", mid : " + mid+ ", high : "+high );
		System.out.println("Going to merge arr1 : " + Arrays.toString(Arrays.copyOfRange(arr, low, mid+1)) + "\n" + " arr2 : "+ Arrays.toString(Arrays.copyOfRange(arr, mid+1, high+1)));
	    
		// Instead of returning temporary array each time, we can use 1 n/2 size array throughout for copying
		int[] arr1 = copyArray(low, mid, arr);

		int low1 = 0;
		int high1 = arr1.length -1;
		int pointer1 = low1;
		int pointer2 = mid+1;

		for(int i = low; i <= high ; i++){
			if(pointer1 <= high1 && pointer2 <= high){
				if(arr1[pointer1] < arr[pointer2]){
					arr[i] = arr1[pointer1];	
					pointer1 ++;
				}
				else{
					arr[i] = arr[pointer2];	
					pointer2 ++;					
				}	
			}
			else if(pointer1 <= high1 && pointer2 > high){
				arr[i] = arr1[pointer1];	
				pointer1 ++;
			}
			else if(pointer1 > high1 && pointer2 <= high){
				arr[i] = arr[pointer2];	
				pointer2 ++;									
			}
			else{
				break;
			}
		}
		// clean arr1
		arr1 = null;
		System.out.println("\n After merging arr1 and arr2 : " +  Arrays.toString(Arrays.copyOfRange(arr, low, high+1)) + "\n and Main array : " + Arrays.toString(arr) + "\n##############");
		
	}

	void merge(int low1, int high1, int low2, int high2, int[] arr1, int[] arr2){

	}

	int[] copyArray(int from, int to, int[] arr){
		int size = (to - from) + 1;
		int[] arr1 = new int[size];
		for(int i = 0; i < size; i++){
			arr1[i] = arr[from+i];
		}
		return arr1;
	}
}
