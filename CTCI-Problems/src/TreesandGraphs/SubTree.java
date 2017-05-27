package TreesandGraphs;


public class SubTree {

	
	private static class TreeNode<T>{
		
		T data;
		TreeNode<T> left, right;
		
		TreeNode(T data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public boolean containsTree(TreeNode<Integer> r1, TreeNode<Integer> r2){
		
		if(r2 == null)
			return true;
		
		return subTree(r1,r2);
		
	}
	public boolean subTree(TreeNode<Integer> r1, TreeNode<Integer> r2){
		
		if(r1 == null)
			return false;
		
		if(r1.data == r2.data && isMatch(r1,r2))
			return true;
		
		return subTree(r1.left,r2) || subTree(r1.right, r2);
		
	}
	
	public boolean isMatch(TreeNode<Integer> r1, TreeNode<Integer> r2){
		
		if(r1 == null && r2 == null)
			return true;
		
		if(r1 == null || r2 == null)
			return false;
		
		if(r1.data != r2.data)
			return false;
		
		return isMatch(r1.left, r2.left) && isMatch (r1.right, r2.right);
	}
}
