package model.decorator;

public class Test {
	
	public static void main(String[] args) {
		SourceInterface source = new Source();
		SourceInterface source1 = new Decorator(source);
		source1.method1();
	}
}
