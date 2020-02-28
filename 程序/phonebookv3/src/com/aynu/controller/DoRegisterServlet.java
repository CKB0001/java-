package com.aynu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aynu.dao.ManagerDAO;
import com.aynu.entity.Manager;

/**
 * 
 */
public class DoRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegisterServlet() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     String username = request.getParameter("UserName");
		     String password = request.getParameter("password");
		     ManagerDAO managerDAO = new ManagerDAO();
		     Manager manager = new Manager();
		     manager.setUsername(username);
		     manager.setPassword(password);
		     
		     if(managerDAO.exists(manager)) {//如果用户已经存在
		    	 String ex = "用户已经存在，请你重新注册";
		    	 System.out.println("用户注册失败：" + username);
		    	 request.setAttribute("ex", ex);
		    	 request.getRequestDispatcher("/register.jsp").forward(request, response);
		     } else {
		         ManagerDAO managerDAO2 = new ManagerDAO();
		         managerDAO2.insert(manager);
		         String msg = "恭喜你,注册成功";
		         System.out.println("用户注册：" + username);
		         request.setAttribute("msg", msg);
		         request.getRequestDispatcher("/login.jsp").forward(request, response);
		     }
	}

}
