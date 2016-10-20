package thread.myqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 仓库类
 * @author weiming
 *
 */
public class Storage {
	
	//保存物品最大数
	public static int MAX_SIZE = 100;
	/**
	 * LinkedBlockingQueue
	 * 向队列尾部添加元素：  add超出最大长度会抛出异常; put不抛异常会阻塞; offer队列已满会返回false
	 * 从队列中取出并移除头元素的方法：poll没有元素返回null; remove没有元素会抛出异常; take阻塞等待队列添加元素
	 */
	//保存物品队列
	public static BlockingQueue<String> goodsQueue = new LinkedBlockingQueue<String>(100);
	
}
