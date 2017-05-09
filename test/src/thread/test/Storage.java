package thread.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	
	public static BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(100);
}
