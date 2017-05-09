package testsynchronized.sync;

import util.LogConsole;

public class TestA {
	
	
	public synchronized void printA(){
		LogConsole.info(Thread.currentThread().getName() + " printA start ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LogConsole.info(Thread.currentThread().getName() + " printA end ");
		this.notifyAll();
		
	}
	
	public synchronized void printB(){
		LogConsole.info(Thread.currentThread().getName() + " printB start ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LogConsole.info(Thread.currentThread().getName() + " printB end ");
		this.notifyAll();
	}
	
	public void printC(){
		LogConsole.info(Thread.currentThread().getName() + " printC start ");
		LogConsole.info(Thread.currentThread().getName() + " printC end ");
	}
}
