package testsynchronized.sync;

public class Test {
	
	public static void main(String[] args) {
		
		TestA a = new TestA();
		Thread t1 = new TestThread(a,1);
		Thread t2 = new TestThread(a,2);
		Thread t3 = new TestThread(a,3);
		Thread t4 = new TestThread(a,1);
		
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t4.setName("t4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
