package lock.object;

public class LockThreadA extends Thread{
	
	private LockMethod lm;
	
	public LockThreadA(LockMethod lm) {
		this.lm = lm;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start ...");
		lm.testA();
		System.out.println(Thread.currentThread().getName() + " end ...");
	}
}
