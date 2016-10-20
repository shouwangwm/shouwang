package jvm;

import java.util.ArrayList;
import java.util.List;

public class TestException {
	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		while(true){
			byte[] b = new byte[1024*1000];
			list.add(b);
			System.out.println(list.size());
		}
	}
}
