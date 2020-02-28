package com.cm.Bean;

public class UserBean {
	
	
	public UserBean(String username, String password, String realname, String idcard, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.idcard = idcard;
		this.phone = phone;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String username;
	private String password;
	private String realname;
	private String idcard;
	private String phone;
	private String address;
	

}
