package com.links.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	// 连接Oracle的驱动字符串
	private static  String Driver = "oracle.jdbc.driver.OracleDriver";
	// 连接数据库的地址跟用户名
	private static  String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	// DB服务器XE库的用户名
	private static  String user = "test";
	// DB服务器的密码
	private static  String pwd = "1234";
	
	/**
	 * 加载驱动，获得DB的连接Connection对象（对数据库进行连接）
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 1、加载驱动
			Class.forName(Driver);
			// 通过DriverManager获得数据库的连接
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 释放数据库资源
	 * @param conn 数据库的连接对象
	 * @param stmt 对象用于将 SQL 语句发送到数据库中，执行不带参数的简单 SQL 语句
	 * @param psmt 预编译SQL语句，执行带参数的SQL
	 * @param rs 获得数据库执行的返回结果集
	 */
	public static void close(Connection conn, Statement stmt, PreparedStatement psmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
