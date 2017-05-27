package ArraysandStrings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ReverseString {

	public static String reverseString(String input){
		int begin = 0;
		int end = input.length()-1;
		char[] charArray = input.toCharArray();
		char temp;
		
		while(begin<end){
			temp = charArray[end];
			charArray[end] = charArray[begin];
			charArray[begin] = temp;
			begin++;
			end--;
		}
		return new String(charArray);
	}
	
	public static void main(String[] args) {
		String original = "reverse";
		try {
			System.out.println(URLEncoder.encode("Hi$@ ", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(buildString());
	}
	
}
