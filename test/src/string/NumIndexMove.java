package string;

public class NumIndexMove {
	
	public static void main(String[] args) {
		
		//每右移一位，相当于除以2
		System.out.println(64>>1); //32
		System.out.println(64>>6); //1
		System.out.println(1>>2); //0
		System.out.println(1>>3); //0
		System.out.println(1>>4); //0
		
		//每左移一位，相当于乘以2
		System.out.println("1<<4:" + (1<<4));
		System.out.println("1<<5:" + (1<<5));
		System.out.println("3<<3:" + (3<<3));
	}
}
