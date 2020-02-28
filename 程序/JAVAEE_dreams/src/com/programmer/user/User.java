package com.programmer.user;



import java.util.Set;

import com.programmer.dream.Dream;

public class User {
	private Integer id;
	private String u_name;
	private String u_password;
	private Set<Dream> dreams;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String u_name, String u_password, Set<Dream> dreams) {
		super();
		
		this.u_name = u_name;
		this.u_password = u_password;
		this.dreams = dreams;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Set<Dream> getDreams() {
		return dreams;
	}
	public void setDreams(Set<Dream> dreams) {
		this.dreams = dreams;
	}
	
}
