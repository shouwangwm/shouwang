package model.bridge;


public class Test {
	
	public static void main(String[] args) {
		SourceInterface source = new SourceSub1();
		Bridge bridge = new MyBridge();
		bridge.setSource(source);
		bridge.method();
		
		SourceInterface source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}
