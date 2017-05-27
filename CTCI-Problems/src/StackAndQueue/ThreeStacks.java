package StackAndQueue;

import java.util.EmptyStackException;

public class ThreeStacks {

	private int noOfStacks = 3;
	private int[] array;
	private int size;
	private int[] tops;
	
	ThreeStacks(int size){
		this.size = size;
		tops = new int[noOfStacks];
		array = new int[size*noOfStacks];
		intializeTops();
	}
	
	public void intializeTops(){
		for(int i = 0 ;  i < noOfStacks ; i++){
		 tops[i] = (size * i) - 1;
		}
	}

	//assuming non zero based numbers are passed
    public void push(int stackNum, int data){
    	int stackTop = tops[stackNum-1] + 1;
    	if(stackTop >= size*stackNum){
			throw new ArrayIndexOutOfBoundsException();
    	}
    	tops[stackNum-1]++;
    	array[tops[stackNum-1]] = data;
	}
    
    public int pop(int stackNum){
    	if(tops[stackNum-1] < size*(stackNum-1))
			throw new EmptyStackException();
    	int data= array[tops[stackNum-1]];
    	tops[stackNum-1]--;
    	return data;
	}
    
    public int peek(int stackNum){
    	if(tops[stackNum-1] < size*(stackNum-1))
			throw new EmptyStackException();
    	int data= array[tops[stackNum-1]];
    	return data;
	}
    
    public boolean isEmpty(int stackNum){
    	return tops[stackNum-1] < size * (stackNum-1);
    }
	
	public static void main(String[] args) {

		ThreeStacks ts =  new ThreeStacks(3);
		ts.push(1, 1);
		ts.push(2, 4);
		ts.push(2, 5);
		ts.push(3, 6);

		System.out.println(ts.pop(1));
		System.out.println(ts.pop(2));
		System.out.println(ts.pop(3));
		
	}

}
