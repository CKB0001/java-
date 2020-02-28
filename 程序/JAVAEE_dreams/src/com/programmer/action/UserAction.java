package com.programmer.action;

import com.programmer.dao.DreamDao;
import com.programmer.user.User;

public class UserAction {
	private User user;
	private String newpassword;//新密码
	DreamDao dao=new DreamDao();
	//用户注册
	public String userregister()
	{
		String register;
		
		if(dao.findusername(user.getU_name()))
		{
			register="error";//用户名已经被注册
		}
		else 
		{
			if(dao.adduser(user))
			{
				register="success";//用户注册成功
			}
			else
			{
				register="false";//数据库错误导致用户注册失败
			}
		}
		return register;
	}

	//用户登录
	public String userlogin()
	{
		String login;
		User user1=new User();
		user1=dao.finduser(user);
		if(user1.getId()==null)
		{
			login="false";//用户登录失败
		}
		else
		{
			login="success";//用户登录成功
		}
		return login;
	}
	
	//用户修改密码
	public String alternewpassword()
	{
		String t;
		if(dao.alterpassword(user, newpassword))
		{
			t="success";//用户修改密码成功
		}
		else
		{
			t="false";//用户修改密码失败(原来的用户名和密码输入错误)
		}		
		return t;
	}

	//属性的get和set方法
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	
}
