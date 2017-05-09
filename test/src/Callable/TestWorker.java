package Callable;

import java.util.concurrent.FutureTask;

public class TestWorker {
	
	public static void main(String[] args) {
		
		Worker w1 = new Worker(1);
		Worker w2 = new Worker(2);
		
		FutureTask<Integer> t1 = new FutureTask<Integer>(w1);
		new Thread(t1).start();
		try {
			System.out.println(" class 1 total score : " + t1.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FutureTask<Integer> t2 = new FutureTask<Integer>(w2);
		new Thread(t2).start();
		try {
			System.out.println(" class 2 total score : " + t2.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
