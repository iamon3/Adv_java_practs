package com.ds.dynamicProgram.lis;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] arr = {10, 1, 2, 3, 4, 5, 31, 22, 9, 33, 21, 50, 41, 60, 80};
		
		List<Integer> bruteForceResult= null;
		List<Integer> recursiveResult= null;
		List<Integer> recursiveDPResult= null;
		List<Integer> iterativeDPResult= null;
		
		System.out.println("\n\n>>>>>>>>>> Starting Brute Force <<<<<<<<<<<<\n\n");
		LongestIncreasingSubSequence bruteForceLis = new LISBruteForceImpl();
		long startTime = System.currentTimeMillis();
		bruteForceResult = bruteForceLis.findLIS(arr);
		long endTime = System.currentTimeMillis();

		System.out.println("\n\n>>>>>>>>>> Starting Recursive <<<<<<<<<<<<\n\n");
		LongestIncreasingSubSequence recursiveLis = new LISRecusriveImpl();
		long startTime1 = System.currentTimeMillis();
		recursiveResult = recursiveLis.findLIS(arr);
		long endTime1 = System.currentTimeMillis();
		
		System.out.println("\n\n>>>>>>>>>> Starting Recursive DP <<<<<<<<<<<<\n\n");
		LongestIncreasingSubSequence recursiveDPLis = new LISRecursiveDP();
		long startTime2 = System.currentTimeMillis();
		recursiveDPResult = recursiveDPLis.findLIS(arr);		
		long endTime2 = System.currentTimeMillis();
		
		System.out.println("\n\n>>>>>>>>>> Starting Iterative DP <<<<<<<<<<<<\n\n");
		LongestIncreasingSubSequence iterativeDPLis = new LISIterativeDP();
		long startTime3 = System.currentTimeMillis();
		iterativeDPResult = iterativeDPLis.findLIS(arr);		
		long endTime3 = System.currentTimeMillis();
		
		System.out.println("\n\n>>>>>>>>>> HERE WE GO RESULTS <<<<<<<<<<<<\n\n");
		System.out.println("Longest Incresing Sequence : " + bruteForceResult);
		System.out.println("Brute Force ExecutionTime Milli seconds: " + (endTime - startTime));
		System.out.println("Longest Incresing Sequence Recursive : " + recursiveResult);
		System.out.println("Recusrive ExecutionTime Milli seconds: " + (endTime1 - startTime1));
		System.out.println("Longest Incresing Sequence Recursive DP : " + recursiveDPResult);
		System.out.println("Recusrive DP ExecutionTime Milli seconds: " + (endTime2 - startTime2));
		System.out.println("Longest Incresing Sequence Iterative DP : " + iterativeDPResult);
		System.out.println("Iterative DP ExecutionTime Milli seconds: " + (endTime3 - startTime3));

	}
}
