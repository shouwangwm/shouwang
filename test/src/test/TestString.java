package test;

import java.util.Calendar;
import java.util.Date;

import com.sun.xml.internal.ws.util.StringUtils;

public class TestString {

	public static void main(String[] args) {
		// String a = "ab";
		// String b = "ab";
		// System.out.println(a == b);
		// System.out.println(a.equals(b));

		// ʹ��char��������ʼ��a��������a������֮ǰ�ַ��������Ѿ�������ֵΪ"abcd"�Ķ���
		// String a = new String(new char[] { 'a', 'b', 'c', 'd' });
		// String b = a.intern();
		// System.out.println(b);
		// if (b == a) {
		// System.out.println("b���������ַ������У�û���½�����");
		// } else {
		// System.out.println("bû�������ַ������У��½��˶���");
		// }

//		Calendar calst = Calendar.getInstance();;
//		Calendar caled = Calendar.getInstance();
//
//		calst.setTime(new Date(1480977937000L));
//		caled.setTime(new Date(System.currentTimeMillis()));
//
//		// ����ʱ��Ϊ0ʱ
//		calst.set(Calendar.HOUR_OF_DAY, 0);
//		calst.set(Calendar.MINUTE, 0);
//		calst.set(Calendar.SECOND, 0);
//		caled.set(Calendar.HOUR_OF_DAY, 0);
//		caled.set(Calendar.MINUTE, 0);
//		caled.set(Calendar.SECOND, 0);
//		// �õ�����������������
//		int days = ((int) (caled.getTime().getTime() / 1000)
//				- (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
//
//		System.out.println(days);
		
//		String a = "-";
//		String attr[] = a.split("-");
//		if(attr != null && attr.length > 0){
//			String a1 = attr[0];
//		    String a2 = attr[1];
//		    System.out.println(a1);
//		    System.out.println(a2);
//		}
		
		
//		StringBuilder param = new StringBuilder();
//		System.out.println(param.length());
		
//		String ln = "aa,bb,cc\r\nstest,test";
//		System.out.println(ln);
		
		
		String name = "ismael";
		//Noncompliant
		if (name.indexOf("ae") > 2) { // Noncompliant
		  // ...
			System.out.println("------" + name.indexOf("ae"));
		}
		//Compliant 
		if (name.indexOf("ae", 2) > -1) {
		  // ...
			System.out.println("------" + name.indexOf("ae", 2));
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		
	}
}
