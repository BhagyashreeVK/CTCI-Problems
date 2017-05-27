package TreesandGraphs;

import java.util.ArrayList;

public class ListOfDepths {
	
	private static class TreeNode<T>{
		
		T data;
		TreeNode<T> left, right;
		
		TreeNode(T data){
			this.data = data;
			left = null;
			right = null;
		}
	}

	public ArrayList<ArrayList<TreeNode<Integer>>> createList(TreeNode<Integer> root){
		
		ArrayList<ArrayList<TreeNode<Integer>>> listOfLists = new ArrayList<ArrayList<TreeNode<Integer>>>(); 
		
		createListofLists(listOfLists, root, 0);
		
		return listOfLists;
		
	}
	
	//Time: O(n) , Space: O(log N)
	public void createListofLists(ArrayList<ArrayList<TreeNode<Integer>>> listOfLists, TreeNode<Integer> node, int level){
		
		if(node == null)
			return;
		
		ArrayList<TreeNode<Integer>> list = null;
		
		if(listOfLists.size() == level){
			list = new ArrayList<TreeNode<Integer>>();
			listOfLists.add(list);
		} else {
			list = listOfLists.get(level); 
		}
		
		list.add(node);
		
		createListofLists(listOfLists, node.left, level+1);
		createListofLists(listOfLists, node.right, level+1);
	}
}
