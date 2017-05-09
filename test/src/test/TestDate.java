package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) {
		
		String d = "2017-01-02 23:11:33";
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss").parse(d);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
