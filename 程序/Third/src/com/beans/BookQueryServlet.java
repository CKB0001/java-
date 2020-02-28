package com.beans;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.beans.BookBean;
import com.beans.BookDAO;
public class BookQueryServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
	    BookDAO bookdao = new BookDAO();
	    BookBean book = bookdao.searchBook(bookid);
	    if(book!=null){
	      request.getSession().setAttribute("book", book);
	      RequestDispatcher view = request.getRequestDispatcher("/display.jsp");
	      view.forward(request, response);
	    }else{
	      RequestDispatcher view = request.getRequestDispatcher("/errorPage.jsp");
	      view.forward(request, response);
	    }
	}	
}
