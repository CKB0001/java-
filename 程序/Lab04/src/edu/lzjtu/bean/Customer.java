package edu.lzjtu.bean;

import java.io.Serializable;

public class Customer  implements Serializable{

	private String id=null;
	private String name=null;
	private String sex=null;
	private String birthday=null;
	private String idcard=null;
	private String address=null;
	private String phone=null;
	public Customer(){
		
	}
	public Customer(String id,String name,String sex,String birthday,String idcard,
			String address,String phone){
		this.id=id;
		this.sex=sex;
		this.name=name;
		this.birthday=birthday;
		this.idcard=idcard;
		this.address=address;
		this.phone=phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustName() {
		return name;
	}
	public void setCustName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdCard(String idcard) {
		this.idcard = idcard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

