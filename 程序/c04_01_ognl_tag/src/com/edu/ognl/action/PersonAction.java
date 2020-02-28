package com.edu.ognl.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.*;

import com.opensymphony.xwork2.ActionSupport;



@Namespace("/")
@ParentPackage("struts-default")
@Results({ @Result(name = "success", location = "/showognl.jsp")})
public class PersonAction extends ActionSupport {
	private static final long serialVersionUID = -1494290883433357310L;	
	private Person person;

	@Action("personaction")
	public String ognlTest() throws Exception {	
		person = new Person("张三",26,new Date());		
		//person = new Person("Mary",31,new Date());
		System.out.println("in personaction");
		return SUCCESS;
	}
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}

