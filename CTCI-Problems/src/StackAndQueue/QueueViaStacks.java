package StackAndQueue;

import java.util.Stack;

public class QueueViaStacks<T> {
	
	Stack<T> stackNew,stackOld;
	
	QueueViaStacks(){
		stackNew = new Stack<T>();
		stackOld = new Stack<T>();
	}
	
	public int size(){
		return stackNew.size() + stackOld.size();
	}

	public void shiftStacks(){
		if(stackOld.isEmpty()){
			while(!stackNew.isEmpty()){
				stackOld.push(stackNew.pop());
			}
		}
	}
	
	public void add(T data){
		stackNew.push(data);
	}
	
	public T peek(){
		shiftStacks();
		return stackOld.peek();
	}
	
	public T pop(){
		shiftStacks();
		return stackOld.pop();
	}
}
