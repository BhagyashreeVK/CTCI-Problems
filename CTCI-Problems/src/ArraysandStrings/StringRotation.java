package ArraysandStrings;

public class StringRotation {

	//you are given isSubstring(String s1, String s2) function that checks whether s2 is a substring of S1.
	
	public boolean isRotation(String s1, String s2){
		
		String s1s1 = s1+s1;
		
		return isSubstring(s1s1,s2);
		
	}
	
	//you are already given this method
	private boolean isSubstring(String s1s1, String s2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {

	}
}
