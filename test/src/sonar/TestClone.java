package sonar;

public class TestClone {

//	public Object clone() { // Noncompliant
//		// ...
//		return new Object();
//	}
	
	private int age;
	@Override
	public String toString() {
		return "TestClone [age=" + age + "]";
	}
	
	public int getAge() {
		return age;
	}
	

	public void setAge(int age) {
		this.age = age;
	}
	

	public TestClone(int age) {
		this.age = age;
	}
	public TestClone(TestClone source) {
		this.age = source.age;
	}
	
	/**
	 * ���ƹ��캯��
	 * @author weiming
	 * @date   2017��3��23��
	 * @param args
	 */
	public static void main(String[] args) {
		TestClone a = new TestClone(11);
		TestClone a2 = new TestClone(a);
		
		System.out.println(a);
		System.out.println(a2);
		
		a.setAge(20);
		System.out.println(a);
		System.out.println(a2);
	}
}
