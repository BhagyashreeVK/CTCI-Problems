package LinkedLists;

public class LargestInteger {

	private class ListNode<T> {

		T data;
		ListNode<T> next;

		ListNode(T data){
			this.data = data;
		    next = null;
		}
		
		ListNode(T data, ListNode<T> next){
			this.data = data;
			this.next = next;
		}
	}
	
	public Integer findLargest(ListNode<Integer> head){
		
		ListNode<Integer> p = head;
		
		int  min = Integer.MAX_VALUE;
		
		while( p != null){
			min = Math.min(min, p.data);
			p = p.next;
		}
		
		return min;
	}
	
	public static void main(String[] args){
		
		
		int[] array = {1,-2,-3,4};
		
		int min = Integer.MAX_VALUE;
		
		int  i=0;
		while (i <array.length){
			min = Math.min(min, array[i]);
			i++;
		}
		System.out.println(min);
	}
}



