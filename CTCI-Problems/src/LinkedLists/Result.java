package LinkedLists;

public class Result {
	
	ListNode<Integer> node;
	boolean isPal;
	
	Result(ListNode<Integer> node, boolean isPal){
		this.node = node;
		this.isPal = isPal;
	}
	
	public int findLength(ListNode<Integer> head){
		
		int size = 0;
		ListNode<Integer> p = head;
		while(p != null) {
			size++;
			p = p.next;
		}
		
		return size;
	}

	public Result isPalindrome(ListNode<Integer> head, int length){
		
		if( head == null || length <= 0){
			return new Result(head,true);
		} else if( length == 1) {
			return new Result(head.next, true);
		}
		
		Result res = isPalindrome(head.next, length-2);
		
		// if child call fails, pass back failure
		if(!res.isPal || res.node == null){
			return res;
		}
		
		//check if the data from the other end matches
		res.isPal = (res.node.data == head.data);
		
		//progress to the next node
		res.node = res.node.next;
		
		return res;
	}
	
	public boolean isPalindrome(ListNode<Integer> head){
		int size = findLength(head);
		Result res = isPalindrome(head, size);
		return res.isPal;
	}
}
