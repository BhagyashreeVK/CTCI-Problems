package ArraysandStrings;

import java.util.HashMap;

public class PalindromePermutation {

	public boolean isPalindromPermutation(String s){
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		int numOfOddCharacters = 0; // to keep track of number of Odd characters
		int count;
		for(int i=0; i < s.length(); i++) {
			if(!Character.isLetterOrDigit(s.charAt(i))){
				continue;
			}
			char c = Character.toLowerCase(s.charAt(i));
			count = hm.containsKey(c) ? hm.get(c) : 0;
			hm.put(c, ++count);
				 if(count%2 == 1){
					 numOfOddCharacters++;
				 } else {
					 numOfOddCharacters--;
				 }
		}
		return numOfOddCharacters <= 1;
	}
	
	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.isPalindromPermutation("  Taco ocAta    "));
	}

}
