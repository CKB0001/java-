package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import com.edu.grade.Grade;
import com.edu.students.Students;


public class StudentsDao {
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction transaction = null;
	Configuration configuration = new Configuration().configure();
	//创建session
	public void lianjie()
	{
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	//关闭数据库
	public void close()
	{
	    transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//根据属性查找学生  根据班级ID查找学生
	public List<Students> findStudent(Students stu)
	{
		
		this.lianjie();
		String hql="FROM Students s WHERE s.id=? or s.sname =? or s.sex=?  or s.birthdaytime=? or s.grade=?";		
		Query stu1=session.createQuery(hql);
		stu1.setParameter(0, stu.getid());
		stu1.setParameter(1, stu.getSname());
		stu1.setParameter(2, stu.getSex());
		stu1.setParameter(3, stu.getBirthdaytime());
		stu1.setParameter(4, stu.getGrade());
		List<Students> stu2=new ArrayList<Students>();
	    stu2=stu1.list();
	   this.close();
		return stu2;	
	}
	//查找所有学生
	public  List<Students> findAllStudents()
	{
		
		this.lianjie();
		
		String hql="from Students s where 1=1";
		Query stu1=session.createQuery(hql);
		List<Students> stu2=new ArrayList<Students>();
	    stu2=stu1.list();
	    
	    this.close();
	    
		return stu2;	
	}
	
	//查找所有班级
	public  List<Grade> findAllGrade()
	{
		
		this.lianjie();
		
		String hql="from Grade s where 1=1";
		Query stu1=session.createQuery(hql);
		List<Grade> stu2=new ArrayList<Grade>();
	    stu2=stu1.list();
	    
	    this.close();
	    
		return stu2;	
	}
	
	//根据属性查找班级
	public List<Grade> findgrade(Grade grade)
	{
		
		this.lianjie();
		String hql="FROM Grade s WHERE s.id=? or s.gname=? or s.opentime=?  ";		
		Query stu1=session.createQuery(hql);
		stu1.setParameter(0, grade.getId());
		stu1.setParameter(1, grade.getGname());
		stu1.setParameter(2, grade.getOpentime());
		List<Grade> stu2=new ArrayList<Grade>();
	    stu2=stu1.list();
	   this.close();
		return stu2;	
	}
	
	//增加班级
	public Boolean addgrade(Grade grade)
	{
		this.lianjie();		
		
		List<Grade> gra=new ArrayList<Grade>();
		gra=this.findgrade(grade);
		if(gra==null)
		{
			session.save(grade);			
			this.close();
			return true;
		}	
		else 
		{
		    this.close();
			return false;
		}	
	}
	
	//增加学生
	public Boolean addstudnets(Students students)
	{
		this.lianjie();
		
		List<Grade> gra=new ArrayList<Grade>();
		gra=this.findgrade(students.getGrade());
		if(gra!=null)
		{			
			session.save(students);			
			this.close();
			return true;
		}
		else 
		{			
			this.close();
			return false;
		}
	}
	
	//更改学生信息（学生学号不能修改）
	public Boolean updatestudents(Students students)
	{
		this.lianjie();
		
		List<Students> stu2=new ArrayList<Students>();
		stu2=this.findStudent(students);
		if(stu2!=null)
		{
			session.update(students);
			this.close();
			return true;
		}
		else
		{
			this.close();
			return false;
		}		
	}
	
	//修改班级信息（班级编号不能修改）
	public Boolean updategrade(Grade grade)
	{
		this.lianjie();
		List<Grade> stu2=new ArrayList<Grade>();
		stu2=this.findgrade(grade);
		if(stu2!=null)
		{
			session.update(grade);
			this.close();
			return true;
		}
		else 
		{
			this.close();
			return false;
		}
	}
	//删除学生(根据学号)
	public Boolean deletestudents(Students students)
	{
		this.lianjie();
		List<Students> stu2=new ArrayList<Students>();
		stu2=this.findStudent(students);
		if(stu2!=null)
		{
			session.delete(students);
			this.close();
			return true;
		}
		else
		{
			this.close();
			return false;
		}		
	}
	//删除班级（根据班级号）
	public Boolean deletegrade(Grade grade)
	{
		this.lianjie();
		List<Grade> stu2=new ArrayList<Grade>();
		stu2=this.findgrade(grade);
		if(stu2==null)
		{
			
			this.close();
			return false;
		}
		else 
		{
			Students stu=new Students();
			stu.setGrade(grade);
			this.deletestudents(stu);
			session.delete(grade);
			this.close();
			return true;
		}
	}
	
}
