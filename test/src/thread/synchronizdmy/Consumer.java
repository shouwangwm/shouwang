package thread.synchronizdmy;

import util.LogConsole;

public class Consumer extends Thread {

	// ÿ��������Ʒ��
	private int num = 10;

	private Storage storage;

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		consume(num);
	}

	public void consume(int num) {
		System.out.println(Thread.currentThread().getName() + "trylock");
		synchronized (storage.list) {
			System.out.println(Thread.currentThread().getName() + "locked");
			//�����while�����滻Ϊif
			while (storage.list.size() < num) {
				LogConsole.info(Thread.currentThread().getName() +  "��Ҫ���ѵĲ�Ʒ������:" + num + " ���������:" + storage.list.size() + " ��ʱ����ִ����������!");

				try {
					LogConsole.info(Thread.currentThread().getName() + " �ڵȴ�������Ӳ�Ʒ");
					storage.list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				storage.list.remove();
			}
			LogConsole.info(Thread.currentThread().getName() + "���Ѿ����Ѳ�Ʒ����:" + num + " ���ֲִ���Ϊ��:" + storage.list.size());
			storage.list.notifyAll();
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
