package thread.lock;

public class Consumer extends Thread {

	// 每次消费物品数
	private int num = 10;

	private Storage storage;

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		consume(num);
	}

	public void consume(int num) {
		storage.consume(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
