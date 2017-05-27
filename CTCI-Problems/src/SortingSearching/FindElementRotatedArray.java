package SortingSearching;

public class FindElementRotatedArray {

	//returns zero based index;
	public static int findElement(int[] arr, int x, int left, int right){
		
		if(right < left)
			return -1;
		
		int mid = (left + right)/2;
		
		if(arr[mid] == x)
			return mid;
		
		if(arr[left] < arr[mid]){ //left half is sorted
			if( x >= arr[left] && x < arr[mid]){
				return findElement(arr,x,left,mid-1);
			} else{
				return findElement(arr,x,mid+1,right);
			}
		} else if (arr[mid] < arr[left]){ //right half is sorted
			
			if( x <= arr[right] && x >  arr[mid]){
				return findElement(arr,x, mid+1, right);
			} else {
				return findElement(arr,x,left, mid-1);
			}
		} else if(arr[left] == arr[mid]){
			if(arr[mid] != arr[right]){
				return findElement(arr,x,mid+1,right);
			} else {
				int result = findElement(arr,x,left, mid-1);
				if(result == -1){
					return findElement(arr,x,mid+1,right);
				} else {
					return result;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
