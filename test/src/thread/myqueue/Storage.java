package thread.myqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * �ֿ���
 * @author weiming
 *
 */
public class Storage {
	
	//������Ʒ�����
	public static int MAX_SIZE = 100;
	/**
	 * LinkedBlockingQueue
	 * �����β�����Ԫ�أ�  add������󳤶Ȼ��׳��쳣; put�����쳣������; offer���������᷵��false
	 * �Ӷ�����ȡ�����Ƴ�ͷԪ�صķ�����pollû��Ԫ�ط���null; removeû��Ԫ�ػ��׳��쳣; take�����ȴ��������Ԫ��
	 */
	//������Ʒ����
	public static BlockingQueue<String> goodsQueue = new LinkedBlockingQueue<String>(100);
	
}
