package innerclass;
/**
 * 匿名内部类
 * @author weiming
 *
 */
public class Listener {
		
	public static void main(String[] args) {
		Person p = new Person(){
			@Override
			public void test() {
				System.out.println("我是匿名生成的");
			}
		};
		p.test();
		
	}
}

interface Person{
	public void test();
}
