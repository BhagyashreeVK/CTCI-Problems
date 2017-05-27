package TreesandGraphs;
public class CommonAncestor {
	
	 private static class TreeNode<T>{
			
			T data;
			TreeNode<T> left, right;
			
			TreeNode(T data){
				this.data = data;
				left = null;
				right = null;
			}
		}
	 
	 public TreeNode<Integer> findCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q){
		 
		 if(root == null)
			 return null;
		 
		 if(root == p)
			 return p;
		 
		 if(root == q)
			 return q;
		 
		 
		 boolean pIsOnLeft = coversNode(root.left, p);
		 boolean qIsOnLeft = coversNode(root.left, q);
		 
		 if( pIsOnLeft != qIsOnLeft){
			 return root;
		 } 
		 
		 TreeNode<Integer> childToSearch = pIsOnLeft ? root.left : root.right;
		 return findCommonAncestor(childToSearch, p ,q);
	 }

	 public boolean coversNode(TreeNode<Integer> root, TreeNode<Integer> q){
		 
		 if(root == null)
			 return false;
		 
		 if(root == q)
			 return true;
		 
		 return coversNode(root.left, q) || coversNode(root.right, q);
		 
	 }
}
