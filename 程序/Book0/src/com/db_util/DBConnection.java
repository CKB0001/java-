package com.db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	//private static String driverName="com.mysql.cj.jdbc.Driver";
	private static String driverName="com.mysql.cj.jdbc.Driver";
	private static String userName="root";
	private static String userPwd="201711045";
	private static String dbName="db_book0";
	public static Connection getDBConnection(){
		String url1="jdbc:mysql://localhost/"+dbName;
		String url2="?user="+userName+"&password="+userPwd;
		String url3="&useSSL=true&serverTimezone=GMT";
		String url=url1+url2+url3;
		Connection con=null;
		try {
			Class.forName(driverName);
			con=DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return con;		
	}
	
	public static void closeDB(Connection con,PreparedStatement pstm,ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		if(pstm!=null)
			try {
				pstm.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}		
	}

	public static void main(String[] ar)throws Exception {
		Connection conn = DBConnection.getDBConnection();
		
		System.out.println(conn.isClosed());
	}
}
