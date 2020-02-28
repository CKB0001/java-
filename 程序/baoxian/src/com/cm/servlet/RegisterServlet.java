package com.cm.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cm.Bean.UserBean;
import com.cm.dao.BaseDAO;
import com.cm.dao.UserDao;




/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("user");
		String password=request.getParameter("passwd");
		String realname=request.getParameter("realname");
		String idcard=request.getParameter("idcard");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
//		UserBean usr = new UserBean(username,password,realname,idcard,phone,address);
		UserDao userDao = new UserDao();
		boolean is =new UserDao().find(username,password);
		
		if(is) {
			request.setAttribute("msg", "<font color='green'>注册成功，请登录！</font>");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "<font color='red'>用户名重复，请重新填写!</font>");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
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
