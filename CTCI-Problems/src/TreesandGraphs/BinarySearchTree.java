package TreesandGraphs;

public class BinarySearchTree {
	
	private static class TreeNode {
		
		int data;
		TreeNode left,right;
		
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}

	}
	
	TreeNode root;
	
	public void add(int data){
		
		if(root == null){
			root = new TreeNode(data);
		} else {
			TreeNode p = root;
			TreeNode parent = null;
			while (true){
				parent = p;
				if(p.data >= data){
				    p = p.right;
				    if(p == null){
				    	parent.right = new TreeNode(data);
				    	return;
				    }
				}
				else {
					p = p.left;
				    if(p == null){
				    	parent.left = new TreeNode(data);
				    	return;
				    }
				}
			}
		}
	}

	//to insert recursively;
	public void insert(int data){
		root = insert(root,data);
	}
	
	public TreeNode insert(TreeNode node,int data){
		if(node == null)
			return new TreeNode(data);
		else{
		if(data > node.data)
			node.right = insert(node.right, data);
		else 
			node.left = insert(node.left, data);
		}
		return node;
	}
	
	public void delete(int data){
		
		root = delete(root,data);
	}
	public TreeNode delete(TreeNode root, int k){
		
		TreeNode p, p2;
		
		if(root.data == k){
			
			TreeNode left = root.left;
			TreeNode right = root.right;
			
			if(left == null && right == null){
				return null;
			} 
			
			if(left == null){
				p = left;
				return p;
			}
			
			if(right == null){
				p = right;
				return p;
			}
			
			p = right;
			p2 = right;
			
			while( p.left != null)
				p = p.left;
			
			p.left = left;
			
			return p2;
			
		} else {
			if(root.data < k){
				root.left = delete(root.left,k);
			} else if (root.data > k){
				root.right = delete(root.right,k);
			}
		}
		
		return root;
	}
	
	public void inOrder(TreeNode root){
		
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(" "+root.data);
		inOrder(root.right);
		
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(2);
		bst.insert(13);
		bst.insert(4);
		bst.insert(15);
		bst.insert(16);
		bst.insert(12);
		bst.insert(1);
		
		bst.inOrder(bst.root);
		
		bst.delete(12);
		System.out.println("\n After deletion : ");
		bst.inOrder(bst.root);
	}

}
