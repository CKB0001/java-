package com.action.user;

import com.dao.user.UserDao;
import com.model.user.EndUser;

public class UserAction {
	private EndUser user;
	private UserDao userDao = new UserDao();

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

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}
}
