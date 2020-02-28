package com.bookDOM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.bookBean.Book;




public class BookDao extends BaseDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//通过ID查找商品
	List<Book>  list0 = new ArrayList<Book>();
	public Book findShopping(int id)
	{
		Book book = new Book();
		try {
			conn = this.getConn();
			
			String sql = "SELECT * FROM book WHERE bid=?;";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				book.setId(rs.getInt("bid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("auther"));
				book.setPrice(rs.getDouble("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setNum(rs.getInt("num"));	
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return book;
	
	}

	public List addShopping(Book book)
	{
		
		list0.add(book);
		return list0;
	}

	public List DeleteShopping(Book c)
	{
		list0.remove(c);
		return list0;
	}

	
//显示所有商品表里面的商品
	public List<Book> searchALLShopping (){
		List<Book> list = new ArrayList<Book>();
		try {
			conn = this.getConn();
			String sql = "SELECT * FROM book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("bid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("auther"));
				book.setPrice(rs.getDouble("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setNum(rs.getInt("num"));	
				list.add(book);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return list;
	}

}
