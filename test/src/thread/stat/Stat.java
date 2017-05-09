package thread.stat;
/**
 * ��֤synchronized��̬������synchronized(Class)��һ����
 * @author weiming
 *
 */
public class Stat {
	
	public static synchronized void StaticSyncMethod(){
		System.out.println("enter StaticSyncMethod ...");
		try {
			System.out.println("StaticSyncMethod sleep ...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end StaticSyncMethod ...");
	}
	
	public void syncBlock(){
		System.out.println("enter syncBlock ...");
		synchronized (Stat.class) {
			try {
				System.out.println("syncBlock sleep ...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end syncBlock ...");
	}

}
