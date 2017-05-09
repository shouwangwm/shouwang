package thread.myqueue;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(2); 
		Thread p = new Product();
		Thread c = new Consumer();
		executor.execute(p);
		executor.execute(c);
	} 
}
