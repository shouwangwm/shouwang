package thread.synchronizdmy;

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
	public static int MAX_SIZE = 100;

	// 队列
	public LinkedList<Object> list = new LinkedList<Object>();

}
