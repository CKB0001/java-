package com.programmer.biaoqian;

public class BiaoQian {
	private Integer id;
	private String b_name;
	private String b_dreamid;
	
	public BiaoQian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BiaoQian(String b_name, String b_dreamid) {
		super();
		this.b_name = b_name;
		this.b_dreamid = b_dreamid;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_dreamid() {
		return b_dreamid;
	}
	public void setB_dreamid(String b_dreamid) {
		this.b_dreamid = b_dreamid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
