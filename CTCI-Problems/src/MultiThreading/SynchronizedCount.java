package MultiThreading;

public class SynchronizedCount extends Thread{
	
	static Integer count = 0;
	int index;
	SynchronizedCount(int i){
		    index = i;
	}
	
	@Override
	public void run() {
	System.out.println("Thread " + index + " running");	
	while(true){
		synchronized (count) {
			//System.out.println("In thread " + index + " count is: " + count);	
		    if(count > 10)
			     return;
		    if(count%2 == 0){
				System.out.println("baba ");
		    }
		    count++;
		 }
	   }
    }
	public static void main(String[] args) {
		SynchronizedCount thread1 = new SynchronizedCount(1);
		SynchronizedCount thread2 = new SynchronizedCount(2);
		thread1.start();
		thread2.start();
	}

}
