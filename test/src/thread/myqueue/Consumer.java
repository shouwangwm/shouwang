package thread.myqueue;

import java.util.Random;
/**
 * 消费者
 * @author weiming
 *
 */
public class Consumer extends Thread {
	
	@Override
	public void run() {
		String str;
		while(true){
			try {
				str = Storage.goodsQueue.take();
				System.out.println("消费了" + str  + " 仓库容量： " + Storage.goodsQueue.size());
//				Consumer.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
