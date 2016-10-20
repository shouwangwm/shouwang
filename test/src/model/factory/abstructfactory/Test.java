package model.factory.abstructfactory;

/**
 * ���󹤳�
 * @author weiming
 *
 */
public class Test {
	
	public static void main(String[] args) {
		Provider provider = new SmsFactory();
		Sender sms = provider.produce();
		sms.send();
		
		Provider mailProvider = new MailFactory();
		Sender mail = mailProvider.produce();
		mail.send();
	}
}
