package lock.method;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试lock锁代码块的机制
 * 
 * @author weiming
 *
 */
public class LockMethod {

	public void testA() {
		// 声明在方法内部，是代码块锁
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " testA sleep 2000 ...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}

	public void testB() {
		// 声明在方法内部，是代码块锁
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " testB sleep 2000 ...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}
}
