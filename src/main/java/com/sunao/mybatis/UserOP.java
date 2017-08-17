package com.sunao.mybatis;

public interface UserOP {
	void addUser(User user);
	void deleteUser(String userName);
	User getUser(String userName);
	void updateUser(User user);
}
