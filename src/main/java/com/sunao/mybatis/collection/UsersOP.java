package com.sunao.mybatis.collection;

public interface UsersOP {
	void addUser(Users user);
	void deleteUser(int id);
	Users getUser(int id);
	void updateUser(Users user);
}
