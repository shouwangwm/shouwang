package innerclass;
/**
 * �����ڲ���
 * @author weiming
 *
 */
public class Listener {
		
	public static void main(String[] args) {
		Person p = new Person(){
			@Override
			public void test() {
				System.out.println("�����������ɵ�");
			}
		};
		p.test();
		
	}
}

interface Person{
	public void test();
}
