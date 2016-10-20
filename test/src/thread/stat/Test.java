package thread.stat;

public class Test {
	
	public static void main(String[] args) {
		
		Stat s1 = new Stat();
		Stat s2 = new Stat();
		
		StaticSyncThread staticSyncThread = new StaticSyncThread();
		SyncBlockThread syncBlockThread = new SyncBlockThread(s1);
		
		//由执行结果可以看出synchronized静态方法和synchronized(Class)是一样的。
		syncBlockThread.start();
		staticSyncThread.start();
		
	}

}
