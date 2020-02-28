package edu.lzjtu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.lzjtu.bean.Customer;
import edu.lzjtu.dao.CustomerDao;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = (String)request.getParameter("name");
		String idcard = (String)request.getParameter("idcard");
		Customer c = new Customer();
		CustomerDao customerDao = new CustomerDao();
		c.setCustName(name);
		c.setIdCard(idcard);
		System.out.println(c.getCustName());
		boolean b =customerDao.DeleteCustomer(c);
		if(b == true){
			request.setAttribute("result", b);
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}		
		else{
			request.getRequestDispatcher("error4.jsp").forward(request, response);
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
