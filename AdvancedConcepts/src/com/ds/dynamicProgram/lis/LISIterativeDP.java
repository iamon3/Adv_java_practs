package com.ds.dynamicProgram.lis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LISIterativeDP implements LongestIncreasingSubSequence {
	
	HashMap<Integer, ArrayList<Integer>> result;
	
	@Override
	public List<Integer> findLIS(int[] arr) {
		result = new HashMap<Integer, ArrayList<Integer>>();
		
		ArrayList<Integer> lis = new ArrayList<Integer>();
		
		lis.add(arr[arr.length-1]);
		result.put(arr.length-1, lis);
		
		//have not handled the corner case when arr.length == 2
		for(int i = arr.length-2; i >= 0 ;i--){
			lis = new ArrayList<Integer>();			
			// Construct  LIS when arr[i] is included
			lis.add(arr[i]);
			
			// Find next element greater than arr[i]
			int j = i+1;
			for(; j< arr.length && arr[i] > arr[j];j++); //Handle condition when j == arr.length
			lis.addAll(result.get(j));
		
			// Compare results of inclusion and exclusion of arr[i],and keep the one with the longest result
			if(result.get(i+1).size() < lis.size()){
				result.put(i, lis);
			}
			else if (result.get(i+1).size() > lis.size()){
				lis.clear();
				lis = new ArrayList<Integer>();
				lis.addAll(result.get(i+1));
				result.put(i, lis);
			}
			else{
				if(arr[i] > result.get(i+1).get(0)){
					result.put(i, lis);
				}
				else{
					lis.clear();
					lis = new ArrayList<Integer>();
					lis.addAll(result.get(i+1));
					result.put(i, lis);
				}
			}						
		}	
		
		return result.get(0);
	}
}
