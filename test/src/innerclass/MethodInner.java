package innerclass;
/**
 * 局部内部类
 * @author weiming
 *
 */
public class MethodInner {
	private String x = "outer";

	public void doStuff() {
		class MyInner {
			public void seeOuter() {
				System.out.println("x is " + x);
			}
		}

		MyInner i = new MyInner();
		i.seeOuter();
	}

	public static void main(String[] args) {
		MethodInner o = new MethodInner();
		o.doStuff();
	}
}
