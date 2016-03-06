package LinkedLists;

public class KthToLast {

	//Time O(n), Space O(1)
	public ListNode<Integer> kthToLast(ListNode<Integer> head, int k){
		
		if(head  == null)
			return null;
		
		ListNode<Integer> p1 = head;
		ListNode<Integer> p2 = head;
		
		for(int i = 0 ; i < k ; i++){
			if(p2 != null)
			    p2 = p2.next;
			else
				return null;
		}
		
		while( p2 != null){ //or p2.next? use p2.next if exclusive of last element
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	public static void main(String[] args) {
		
		KthToLast ktl = new KthToLast();
		ListNode<Integer> node1 = new ListNode<Integer>(6,null);
		ListNode<Integer> node2 = new ListNode<Integer>(5,node1);
		ListNode<Integer> node3 = new ListNode<Integer>(4,node2);
		ListNode<Integer> node4 = new ListNode<Integer>(3,node3);
		ListNode<Integer> node5 = new ListNode<Integer>(2,node4);
		ListNode<Integer> node6 = new ListNode<Integer>(1,node5);
		
		ListNode<Integer> p = node6;
		while (p != null) {
			System.out.print(p.data + "->");
			p = p.next;
		}
		
		p = ktl.kthToLast(node6, 8);
		
		int data = p == null ? -1 : p.data;
		
		System.out.println("\n" + data);
	}

}
