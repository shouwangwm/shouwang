package thread.stat;

public class Test {
	
	public static void main(String[] args) {
		
		Stat s1 = new Stat();
		Stat s2 = new Stat();
		
		StaticSyncThread staticSyncThread = new StaticSyncThread();
		SyncBlockThread syncBlockThread = new SyncBlockThread(s1);
		
		//��ִ�н�����Կ���synchronized��̬������synchronized(Class)��һ���ġ�
		syncBlockThread.start();
		staticSyncThread.start();
		
	}

}
