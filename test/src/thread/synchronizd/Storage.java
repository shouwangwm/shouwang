package thread.synchronizd;

import java.util.LinkedList;

import util.LogConsole;

/**
 * �ֿ���
 * 
 * @author weiming
 *
 */
public class Storage {

	// ���洢��
	public int MAX_SIZE = 100;

	// ����
	public LinkedList<Object> list = new LinkedList<Object>();

	public void produce(int num) {
		synchronized (list) {
			while (list.size() + num > MAX_SIZE) {

				LogConsole.info(Thread.currentThread().getName() + "��Ҫ�����Ĳ�Ʒ������:" + num + " ���������:" + list.size() + " ��ʱ����ִ����������!");

				try {
					LogConsole.info(Thread.currentThread().getName() + "�ڵȴ����в�Ʒ������");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				list.add(new Object());
			}
			LogConsole.info(Thread.currentThread().getName() + "���Ѿ�������Ʒ����:" + num + " ���ֲִ���Ϊ��:" + list.size());
			list.notifyAll();
		}
	}

	public void consume(int num) {
		synchronized (list) {
			while (list.size() < num) {
				LogConsole.info(Thread.currentThread().getName() + "��Ҫ���ѵĲ�Ʒ������:" + num + " ���������:" + list.size() + " ��ʱ����ִ����������!");

				try {
					LogConsole.info(Thread.currentThread().getName() + "�ڵȴ�������Ӳ�Ʒ");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				list.remove();
			}
			LogConsole.info(Thread.currentThread().getName() + "���Ѿ����Ѳ�Ʒ����:" + num + "���ֲִ���Ϊ��:" + list.size());
			list.notifyAll();

		}
	}
}
