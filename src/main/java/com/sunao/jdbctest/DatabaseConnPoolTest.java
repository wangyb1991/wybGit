package com.sunao.jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnPoolTest {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/jdbc_db?useUnicode=true&characterEncoding=utf-8";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";
	private static BasicDataSource dbs = null;
	
	public static void dbPoolInit() {
		dbs = new BasicDataSource();
		dbs.setUrl(DB_URL);
		dbs.setDriverClassName(JDBC_DRIVER);
		dbs.setUsername(USER);
		dbs.setPassword(PASSWORD);
	}
	
	public static void dbPoolTest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dbs.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from students");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
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
				if (rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		dbPoolInit();
		dbPoolTest();
	}
}
