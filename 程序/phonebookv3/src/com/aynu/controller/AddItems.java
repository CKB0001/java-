package com.aynu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aynu.dao.ManagerDAO;
import com.aynu.dao.ManagerItemsDAO;
import com.aynu.entity.ManagerItems;

/**
 * Servlet implementation class AddItems
 */
public class AddItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("hello");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		//数据库操作类
		ManagerItemsDAO managerItemsDAO = new ManagerItemsDAO();
		
		//获得前端页面的字段
	    String name = (String) request.getParameter("name");
	    String phone = (String) request.getParameter("phone");
	    String address = (String) request.getParameter("address");
	    String qq = (String) request.getParameter("qq");
	    String username = (String) session.getAttribute("username");
	    
	    ManagerItems items = new ManagerItems();
	    
	    
	    items.setName(name);
	    items.setPhone(phone);
	    items.setQq(qq);
	    items.setAddress(address);
	    items.setManger(username);
	    
	    
	    System.out.println(name);
	    System.out.println(phone);
	    System.out.println(qq);
	    System.out.println(address);
	    
	    
	    managerItemsDAO.insertManagerItems(items);
	    //重定向到主页面，由另一个servlet处理刷新页面
	    response.sendRedirect("RefreshItems");
	}

}
