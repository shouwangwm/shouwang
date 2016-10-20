package lock.method;

public class LockThreadB extends Thread{
	
	private LockMethod lm;
	
	public LockThreadB(LockMethod lm) {
		this.lm = lm;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start ...");
		lm.testB();
		lm.testA();
		System.out.println(Thread.currentThread().getName() + " end ...");
	}
}
