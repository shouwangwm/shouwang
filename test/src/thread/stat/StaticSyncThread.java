package thread.stat;

public class StaticSyncThread extends Thread {
	
	@Override
	public void run() {
		Stat.StaticSyncMethod();
	}

}
