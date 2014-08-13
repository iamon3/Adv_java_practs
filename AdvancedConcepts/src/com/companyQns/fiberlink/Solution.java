package com.companyQns.fiberlink;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
Login	krishna.nagaraj@yahoo.com
Password	d877300e
https://www.hackerrank.com/tests/51ad2b7322d53

Question : 

The X-duets of a string of characters are the ordered pairs of characters that are X distance from each other. 
A string is X-particular if all its X-duets are different. 
A string is Perfect String if it is X-particular for all possible X distances.

For e.g. take the string FLBL, its 0-duets are FL, LB and BL. Since all these are different, FLBL is 0-particular. 
Similarly, its 1-duets are FB and LL, since they are different FLBL is 1-particular as well. 
Lastly, the only 2-duets of FLBL is FL, so FLBL is 2-particular. Hence, FLBL is a Perfect String.

Note that the fact that FL is both a 0-duet and 2-duet is insignificant as zero and two are different distances.
 
Write a function called isPerfectString(String input) that returns a Boolean
Where: 
The "input" is a non-empty strings of at most 100 capital letters, each string on a line by itself, followed by a line containing only two dollars ($$) signaling the end of the input.
Output:
For each input line, output whether or not it is a Perfect string a boolean value


Sample Input	Sample Output

	FLBL			1
	FFLL			0
	ORDINARY		1
	R				1
	QYQRQYY			0

Note : Please do not use any print statements in your final function.
 */

public class Solution {
	
	static int isPerfectString(String input) {
		
		// Convert input String to char array for simplicity
		char[] inputCharArr = input.toCharArray();
		
		// Number of characters. 
		int noOfChar = inputCharArr.length;
		
		// If number of characters  = 1 then return 1, as it's a perfect String.
		if(1 == noOfChar) return 1;
		
		// Set of X-duets e.g. set of 0-duets or set of 1-duets etc
		Set<String> charPairs = new HashSet<String>();
		
		// k = distance i.e. for 0-duet distance = 0, 1-duet distance = 1 
		for(int k = 0; k <= noOfChar -2; k++){
			
			int i = 0; // start index
			int j = k + 1; // end index
			
			for(; j <= noOfChar -1; i++, j++ ){
				
				// Form a pair of string for k-duet
				String strPair = Character.toString(inputCharArr[i]) + Character.toString(inputCharArr[j]);
				
				// If the formed k-duet string is already present in set of k-duet strings, then it's not isPerfectString. return 0;
				// else insert new k-duet string in the set of k-duet strings
				if( charPairs.contains(strPair)) return 0;
				charPairs.add(strPair);
			}
			
			// Clear the set of k-duet strings inserted, to insert new set of (k+1)-duet strings
			charPairs.clear();
		}
		
		// Since k-particular for all possible k distances, the input string is a perfect string. Thus return 1.
		return 1;
    }
	
	public static void main(String[] args) throws IOException{
		
		String input = "QYQRQYY";
		System.out.println(input + " : " + isPerfectString(input));
		/**
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        String _input;
        _input = in.nextLine();
        
        res = isPerfectString(_input);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();*/	
    }
}
