package thread.myqueue;

import java.util.Random;
/**
 * 生产者
 * @author weiming
 *
 */
public class Product extends Thread {
	
	@Override
	public void run() {
		String str;
		Random r = new Random();
		for(int i = 0 ; i< 10000; i++){
			str = "goods-" + i;
			try {
				//超过队列最大长度，自动阻塞
				Storage.goodsQueue.put(str);
				System.out.println("生产了：" + str + " 仓库中物品容量： " + Storage.goodsQueue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
