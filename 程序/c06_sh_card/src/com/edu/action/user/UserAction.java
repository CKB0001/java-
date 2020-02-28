package com.edu.action.user;


import com.edu.dao.user.UserDao;
import com.edu.model.user.User;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {	
	private static final long serialVersionUID = 1L;
	private User user;
	private String re_password;
	private String msg;
	private UserDao userDao = new UserDao();

	// 用户登录Action方法
	public String userLogin() throws Exception {
		String forward = null;		
		User user2 = userDao.findBynameAndPassword(user);
		if (user2 != null) {
			forward = "success"; //登录成功标记值
			user.setUserRealName(user2.getUserRealName());
		} else {
			msg="用户不存在 或密码不正确，登录失败,请重新登录或注册！";
			forward = "failure";//登录失败标记值
		}
		return forward;
	}

	// 用户注册Action方法
	public String userRegister() throws Exception {
		String forward =null;		
		int flag = 0;				
		User user2 = userDao.findByname(user);		
		if (user2!=null && (user2.getUserName().trim()).equals((user.getUserName()).trim())) {
			msg="用户:"+ user.getUserName()+"  已经存在，请重新注册!";
			forward = "error"; //用户名已被占用标记标记值
		} else {
			flag = userDao.insert(user);
			if (flag == 1) {
				forward = "success"; //成功注册标记值
			}else{
				msg="数据库写错误！!";
				forward ="error";
			}
		}
		return forward;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRe_password() {
		return re_password;
	}

	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}	
	
	
}
