package StackAndQueue;

import java.util.EmptyStackException;

public class MinStack {
	
	private static class MinStackNode{
		
		int data;
		int min;
		MinStackNode previous;
		
		MinStackNode(int data, int min, MinStackNode previous){
			this.data = data;
			this.min = min;
			this.previous = previous;
		} 
		
	}

	MinStackNode top;
	
	public void push(int data){
		
		if(top == null){
			 top = new MinStackNode(data,data,null);
		} else {
			top = new MinStackNode(data,Math.min(data, top.data),top);
			/*if(data < top.data)
			     top = new MinStackNode(data, data, top); 
			else
				top = new MinStackNode(data, top.data, top);*/
		}
	}
	
	public int min(){
		
		if(top == null)
			throw new EmptyStackException();
		
		return top.min;
		
	}
	
	public int pop(){
		
		if(top == null)
			throw new EmptyStackException();
	
		int data = top.data;
		top = top.previous;
		
		return data;
	}
	
	public static void main(String[] args) {
		
		MinStack stack = new MinStack();
		
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(0);
		
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());

	}

}
