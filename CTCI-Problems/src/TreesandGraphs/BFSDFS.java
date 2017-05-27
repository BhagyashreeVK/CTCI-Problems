package TreesandGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BFSDFS {

	  private enum state {unvisited, visited};
	  private static class TreeNode<T>{
			
			T data;
			TreeNode<T> left, right;
			state state;
			TreeNode(T data){
				this.data = data;
				left = null;
				right = null;
				state = state.unvisited;
			}
		}
	  
	  public void BFS(TreeNode<Integer> root){
		  
		  Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		  q.add(root);
		  
		  while(!q.isEmpty()){
			  
			  TreeNode<Integer> p =  q.poll();
			  
			  if(p.left != null)
				q.add(p.left);
			  
			  if(p.right != null)
				q.add(p.right);
			  
			  System.out.print(" " + p.data);
		  }
	  }
	  
	  public void DFS(TreeNode<Integer> root){
		  
		  Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
		  s.add(root);
		  
		  while(!s.isEmpty()){
			  
			  TreeNode<Integer> p  = s.peek();
			  
			  if(p.left != null && p.state == state.unvisited){
				  s.push(p.left);
				  continue;
			  }
			  
			  if(p.right != null && p.state == state.unvisited){
				  s.push(p.right);
			      continue;
		      }
			  
			  p.state = state.visited;
			  System.out.println(s.pop());
			  
		  }
	  }
}
