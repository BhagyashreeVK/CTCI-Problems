package StackAndQueue;

import java.util.EmptyStackException;

public class MyStack<T> {

	private static class StackNode<T>{
		T data;
		StackNode<T> previous;
		
		StackNode(T data){
			this.data = data;
			this.previous = null;
		}
		
		StackNode(T data, StackNode<T> previous){
			this.data = data;
			this.previous = previous;
		}
	}
	
	StackNode<T> top;
	
	public void push(T data){
		
		if(top == null){
			top = new StackNode<T>(data);
		} else{
		   top = new StackNode<T>(data,top);
		}
	} 
	
	public T pop(){
		if(top == null)
			throw new EmptyStackException();
		
		T data = top.data;
		top = top.previous;
		
		return data;
	}
	
	public T peek(){
		if(top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	public static void main(String[] args) {
		
		MyStack<Integer> stack = new MyStack<Integer>();
		
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
