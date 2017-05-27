package BitManipulation;

public class IntegerToBinary {

	public String convertToBinary(int num){
		StringBuilder binary = new StringBuilder();
		while(num != 0){
			binary.append(num%2);
			num /= 2;
		}
		return binary.reverse().toString();
	}
	
	public static void main(String[] args) {
		IntegerToBinary ib = new IntegerToBinary();
		System.out.println(ib.convertToBinary(16));
		System.out.println(0.04 > 0);
		
	}
}
