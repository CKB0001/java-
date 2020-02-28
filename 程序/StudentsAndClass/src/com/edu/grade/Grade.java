package com.edu.grade;

import java.sql.Date;

public class Grade {
	private int id;
	private String gname;
	private Date opentime;
	
	
	public Grade(int id, String gname, Date opentime) {
		super();
		this.id = id;
		this.gname = gname;
		this.opentime = opentime;
	}
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Date getOpentime() {
		return opentime;
	}
	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}
	
}
