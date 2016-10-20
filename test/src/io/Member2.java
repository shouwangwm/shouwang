package io;

public class Member2 {
	private String name;
	private int age;
	private int classNum;
	private String className;

	public Member2() {
	}

	public Member2(String name, int age, String className, int classNum) {
		this.name = name;
		this.age = age;
		this.className = className;
		this.classNum = classNum;
	}
	
	public int getClassNum() {
		return classNum;
	}
	

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	

	public String getClassName() {
		return className;
	}
	

	public void setClassName(String className) {
		this.className = className;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Member2 [name=" + name + ", age=" + age + ", classNum=" + classNum + ", className=" + className + "]";
	}
	
	
}