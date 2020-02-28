package com.edu.ognl.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



@Namespace("/")
@ParentPackage("struts-default")
@Results({ @Result(name = "success", location = "/showognl.jsp")})
public class OgnlAction extends ActionSupport {
	private static final long serialVersionUID = -1494290883433357310L;		
	@Action("ognlTest")
	public String ognlTest() throws Exception {	
		String value;
		
		// 获得ActionContext实例，以便访问Servlet API
		ActionContext ctx = ActionContext.getContext();
		// 存入application
		ctx.getApplication().put("msg", "application信息");
		// 保存session
		ctx.getSession().put("msg", "seesion信息");
		// 保存request信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "request信息");	
		value="application对象中包含的信息";
		ctx.getApplication().put("msg", value);
		value="session对象中包含的信息";
		ctx.getSession().put("msg", value);
		value ="request 对象中属性msg的值";
		request.setAttribute("msg", value);
		return SUCCESS;
	}
}

