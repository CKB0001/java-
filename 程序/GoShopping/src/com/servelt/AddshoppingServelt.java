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
	 	   	  
	    int  id =0;
	    id=Integer.valueOf(request.getParameter("id"));  

	    if(id==0)
	    {
	    	request.getRequestDispatcher("error2.jsp").forward(request, response);
	    }
	    else
	    {
	    
		     BookDao book1=new BookDao();
		     Book accessCount=null;		 
		    accessCount=book1.findShopping(id);
		
		    List<Book> list= (List<Book>)book1.addShopping(accessCount);
		    
		    System.out.println(session.getAttribute("list"));
		    if(session.getAttribute("list")==null)
		    {
		    	session.setAttribute("list", list);
		   
		    }
		    else
		    {
		    	boolean tu=false;
		    	
		    	
		    	List<Book> list1=(List<Book>)session.getAttribute("list");
		   
		    	Book book0=new Book();
		    	for(Book x:list)
		    	{
		    		for(Book y:list1)		    			
		    			if(x.getId()==y.getId())
		    			{
		    		
		    				tu=true;
		    				book0=x;
		    				
		    				break;
		    			}
		    		System.out.print("in for");
		    	}
		    	if(tu)
		    	{
		    		list.remove(book0);
		    	}
		    	
		    	for(Book a:list1)
			    	{		
		    				    			
		    				list.add(a);		    		
			    								    			
			    	}
			    	session.setAttribute("list", list);		    	
		    }
		    //将List<Book>类型转换为List<Shopping>
		    List<Shopping> shoppinglist=new ArrayList<Shopping>();
		   
		    int i=1;
		    for(Book book:list)
		    {
		    	Shopping shop=new Shopping();
		    	shop.setId(book.getId());
		    	shop.setBookname(book.getBookname());
		    	shop.setAuthor(book.getAuthor());
		    	shop.setPublisher(book.getPublisher());
		    	shop.setPrice(book.getPrice());
		    	shop.setNum(book.getNum());
		    	shop.setNumshopping(i);
		    	
		    	shoppinglist.add(shop);
		    }	
		   
		    request.setAttribute("shoppinglist", shoppinglist);
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
