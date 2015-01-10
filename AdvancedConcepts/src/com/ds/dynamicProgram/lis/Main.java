package com.ds.dynamicProgram.lis;

public class Main {

	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		LongestIncreasingSubSequence lis = new LISBruteForceImpl();
		long startTime = System.currentTimeMillis();
		System.out.println("Longest Incresing Sequence : " + lis.findLIS(arr));
		long endTime = System.currentTimeMillis();
		System.out.println("ExecutionTime Milli seconds: " + (endTime - startTime));
	}
}
