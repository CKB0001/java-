package com.cm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_baoxian?useSSL=true&serverTimezone=GMT";
		String loginid="root";
		String pwd="qjh1035";
		Connection conn=DriverManager.getConnection(url,loginid,pwd);
		return conn;
	}
	
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}

