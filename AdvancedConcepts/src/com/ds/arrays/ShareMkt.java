package com.ds.arrays;

// Find min & max prices when a stock should have been bought and sold.

public class ShareMkt {

	public static void main(String[] args) {

		int[] arr = {13,2,4,41,26,24,15,38, 51,1};
		find(arr);
	}

	private static void find(int[] arr){
		int min = 100;
		int max = 101;
		int tempMin=100;

		for(int i=0; i < arr.length; i++){
			if(arr[i] < min && arr[i] < tempMin){
				tempMin=arr[i];
			}
			if(arr[i]> tempMin && (arr[i]-tempMin) > max-min){
				min = tempMin;
				max = arr[i];
			}
		}
		System.out.println("Min : " + min + ",max : " + max);
	}
}
