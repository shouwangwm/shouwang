package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		
		Long a = 1470810619000L;
		String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(a));
		System.out.println(str);
		
		Long de = new Date(0).getTime();
		System.out.println(0);
	}
	
}
