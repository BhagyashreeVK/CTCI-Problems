package LinkedLists;

public class PartitionList {

	//Edge cases won't work!!
	//Taking O(n) space
	public ListNode<Integer> partitionList(ListNode<Integer> head , int x){
		
		ListNode<Integer> head1 = null; // for elements lower than x;
		ListNode<Integer> tail1 = null;
		ListNode<Integer> head2 = null; // for elements greater than or equal to x;
		ListNode<Integer> tail2 = null;
		ListNode<Integer> p = head;
		
		while( p != null ){
			
			if(p.data < x){
				
				if(head1 == null){
					head1 = new ListNode<Integer>(p.data,null);
					tail1 = head1;
				} else{
					ListNode<Integer> tempNode = new ListNode<Integer>(p.data, null);
					tail1.next = tempNode;
					tail1 = tail1.next;
				}
			} else {
				if(head2 == null){
					head2 = new ListNode<Integer>(p.data,null);
					tail2 = head2;
				} else{
					ListNode<Integer> tempNode = new ListNode<Integer>(p.data, null);
					tail2.next = tempNode;
					tail2 = tail2.next;
				}
			}
			
			p = p.next;
		}
		
		if(tail1 != null && head2 != null)
		     tail1.next = head2; // merge the lists;
		
		if(head1 != null)
			return head1;
		
		return head2;
	}
	
	//Time O(n) , Space O(1)
	public ListNode<Integer> partitionListSpaceOptimised(ListNode<Integer> head , int x){
		
		ListNode<Integer> head1 = null; // for elements lower than x;
		ListNode<Integer> tail1 = null;
		ListNode<Integer> head2 = null; // for elements greater than or equal to x;
		ListNode<Integer> tail2 = null;
		ListNode<Integer> p = head;
		
		while( p != null ){
			ListNode<Integer> next = p.next;
			p.next = null;
			if(p.data < x){
				if(head1 == null){
					head1 = p;
					tail1 = head1;
				} else{
					tail1.next = p;
					tail1 = tail1.next;
				}
			} else {
				if(head2 == null){
					head2 = p;
					tail2 = head2;
				} else{
					tail2.next = p;
					tail2 = tail2.next;
				}
			}
			p = next;
		}
		if(head1 == null)
			return head2;
		     tail1.next = head2; // merge the lists;
		return head1;
	}
	
	//No need to maintain 4 pointers
	public ListNode<Integer> partitionListAroundX(ListNode<Integer> head, int x){
		
		ListNode<Integer> newHead = head;
		ListNode<Integer> tail = head;
		ListNode<Integer> p = head;
		
		while(p != null){
	     ListNode<Integer> next = p.next;	
	     if(p.data < x){
	    	 //insert before head
	    	 p.next = head;
	    	 head = p;
	     } else {
	    	 //insert after tail
	    	 tail.next = p;
	    	 tail = p;
	     }
	     p = next;
		}
		
		tail.next = null;
		
		return newHead;
	}
	
	public void printNodes(ListNode<Integer> p){
		while(p != null){
			System.out.print(p.data + "->");
			p = p.next;
		}
	}
	
	public static void main(String[] args) {

		ListNode<Integer> node1 = new ListNode<Integer>(12,null);
		ListNode<Integer> node2 = new ListNode<Integer>(13,node1);
		ListNode<Integer> node3 = new ListNode<Integer>(11,node2);
		ListNode<Integer> node4 = new ListNode<Integer>(26,node3);
		ListNode<Integer> node5 = new ListNode<Integer>(14,node4);
		ListNode<Integer> node6 = new ListNode<Integer>(11,node5);
		
		PartitionList pl = new PartitionList();
		pl.printNodes(node6);
		
		ListNode<Integer> head = pl.partitionList(node6, 11);
		
		System.out.println("\n after partition");
		pl.printNodes(head);
		
	}

}
