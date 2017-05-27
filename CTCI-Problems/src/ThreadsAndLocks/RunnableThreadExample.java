package ThreadsAndLocks;

public class RunnableThreadExample implements Runnable{

	int count = 0;
	
	@Override
	public void run() {
		
		System.out.println("Runnable thread is starting");
		
		try {
			while(count < 5){
				System.out.println("Runnable thread sleeping");
				Thread.sleep(500);
				count++;
			}
		 } catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Runnable thread interrupted!!");
		 }
		System.out.println("Runnable thread is now terminating");
	}

	public static void main(String[] args) {
	
		RunnableThreadExample runner = new RunnableThreadExample();
		Thread thread = new Thread(runner);
		thread.start();
		
		try {
		   while(runner.count != 5){
  			    System.out.println("Main Thread Sleeping Now");
				Thread.sleep(500);
			
		    }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
