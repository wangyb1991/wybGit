package com.sunao.mybatis.collections;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMybatisOP {
	public static void main(String[] args) {
		// 1.聲明配置文件的目錄位置
		String resource = "conf.xml";
		// 2.加載應用配置文件
		InputStream is = HelloMybatisOP.class.getClassLoader()
				.getResourceAsStream(resource);
		// 3.創建SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		// 4.獲取Session(true為取消事務操作，false為事務操作)
		SqlSession session = sf.openSession(true);
		try {
			// 5.获取操作类
			UsersOP uop = session.getMapper(UsersOP.class);
			// 查询用户
			List<Users> users = uop.getUser("xiaowang");
			for (Users user : users) {
				System.out.println(user.getId()+" "+user.getUserName()+" "+user.getCorp());
				System.out.println(user.getCourses().get(0).getCourseName());
				System.out.println(user.getCourses().get(0).getTeacher().getTeacherName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.關閉Session
			session.close();
		}
	}
}
