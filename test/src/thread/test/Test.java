package thread.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		
		Executor e = Executors.newFixedThreadPool(2);
		Product  p = new Product();
		Consumer c = new Consumer();
		e.execute(p);
		e.execute(c);
	}
}
