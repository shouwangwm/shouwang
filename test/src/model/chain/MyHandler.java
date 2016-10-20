package model.chain;

public class MyHandler extends AbstractHandler implements Handler {
	
	String name;
	public MyHandler(String name) {
		this.name = name;
	}
	@Override
	public void oprator() {
		System.out.println(name + " execute");
		if(getHandler() != null){
			getHandler().oprator();
		}
	}

}
