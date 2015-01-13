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
			
			// Find LIS when arr[i] is included
			lis.add(arr[i]);
			int j= i+1;
			for(; j < arr.length && arr[i]>arr[j]; j++);			
			if(j < arr.length){ 
				lis.addAll(result.get(j));
			}	
			
			if(lis.size() <  result.get(i+1).size()){
				lis.clear();
				lis.addAll(result.get(j));				
			}
			result.put(i, lis);
		}	
		return result.get(0);
	}
}
