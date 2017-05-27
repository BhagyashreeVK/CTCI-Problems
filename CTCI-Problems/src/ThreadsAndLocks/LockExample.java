package ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	
	Lock lock;
	String name;
	int balance = 100;
	
	LockExample(String n){
		name = n;
		lock = new ReentrantLock();
	}
	
	public int withDraw(int amt){
		lock.lock();
	int temp = balance;	
	  try {
	    Thread.sleep(1000);
	    temp -=amt;
	    Thread.sleep(1000);
	    balance = temp;
	    System.out.println("Thread "+ name + "in withdraw");
	  } catch (Exception e) {
	  }
	  lock.unlock();
	  return temp;	
	}
	
	public int deposit(int amt){
		lock.lock();
		int temp = balance;	
	  try {
	    Thread.sleep(1000);
	    temp +=amt;
	    Thread.sleep(1000);
	    balance = temp;
	    System.out.println("Thread "+ name +"in Deposit");
	  } catch (Exception e) {
	  }
	  lock.unlock();
	  return temp;	
	}

	public static void main(String[] args) {

		LockExample thread1 = new LockExample("1");
		LockExample thread2 = new LockExample("2");
		LockExample thread3 = new LockExample("3");
		
		System.out.println(thread1.withDraw(20));
		System.out.println(thread2.withDraw(40));
		System.out.println(thread3.deposit(200));
		
	}

}
