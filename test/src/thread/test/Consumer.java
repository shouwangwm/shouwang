package thread.test;

public class Consumer extends Thread {
	
	@Override
	public void run() {
		
		while(true){
			try {
				Storage.queue.take();
				System.out.println(Thread.currentThread().getName() + " == " + Storage.queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
