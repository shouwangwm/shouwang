package thread.lock;

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
		storage.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
