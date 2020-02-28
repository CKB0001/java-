package com.action.user;


import java.util.List;

import com.dao.user.UserDao;
import com.model.user.EndUser;


public class UserAction {
	private EndUser user;
	private UserDao userDao = new UserDao();
	private List<EndUser> users=userDao.findAll();
	private String st="欢迎查看用户信息";
	private String newpassword;
	//显示所有用户
	public String list() throws Exception{
		String forword = "success";
		for(EndUser user1:users)
		{
			if(st!=null)
			{			
				st=st+"<tr>";
			}
			else
			{
				st="<tr>";
			}
			int i=user1.getUserId();
	      //  <td><%=customer.getId()%></td>
	        st=st+"<td>"+String.valueOf(i)+"</td>";
	        //<td><%=customer.getCustName()%></td>
	        String n=user1.getUserName();
	        st=st+"<td>"+n+"</td>";
	       // <td><%=customer.getSex() %> </td>
	        String p=user1.getUserPassword();
	        st=st+"<td>"+p+"</td>";
	        //<td><%=customer.getBirthday() %></td>
	        String q=user1.getUserRealName();
	        st=st+"<td>"+q+"</td>";
	        st=st+" </tr>";
	        System.out.println("in list");
			}
		
		return forword;
	}

	// 用户登录Action方法
	public String userLogin() throws Exception {
		String forward = null;
		EndUser user2 = userDao.find(user);
		if (user2 != null) {
			forward = "success"; //登录成功标记值
			user.setUserRealName(user2.getUserRealName());
		} else {
			forward = "failure";//登录失败标记值
		}
		return forward;
	}

	// 用户注册Action方法
	public String userRegister() throws Exception {
		String forward ="error";	//数据库存数据时出错标记值	
		int flag = 0;
		EndUser user2=(userDao.find(user));
		if (user2!=null && (user2.getUserName().trim()).equals((user.getUserName()).trim())) {
			forward = "error_user"; //用户名已被占用标记标记值
		} else {
			flag = userDao.save(user);
			if (flag == 1) {
				forward = "success"; //成功注册标记值
			}
		}
		return forward;
	}
	//用户修改密码的方法
	public String userupdate()
	{
		String forward="error";
		
		EndUser user2=(userDao.find(user));
		if(user2==null)
		{
			forward="null";
		}
		else
		{
			System.out.println(newpassword);
			int i=userDao.update(user2, newpassword);
			if(i==0)
				forward="error";
			else
				forward="success";
		}
		return forward;
	}
	//用户删除的方法
	public String userdelete()
	{
		String forward="error";
		System.out.println(user.getUserName());
		EndUser user2=(userDao.find(user));
		if(user2==null)
		{
			forward="null";
		}
		else
		{
			int i=userDao.delete(user);
			if(i==0)
				forward="error";
			else
				forward="success";
		}
		return forward;
	}
	
	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
}
