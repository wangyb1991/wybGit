package com.sunao.mybatis.collections;

import java.util.List;

public class Users {
	private int id;
	private String userName;
	private String corp;
	private List<Course> courses;

	/*在与resultMap的constructor映射时，构造方法的参数类型必须要写成包装类，这里的int需要写成Integer
	另外，构造方法的参数序列要和resultMap中的constructor子标签序列一致！否则会不匹配！*/
	public Users(Integer id, String userName, String corp) {
		this.id = id;
		this.userName = userName;
		this.corp = corp;
	}

	public Users() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
