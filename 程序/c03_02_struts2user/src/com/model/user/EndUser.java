package com.model.user;

public class EndUser  {
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userRealName;
	
	public EndUser() {}
	
	public EndUser(Integer userId, String userName, String userPassword,String userRealName) {		
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRealName = userRealName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	

}