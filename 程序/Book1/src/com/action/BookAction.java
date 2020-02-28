package com.action;

import java.util.List;

import com.dao.BookDao;
import com.model.Book;
import com.model.EndUser;


public class BookAction {
	private List<Book> booklist;
	private String bookname;
	private String auther;
	private EndUser user;
	private String s;
	BookDao dao=new BookDao();
	 
	//查出所有书籍
	public String findall()
	{
		String forward = "success";
		booklist=dao.searchALLBook();
		for(Book book:booklist)
		{
			System.out.println(book.getPrice());
		}
		System.out.println("in findall");
		s="<thead>"+" <tr>"+" <th>编号</th>"+" <th>书名</th>"+"<th>作者</th>"+"<th>出版社</th>"+"<th>价格</th>"+"</tr>"+"</thead>";
		return forward;
	}
	
	//按书名模糊查找
	public String findname()
	{
		String forward ="success";
		booklist=dao.searchNameBook(bookname);
		System.out.println("in findname");
		return forward;
	} 
	
	//按作者模糊查找
	public String findauther()
	{
		String forward = "success";
		booklist=dao.searchAuthorBook(auther);
		System.out.println("in findauther");
		return forward;
	}
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
	
}
