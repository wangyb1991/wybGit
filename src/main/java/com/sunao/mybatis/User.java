package com.sunao.mybatis;

public class User {
	private String userName;
	private int sex;
	private String password;
	private int account;
	public User(String userName, int sex, String password, int account) {
		this.userName = userName;
		this.sex = sex;
		this.password = password;
		this.account = account;
	}
	public User() {

	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
}
