package lock.object;

public class Test {

	public static void main(String[] args) {

		LockMethod lm = new LockMethod();

		Thread a = new LockThreadA(lm);
		Thread b = new LockThreadB(lm);

		a.start();
		b.start();
	}

}
