package com.sunao.mybatis;

import java.io.InputStream;

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
			// 5.獲取操作類
			UserOP uop = session.getMapper(UserOP.class);
			// 新增用戶
			User newuser = new User("xiaoliu", 0, "123456", 0);
			uop.addUser(newuser);
			// 修改用戶
			User updateuser = new User("xiaoliu", 0, "123456", 100);
			uop.updateUser(updateuser);
			// 查詢用戶
			User getuser = uop.getUser("xiaoliu");
			System.out.println(getuser.getUserName()+" "+getuser.getSex()+" "+
			getuser.getPassword()+" "+getuser.getAccount());
			// 刪除用戶
			uop.deleteUser("xiaoliu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.關閉Session
			session.close();
		}
	}
}
