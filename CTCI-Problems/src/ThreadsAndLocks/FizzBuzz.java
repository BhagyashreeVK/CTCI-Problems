package ThreadsAndLocks;

public class FizzBuzz extends Thread{

	//private static Object lock = new Object();
	//protected static int current = 1;
	protected static Integer current = 1;
	private int max;
	private boolean div3, div5;
	private String toPrint;
	
	public FizzBuzz(boolean div3, boolean div5, int max, String toPrint){
		this.div3 = div3;
		this.div5 = div5;
		this.max = max;
		this.toPrint = toPrint;
	}
	
	public void print(){
		System.out.print(toPrint + " ");
	}
	
	public void run(){
		while(true){
			synchronized(current){
				if(current > max)
					return;
				if(((current % 3 == 0) == div3) && ((current % 5 == 0) == div5)){
					print();
					current++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
	
		Thread[] threads = { new FizzBuzz(true, true, 20, "FizzBuzz"),
				new FizzBuzz(true, false, 20, "Fizz"),
				new FizzBuzz(false, true, 20, "Buzz"),
				new NumberThread(false, false, 20),
		};
		
		for(Thread thread:threads){
			thread.start();
		}
	}

}
