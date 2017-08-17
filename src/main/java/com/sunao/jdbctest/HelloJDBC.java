package com.sunao.jdbctest;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class HelloJDBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jdbc_db?useUnicode=true&characterEncoding=utf-8";
	static final String USER = "root";
	static final String PASSWORD = "123456";
	
	public static void main(String[] args) throws ClassNotFoundException {
		Set<Student> stds = new HashSet<Student>();
		stds.add(new Student("小梁", "女", 19, "13254687985"));
		stds.add(new Student("小趙", "女", 18, "13354487987"));
		stds.add(new Student("小宋", "男", 29, "14254667288"));
		insertStudents(stds);
	}
	
	public static void insertStudents(Set<Student> stds) throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		
		// 1.裝載驅動程序
		Class.forName(JDBC_DRIVER);
		// 2.建立數據庫連接
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			// 3.執行SQL語句
			stmt = conn.createStatement();
			// 反射得到Student類的屬性名
			String colm = "";
			Student s = new Student();
			for (Field f : s.getClass().getDeclaredFields()) {
				colm += f.getName() + ",";
			}
			colm = colm.substring(0, colm.length()-1);
			
			for (Student std : stds) {
				/*得到values的字符串，插入數據時可以用aes_encrypt(value,code)加密
				和aes_decrypt(col,code)解密，那麼相應的數據庫中字段的數據類型應該為
				BLOB類型的才能夠存儲*/
				stmt.addBatch("insert into students("
						+colm+ ") values('"
						+std.getName()+"','"+std.getSex()
						+"',"+std.getAge()+",'"+std.getTel()+ "')");
			}
			stmt.executeBatch();
			stmt.clearBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn!=null){
					conn.close();
				}
				if (stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
