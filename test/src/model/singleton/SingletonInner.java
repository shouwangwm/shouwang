package model.singleton;

/**
 * 当Singleton加载时，不会初始化其内部类；
 * 只有在调用getInstance这个方法时，才会加载内部类SingletonHolder，实现了延迟加载的功能，又降低系统性能。
 * @author weiming
1、单例模式使用内部类来维护到单例的实例，当SingleTon3被加载时，其内部类并不会被初始化，
因此单例类被加载jvm时，不会初始化单例类，而当getInstance()方法被调用时，才加载SingleHolder（内部类），
从而初始化instance。
2、此种方式实例创建是在类加载时完成，因此天生对多线程友好，getInstance方法不必使用同步关键字
3、使用内部类方式实现单例，既可以做到延迟加载，也不必使用关键字，是一种比较完善的时间。
 */
public class SingletonInner {
	
	
	private SingletonInner(){
		
	}
	
	private static class SingletonHolder{
		private static SingletonInner singleton = new SingletonInner();
	}
	
	public static SingletonInner getInstance(){
		return SingletonHolder.singleton;
	}
	

}
