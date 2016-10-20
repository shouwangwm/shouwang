package string;

public class TestMemeoryAddress {
	
	public static void main(String[] args) {
		
		
		String a = "aaa";
		String b = a;
		a = "bbb";
//		a = new String("temp");
		System.out.println(b); //输出aaa,因为b指向的内存地址没有变 ， a的重新指向与b无关， jvm内存原理。
		
	}
}
