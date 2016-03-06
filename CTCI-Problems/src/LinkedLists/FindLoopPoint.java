package LinkedLists;

public class FindLoopPoint {
	
	/*
	 * Fast runner runs twice the speed of slow runner
	 * that means if slow has taken p steps then fast has taken 2p steps
	 * let's say there are k nodes before the start of the loop
	 * so when slow runner enters the loop, the fast runner is already k nodes into the loop
	 * now the distance between them is LOOP_SIZE-K;
	 * hence, they will meet at LOOP_SIZE - K point; both will be k moves away from the loop start point
	 * head of the list will also be k nodes away from the loop
	 * so take one pointer back to head of list and then move the fast runner one step at a time, 
	 * their point of collision will be the starting point of loop
	 * */
	
	public ListNode<Integer> findLoopStart(ListNode<Integer> head){

		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head.next.next;
		
		while(fast.next != null || fast != null ){
			
			if(slow == fast){
				break;
			}
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		
		while(slow != fast){
		
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

}
