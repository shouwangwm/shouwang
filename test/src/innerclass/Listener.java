package innerclass;
/**
 * �����ڲ���
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
				System.out.println("�����������ɵ�");
			}
		});
	}
}

interface Person{
	
	public void test();
}
