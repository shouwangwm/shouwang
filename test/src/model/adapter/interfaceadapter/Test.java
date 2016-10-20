package model.adapter.interfaceadapter;
/**
 * Ω”ø⁄  ≈‰∆˜
 * @author weiming
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		SourceInterface source1 = new SourceSub1();
		source1.method1();
		source1.method2();
		
		SourceInterface source2 = new SourceSub2();
		source2.method1();
		source2.method2();
		
	}
}
