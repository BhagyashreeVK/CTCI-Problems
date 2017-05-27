package TreesandGraphs;


public class Successor {

	 private static class TreeNode<T>{
			
			T data;
			TreeNode<T> left, right, parent;
			
			TreeNode(T data){
				this.data = data;
				left = null;
				right = null;
			}
		}
	 
	 public TreeNode<Integer> findSuccessor(TreeNode<Integer> node){

		 if(node.right != null){
			 return leftMostChild(node.right);
		 } else {
			 
			 TreeNode<Integer> q = node;
			 TreeNode<Integer> x = q.parent;
			 
			 while(x != null && x.left != q){
				 
				 q = x;
				 x = x.parent;
			 }
			 
			 return x;
 		 }
	 }
	 
	public TreeNode<Integer> leftMostChild(TreeNode<Integer> node){
		
		if(node == null){
			return null;
		}
		
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
}
