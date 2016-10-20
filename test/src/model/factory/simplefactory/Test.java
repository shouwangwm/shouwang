package model.factory.simplefactory;

/**
 * ≤‚ ‘ºÚµ•π§≥ß
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
