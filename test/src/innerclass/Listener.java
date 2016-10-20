package innerclass;
/**
 * 匿名内部类
 * @author weiming
 *
 */
public class Listener {
	
	public Listener(Person p) {
		p.test();
	}
	
	public static void main(String[] args) {
		Listener listener = new Listener(new Person(){
			@Override
			public void test() {
				System.out.println("我是匿名生成的");
			}
		});
	}
}

interface Person{
	
	public void test();
}
