package lock.object;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����lock�������Ļ���
 * @author weiming
 *
 */
public class LockMethod {
	
	//������������������Ƕ�����
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
