package sonar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition notFull  = lock.newCondition();
		try {
			notFull.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
