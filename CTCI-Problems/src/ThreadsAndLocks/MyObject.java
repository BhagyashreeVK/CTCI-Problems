package ThreadsAndLocks;

public class MyObject {

	public synchronized void foo(String name){
		try {
			System.out.println("Thread " + name + ".foo() : starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo() : ending");
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + ".foo() : interrupted");
		}
	}
	
	public static synchronized void staticFoo(String name){
		try {
			System.out.println("Thread " + name + ".staticfoo() : starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".staticfoo() : ending");
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + ".staticfoo() : interrupted");
		}
	}
	
	public static synchronized void staticBar(String name){
		try {
			System.out.println("Thread " + name + ".staticbar() : starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".staticbar() : ending");
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + ".staticbar() : interrupted");
		}
	}
}
