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
//向购物车里面加入商品（初始商品为1）	
	/*public boolean addShopping(Book book) {
		try {
			conn = this.getConn();
			String sql = "INSERT INTO shopping(bid,bookname,auther,price,publisher,num,shoppingnum)VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,book.getId());
			ps.setString(2, book.getBookname());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getPublisher());
			ps.setInt(6, book.getNum());
			ps.setInt(7, 1);
			ps.executeUpdate();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			this.closeAll(conn, ps, rs);
		}
	}*/
	public List addShopping(Book book)
	{
		
		list0.add(book);
		return list0;
	}
//删除商品表里面的商品(通过输的id)
	/*public boolean DeleteShopping(Book c) {
		try {
			conn = this.getConn();
			
			String sql1 = "DELETE FROM shopping WHERE bid='"+c.getId()+"';";			
				ps = conn.prepareStatement(sql1);
				ps.executeUpdate();			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			this.closeAll(conn, ps, rs);
		}
	}*/
	public List DeleteShopping(Book c)
	{
		list0.remove(c);
		return list0;
	}
//修改购物车里面的商品数量	(通过点击按钮增加或减少)
	/*public boolean AlterShopping(Book book,int q) {
		try {
			conn = this.getConn();
			
			String sq2 = "SELECT shoppingnum FROM shoppingnum WHERE bid="+book.getId()+";";
			ps = conn.prepareStatement(sq2);
			rs = ps.executeQuery();
			
			String sql = "UPDATE shopping SET shoppingnum=? WHERE bid=?";
			ps = conn.prepareStatement(sql);
			if(q==1)
			{
				ps.setInt(1, (rs.getInt("shoppingnum")+1));
			}
			else
				if((rs.getInt("shoppingnum")-1)>=0)
					ps.setInt(1, (rs.getInt("shoppingnum")-1));
				else
					return false;
			ps.setInt(2, book.getId());
			ps.executeUpdate();			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			this.closeAll(conn, ps, rs);
		}
	}
	*/
	
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
//显示购物车里面的商品
/*	public List<Book> searchALLGoShopping (){
		List<Book> list = new ArrayList<Book>();
		try {
			conn = this.getConn();
			String sql = "SELECT * FROM shopping";
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
	}*/
	
}
