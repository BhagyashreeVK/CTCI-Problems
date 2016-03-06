package LinkedLists;

public class FindIntersection {

	class TailandLength{
	 int length;
	 ListNode<Integer> tail;
	 
	 TailandLength(ListNode<Integer> tail, int length){
		 this.length = length;
		 this.tail = tail;
	 }
	}
	
	public TailandLength findLength(ListNode<Integer> head){
		 int size = 0;
		 ListNode<Integer> p = head;
		 while(p.next != null){
			 size++;
			 p = p.next;
		 }
		 
		 return new TailandLength(p,++size);
	}
	
	public ListNode<Integer> findIntersection(ListNode<Integer> head1, ListNode<Integer> head2){
		
		TailandLength result1 = findLength(head1);
		TailandLength result2 = findLength(head2);
		
		if(result1.tail != result2.tail){
			return null;
		}
		
		ListNode<Integer> shorter = result1.length > result2.length ? head2: head1; 
		ListNode<Integer> longer = result1.length > result2.length ? head1: head2;
		
			
			longer = traverseToKthNode(longer, Math.abs(result1.length - result2.length));

			while( shorter != longer){
				
				shorter = shorter.next;
				longer = longer.next;
			}
			
			return longer;
	}
	
	public ListNode<Integer> traverseToKthNode(ListNode<Integer> head, int steps){
		
		ListNode<Integer> current = head;
		while(steps > 0 && current != null){
			current = current.next;
			steps--;
		}
		
		return current;
	}
}
