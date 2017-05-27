package ArraysandStrings;

import java.util.HashMap;

public class IsPermutation {

	//Time O(n) , Space O(n)
	public boolean isPermutation(String s, String t){
		
		if(s.isEmpty() && t.isEmpty())
			return true;
		if(s.length() != t.length()){
			return false;
		}
		
		HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
		
		for(int i = 0; i < s.length(); i ++){
			if(hm.containsKey(s.charAt(i))){
				int count = hm.get(s.charAt(i));
				hm.put(s.charAt(i), ++count);
			} else { 
			  hm.put(s.charAt(i), 1);
			}
		}
		
		for(int i = 0 ; i < t.length(); i++){
			if(!hm.containsKey(t.charAt(i))){
				return false;
			} else {
				int count = hm.get(s.charAt(i));
				if(--count < 0)
					return false;
				hm.put(s.charAt(i), count);
			}
		}
		return true;
	}
	
	//Time O(n), Space O(1)
	public boolean isPermutationWithoutHashMap(String s, String t){
		
		if(s.length() != t.length())
		 return false;
		int[] charMap = new int[256];
		for(int i=0 ; i < s.length(); i ++){
			if(Character.isWhitespace(s.charAt(i))){
				continue;
			}
			charMap[s.charAt(i)]++;
		}
		for(int i=0; i < t.length(); i ++){
			if(Character.isWhitespace(t.charAt(i))){
				continue;
			}
			
			if (--charMap[t.charAt(i)] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		IsPermutation isp = new IsPermutation();
		System.out.println(isp.isPermutationWithoutHashMap("dog is a", "god asi"));
	}

}
