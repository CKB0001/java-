package com.programmer.dao;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import com.programmer.dream.Dream;
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
	//关闭
	public void close()
	{
	    transaction.commit();
		session.close();
		sessionFactory.close();
	}
		
	//查找梦（根据标题，比开始日期大，结束日期小)(全部梦)//待测试日期
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Dream> finddream(Dream dream,User user)
	{
		List<Dream> dreams = new ArrayList<Dream>();
		this.lianjie();
		/*
		 * SELECT dream.*
          FROM dream
           WHERE dream.`USER_ID`=3 AND 
           (dream.`DREAMNAME`LIKE "%null%" OR dream.`STARTTIME`< '2019-11-16');
		 * 
		 * */
		String sql;
		if(dream.getDreamname()==null && dream.getStarttime()==null && dream.getStarttime()==null)
		{
		
			 sql="select dream.* from dream where dream.USER_ID=? and (dream.DREAMNAME like ? or dream.STARTTIME > ? or dream.ENDTIME < ? or 1=1) ";
		}
		else
		{
			 sql="select dream.* from dream where dream.USER_ID=? and (dream.DREAMNAME like ? or dream.STARTTIME > ? or dream.ENDTIME < ?)";
		}
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		sqlQuery.addEntity(Dream.class);
		String name="%"+dream.getDreamname()+"%";
		sqlQuery.setParameter(0, user.getId());
		sqlQuery.setParameter(1, name);
		System.out.println(dream.getStarttime());
		if(dream.getStarttime()==null)
		{
			dream.setStarttime(new Date(4000,01, 01));
		}
		if(dream.getEndtime()==null)
		{
			dream.setEndtime(new Date(1,01 , 01));
		}
		
		sqlQuery.setTimestamp(2, dream.getStarttime());
		sqlQuery.setTimestamp(3, dream.getEndtime());
		dreams=sqlQuery.list();
		this.close();
		return dreams;
	}
	
	//通过ID查找dream
	public Dream findiddream(int id)
	{
		this.lianjie();
		Dream dream=(Dream)session.get(Dream.class, id);
		this.close();
		return dream;
	}
	
	//添加梦
	public Boolean adddream(Dream dream,User user)
	{
		Boolean t;
		/*try 
	    {*/
			this.lianjie();
			Set<Dream> dreams=new HashSet<Dream>();
			User user1=(User)session.get(User.class, new UserDao().finduser(user).getId());
			user1.setU_name(user.getU_name());
			user1.setU_password(user.getU_password());
			
			Dream dream2=new Dream();
			List<Dream> dreamlist =this.finddream(dream2, user);
			for(Dream d:dreamlist)
			{
				dreams.add(d);
			}
			dreams.add(dream);
			
			user1.setDreams(dreams);
			
			this.lianjie();
			session.update(user1);	
		
			session.save(dream);
			this.close();
			
			t=true;		
		/*}
		catch(Exception e)
		{
			t=false;
		}*/
		return t;
	}

	//删除梦
	public Boolean deletedream(Dream dream)
	{
		Boolean t;
		try 
	    {
			this.lianjie();
			Dream dream1=(Dream)session.get(Dream.class, dream.getId());
			session.delete(dream1);
			this.close();
			t=true;
		}
		catch(Exception e)
		{
			t=false;
		}
		
		return t;
	}

	//修改梦
	public Boolean updatedream(Dream dream)
	{
		Boolean t;
		
				this.lianjie();
				Dream dream1=(Dream)session.get(Dream.class,dream.getId());
				dream1.setDreamname(dream.getDreamname());
				dream1.setStarttime(dream.getStarttime());
				dream1.setEndtime(dream.getEndtime());
				dream1.setText(dream.getText());
				session.update(dream1);
				this.close();
				t=true;		
		return t;
	}
	
	//查找最后一个梦的ID
	public int maxid()
	{
		this.lianjie();
		String sql="SELECT MAX(id) FROM dream;";
		SQLQuery sqlquery=session.createSQLQuery(sql);
		int dreamid=(int)sqlquery.list().get(0);
		this.close();
		return dreamid;
	}
	
	//将date转换为特定的String（yyyy-MM-ddTHH:mm:ss）用于jsp显示
	public String date_dateloacaltime(Date time)
	{
		String t;
		DateFormat s=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		
		t=s.format(time);
		//System.out.println(t.charAt(10));
		StringBuilder f=new StringBuilder(t);
		f.replace(10, 11, "T");
		//yyyy-MM-ddTHH:mm:ss
		f.replace(13, 14, ":");
		f.replace(16, 17, ":");
		t=String.valueOf(f);
		return t;
	}

	//将String转换为特定的date  用于jsp向后端传值转换
	public Date String_date(String time)
	{
		int t[]=new int[5];
		t[0]=Integer.valueOf(time.substring(0, 4));
		t[1]=Integer.valueOf(time.substring(5,7));
		t[2]=Integer.valueOf(time.substring(8,10));
		t[3]=Integer.valueOf(time.substring(11,13));
		t[4]=Integer.valueOf(time.substring(14,16));
		@SuppressWarnings("deprecation")
		Date d=new Date(t[0]-1900,t[1]-1,t[2],t[3],t[4]);
		return d;
	}
}

