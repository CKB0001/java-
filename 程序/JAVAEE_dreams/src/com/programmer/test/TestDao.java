package com.programmer.test;

import com.programmer.dao.DreamDao;
import com.programmer.user.User;

public class TestDao {
	public static void main(String args[]) {
		DreamDao dao=new DreamDao();
		
		User user=new User();
		user.setU_name("tj");
		user.setU_password("201711014");
		
		//dao.adduser(user);
		 
		System.out.println(dao.finduser(user).getId());
		System.out.println(dao.findusername(user.getU_name()));
		System.out.println("ddad");
		System.out.println(dao.alterpassword(user, "201711014"));
	}
	
}
