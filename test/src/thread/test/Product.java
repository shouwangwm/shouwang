package thread.test;

public class Product extends Thread {
	
	@Override
	public void run() {
		
		while(true){
			try {
				Storage.queue.put(new Object());
				System.out.println(Thread.currentThread().getName() + " == " + Storage.queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
