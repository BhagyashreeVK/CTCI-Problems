package StackAndQueue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyQueue<T> {
	
	private static class QueueNode<T>{
		
		T data;
		QueueNode<T> next;
		
		QueueNode(T data){
			
			this.data = data;
		}
		
        QueueNode(T data, QueueNode<T> next){
			this.data = data;
			this.next = next;
		}
		
	}

	QueueNode<T> first;
	QueueNode<T> last;
	
	public void add(T data){
		
		if(first == null){
			first = new QueueNode<T>(data);
			last = first;
		} else {
			last.next = new QueueNode<T>(data);
			last = last.next;
		}
	}
	
	public T remove(){
		
	if(first == null)
		throw new NoSuchElementException();
	
	T data = first.data;
	first = first.next;
	return data;
	}
	
	public T peek(){
		if(first == null)
			throw new EmptyStackException();
		
		return first.data;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	
	public static void main(String[] args) {
		
		MyQueue<String> q = new MyQueue<String>();
		
		q.add("Arjun");
		q.add("Karna");
		q.add("Mahabharat");
		q.add("Dhritrashtra");
		
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
	
}
