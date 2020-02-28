package com.programmer.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.programmer.biaoqian.BiaoQian;

public class BiaoQianDao {
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
	
	//从数据库中取出dreamid
	@SuppressWarnings("unchecked")
	public String dreamid(BiaoQian bia)
	{
		this.lianjie();
		String sql="select b_dreamid from biaoqian where id=?";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter(0, bia.getId()); 
	
		List<String> list=new ArrayList<String>();
		
		String q = null;
		list=query.list();
		for(String o:list)
		{
			q=o;
		}
		this.close();
		return q;
	}
	
	//从数据库中取出dreamID转换为int
	@SuppressWarnings("unchecked")
	public List<Integer> dreamid_int(BiaoQian bia)
	{
		this.lianjie();
		String sql="select b_dreamid from biaoqian where id=?";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter(0, bia.getId()); 
		List<Integer> dreamidlist=new ArrayList<Integer>();
		List<String> list=new ArrayList<String>();
		
		String q = null;
		list=query.list();
		for(String o:list)
		{
			q=o;
		}
		System.out.println("q=="+q);
		for(int i=0;i<q.length();i++)
		{
			if(q.charAt(i)==',')
			{
				if(q.charAt(i+1)=='/')
				{
					break;
				}
				else
				{
					String s="0";
					for(int j=i+1;j<q.length();j++)
					{
						
						if(q.charAt(j)!=',')
						{
							s=s+q.charAt(j);
//							System.out.println("if_s="+s);
//							System.out.println("q.charAt"+q.charAt(j));
						}
						else
						{
							System.out.println(s);
							dreamidlist.add(Integer.valueOf(s));
							break;
						}
					}
				}
			}
		}
		this.close();
		return dreamidlist;
	}
	
	//将dreamID储存在数据库的标签中
	public Boolean updateorsave(int dreamid,int b_id)
	{
		boolean p=false;
		try {
			BiaoQian bia=new BiaoQian();
			bia.setId(b_id);
			List<Integer> dreamid1=this.dreamid_int(bia);
			Boolean t=true;
			for(int i:dreamid1)
			{
				if(i==dreamid)
				{
					t=false;
					System.out.println(i);
				}
				
			}	
			if(t) 
			{
				String q=this.dreamid(bia);
				q=q.substring(0,q.length()-1)+String.valueOf(dreamid)+",/";
				this.lianjie();
				BiaoQian biaoqian=(BiaoQian)session.get(BiaoQian.class, b_id);
				biaoqian.setB_dreamid(q);
				session.update(biaoqian);
				this.close();
			}
			p=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			p=false;
		}
		return p;
	}

	//将dreamid在数据库的标签中删除
	public Boolean delete(int dreamid,int bid)
	{
		boolean t=false;
		try {
			BiaoQian bia=new BiaoQian();
			bia.setId(bid);
			List<Integer> list=this.dreamid_int(bia);
			this.lianjie();
			BiaoQian bia1=(BiaoQian)session.get(BiaoQian.class, bid);
			bia1.setB_dreamid(",/");
			session.update(bia1);
			this.close();
			for(int i:list)
			{
				if(i!=dreamid)
				{
					this.updateorsave(i, bid);
				}
			}
			t=true;
		
		}
		catch (Exception e) {
			// TODO: handle exception
			t=false;
		}
		return t;
	}

	//通过dream查找bid
	public int chabid(int dreamid)
	{
		int bid=0;
		List<Integer> intlist=new ArrayList<Integer>();
		for(int i=1;i<=5;i++)
		{
			BiaoQian bia=new BiaoQian();
			bia.setId(i);
			intlist=this.dreamid_int(bia);
			for(int j:intlist)
			{
				if(j==dreamid)
				{
					bid=i;
				}
				System.out.println("in chabid j:"+j);
			}
		}
		
		return bid;
	}
	
	//通过bid查找b_name
	public String cha_bname(int bid)
	{
		this.lianjie();
		String sql="select B_NAME from biaoqian where id=?";
		SQLQuery sqlquery =session.createSQLQuery(sql);
		sqlquery.setParameter(0, bid); 
		String bname=(String)sqlquery.list().get(0);
		this.close();
		return bname;
	}

}
