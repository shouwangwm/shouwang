package model.proxy;

public class Proxy implements SourceInterface{

	Source source;
	public Proxy() {
		this.source = new Source();
	}
	@Override
	public void method1() {
		System.out.println("proxy before");
		source.method1();
		System.out.println("proxy after");
	}

}
