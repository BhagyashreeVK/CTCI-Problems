package BitManipulation;

public class IntegerAtoB {

	public static int countBitsToChange(int a, int b){
		
		int count = 0;
		for(int c = a ^ b; c !=0; c >>=1){
			
			count += c&1;
			
		}
		
		return count;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
