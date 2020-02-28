package com.edu.entity;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class InsertMain {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		System.out.println("请依次输入：姓名   性别  年龄：");
		String name=cin.next();
		String sex=cin.next();
		int age=cin.nextInt();
		Person person = new Person(name,sex,age);		
		transaction = session.beginTransaction();		
		session.save(person);
		transaction.commit();
		session.close();
		sessionFactory.close();
		cin.close();
	}

}
