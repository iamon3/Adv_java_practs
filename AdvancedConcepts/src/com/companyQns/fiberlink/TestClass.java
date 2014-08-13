package com.companyQns.fiberlink;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestClass {
/**
 * 
Login	krishna.nagaraj@yahoo.com
Password	d877300e
https://www.hackerrank.com/tests/51ad2b7322d53

The X-duets of a string of characters are the ordered pairs of characters that are X distance from each other. A string is X-particular if all its X-duets are different. A string is Perfect String if it is X-particular for all possible X distances.
For e.g. take the string FLBL, its 0-duets are FL, LB and BL. Since all these are different, FLBL is 0-particular. Similarly, its 1-duets are FB and LL, since they are different FLBL is 1-particular as well. Lastly, the only 2-duets of FLBL is FL, so FLBL is 2-particular. Hence, FLBL is a Perfect String.
Note that the fact that FL is both a 0-duet and 2-duet is insignificant as zero and two are different distances.
 
Write a function called isPerfectString(String input) that returns a Boolean
Where: 
The "input" is a non-empty strings of at most 100 capital letters, each string on a line by itself, followed by a line containing only two dollars ($$) signaling the end of the input.
Output:
For each input line, output whether or not it is a Perfect string a boolean value


Sample Input	Sample Output
FLBL	1
FFLL	0
ORDINARY	1
R	1
QYQRQYY	0
Note : Please do not use any print statements in your final function.
 */
	
	static int isPerfectString(String input) {
		
        // Case -1 : NULL or input string is invalid. Thus return 0.
		if(null == input || input.trim() == "") return 0;
		
		// Convert input String to char array for simplicity
		char[] inputCharArr = input.toCharArray();
		
		// Count of characters
		int charCount = inputCharArr.length;
		
		// If count of characters  = 1 then return 1, as it's a perfect String.
		if(charCount == 1) return 1;
		
		// Set of X-duets e.g. set of 0-duets or set of 1-duets etc
		Set<String> x_duets = new HashSet<String>();

		// To hold temp string of X-duet
		StringBuilder sb = new StringBuilder();
		
		// distance i.e. for 0-duet distance = 0, 1-duet distance = 1
		for(int distance = 0; distance <= charCount-2; distance++){
			
			// In X-duet e.g. FB Left character 'L' is present at index in
			int leftIndex = 0; 
						
			for(int rightIndex = distance + 1; rightIndex <= charCount -1; leftIndex++, rightIndex++ ){

				// Form a pair of string for k-duet				
				sb.append(inputCharArr[leftIndex]).append(inputCharArr[rightIndex]);
				
				// If the formed k-duet string is already present in set of k-duet strings, 
                // then it's not isPerfectString. return 0;				
				if( x_duets.contains(sb.toString())){ 
					x_duets.clear(); 
					return 0;
				}
				// else insert new k-duet string in the set of k-duet strings				
				x_duets.add(sb.toString()); 
				sb.delete(0, sb.length());
			}
			
			x_duets.clear();
		}		
		return 1;
    }
	
	
	public static void main(String[] args) throws IOException{
		
		String input = "QYQRQYY";
		System.out.println(input + " : " + isPerfectString(input));
    }
}
