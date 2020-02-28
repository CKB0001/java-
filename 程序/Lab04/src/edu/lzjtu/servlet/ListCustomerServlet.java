package edu.lzjtu.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.lzjtu.bean.Customer;
import edu.lzjtu.dao.CustomerDao;

/**
 * Servlet implementation class ListCustomerServlet
 */
@WebServlet("/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		CustomerDao customerDao = new CustomerDao();
		List<Customer> list =null;
				list=customerDao.searchALLCustomer();
		if(list == null){
			request.getRequestDispatcher("error1.jsp").forward(request, response);
		}
		else{
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
