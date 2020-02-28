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
			System.out.println("用户已经存在，放行");
			chain.doFilter(request, response);
		} else {
			/* res.sendRedirect("login.jsp"); */
			// 指定服务器直接返回登陆页面
			
			String msg = "你还未登陆，请登陆！！！";
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
		System.out.println("客户端请求路径：" + req.getRequestURI());
         
		if (charset == null) {
			charset = "UTF-8";
		}
		
		//解决客户端和服务器端解码和编码不一致问题
		res.setContentType("text/html;charset=" + charset);
		
		//解决提交表单中文字段字段乱码问题
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
         //指定客户端请求URL直接放行
		if (noLoginPaths != null) {
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				System.out.println("指定不拦截的路径：" + strArray[i]);
			}

			for (int i = 0; i < strArray.length; i++) {

				if (strArray[i] == null || "".equals(strArray[i]))
					continue;
				if (req.getRequestURI().indexOf(strArray[i]) != -1 || req.getRequestURI().endsWith(".css")
						|| req.getRequestURI().endsWith(".js")) {
					System.out.println("放行URL:" + req.getRequestURI());
					return true;
				}

			}
           
			//如果已经登陆，直接放行
			if (session.getAttribute("username") != null) {
				System.out.println("已经登陆，放行:" + session.getAttribute("username"));
				return true;
			} else {
				/* res.sendRedirect("login.jsp"); */
			}

		}
        
		return false;
	}

}
