package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class dataSource {
private static String DriverName="com.mysql.cj.jdbc.Driver";
private static String dburl="jdbc:mysql://localhost:3306/db_bookstore?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
private static String dbName="root";
private static String userPwd="201711045";
public static  Connection getConnection()
{
	Connection conn=null;
	
	try {
		Class.forName(DriverName);
		
		conn = DriverManager.getConnection(dburl, dbName,userPwd); 				
		
		}catch (Exception e) { 
			System.out.println(e.getMessage());
		}
	return conn;
}

}
