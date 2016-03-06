package LinkedLists;

import java.util.Stack;

public class PalindromeList {
	
	public boolean isPalindromeWithStack(ListNode<Integer> head){
		
		if(head == null)
		return false;
		
		ListNode<Integer> p = head;
		ListNode<Integer> fast = head;
		ListNode<Integer> slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null || fast.next != null ){
			stack.push(slow.data);
			slow = slow.next;
     		fast = fast.next.next;
		}
		
		if(fast != null){
			slow = slow.next; //ignore middle element for odd length linked list;
		}
		
		while( slow != null ){
			
			if(slow.data != stack.pop()){
				return false;
			}
			
		}
		
		return true;
	}

}
