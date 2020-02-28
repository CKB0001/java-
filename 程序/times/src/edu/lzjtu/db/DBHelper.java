package edu.lzjtu.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

	public static Connection getConnection(){
		
		Connection conn =null;
		String url="jdbc:mysql://localhost:3306/db_phonebook?useSSL=true&serverTimezone=GMT";
		String loginid="root";
		String pwd="rootroot";
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,loginid,pwd);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	static String driver="com.mysql.cj.jdbc.Driver";
}
