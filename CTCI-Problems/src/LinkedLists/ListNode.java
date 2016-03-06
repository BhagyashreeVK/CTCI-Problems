package LinkedLists;

public class ListNode<T> {

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
