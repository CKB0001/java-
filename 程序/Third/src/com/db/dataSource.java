package com.db;
import java.sql.*;
public class dataSource {	
	private static String driverName = "com.mysql.cj.jdbc.Driver"; //驱动程序名
	private static String userName = "root";  //数据库用户名
	private static String userPwd = "201711045";  //密码
	private static String db = "jdbc:mysql://localhost:3306/db_bookstore?serverTimezone=UTC&characterEncoding=utf-8";  //数据库名
	public static Connection getConnection()
	{	
	Connection conn=null;
	try{
		Class. forName( driverName);
		conn=DriverManager. getConnection(db,userName,userPwd);
		}catch (Exception e) {e.printStackTrace();}
	return conn;
    }
}
