package model.factory.staticfactorymethod;

/**
 * 静态工厂方法
 * @author weiming
 *
 */
public class Test {
	
	public static void main(String[] args) {
		Sender sender = SendFactory.produceSms();
		sender.send();
		
		Sender sender2 = SendFactory.produceMail();
		sender2.send();
	}
}
