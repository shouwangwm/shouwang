package test;

public class FlTest {
	
	public static void main(String[] args) {
		float f = 123.456f;
		boolean b = Float.isNaN(f);
		System.out.println(b);
		
		float cc = -1f;
		boolean c = Float.isNaN(cc);
		System.out.println(c);
	}
	
}
