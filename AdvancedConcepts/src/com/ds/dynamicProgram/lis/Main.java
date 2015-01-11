package com.ds.dynamicProgram.lis;

public class Main {

	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		LongestIncreasingSubSequence bruteForceLis = new LISBruteForceImpl();
		long startTime = System.currentTimeMillis();
		System.out.println("Longest Incresing Sequence : " + bruteForceLis.findLIS(arr));
		long endTime = System.currentTimeMillis();

		
		LongestIncreasingSubSequence recursiveLis = new LISBruteForceImpl();
		long startTime1 = System.currentTimeMillis();
		System.out.println("Longest Incresing Sequence : " + recursiveLis.findLIS(arr));
		long endTime1 = System.currentTimeMillis();
		
		System.out.println("Brute Force ExecutionTime Milli seconds: " + (endTime - startTime));
		System.out.println("Recusrive ExecutionTime Milli seconds: " + (endTime1 - startTime1));

	}
}
