package com.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.beans.BookBean;
import com.db.*;

public class BookDAO{
   
	
	
   public BookDAO(){
   }
   // 根据书号查询图书信息
   
   public BookBean searchBook(String bookid){  
	   
	 
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rst = null;
      BookBean  book = new BookBean();
      
      try{
    	  
          conn = dataSource.getConnection(); 
       // conn = DataSource.getConnection();
   	    pstmt = conn.prepareStatement("SELECT * FROM books WHERE bookid=?"); 
   	    pstmt.setString(1,bookid);
   	    rst = pstmt.executeQuery();
   	    if(rst.next()){
   	      book.setBookid(rst.getString("bookid"));
   	      book.setTitle(rst.getString("title"));
          book.setAuthor(rst.getString("author"));
          book.setPublisher(rst.getString("publisher"));
          book.setPrice(rst.getFloat("price"));
   	      return book;
        }else{
          return  null;
        }
   	 }catch(SQLException se){
   	  	return null;
   	 }finally{
   	  	 try{
   	  	 	conn.close();
   	  	 }catch(SQLException se){
   	  	 }
   	 }
   }   
    
   // 插入一本图书记录
   public boolean insertBook(BookBean book){  	  
   	   Connection conn = null;
   	   PreparedStatement pstmt = null;
   	   try{
   	  	 conn = dataSource.getConnection();
   	  	 pstmt = conn.prepareStatement(
   	  	 	 "INSERT INTO books VALUES(?,?,?,?,?)"); 
   	  	 
   	     pstmt.setString(1,book.getBookid());
   	     pstmt.setString(2,book.getTitle());
   	     pstmt.setString(3,book.getAuthor());
   	     pstmt.setString(4,book.getPublisher());
   	     pstmt.setFloat(5,book.getPrice());
   	
   	     pstmt.executeUpdate();
   	     pstmt.close();
   	     return true;
   	   }catch(SQLException se){
   	  	 return false;
   	   }finally{
   	  	  try{
   	  	 	conn.close();
   	  	  }catch(SQLException se){ }
   	   }
   }     
}
