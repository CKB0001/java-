package text;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.programmer.biaoqian.BiaoQian;
import com.programmer.dao.BiaoQianDao;
import com.programmer.dao.DreamDao;

public class testbiaoqian {
	public static void main(String[] args) {
	BiaoQian b=new BiaoQian();
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction transaction = null;
	Configuration configuration = new Configuration().configure();
	
//	public void lianjie()
//	{
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
//	}
		
		BiaoQianDao dao=new BiaoQianDao();
		DreamDao dao1=new DreamDao();
//		List<Integer> l=new ArrayList<Integer>();
//		l=dao.dreamid_int("开心");
//		for(int x:l)
//		{
//			System.out.println(x);
//		}
//		
		
		//dao.updateorsave(15,3);
		//dao.delete(3, 2);
//		System.out.println( dao.chabid(3));
		System.out.println(dao1.maxid());
	//关闭
//	public void close()
//	{
	    transaction.commit();
		session.close();
		sessionFactory.close();
//	}
}
}
