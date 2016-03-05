package ArraysandStrings;

import java.util.HashMap;

public class PalindromePermutation {

	public boolean isPalindromPermutation(String s){
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		int numOfOddCharacters = 0; // to keep track of number of Odd characters
		for(int i=0; i < s.length(); i++) {
			if(!Character.isLetterOrDigit(s.charAt(i))){
				continue;
			}
			char c = Character.toLowerCase(s.charAt(i));
			int count = 1;
			if(hm.containsKey(c)){
				 count = hm.get(c);
				 count++;
				 if(count%2 == 0){
					 numOfOddCharacters--;
				 } else {
					 numOfOddCharacters++;
				 }
			}
			hm.put(s.charAt(i), count);
		}
		return numOfOddCharacters <= 1;
	}
	
	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.isPalindromPermutation("  Taco ocata    "));
	}

}
