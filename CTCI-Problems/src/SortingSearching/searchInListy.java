package SortingSearching;

import java.util.ArrayList;

public class searchInListy{
 private static class Listy {

	ArrayList<Integer> list;
	
	Listy(){
		list = new ArrayList<>();
	}
	
	public int elementAt(int i){
		
		if(i >= list.size())
			return -1;
		
		return list.get(i);
	}
	
}
 
 public int searchElement(Listy l, int x){
	 int index = 0;
	 while(l.elementAt(index) != -1 && l.elementAt(index) < x){
		 index *= 2;
	 }
	 return searchElement(l,x,index/2,index);
 }
 
 public int searchElement(Listy l, int x, int low, int high){
	 int mid;
	 while(low <= high){
	 mid = (low + high) /2;
	 int middleElement = l.elementAt(mid);
	 if(middleElement == x){
		 return mid;
	 } else if(x < middleElement || middleElement == -1){
	     high = mid - 1; 
	 } else {
		 low = mid + 1;
	 }
	 
	 }
	 return -1;
 }
 
}