package com.aynu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aynu.dao.ManagerItemsDAO;
import com.aynu.entity.ManagerItems;

/**
 * Servlet implementation class UpdataItemsById
 */
public class UpdataItemsById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataItemsById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		ManagerItemsDAO managerItemsDAO = new ManagerItemsDAO();
	    ArrayList< ManagerItems> list = (ArrayList<ManagerItems>) managerItemsDAO.findItemsById(id);
	    System.out.println(list);
	    System.out.println(list==null?null:list.size());
	    ManagerItems mItems = list.get(0);
	    
	    /*
		Iterator<ManagerItems>  it = list.iterator();
	    ManagerItems mItems = new ManagerItems();
		         if(it.hasNext()) {
		        	mItems = it.next();
		         } else {
		        	 System.out.println("Œ¥≤È’“µΩ");
		        	 return ;
		         }*/
	    
		        request.setAttribute("a", mItems.getName());
		 		request.setAttribute("b", mItems.getPhone());
		 		request.setAttribute("c", mItems.getQq());
		 		request.setAttribute("d", mItems.getAddress());
		 		request.setAttribute("e", mItems.getId());
		 		   
		      request.getRequestDispatcher("/updataitems.jsp").forward(request, response);
		      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerItems mItems = new ManagerItems(); 
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String qq = request.getParameter("qq");
		int id =Integer.parseInt(request.getParameter("id"));
		mItems.setName(name);
		mItems.setAddress(address);
		mItems.setId(id);
		mItems.setPhone(phone);
		mItems.setQq(qq);
		
		ManagerItemsDAO managerItemsDAO = new ManagerItemsDAO();
		managerItemsDAO.update(mItems);
		
		response.sendRedirect("RefreshItems");
	}

}
