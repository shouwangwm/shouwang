package model.factory.abstructfactory;

public class MailFactory implements Provider{
	
	public Sender produce(){
		return new MailSender();
	}
	
}
