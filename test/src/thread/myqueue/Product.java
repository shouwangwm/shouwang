package thread.myqueue;

import java.util.Random;
/**
 * ������
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
				//����������󳤶ȣ��Զ�����
				Storage.goodsQueue.put(str);
				System.out.println("�����ˣ�" + str + " �ֿ�����Ʒ������ " + Storage.goodsQueue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
