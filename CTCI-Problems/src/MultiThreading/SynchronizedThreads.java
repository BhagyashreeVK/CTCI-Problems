package MultiThreading;

public class SynchronizedThreads extends Thread{
	
	Object obj1,obj2;
	int index;
	static Object object1, object2;
	
	public SynchronizedThreads(int i) {
		index = i;
		obj1 = new Object();
		obj2 = new Object();
		object1 = new Object();
		object2 = new Object();
	}
	
	public SynchronizedThreads(int i, Object o1, Object o2) {
		index = i;
		obj1 = o1;
		obj2 = o2;
	}
	
	@Override
	public void run(){
		
		System.out.println("Thread "+ index +" waiting for object 1");
		synchronized(object1){
			System.out.println("Thread " + index + " holding object 1");
			try {
				sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread " + index + " out of synchronized block 1");
		}
		
		System.out.println("Thread "+ index +" waiting for object 2");
        
		synchronized (object2) {
			System.out.println("Thread " + index + " holding object 2");
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread " + index + " out of synchronized block 2");
		}
	}

	public static void main(String[] args) {
		
		/*Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		SynchronizedThreads thread1 = new SynchronizedThreads(1);
		SynchronizedThreads thread2 = new SynchronizedThreads(2);
		thread1.start();
		thread2.start();*/
		int count = 0;
		while(true){
			
			if(count > 10)
				return;
			
			if(count%2 == 0)
			  System.out.println(count);
			
			count++;
		}
	}

}
