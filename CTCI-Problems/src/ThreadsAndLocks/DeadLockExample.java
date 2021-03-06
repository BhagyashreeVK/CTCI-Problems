package ThreadsAndLocks;

public class DeadLockExample {
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	private static class ThreadDemo1 extends Thread{
		public void run() {
			synchronized(lock1){
				System.out.println("Thread 1 holding lock 1");
				try {
					Thread.sleep(200);
				} catch (Exception e) {
				}
				System.out.println("Thread 1 waiting for lock 2");
				synchronized (lock2) {
					System.out.println("Thread 1 holding lock 1 and lock 2");
				}
			}
		}
	}
	
	private static class ThreadDemo2 extends Thread{
		public void run() {
			synchronized(lock2){
				System.out.println("Thread 2 holding lock 2");
				try {
					Thread.sleep(200);
				} catch (Exception e) {
				}
				System.out.println("Thread 2 waiting for lock 1");
				synchronized (lock1) {
					System.out.println("Thread 2 holding lock 1 and lock 2");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo1 thread1 = new ThreadDemo1();
		ThreadDemo2 thread2 = new ThreadDemo2();
		thread1.start();
		thread2.start();
	}

}
