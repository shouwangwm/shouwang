package testsynchronized.syncThis;

import util.LogConsole;

public class TestA {

	public void printA() {
		LogConsole.info(Thread.currentThread().getName() + " printA start ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LogConsole.info(Thread.currentThread().getName() + " printA end ");

	}

	public void printB() {
		LogConsole.info(Thread.currentThread().getName() + " printB start ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LogConsole.info(Thread.currentThread().getName() + " printB end ");

	}

}
