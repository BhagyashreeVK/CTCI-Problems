package ArraysandStrings;

public class ZeroMatrix {

	//Matrix of MxN;
	//Time: O(MN), Space: O(1)
	public void makeZeroMatrix(int[][] matrix){
		
		int[] rows  = new int[matrix.length];
		int[] columns = new int[matrix[0].length];

		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}
		
		//Don't initialize with 0, by default it is initialized by 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length ; j++){
				if(rows[i] == 1 || columns[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
	
		ZeroMatrix zm = new ZeroMatrix();
		int[][] matrix = new int[][]{{1,2,0}, {1,2,3}, {0,3,4}};

		for(int i =0; i <matrix.length; i++){
			 System.out.println(" ");
		   for(int j=0; j <matrix[0].length ; j++){
		      System.out.print(matrix[i][j] +" ");
			}
		}
		
		System.out.println("\n===========");
		
	    zm.makeZeroMatrix(matrix);
		for(int i =0; i <matrix.length; i++){
			 System.out.println(" ");
		   for(int j=0; j <matrix[0].length ; j++){
		      System.out.print(matrix[i][j] +" ");
			}
		}
	}
}
