package thread.synchronizdmy;

import util.LogConsole;

/**
 * ������
 * 
 * @author weiming
 *
 */
public class Producer extends Thread {

	// ÿ��������
	private int num = 5;

	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		produce(num);
	}

	public void produce(int num) {
		System.out.println(Thread.currentThread().getName() + "trylock");
		synchronized (storage.list) {
			System.out.println(Thread.currentThread().getName() + "locked");
			
			//�����while�����滻Ϊif
			while (storage.list.size() + num > storage.MAX_SIZE) {

				LogConsole.info(Thread.currentThread().getName() + "��Ҫ�����Ĳ�Ʒ������:" + num + " ���������:" + storage.list.size() + "  ��ʱ����ִ����������!");

				try {
					LogConsole.info(Thread.currentThread().getName() + " �ڵȴ����в�Ʒ������");
					storage.list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				storage.list.add(new Object());
			}
			LogConsole.info(Thread.currentThread().getName() + "���Ѿ�������Ʒ����:" + num + " ���ֲִ���Ϊ��:" + storage.list.size());
			storage.list.notifyAll();
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
