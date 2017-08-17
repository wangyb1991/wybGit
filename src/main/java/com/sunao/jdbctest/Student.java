package com.sunao.jdbctest;

public class Student {
	private String name;
	private String sex;
	private int age;
	private String tel;
	public Student(String name, String sex, int age, String tel) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
	}
	
	public Student() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
