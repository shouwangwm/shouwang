package test;

public class TestString {
	
	public static void main(String[] args) {
//		String a = "ab";
//		String b = "ab";
//		System.out.println(a == b);
//		System.out.println(a.equals(b));
		
		 // ʹ��char��������ʼ��a��������a������֮ǰ�ַ��������Ѿ�������ֵΪ"abcd"�Ķ���  
        String a = new String(new char[] { 'a', 'b', 'c', 'd' });  
        String b = a.intern();  
        System.out.println(b);
        if (b == a) {  
            System.out.println("b���������ַ������У�û���½�����");  
        } else {  
            System.out.println("bû�������ַ������У��½��˶���");  
        }  
	}
}
