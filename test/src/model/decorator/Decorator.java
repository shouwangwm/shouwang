package model.decorator;

public class Decorator implements SourceInterface{
	
	SourceInterface source;
	
	public Decorator(SourceInterface source) {
		this.source = source;
	}
	
	public void method1(){
		System.out.println(" decorator start");
		source.method1();
		System.out.println(" decorator end");
	}
}
