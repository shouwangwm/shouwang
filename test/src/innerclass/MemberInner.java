package innerclass;
/**
 * 成员内部类
 * @author weiming
 *
 */
public class MemberInner {
	private int x = 100;

	public void makeInner() {
		Inner in = new Inner();
		in.seeOuter();
	}

	class Inner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
			System.out.println("Inner class reference is " + this);
			System.out.println("Outer class reference is " + MemberInner.this);
		}
	}

	public static void main(String[] args) {
		MemberInner o = new MemberInner();
		Inner i = o.new Inner();
		i.seeOuter();
	}
}