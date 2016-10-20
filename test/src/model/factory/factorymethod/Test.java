package model.factory.factorymethod;

/**
 * 工厂方法
 * @author weiming
 *
 */
public class Test {
	
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceSms();
		sender.send();
		
		Sender sender2 = factory.produceMail();
		sender2.send();
	}
}
