package lock.object;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试lock锁代码块的机制
 * @author weiming
 *
 */
public class LockMethod {
	
	//声明成类变量，这样是对象锁
	Lock lock = new ReentrantLock();
	
	public void testA(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " testA sleep 2000 ...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}
	
	public void testB(){
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
