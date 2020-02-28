package com.aynu.configfilter;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class LoginFilter
 */


public class LoginFilter implements Filter {
	private FilterConfig config;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (isPass(req, res)) {
			System.out.println("�û��Ѿ����ڣ�����");
			chain.doFilter(request, response);
		} else {
			/* res.sendRedirect("login.jsp"); */
			// ָ��������ֱ�ӷ��ص�½ҳ��
			
			String msg = "�㻹δ��½�����½������";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

	public boolean isPass(HttpServletRequest reqs, HttpServletResponse ress) {
		
		HttpServletRequest req = reqs;
		HttpServletResponse res = ress;
		HttpSession session = req.getSession();
		String charset = config.getInitParameter("charset");
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		System.out.println("�ͻ�������·����" + req.getRequestURI());
         
		if (charset == null) {
			charset = "UTF-8";
		}
		
		//����ͻ��˺ͷ������˽���ͱ��벻һ������
		res.setContentType("text/html;charset=" + charset);
		
		//����ύ�������ֶ��ֶ���������
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
         //ָ���ͻ�������URLֱ�ӷ���
		if (noLoginPaths != null) {
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				System.out.println("ָ�������ص�·����" + strArray[i]);
			}

			for (int i = 0; i < strArray.length; i++) {

				if (strArray[i] == null || "".equals(strArray[i]))
					continue;
				if (req.getRequestURI().indexOf(strArray[i]) != -1 || req.getRequestURI().endsWith(".css")
						|| req.getRequestURI().endsWith(".js")) {
					System.out.println("����URL:" + req.getRequestURI());
					return true;
				}

			}
           
			//����Ѿ���½��ֱ�ӷ���
			if (session.getAttribute("username") != null) {
				System.out.println("�Ѿ���½������:" + session.getAttribute("username"));
				return true;
			} else {
				/* res.sendRedirect("login.jsp"); */
			}

		}
        
		return false;
	}

}
