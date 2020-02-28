package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db_util.DBConnection;
import com.model.Book;

public class BookDao {
	public BookDao(){
	   }
	   // 根据书号查询图书信息
	   
	   public Book searchBook(int bookid){  		 
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rst = null;
	      Book  book = new Book();
	      
	      try{
	    	  
	          conn = DBConnection.getDBConnection(); 
	       // conn = DataSource.getConnection();
	   	    pstmt = conn.prepareStatement("SELECT * FROM t_book WHERE bid=?"); 
	   	    pstmt.setInt(1,bookid);
	   	    rst = pstmt.executeQuery();
	   	    if(rst.next()){
	   	      book.setBookid(rst.getInt("bid"));
	   	      book.setTitle(rst.getString("bookname"));
	          book.setAuthor(rst.getString("auther"));
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
	   public boolean insertBook(Book book){  	  
	   	   Connection conn = null;
	   	   PreparedStatement pstmt = null;
	   	   try{
	   	  	 conn = DBConnection.getDBConnection();
	   	  	 pstmt = conn.prepareStatement(
	   	  	 	 "INSERT INTO t_book VALUES(?,?,?,?,?)"); 
	   	  	 
	   	     pstmt.setInt(1,book.getBookid());
	   	     pstmt.setString(2,book.getTitle());
	   	     pstmt.setString(3,book.getAuthor());
	   	     pstmt.setFloat(4,book.getPrice());
	   	     pstmt.setString(5,book.getPublisher());
	   	    
	   	
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
	   //查找全部图书
		public List<Book> searchALLBook(){
			 Connection conn = null;
		   	 PreparedStatement ps = null;
		   	 ResultSet rst = null;
			 List<Book> list = new ArrayList<Book>();
			try {
				conn =DBConnection.getDBConnection();
				String sql = "SELECT * FROM t_book";
				ps = conn.prepareStatement(sql);
				rst = ps.executeQuery();
				
				while(rst.next()) {
				  Book book = new Book();
				  book.setBookid(rst.getInt("bid"));
		   	      book.setTitle(rst.getString("bookname"));
		          book.setAuthor(rst.getString("auther"));
		          book.setPublisher(rst.getString("publisher"));
		          book.setPrice(rst.getFloat("price"));
				  list.add(book);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try{
		   	  	 	conn.close();
		   	  	  }catch(SQLException se){ }
			}
			return list;
		}
		//查找图书按照书名模糊查询
		public List<Book> searchNameBook(String bookname){
			 Connection conn = null;
		   	 PreparedStatement ps = null;
		   	 ResultSet rst = null;
			List<Book> list = new ArrayList<Book>();
			try {
				conn =DBConnection.getDBConnection();
				String A="%"+bookname+"%";
				String sql = "SELECT * FROM t_book where bookname like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, A);
				rst = ps.executeQuery();			
				while(rst.next()) {
				  Book book = new Book();
				  book.setBookid(rst.getInt("bid"));
		   	      book.setTitle(rst.getString("bookname"));
		          book.setAuthor(rst.getString("auther"));
		          book.setPublisher(rst.getString("publisher"));
		          book.setPrice(rst.getFloat("price"));
				  list.add(book);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try{
		   	  	 	conn.close();
		   	  	  }catch(SQLException se){ }
			}
			return list;
		}
		
		//查找图书按照作者模糊查询
		public List<Book> searchAuthorBook(String auther){
			 Connection conn = null;
		   	 PreparedStatement ps = null;
		   	 ResultSet rst = null;
			List<Book> list = new ArrayList<Book>();
			try {
				conn =DBConnection.getDBConnection();
				String A="%"+auther+"%";
				String sql = "SELECT * FROM t_book where auther like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, A);
				rst = ps.executeQuery();
				
				while(rst.next()) {
				  Book book = new Book();
				  book.setBookid(rst.getInt("bid"));
		   	      book.setTitle(rst.getString("bookname"));
		          book.setAuthor(rst.getString("auther"));
		          book.setPublisher(rst.getString("publisher"));
		          book.setPrice(rst.getFloat("price"));
				  list.add(book);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try{
		   	  	 	conn.close();
		   	  	  }catch(SQLException se){ }
			}
			return list;
		}
		
}
