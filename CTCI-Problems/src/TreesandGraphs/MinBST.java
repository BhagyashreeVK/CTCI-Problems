package TreesandGraphs;

public class MinBST {
	
	private static class TreeNode<T>{
		T data;
		TreeNode<T> left, right;
		TreeNode(T data){
			this.data = data;
			left = null;
			right = null;
		}
	}

		
	public TreeNode<Integer> createMinBST(int[] array){
		return createMinBST(array,0,array.length-1);
	}
	
	public TreeNode<Integer> createMinBST(int[] array, int low, int high){
		
		if(high < low)
			return null;
		
		int mid = (low + high) / 2;
		TreeNode<Integer> node = new TreeNode<Integer>(array[mid]);
		node.left = createMinBST(array, low, mid-1);
		node.right = createMinBST(array, mid+1, high);
		return node;
	}
	
  public void inOrder(TreeNode<Integer> root){
		
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(" "+root.data);
		inOrder(root.right);
		
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[]{1,2,3,10,13,14,15};

		MinBST mst = new MinBST();
		
		TreeNode<Integer> root = mst.createMinBST(array);
		mst.inOrder(root);
		
	}

}
