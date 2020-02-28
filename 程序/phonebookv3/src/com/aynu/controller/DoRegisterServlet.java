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
		     
		     if(managerDAO.exists(manager)) {//����û��Ѿ�����
		    	 String ex = "�û��Ѿ����ڣ���������ע��";
		    	 System.out.println("�û�ע��ʧ�ܣ�" + username);
		    	 request.setAttribute("ex", ex);
		    	 request.getRequestDispatcher("/register.jsp").forward(request, response);
		     } else {
		         ManagerDAO managerDAO2 = new ManagerDAO();
		         managerDAO2.insert(manager);
		         String msg = "��ϲ��,ע��ɹ�";
		         System.out.println("�û�ע�᣺" + username);
		         request.setAttribute("msg", msg);
		         request.getRequestDispatcher("/login.jsp").forward(request, response);
		     }
	}

}
