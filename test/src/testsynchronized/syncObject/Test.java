package testsynchronized.syncObject;

public class Test {
	
	public static void main(String[] args) {
		
		TestA a = new TestA();
		Thread t1 = new TestThread(a,"printA");
		Thread t2 = new TestThread(a,"printB");
		Thread t4 = new TestThread(a,"printA");

		t1.start();
		t2.start();
		t4.start();
	}
}
