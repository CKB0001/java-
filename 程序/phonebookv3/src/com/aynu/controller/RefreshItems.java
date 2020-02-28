package com.aynu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aynu.dao.ManagerItemsDAO;
import com.aynu.entity.ManagerItems;

/**
 * Servlet implementation class RefreshItems
 */
public class RefreshItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ManagerItems> itemList = new ArrayList<ManagerItems>();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
		ManagerItemsDAO mDao = new ManagerItemsDAO();
		itemList = (ArrayList<ManagerItems>) mDao.findItemsByManager(username);
		request.removeAttribute("itemList");
		request.setAttribute("itemList", itemList);
		
		System.out.println(itemList.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
