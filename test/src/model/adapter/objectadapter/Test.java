package model.adapter.objectadapter;
/**
 * ¶ÔÏóÊÊÅäÆ÷
 * @author weiming
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}
