package thread.synchronizd;

import java.util.LinkedList;

import util.LogConsole;

/**
 * 仓库类
 * 
 * @author weiming
 *
 */
public class Storage {

	// 最大存储数
	public int MAX_SIZE = 100;

	// 队列
	public LinkedList<Object> list = new LinkedList<Object>();

	public void produce(int num) {
		synchronized (list) {
			while (list.size() + num > MAX_SIZE) {

				LogConsole.info(Thread.currentThread().getName() + "【要生产的产品数量】:" + num + " 【库存量】:" + list.size() + " 暂时不能执行生产任务!");

				try {
					LogConsole.info(Thread.currentThread().getName() + "在等待队列产品被消费");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				list.add(new Object());
			}
			LogConsole.info(Thread.currentThread().getName() + "【已经生产产品数】:" + num + " 【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

	public void consume(int num) {
		synchronized (list) {
			while (list.size() < num) {
				LogConsole.info(Thread.currentThread().getName() + "【要消费的产品数量】:" + num + " 【库存量】:" + list.size() + " 暂时不能执行消费任务!");

				try {
					LogConsole.info(Thread.currentThread().getName() + "在等待队列添加产品");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				list.remove();
			}
			LogConsole.info(Thread.currentThread().getName() + "【已经消费产品数】:" + num + "【现仓储量为】:" + list.size());
			list.notifyAll();

		}
	}
}
