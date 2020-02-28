package com.cm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cm.Bean.UserBean;

import com.cm.dao.BaseDAO; ;

public class UserDao {
 public static boolean find(String username,String password) {
		Connection conn = null;
	   	PreparedStatement pstmt = null;
	   	ResultSet rs = null;
	   	UserBean u1 = null;
	   	try{
//	   	  	 conn = BaseDAO.getConnection();
	   	  	 pstmt = conn.prepareStatement(
	   	  	 	 "select * from user where username=? and password=?"); 
	   	     pstmt.setString(1,username);
	   	     pstmt.setString(2,password);
	   	     
	   	     rs = pstmt.executeQuery();
	   	     if(rs.next()){
//	   	    	 u1 = new UserBean();
//	   	    	 u1.setUsername(rs.getString("username"));
//	   	    	 u1.setPassword(rs.getString("password"));
	   	    	 return true;
	   	     }else return false;
	   	     pstmt.close();
	   	     rs.close();
	   	   }catch(SQLException se){
	   		  
	   	   }finally{
	   	  	  try{
	   	  	 	conn.close();
	   	  	  }catch(SQLException se){
	   	  		  
	   	  	  }
	   	   }
		return false;
  }
 public boolean insertUser(UserBean u){  	  
 	   Connection conn = null;
 	   PreparedStatement pstmt = null;
 	   try{
// 	  	 conn = BaseDAO.getConnection();
 	  	 pstmt = conn.prepareStatement(
 	  	 	 "INSERT INTO user VALUES(?,?,?,?,?,?)"); 
 	     pstmt.setString(1,u.getUsername());
 	     pstmt.setString(2,u.getPassword());
 	     pstmt.setString(3,u.getRealname());
 	     pstmt.setString(4,u.getIdcard());
 	     pstmt.setString(5,u.getPhone());
 	     pstmt.setString(6,u.getAddress());
 	     
 	     pstmt.executeUpdate();
 	     pstmt.close();
 	     return true;
 	   }catch(SQLException se){
 	  	 return false;
 	   }finally{
 	  	  try{
 	  	 	conn.close();
 	  	  }catch(SQLException se){
 	  		  
 	  	  }
 	   }
 }
}

