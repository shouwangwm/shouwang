package string;

public class TestMemeoryAddress {
	
	public static void main(String[] args) {
		
		
		String a = "aaa";
		String b = a;
		a = "bbb";
//		a = new String("temp");
		System.out.println(b); //���aaa,��Ϊbָ����ڴ��ַû�б� �� a������ָ����b�޹أ� jvm�ڴ�ԭ��
		
	}
}
