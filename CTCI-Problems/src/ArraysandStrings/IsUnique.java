package ArraysandStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

	//Time O(n) , Space O(n);
	public boolean isUnique(String s){
		
		if(s.length() > 256){
			return false;
		}
		
		HashMap<Character,Boolean> hm  = new HashMap<Character,Boolean>();
		for(int i=0; i < s.length(); i++){
			
			if(hm.containsKey(s.charAt(i))){
				return false;
			}
			hm.put(s.charAt(i), true);
		}
		return true;
	}
	
  public boolean isUniqueHashSet(String s){
		
		if(s.length() > 256){
			return false;
		}
		
		Set<Character> hm  = new HashSet<Character>();
		for(int i=0; i < s.length(); i++){
			if(hm.contains(s.charAt(i))){
				return false;
			}
			hm.add(s.charAt(i));
		}
		return true;
	}
	
	
	//Time O(n) , Space O(1);
	public boolean isUniqueWithoutExtraSpace(String s){
		
		if(s.length() > 256){
			return false;
		}
		
		boolean[] charMap = new boolean[256];
		for(int i=0; i<s.length(); i++){
			
			if(charMap[s.charAt(i)]){
				return false;
			}
			charMap[s.charAt(i)] = true;
		}
		return true;
	}
	public static void main(String[] args) {

	}

}
