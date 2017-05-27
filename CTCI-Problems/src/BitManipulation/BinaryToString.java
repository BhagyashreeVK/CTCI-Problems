package BitManipulation;

public class BinaryToString {
	
	
	public String getBinary(double num){
		
		if(num >=1 || num <=0 ){
			
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		
		binary.append(".");
		
		while(num > 0){
			if(binary.length() >= 32){
				return "ERROR";
			}
			 num *= 2;
			 if(num >= 1){
				 binary.append(1);
				 num -= 1;
			 } else {
				 binary.append(0);
			 }
		}
		return binary.toString();
	}
	
	public static void main(String[] args) {
		
		BinaryToString bs = new BinaryToString();
		double num = 0.4;
		System.out.println(bs.getBinary(num ));
	}
}
