package ArraysandStrings;

public class URLify {
	
	public String convertSpaces(char[] charArray, int trueLength){
		int whiteSpace = 0;
		for(int i = 0 ; i < trueLength ; i++){
			if(charArray[i] == ' '){
				whiteSpace++;
			}
		}
		
		int newLen = whiteSpace*2 + trueLength;
		for(int i = trueLength - 1 ; i >= 0 ; i--){
			if(charArray[i] == ' '){
				charArray[newLen - 1] = '0';
				charArray[newLen - 2] = '2';
				charArray[newLen - 3] = '%';
				newLen -= 3;
			} else {
				charArray[newLen - 1] = charArray[i];
				newLen--;
			}
		}
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		URLify url = new URLify();
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = 13;
		String s = url.convertSpaces(arr, trueLength);	
		System.out.println(s);
	}
}
