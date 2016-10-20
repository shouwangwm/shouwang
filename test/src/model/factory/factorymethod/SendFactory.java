package model.factory.factorymethod;

public class SendFactory {
	
	public Sender produceSms(){
		return new SmsSender();
	}
	
	public Sender produceMail(){
		return new MailSender();
	}
}
