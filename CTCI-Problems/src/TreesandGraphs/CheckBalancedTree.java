package TreesandGraphs;

public class CheckBalancedTree {
	
	//Time O(N), Space: O(H) - Height of Tree
	private static class TreeNode<T>{
		
		T data;
		TreeNode<T> left, right;
		
		TreeNode(T data){
			this.data = data;
			left = null;
			right = null;
		}
	}

	public int checkHeight(TreeNode<Integer> node) {

		if(node == null)
			return 0;
	
		int left = checkHeight(node.left);
		if(left == -1){
			return -1;
		}
		
		int right = checkHeight(node.right);
		if(right == -1){
			return -1;
		}
		
		if(Math.abs(left- right) > 1){
			return -1;
		} else {
			return Math.max(left, right)+1;
		}
	}
	
	public boolean isBalanced(TreeNode<Integer> root){
		
		if(checkHeight(root) == -1)
			return false;
		
		return true;
	}
}
