package model.factory.simplefactory;

/**
 * ���Լ򵥹���
 * @author weiming
 *
 */
public class Test {
	
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceSender("sms");
		sender.send();
	}
}
