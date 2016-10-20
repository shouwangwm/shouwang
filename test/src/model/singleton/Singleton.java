package model.singleton;
/**
 * ����ʽ
 * @author weiming
 *
 */
public class Singleton {
	
	private static Singleton singleton = null;
	
	private Singleton(){
		
	}
	
	public static synchronized Singleton instance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
	
	
}
