package model.factory.staticfactorymethod;

public class SendFactory {
	
	public static Sender produceSms(){
		return new SmsSender();
	}
	
	public static Sender produceMail(){
		return new MailSender();
	}
}
