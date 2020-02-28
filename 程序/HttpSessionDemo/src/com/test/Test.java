package com.test;

import java.util.List;

import com.bookBean.Book;
import com.bookDOM.BookDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDao book=new BookDao();
		
		List<Book> book1=null;
		book1=book.searchALLShopping();
		for(Book c:book1)
		{
			System.out.println(c.getPrice());
		}
	}

}
