package StackAndQueue;

import java.util.Stack;

public class SortStack {
	
	//Time: O(N^2) , Space: O(n)
	public Stack<Integer> sortStack(Stack<Integer> stack){
		
		Stack<Integer> sortedStack = new Stack<Integer>();
		int temp;
		
		while(!stack.isEmpty()){
			temp = stack.pop();
			while(!sortedStack.isEmpty() && sortedStack.peek() > temp ){
				stack.push(sortedStack.pop());
			} 
			sortedStack.push(temp);
		}
		
		return sortedStack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
