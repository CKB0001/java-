package com.programmer.dream;


import java.util.Date;


public class Dream {
	private Integer id;
	private String dreamname;
	private Date starttime;
	private Date endtime;
	private String text;
	public Dream() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dream(Integer id, String dreamname, Date starttime, Date endtime, String text) {
		super();
		this.id = id;
		this.dreamname = dreamname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.text = text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDreamname() {
		return dreamname;
	}
	public void setDreamname(String dreamname) {
		this.dreamname = dreamname;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
