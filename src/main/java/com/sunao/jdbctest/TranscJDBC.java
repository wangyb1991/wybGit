package com.sunao.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class TranscJDBC {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/jdbc_db?useUnicode=true&characterEncoding=utf-8";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";
	private static BasicDataSource dbs = null;
	
	public static void dbPoolInit() {
		dbs = new BasicDataSource();
		dbs.setDriverClassName(JDBC_DRIVER);
		dbs.setUrl(DB_URL);
		dbs.setUsername(USER);
		dbs.setPassword(PASSWORD);
	}
	
	public static void transcTest() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			conn = dbs.getConnection();
			conn.setAutoCommit(false);
			ptmt = conn.prepareStatement("update user set account = ? where userName = ?");
			ptmt.setInt(1, 0);
			ptmt.setString(2, "zhangsan");
			ptmt.execute();
			ptmt.setInt(1, 100);
			ptmt.setString(2, "lisi");
			ptmt.execute();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (conn!=null){
					conn.close();
				}
				if (ptmt!=null){
					ptmt.close();
				}
			} catch (SQLException e) {

			}
		}
	}
	
	public static void main(String[] args) {
		dbPoolInit();
		transcTest();
	}
}
