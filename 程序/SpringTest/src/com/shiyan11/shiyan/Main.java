package com.shiyan11.shiyan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shiyan.xml");
		Test t=(Test) ctx.getBean("a");
		t.execute();
	}

}
