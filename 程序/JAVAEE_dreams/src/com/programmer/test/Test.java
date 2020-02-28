package com.programmer.test;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.service.ServiceRegistry;


import com.programmer.dream.Dream;
import com.programmer.user.User;

public class Test {
	public static void main(String args[])
	{
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Set<Dream> dreams=new HashSet<Dream>();
		Dream dream = new Dream();
		dream.setDreamname("firstdream");
	    @SuppressWarnings("deprecation")
		Date ndtime=new Date(2019, 11, 12, 2, 30, 12);
		dream.setEndtime(ndtime);
		@SuppressWarnings("deprecation")
		Date dndtime=new Date(2019, 11, 13, 2, 30, 12);
		dream.setStarttime(dndtime);
		dream.setText("first dream !!!!");
				//JAVAEE_dreams/dream/secondream.txt;	
	
		
		dreams.add(dream);
		

		User user=(User)session.get(User.class, 3);
		user.setU_name("ckb");
		user.setU_password("201711045");
		user.setDreams(dreams);
		session.update(user);
		//session.save(user);
		session.save(dream);
		

		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
}
