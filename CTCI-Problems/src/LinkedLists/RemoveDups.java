package LinkedLists;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDups {

	//Time O(n), Space: O(n)
	public void removeDups(ListNode<Integer> head){
		
		ListNode<Integer> p = head;
		ListNode<Integer> previous = null;
		HashSet<Integer> hs = new HashSet<Integer>();

		while(p != null){
			if(hs.contains(p.data)){
				previous.next = p.next;
			} else {
				hs.add(p.data);
				previous = p;
			}
			p = p.next;
		}
	}
	
	    //Time O(n^2), Space: O(1)
		public void removeDupsWithoutDS(ListNode<Integer> head){
			
			ListNode<Integer> current = head;
			
			while(current != null){
				ListNode<Integer> runner = current;
				while(runner.next != null){
					if(current.data == runner.next.data){
						runner.next = runner.next.next;
					}else {
					runner = runner.next;
					}
				}
				current = current.next;
			}
			
		}
	
	public static void main(String[] args) {

		ListNode<Integer> node1 = new ListNode<Integer>(2,null);
		ListNode<Integer> node2 = new ListNode<Integer>(1,node1);
		ListNode<Integer> node3 = new ListNode<Integer>(3,node2);
		ListNode<Integer> node4 = new ListNode<Integer>(3,node3);
		ListNode<Integer> node5 = new ListNode<Integer>(4,node4);
		ListNode<Integer> node6 = new ListNode<Integer>(2,node5);
		
		RemoveDups rd = new RemoveDups();
		rd.removeDupsWithoutDS(node6);
		
		ListNode<Integer> p = node6;
		while (p != null) {
			System.out.print(p.data + "->");
			p = p.next;
		}
	}

}
