package thread.myqueue;

import java.util.Random;
/**
 * ������
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
				System.out.println("������" + str  + " �ֿ������� " + Storage.goodsQueue.size());
//				Consumer.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
