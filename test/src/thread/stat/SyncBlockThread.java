package thread.stat;

public class SyncBlockThread extends Thread {
	
	private Stat stat;
	
	public SyncBlockThread(Stat stat){
		this.stat = stat;
	}
	
	@Override
	public void run() {
		stat.syncBlock();
	}

}
