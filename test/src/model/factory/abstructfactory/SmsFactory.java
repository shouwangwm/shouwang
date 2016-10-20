package model.factory.abstructfactory;

public class SmsFactory implements Provider{
	
	public Sender produce(){
		return new SmsSender();
	}
	
}
