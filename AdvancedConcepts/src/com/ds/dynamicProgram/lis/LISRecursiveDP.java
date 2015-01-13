package com.ds.dynamicProgram.lis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LISRecursiveDP implements LongestIncreasingSubSequence {
	HashMap<Integer, ArrayList<Integer>> result;
	@Override
	public List<Integer> findLIS(int[] arr) {
		result = new HashMap<Integer, ArrayList<Integer>>();
		return findLIS(0, arr);
	}

	private ArrayList<Integer> findLIS(int i, int[] arr) {
		ArrayList<Integer> lis ;
		if(i == arr.length-1){
			lis = new ArrayList<Integer>();
			lis.add(arr[i]);
			result.put(i, lis);
			return lis;
		}
		ArrayList<Integer> exclusion = lisStartingFrom(i+1, arr);
		ArrayList<Integer> inclusion = lisStartingFrom(i, arr);
		return (inclusion.size() < exclusion.size()? exclusion : inclusion);
	}

	private ArrayList<Integer> lisStartingFrom(int i, int[] arr) {
		int secondGreaterElmIndex =i+1;
		ArrayList<Integer> longestSubSequenceStartingFrom = new ArrayList<Integer>();
		longestSubSequenceStartingFrom.add(arr[i]);

		while(secondGreaterElmIndex < arr.length){
			if(arr[i] < arr[secondGreaterElmIndex]){				
				if(longestSubSequenceStartingFrom.size() > 0){
					int  longestSubSeqSecondGreaterNumber  = 0;
					if(longestSubSequenceStartingFrom.size() > 1){
						longestSubSeqSecondGreaterNumber = longestSubSequenceStartingFrom.get(1);
					}
					if(0 == longestSubSeqSecondGreaterNumber || longestSubSeqSecondGreaterNumber > arr[secondGreaterElmIndex]){
						ArrayList<Integer>  newSubSequence = new ArrayList<Integer>();
						newSubSequence.add(arr[i]);
						// Store the result of recursive call if it is not stored, to avoid repeated duplicate recursive calls
						if(!result.containsKey(secondGreaterElmIndex)){
							ArrayList<Integer> lisStartingFromSecondGreaterElmIndex = findLIS(secondGreaterElmIndex, arr);
							result.put(secondGreaterElmIndex, lisStartingFromSecondGreaterElmIndex);							
						}
						newSubSequence.addAll(result.get(secondGreaterElmIndex));						
						if(longestSubSequenceStartingFrom.size() < newSubSequence.size()){
							longestSubSequenceStartingFrom.clear();
							longestSubSequenceStartingFrom = newSubSequence;
						}						
					}
				}
			}
			secondGreaterElmIndex ++;
		}
		result.put(i, longestSubSequenceStartingFrom);
		System.out.println("LIS starting from "+arr[i]+" : " + result.get(i));
		return result.get(i);
	}
}
