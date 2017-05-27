package StackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {
	
	Stack<Stack<Integer>> stacks;
	int capacity;
	
	SetOfStacks(int capacity){
		stacks = new Stack<Stack<Integer>>();
		this.capacity = capacity;
	}
	
	public Stack<Integer> getLastStack(){
		
		if(stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int data){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack == null || lastStack.size() == capacity){
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(data);
			stacks.push(newStack);
		} else {
			lastStack.push(data);
		}
	}
	
	public int pop(){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack == null || lastStack.isEmpty()){
			throw new EmptyStackException();
		}
		int data = lastStack.pop();
		if(lastStack.isEmpty()){
		     stacks.pop();
		}
		return data;
	}
	
	public int popAtIndex(int i){
		
		if(stacks == null || stacks.isEmpty())
			throw new EmptyStackException();
		
		Stack<Integer> stack = stacks.get(i);
		
		if(stack == null || stack.isEmpty()){
			throw new EmptyStackException();
		}
		
		int data = stack.pop();
		
		if(stack.isEmpty())
			stacks.remove(i);
		
		return data;
	}

	public static void main(String[] args) {

		SetOfStacks stack = new SetOfStacks(3);
		
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(6);
		stack.push(5);
		
		System.out.println(stack.popAtIndex(0));
		System.out.println(stack.pop());
		System.out.println(stack.popAtIndex(1));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
	}

}
