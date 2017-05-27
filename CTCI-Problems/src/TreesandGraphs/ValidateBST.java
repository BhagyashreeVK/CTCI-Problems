package TreesandGraphs;

public class ValidateBST {

  private static class TreeNode<T>{
		
		T data;
		TreeNode<T> left, right;
		
		TreeNode(T data){
			this.data = data;
			left = null;
			right = null;
		}
	}
  
	public boolean isValidBST(TreeNode<Integer> node, Integer min, Integer max){
		
		if(node == null)
			return true;
		
		if(min != null && node.data <= min){
			return false;
		}
		
		if(max != null && node.data >= max){
			return false;
		}
		
		if(!isValidBST(node.left, min, node.data) || !isValidBST(node.right, node.data, max)){
			return false;
		}
		
		return true;
	}
	
}
