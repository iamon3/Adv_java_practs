package com.basic.datatypes.arrays.multidimensional;

public class MultidimensionalArray {

	public static void main(String[] args) {
		int[][][] arr = new int[2][][];
		
		// 2nd dimensional instantiation
		arr[0] = new int[1][];
		arr[1] = new int[2][];
		
		// 3rd dimensional instantiation
		arr[0][0] = new int[2];
		arr[1][0] = new int[1];
		arr[1][1] = new int[2];
		
		// 3rd dimensional initialization
		arr[0][0][0] = 1;
		arr[0][0][1] = 4;
		
		arr[1][0][0] = 2;		
		
		arr[1][1][0] = 1;		
		arr[1][1][1] = 5;
		
		
		for(int i = 0; i< arr.length; i++){
			System.out.println("arr["+i+"].length : " + arr[i].length);
			for(int j =0; j<arr[i].length; j++){
				System.out.println("arr["+i+"]["+j+"].length : " + arr[i][j].length);
				for(int k =0; k < arr[i][j].length; k++){
					System.out.print("arr["+i+"]["+j+"]["+k+"] : " + arr[i][j][k] + ", ");
				}				
			}
		}
		
		// arr1 is same as arr. 2nd option for instantiation and initialization
		int []arr1[][] = new int[][][] { {{1,4}}, {{2}, {1,5}}};
		System.out.println("\n\n ############# \n");
		for(int i = 0; i< arr1.length; i++){
			System.out.println("arr1["+i+"].length : " + arr1[i].length);
			for(int j =0; j<arr1[i].length; j++){
				System.out.println("arr1["+i+"]["+j+"].length : " + arr1[i][j].length);
				for(int k =0; k < arr1[i][j].length; k++){
					System.out.print("arr1["+i+"]["+j+"]["+k+"] : " + arr1[i][j][k]+ ", ");
				}				
			}
		}
	}
}
