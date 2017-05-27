package SortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
	
	 public String sortChars(String s){
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
	
	 public void groupAnagrams(String[] strings){
	
		 HashMap<String, ArrayList<String>> hmap =  new HashMap<String, ArrayList<String>>();
		 
		 for(String s: strings){
			 String key = sortChars(s);
			 if(!hmap.containsKey(key)){
				 hmap.put(key, new ArrayList<String>());
			 }
			 hmap.get(key).add(s);
		 }
		 
		 int index = 0;
		 for(String key: hmap.keySet()){
			 ArrayList<String> anagrams = hmap.get(key);
			 for(String anagram: anagrams){
				 strings[index] = anagram;
				 index++;
			 }
		 }
	 }
	 
}
