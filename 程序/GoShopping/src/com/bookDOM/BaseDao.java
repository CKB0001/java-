package com.bookDOM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	private static String DriverName="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	private static String dbName="root";
	private static String userPwd="201711045";
	public Connection getConn() throws ClassNotFoundException, SQLException {
		
		Class.forName(DriverName);
		Connection conn = DriverManager.getConnection(dburl, dbName,userPwd);
		return conn;
	}
	
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
