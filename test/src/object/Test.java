package object;

public class Test {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("init");
		p.setAge(1);
		
		String name = "temp";
		int age = 11;
		
		Test t = new Test();
		//基本类型不会改变值， 对象类型的属性会改变
		t.test(name,age,p);
		print(name);
		print(age);
		print(p);
		
		Service s = new Service();
		s.setName("init");
		s.setAge(1);
		s.test();
		print(null);
		print(s.getName());
		print(s.getAge());
		
	}
	
	public void test(String name,int num, Person p){
		name = "change";
		num = 100;
		p.setName("change");
		p.setAge(100);
	}
	
	
	public static void print(Object o){
		System.out.println(o);
	}
	
}
