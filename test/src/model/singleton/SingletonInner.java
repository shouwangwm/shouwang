package model.singleton;

/**
 * ��Singleton����ʱ�������ʼ�����ڲ��ࣻ
 * ֻ���ڵ���getInstance�������ʱ���Ż�����ڲ���SingletonHolder��ʵ�����ӳټ��صĹ��ܣ��ֽ���ϵͳ���ܡ�
 * @author weiming
1������ģʽʹ���ڲ�����ά����������ʵ������SingleTon3������ʱ�����ڲ��ಢ���ᱻ��ʼ����
��˵����౻����jvmʱ�������ʼ�������࣬����getInstance()����������ʱ���ż���SingleHolder���ڲ��ࣩ��
�Ӷ���ʼ��instance��
2�����ַ�ʽʵ���������������ʱ��ɣ���������Զ��߳��Ѻã�getInstance��������ʹ��ͬ���ؼ���
3��ʹ���ڲ��෽ʽʵ�ֵ������ȿ��������ӳټ��أ�Ҳ����ʹ�ùؼ��֣���һ�ֱȽ����Ƶ�ʱ�䡣
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
