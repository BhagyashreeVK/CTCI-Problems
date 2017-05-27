package ThreadsAndLocks;

public class SynchronizedExample extends Thread{

	private String name;
	private MyObject myObj;
	
	public SynchronizedExample(MyObject obj, String n){
		name = n;
		myObj = obj;
	}
	
	public void run(){
//		myObj.foo(name);
		
		if(name.equals("fooboo"))
			MyObject.staticFoo(name);
		else
			MyObject.staticBar(name);
	}
	
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		SynchronizedExample thread1 = new SynchronizedExample(obj1, "fooboo");
		SynchronizedExample thread2 = new SynchronizedExample(obj1, "baba");
		thread1.start();
		thread2.start();
	}

}
