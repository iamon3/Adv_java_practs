package com.ds.arrays;

/**
 *  Print array in spiral order.
 */
public class TestSpiralPrint {

	public static void main(String[] args) {

	TestSpiralPrint tsp = new TestSpiralPrint();
	tsp.print();
	}

	private void print() {
		int [][] arr = new int [][] {{1,2,3,4},{10, 11, 12, 5},{9, 8, 7,6}};
		
		int row_max = 2, row_min=0; // index 0 to 2
		int col_max = 3, col_min=0; // index 0 to 3 i.e. 3 X 4 matrix
		int dir = 1; //1 right, 2 down, 3 left, 4 up
		int i=0, j=0;
		
		while ( row_min<=row_max && col_min<=col_max){
			if(dir==1){
				if(j<=col_max){
					System.out.print(" " + arr[i][j]);
					j +=1;
				}
				else{
					System.out.println("");
					dir=2;
					j -= 1;
					i += 1;
					row_min +=1;
				}
			}
			else if(dir==2){
				if(i<=row_max){
					System.out.print(" " + arr[i][j]);
					i+=1;
				}
				else{
					System.out.println("");
					dir=3;
					i -=1;
					j -= 1;
				}
			}			
			else if(dir==3){
				if(j >= col_min){
					System.out.print(" " + arr[i][j]);
					j -= 1;					
				}
				else{
					System.out.println("");
					dir = 4;
					i-=1;
					j +=1;		
				}
			}
			else{
				if(i >= row_min){
					System.out.print(" " + arr[i][j]);
					i-=1;
				}
				else{
					System.out.println("");
					dir = 1;					
					i+=1;
					j +=1;
					col_min +=1;
					col_max -=1;
					row_max -=1;
				}
			}
		}
	}
}
