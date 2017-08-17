package com.sunao.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMybatis {
	public static void main(String[] args) {
		// 1.聲明配置文件的目錄位置
		String resource = "conf.xml";
		// 2.加載應用配置文件
		InputStream is = HelloMybatis.class.getClassLoader()
				.getResourceAsStream(resource);
		// 3.創建SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		// 4.獲取Session(true為取消事務操作，false為事務操作)
		SqlSession session = sf.openSession(true);
		try {
			// 5.獲取操作類
			UserOP uop = session.getMapper(UserOP.class);
			// 6.完成查詢操作
			/*以下兩句為了測試mapper.xml文件中的#{value}value名字的映射，
			結果為當傳入的是JavaBean類時，value需要和類的成員變量名字一致，但是當傳入的是變量時則無所謂，隨便命名，建議用成員變量的名字*/
//			User u = new User("zhangsan", 0, "123456", 0);
//			User user = gui.getUser(u);
			User user = uop.getUser("zhangsan");
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
