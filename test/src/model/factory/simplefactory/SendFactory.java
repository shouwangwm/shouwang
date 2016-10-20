package model.factory.simplefactory;

public class SendFactory {
	
	public Sender produceSender(String type){
		if("sms".equals(type)){
			return new SmsSender();
		}else if("mail".equals(type)){
			return new MailSender();
		}else{
			System.out.println("��������ȷ������");
			return null;
		}
	}
}
