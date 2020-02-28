package com.programmer.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import com.programmer.user.User;



public class DreamDao {
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction transaction = null;
	Configuration configuration = new Configuration().configure();
	
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
		
	//根据用户名和密码查找用户的各个属性
	@SuppressWarnings("unchecked")
	public User finduser(User user)
	{
		this.lianjie();
		
		String hql="from User u where u.u_name=? and u.u_password=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, user.getU_name());
		query.setParameter(1, user.getU_password());
		List<User> user1=null;
		user1=query.list();
		User user2=new User();
		for(User s:user1)
		{
			user2=s;
		}		
		
		this.close();
		return user2;
	}

	//查找用户名是否已经在数据库中(有true没有false)
	public Boolean findusername(String name)
	{
		this.lianjie();
		
		Boolean t=false;
		
		String sql="select u_name from user where u_name=?";		
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		//sqlQuery.addEntity(User.class);
		sqlQuery.setParameter(0, name);
		
		@SuppressWarnings("unchecked")
		List<String> name1=sqlQuery.list();		
		for(String s :name1)
		{
			if(s!=null)
			{
				t=true;
			}
		}
		this.close();
		return t;
	}

	//添加用户
	public Boolean adduser(User user)
	{
		Boolean t=false;
		this.lianjie();		
		session.save(user);
		this.close();
		if(this.findusername(user.getU_name()))
		{
			t=true;
		}
		return t;
	}

	//修改用户密码
	public Boolean alterpassword(User user,String newpassword)
	{
		
		Boolean t=false;
		User user1=new User();
		user1=this.finduser(user);
		this.lianjie();
		if(user1.getId()!=null) 
		{
			User user2=(User)session.get(User.class, user1.getId());
			user2.setU_name(user1.getU_name());
			user2.setDreams(user1.getDreams());
			user2.setU_password(newpassword);
			session.update(user2);
			t=true;
		}		
		this.close();
		return t;
	}
	
}

