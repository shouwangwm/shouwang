package object;

public class Service {
	
	private String name;
	private int age;
	
	public void test(){
		name = "change";
		age = 100;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
