package com.sunao.mybatis.collections;

import java.util.List;

public interface UsersOP {
	void addUser(Users user);
	void deleteUser(int id);
	List<Users> getUser(String userName);
	void updateUser(Users user);
}
