package com.db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dao.BookDao;
import com.dao.UserDao;
import com.model.Book;
import com.model.EndUser;

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
		System.out.println("fsafa");
		UserDao user1=new UserDao();
		EndUser user2=new EndUser();
		user2.setUserName("001");
		user2.setUserPassword("654");
		EndUser user3=new EndUser();
		user3=user1.find(user2);
		System.out.println(user3.getUserRealName());
		
		BookDao dao=new BookDao();
		List<Book> list=null;
		list=dao.searchALLBook();
		for(Book book:list)
		{
			System.out.println(book.getTitle());
		}
		
	}
}
