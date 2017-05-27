package SortingSearching;

public class SparseSearch {

	public int searchString(String[] strings, String s, int low, int high){
	

		if(high < low)
			return -1;
		
		int mid = (low + high) /2;
		
		if(strings[mid].isEmpty()){
			int left = mid - 1;
			int right = mid + 1;
			while(true){
				if(left < low && right > high ){
					return -1;
				} else if(left >= low && !strings[left].isEmpty()){
					mid = left;
					break;
				} else if( right <= high && !strings[right].isEmpty()){
					mid = right;
					break;
				}
				left--;
				right++;
			}
		}
		
		if(strings[mid].equals(s)){
			return mid;
		}else if(strings[mid].compareTo(s) < 0){ // search right
			return searchString(strings,s, mid+1, high);
		}else {//search left;
			return searchString(strings,s, low, mid-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
