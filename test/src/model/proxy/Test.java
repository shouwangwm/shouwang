package model.proxy;

public class Test {
	
	public static void main(String[] args) {
		SourceInterface proxy = new Proxy();
		proxy.method1();
	}
}
