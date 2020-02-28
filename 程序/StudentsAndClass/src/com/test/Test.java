package com.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dao.StudentsDao;
import com.edu.grade.Grade;
import com.edu.students.Students;




public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner cin=new Scanner(System.in);
		@SuppressWarnings("deprecation")
		Date i = new Date(2002,02,12);
		
		Students stu=new Students("201711048","cee","男",i);
		@SuppressWarnings("deprecation")
		Date s = new Date(2017,02,12);
		Grade g = new Grade(1701,"计科",s);
		
		stu.setGrade(g);*/
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();		
		//session.save(g);
		//session.save(stu);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		StudentsDao dao = new StudentsDao();
		List<Students> stu2=new ArrayList<Students>();
		List<Students> stu3=new ArrayList<Students>();
		Students s1=new Students();
		//s1.setid("201711038");
		Grade r =new Grade();
		
		r.setGname("计科");
		//s1.setGrade(r);
		//stu2=dao.findStudent(s1);
		stu3=dao.findAllStudents();
		for(Students sq:stu3)
		{
			System.out.println(sq.getSname());
		}
		/*for(Students sq:stu3)
		{
			System.out.println(sq.getSex());
		}
		List<Grade> stu4=new ArrayList<Grade>();
		stu4=dao.findAllGrade();
		for(Grade sq:stu4)
		{
			System.out.println(sq.getGname());
		}
	
		stu4=dao.findgrade(r);*/
		
		List<Grade> stu5=new ArrayList<Grade>();
		stu5=dao.findgrade(r);
		for(Grade sq:stu5)
		{
			System.out.println(sq.getId());
		}
		
	}

}
