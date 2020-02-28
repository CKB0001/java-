package com.edu.db_util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public final class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();

	private HibernateUtil() {}

	static {
		// 第一步:读取Hibernate的配置文件 hibernamte.cfg.xml文件
		Configuration configuration = new Configuration().configure();
		// 第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
		StandardServiceRegistryBuilder regbulider = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		// 创建注册服务
		ServiceRegistry serviceRegistry = regbulider.build();
		// 第三步:创建会话工厂
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}

	public static Session getThreadLocalSession() {
		Session s = (Session) session.get();
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}	

	public static void closeSession() {
		Session s = (Session) session.get();
		if (s != null) {
			s.close();
			session.set(null);
		}
	}

}
