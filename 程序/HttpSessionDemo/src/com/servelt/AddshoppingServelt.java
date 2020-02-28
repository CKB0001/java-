package com.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookBean.Book;
import com.bookBean.Shopping;
import com.bookDOM.BookDao;

/**
 * Servlet implementation class AddshoppingServelt
 */
public class AddshoppingServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddshoppingServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
	    HttpSession session = request.getSession(true);	  
	    System.out.println("in addbook1");	   	  
	    int  id =0;
	    id=Integer.valueOf(request.getParameter("id"));  
	    System.out.println("in addbook2");
	    if(id==0)
	    {
	    	request.getRequestDispatcher("error2.jsp").forward(request, response);
	    }
	    else
	    {
	    	System.out.println("in addbook3");
		     BookDao book1=new BookDao();
		     Book accessCount=null;		 
		    accessCount=book1.findShopping(id);
		    System.out.println("in addbook4");
		    List<Book> list= (List<Book>)book1.addShopping(accessCount);
		    
		    System.out.println(session.getAttribute("list"));
		    if(session.getAttribute("list")==null)
		    {
		    	session.setAttribute("list", list);
		    	System.out.println("in if1");
		    }
		    else
		    {
		    	boolean tu=false;
		    	
		    	System.out.println("else1");
		    	List<Book> list1=(List<Book>)session.getAttribute("list");
		    	System.out.println("for1");
		    	Book book0=new Shopping();
		    	for(Book x:list)
		    	{
		    		for(Book y:list1)
		    			if(x.getId()==y.getId())
		    			{
		    				System.out.println("c");
		    				tu=true;
		    				book0=x;
		    				break;
		    			}
		    	}
		    	if(tu)
		    	{
		    		list.remove(book0);
		    	}
		    	
		    	for(Book a:list1)
			    	{		
		    				System.out.println("conguf");		    			
		    				list.add(a);		    		
			    			 System.out.println(a.getNum());					    			
			    	}
			    	session.setAttribute("list", list);		    	
		    }
		    System.out.println("in addbook5");		    
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("shopping.jsp").forward(request, response);
	    }		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
