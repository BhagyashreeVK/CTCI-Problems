package SortingSearching;

public class MergeSortedArrays {
	
    //lastA = zero based index of element in A 
	//lastB = zero based index of last element in B
	public static void mergeArrays(int[] a, int[] b, int lastA, int lastB){
		
		int indexA = lastA; //lastA-1 if non zero based index
		int indexB = lastB; //lastB-1 if non zero based index
		int indexMerged = lastA+lastB+1; // lastA+lastB-1 if non zero based index;
		
		//start putting elements from the end of array
		while(indexB >=0){
			if(indexA >= 0 && a[indexA] > b[indexB]){
				a[indexMerged] = a[indexA];
				indexA--;
			} else {
				a[indexMerged] = a[indexB];
				indexB--;
			}
			
			indexMerged--;
		}
		
	}

}
