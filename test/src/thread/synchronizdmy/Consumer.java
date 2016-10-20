package thread.synchronizdmy;

import util.LogConsole;

public class Consumer extends Thread {

	// 每次消费物品数
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
			//这里的while不能替换为if
			while (storage.list.size() < num) {
				LogConsole.info(Thread.currentThread().getName() +  "【要消费的产品数量】:" + num + " 【库存量】:" + storage.list.size() + " 暂时不能执行消费任务!");

				try {
					LogConsole.info(Thread.currentThread().getName() + " 在等待队列添加产品");
					storage.list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				storage.list.remove();
			}
			LogConsole.info(Thread.currentThread().getName() + "【已经消费产品数】:" + num + " 【现仓储量为】:" + storage.list.size());
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
