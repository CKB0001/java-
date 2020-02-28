package com.aynu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aynu.dao.ManagerDAO;
import com.aynu.dao.ManagerItemsDAO;
import com.aynu.entity.Manager;
import com.aynu.entity.ManagerItems;

/**
 * Servlet implementation class demServlet
 */
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerDAO managerDAO = new ManagerDAO();
		HttpSession session = request.getSession();
		String username = request.getParameter("UserName");
		String password = request.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		Manager manager = new Manager();
		manager.setUsername(username);
		manager.setPassword(password);
		if (managerDAO.exists(manager)) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);

			ArrayList<ManagerItems> itemList = new ArrayList<ManagerItems>();

			ManagerItemsDAO mDao = new ManagerItemsDAO();
			itemList = (ArrayList<ManagerItems>) mDao.findItemsByManager(username);
			request.setAttribute("itemList", itemList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "你输入的密码或者用户名不正确，请重新输入";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
