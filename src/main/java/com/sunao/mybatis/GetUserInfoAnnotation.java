package com.sunao.mybatis;

import org.apache.ibatis.annotations.Select;

public interface GetUserInfoAnnotation {
	@Select("select * from user where userName = #{name}")
	User getUser(String name);
}
