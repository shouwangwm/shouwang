package testsynchronized.sync;

public class TestThread extends Thread {
	
	private TestA a;
	private int flag;
	
	public TestThread(TestA a, int flag) {
		super();
		this.a = a;
		this.flag = flag;
	}

	@Override
	public void run() {

		if(flag == 1){
			a.printA();
		}else if(flag == 2){
			a.printB();
		}else{
			a.printC();
		}
	}
}
