package testsynchronized.syncThis;

public class TestThread extends Thread {
	
	private TestA a;
	private String flag;
	
	public TestThread(TestA a, String flag) {
		super();
		this.a = a;
		this.flag = flag;
	}

	@Override
	public void run() {

		if("printA".equals(flag)){
			synchronized(this){
				a.printA();
			}
		}else{
			synchronized(this){
				a.printB();
			}
		}
	}
}
