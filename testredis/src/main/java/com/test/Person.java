package com.test;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * @time : 2017年4月11日 下午4:57:50
	 * @author :weiming
	 */
	private static final long serialVersionUID = 6637281411916173598L;
	private int age;
	private String name;
	
	public Person() {
		super();
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
