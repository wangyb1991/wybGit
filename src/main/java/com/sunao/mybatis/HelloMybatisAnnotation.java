package com.sunao.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMybatisAnnotation {
	public static void main(String[] args) {
		// 1.聲明配置文件的目錄位置
		String resource = "conf.xml";
		// 2.加載應用配置文件
		InputStream is = HelloMybatisAnnotation.class.getClassLoader()
				.getResourceAsStream(resource);
		// 3.創建SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		// 下面這兩句為差異代碼，相當於把mapper映射添加到conf.xml文件中
		Configuration conf = sf.getConfiguration();
		conf.addMapper(GetUserInfoAnnotation.class);
		// 4.獲取Session
		SqlSession session = sf.openSession();
		try {
			// 5.獲取操作類
			GetUserInfoAnnotation gui = session.getMapper(GetUserInfoAnnotation.class);
			// 6.完成查詢操作
			User user = gui.getUser("zhangsan");
			System.out.println(user.getUserName()+" "+user.getSex()+" "+
			user.getPassword()+" "+user.getAccount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.關閉Session
			session.close();
		}
	}
}
