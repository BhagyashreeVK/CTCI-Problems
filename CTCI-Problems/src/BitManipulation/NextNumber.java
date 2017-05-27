package BitManipulation;

public class NextNumber {
	
	public static int getNext(int n){
		
		int num = n;
		int c0 = 0;
		int c1 = 0;
		int p = 0;
		
		while( (num&1) == 0 && num != 0){
			c0++;
			num >>=1;
		}
		
		while( (num&1) == 1){
			c1++;
			num >>=1;
		}
		
		//there's no greater number with equal ones
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		
		p = c0+c1; 
		
		//replace rightmost non trailing 0 to 1 
		n = n | (1 << p);
		//clear bits from 0 to p (exclusive of P)
		n = (n & (~((1 << p)-1)));
		//add c1-1 ones
		n = n | ((1 << (c1-1))-1);

		return n;
	}
	
	public static int getPrevious(int n){
		
		int num = n;
		int c0 = 0;
		int c1 = 0;
		int p = 0;
		
		while((num & 1) == 1){
			c1++;
			num >>=1;
		}
		
		if(num == 0)
			return -1;
		
		while ((num & 1) == 0 && (num != 0)){
			c0++;
			num >>=1;
		}
		
		p = c0+c1;
		
		//flip rightmost non trailing 1 to 0;
		//n = n &  ((1 << p) - 1);
		
		//clear bits from 0 to p(inclusive)
		n = n &  ~((1 << p+1) - 1);
		
		//add c1 +1 ones to immediate right of p
		int mask = ((1 << c1+1) -1);
		n = n | mask << (c0 - 1);
		
		return n;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getPrevious(13));
		System.out.println(getNext(13));

	}

}
