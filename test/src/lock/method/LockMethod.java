package lock.method;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����lock�������Ļ���
 * 
 * @author weiming
 *
 */
public class LockMethod {

	public void testA() {
		// �����ڷ����ڲ����Ǵ������
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
		// �����ڷ����ڲ����Ǵ������
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
