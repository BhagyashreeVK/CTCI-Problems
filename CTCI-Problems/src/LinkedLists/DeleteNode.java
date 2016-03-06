package LinkedLists;

public class DeleteNode {

	public boolean deleteNode(ListNode<Integer> node){

		//can't delete if end of node
		if(node == null || node.next == null)
			return false;
		
		ListNode<Integer> next = node.next;
		node.data = next.data;
		node.next = next.next;
		
		return true;
		
	}
	
	public void printNodes(ListNode<Integer> p){
		while(p != null){
			System.out.print(p.data + "->");
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		
		ListNode<Integer> node1 = new ListNode<Integer>(6,null);
		ListNode<Integer> node2 = new ListNode<Integer>(5,node1);
		ListNode<Integer> node3 = new ListNode<Integer>(4,node2);
		ListNode<Integer> node4 = new ListNode<Integer>(3,node3);
		ListNode<Integer> node5 = new ListNode<Integer>(2,node4);
		ListNode<Integer> node6 = new ListNode<Integer>(1,node5);
		
		DeleteNode dn = new DeleteNode();
		dn.printNodes(node6);
		dn.deleteNode(node3);
		System.out.println("\n After Deletion");
		dn.printNodes(node6);

	}

}
