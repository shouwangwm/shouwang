package model.singleton;
/**
 * ¶öººÊ½
 * @author weiming
 *
 */
public class Singleton2 {
	
	private static final Singleton2 singleton = new Singleton2();
	
	private Singleton2(){
		
	}
	
	public static Singleton2 instance(){
		return Singleton2.singleton;
	}
	
	
}
