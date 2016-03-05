package ArraysandStrings;

public class StringCompression {

	public String compressString(String s){
		String compressedString = compressedString(s);
		return compressedString.length() < s.length() ? compressedString : s;
	}
	
    public String compressedString(String s){
    	StringBuilder compressedString = new StringBuilder();
    	int i = 0;
    	char prevChar = s.charAt(0);
    	int charCount = 0;
    	while(i < s.length()){
    		if(s.charAt(i) == prevChar){
    			charCount++;
    		} else {
    			compressedString.append(prevChar).append(charCount);
    			prevChar = s.charAt(i);
    			charCount = 1;
    		}
    		i++;
    	}
    	compressedString.append(prevChar).append(charCount);
    	return compressedString.toString();
	}

    public static void main(String[] args) {
    	StringCompression sc = new StringCompression();
    	System.out.println(sc.compressString("aabcccccaaa"));
    	System.out.println(sc.compressString("aabb"));
    	System.out.println(sc.compressString("aaaaaaaaaaaaaaab"));
	}
}
