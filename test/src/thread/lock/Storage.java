package thread.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

	// ���洢��
	public int MAX_SIZE = 100;

	// ����
	public LinkedList<Object> list = new LinkedList<Object>();
	// ��
	private final Lock lock = new ReentrantLock();

	// �ֿ�������������
	private final Condition full = lock.newCondition();
	// �ֿ�յ���������
	private final Condition empty = lock.newCondition();

	public void produce(int num) {
		lock.lock();
		while (list.size() + num > MAX_SIZE) {
			System.out.println("��Ҫ�����Ĳ�Ʒ������:" + num + " ���������:" + list.size() + " ��ʱ����ִ����������!");
			try {
				// �������������㣬��������
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// ����������������£�����num����Ʒ
		for (int i = 1; i <= num; ++i) {
			list.add(new Object());
		}

		System.out.println("���Ѿ�������Ʒ����:" + num + " ���ֲִ���Ϊ��:" + list.size());
		full.signalAll();
		empty.signalAll();

		lock.unlock();
	}
	
	// ����num����Ʒ  
    public void consume(int num)  
    {  
        // �����  
        lock.lock();  
  
        // ����ֿ�洢������  
        while (list.size() < num)  
        {  
            System.out.println("��Ҫ���ѵĲ�Ʒ������:" + num + " ���������:" + list.size()  
                    + " ��ʱ����ִ����������!");  
            try  
            {  
                // �������������㣬��������  
                empty.await();  
            }  
            catch (InterruptedException e)  
            {  
                e.printStackTrace();  
            }  
        }  
  
        // ����������������£�����num����Ʒ  
        for (int i = 1; i <= num; ++i)  
        {  
            list.remove();  
        }  
  
        System.out.println("���Ѿ����Ѳ�Ʒ����:" + num + " ���ֲִ���Ϊ��:" + list.size());  
  
        // �������������߳�  
        full.signalAll();  
        empty.signalAll();  
  
        // �ͷ���  
        lock.unlock();  
    }  
}
