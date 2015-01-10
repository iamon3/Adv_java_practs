package com.ds.dynamicProgram.lis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class LISBruteForceImpl implements LongestIncreasingSubSequence {

	@Override
	public List<Integer> findLIS(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> allIncreasingSubSequesncesForEachElm = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0; i< arr.length; i++){
			List<ArrayList<Integer>> allIncreasingSubSequences = findAllSubSequencesStartingFrom(i, arr);
			allIncreasingSubSequesncesForEachElm.put(i, longestIncreasingSubSequenceFrom(allIncreasingSubSequences));
		}
		
		return maxLengthSubSequence(allIncreasingSubSequesncesForEachElm);	
	}
		
	private ArrayList<Integer> longestIncreasingSubSequenceFrom(List<ArrayList<Integer>> allIncreasingSubSequences) {
		int maxSubSeqIndex = 0;
		int maxSize= allIncreasingSubSequences.get(0).size();
		for(int i=1; i < allIncreasingSubSequences.size(); i++){
			if(maxSize < allIncreasingSubSequences.get(i).size()){
				maxSubSeqIndex = i;
				maxSize = allIncreasingSubSequences.get(i).size();
			}
		}
		return allIncreasingSubSequences.get(maxSubSeqIndex);
	}

	private List maxLengthSubSequence(HashMap<Integer, ArrayList<Integer>> longestIncreasingSubSequesncesForEachElm) {
		int longestSubSequenceElement = -1;
		int longesSubSequenceLength = 0;
		for(Integer element :longestIncreasingSubSequesncesForEachElm.keySet()){
			if(longesSubSequenceLength < longestIncreasingSubSequesncesForEachElm.get(element).size()){
				longestSubSequenceElement = element;
				longesSubSequenceLength = longestIncreasingSubSequesncesForEachElm.get(element).size();
			}
		}
		return longestIncreasingSubSequesncesForEachElm.get(longestSubSequenceElement);
	}

	private List<ArrayList<Integer>> findAllSubSequencesStartingFrom(int i, int[] arr) {
		int secondGreaterElmIndex =i+1;
		LinkedList<ArrayList<Integer>> allSubSequencesStartingFrom = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer>  initialSubSequence = new ArrayList<Integer>();
		initialSubSequence.add(arr[i]);
		allSubSequencesStartingFrom.add(initialSubSequence);
		System.out.println("Initially : " + allSubSequencesStartingFrom);
		while(secondGreaterElmIndex < arr.length){
			if(arr[i] < arr[secondGreaterElmIndex]){
				System.out.println("Next SubSequence Greater elm : " +arr[secondGreaterElmIndex]);
				ArrayList<Integer> lastSubSequence = allSubSequencesStartingFrom.getLast();
				
				if(lastSubSequence.size() > 0){
					System.out.println("Last SubSequence : " + lastSubSequence);
					int  lastSubSeqSecondGreaterNumber  = 0;
					if(lastSubSequence.size() > 1){
						lastSubSeqSecondGreaterNumber = lastSubSequence.get(1);
						System.out.println("Last sub sequence second greater number : " + lastSubSeqSecondGreaterNumber);
					}
					
					if(0 == lastSubSeqSecondGreaterNumber || lastSubSeqSecondGreaterNumber > arr[secondGreaterElmIndex]){
						ArrayList<Integer>  newSubSequence = new ArrayList<Integer>();
						newSubSequence.add(arr[i]);
						newSubSequence.add(arr[secondGreaterElmIndex]);
						int lastGreaterNumber = arr[secondGreaterElmIndex];
						for(int k = secondGreaterElmIndex +1; k<arr.length;k++){
							if(arr[k]>lastGreaterNumber){
								newSubSequence.add(arr[k]);
								lastGreaterNumber =arr[k];
								System.out.println("Subsequence being created : " + newSubSequence);
							}
						}
						allSubSequencesStartingFrom.add(newSubSequence);
						System.out.println("Allsubsequences : " + allSubSequencesStartingFrom);
					}
				}
			}
			secondGreaterElmIndex ++;
		}
		return allSubSequencesStartingFrom;
	}
}
