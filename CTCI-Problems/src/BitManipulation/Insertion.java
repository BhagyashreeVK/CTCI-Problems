package BitManipulation;

public class Insertion {

	//insert m into n from bits j through i
	//zero based indexes
	public int insertIntoPosition(int m, int n, int j, int i){
		
		/*
		 * Step 1: Clear bits from j to i in n
		 * Step 2: Left shift M by i bits
		 * Step 3: Merge M and N by ORing them
		 * */
		int mask = clearBitsHelper(j,i);
		int maskedN = n & mask; //clear bits from j to i in N
		int shiftedM = m << i; //shift m by i bits
		return maskedN | shiftedM;
		
	}
	
	//clear bits from j through i in n
	public int clearBitsHelper(int j, int i){

		//left half
		//shift not of 0 by j+1 bits 
		//to get all ones on left of j
		
		int allOnes = ~0;
		int left = (allOnes << (j+1));
		
		//right half
		//shift one by i bits
		//subtract one to get all ones on right of i

		int right = ((1 << i) - 1);
		// all zeros from j to i
		return left | right;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
