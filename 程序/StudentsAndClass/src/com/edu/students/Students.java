package com.edu.students;

import java.sql.Date;

import com.edu.grade.Grade;

public class Students {
	private String id;
	private String sname;
	private String sex;
	private Date birthdaytime;
	private Grade grade;
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Students(String id, String sname, String sex, Date birthdaytime) {
		super();
		this.id = id;
		this.sname = sname;
		this.sex = sex;
		this.birthdaytime = birthdaytime;
		
	}

	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthdaytime() {
		return birthdaytime;
	}
	public void setBirthdaytime(Date birthdaytime) {
		this.birthdaytime = birthdaytime;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}
