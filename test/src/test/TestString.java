package test;

public class TestString {
	
	public static void main(String[] args) {
//		String a = "ab";
//		String b = "ab";
//		System.out.println(a == b);
//		System.out.println(a.equals(b));
		
		 // 使用char数组来初始化a，避免在a被创建之前字符串池中已经存在了值为"abcd"的对象  
        String a = new String(new char[] { 'a', 'b', 'c', 'd' });  
        String b = a.intern();  
        System.out.println(b);
        if (b == a) {  
            System.out.println("b被加入了字符串池中，没有新建对象");  
        } else {  
            System.out.println("b没被加入字符串池中，新建了对象");  
        }  
	}
}
