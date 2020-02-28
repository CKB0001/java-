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
 * Servlet implementation class AlterCustomerServlet
 */
@WebServlet("/AlterCustomerServlet")
public class AlterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = (String)request.getParameter("cid");
		String name = (String)request.getParameter("cname");
		String sex = (String)request.getParameter("csex");
		String birthday = (String)request.getParameter("cbirthday");
		String idcard = (String)request.getParameter("cidcard");
		String address = (String)request.getParameter("caddress");
		String phone = (String)request.getParameter("cphone");
		Customer c = new Customer();
		CustomerDao customerDao = new CustomerDao();
		c.setId(id);
		c.setCustName(name);
		c.setSex(sex);
		c.setBirthday(birthday);
		c.setIdCard(idcard);
		c.setAddress(address);
		c.setPhone(phone);		
		boolean b =customerDao.AlterCustomer(c);
		System.out.print(b);
		if(b == true){
			request.setAttribute("result", b);
			request.getRequestDispatcher("alter.jsp").forward(request, response);
		}		
		else{
			request.getRequestDispatcher("error3.jsp").forward(request, response);
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
