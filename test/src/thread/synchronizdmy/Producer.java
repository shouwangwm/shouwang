package thread.synchronizdmy;

import util.LogConsole;

/**
 * 生产者
 * 
 * @author weiming
 *
 */
public class Producer extends Thread {

	// 每次生产数
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
			
			//这里的while不能替换为if
			while (storage.list.size() + num > storage.MAX_SIZE) {

				LogConsole.info(Thread.currentThread().getName() + "【要生产的产品数量】:" + num + " 【库存量】:" + storage.list.size() + "  暂时不能执行生产任务!");

				try {
					LogConsole.info(Thread.currentThread().getName() + " 在等待队列产品被消费");
					storage.list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				storage.list.add(new Object());
			}
			LogConsole.info(Thread.currentThread().getName() + "【已经生产产品数】:" + num + " 【现仓储量为】:" + storage.list.size());
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
