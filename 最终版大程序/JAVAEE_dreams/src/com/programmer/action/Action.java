package com.programmer.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.programmer.biaoqian.BiaoQian;
import com.programmer.dao.BiaoQianDao;
import com.programmer.dao.DreamDao;
import com.programmer.dao.UserDao;
import com.programmer.dream.Dream;
import com.programmer.user.User;

public class Action {
	
	private String newpassword;//新密码		
	private int id;//记录dream的ID
	private int bid;//记录标签的ID
	private String start;//开始时间 的String
	private String end;//结束时间的String
	private BiaoQian biaoqian=new BiaoQian();
	private List<Dream> dreams=new ArrayList<Dream>();
	private DreamDao dao1=new DreamDao();
	static User user=new User();
	private UserDao dao=new UserDao();
	private Dream dream=new Dream();
	private BiaoQianDao biaoqiandao=new BiaoQianDao();
	
	//用户注册
	public String userregister()
	{
		String register;
		
		if(dao.findusername(user.getU_name()))
		{	
			register="error";//用户名已经被注册
		}
		else 
		{
			if(dao.adduser(user))
			{
				register="success";//用户注册成功
			}
			else
			{
				register="false";//数据库错误导致用户注册失败
			}
		}
		return register;
	}

	//用户登录
	public String userlogin()
	{
		String login;
		User user1=new User();
		user1=dao.finduser(user);
	
		
		if(user1.getId()==null)
		{
			login="false";//用户登录失败
		}
		else
		{
			login="success";//用户登录成功
			user=user1;
			System.out.println(user.getId());
		}
		return login;
	}
	
	//用户修改密码
	public String alternewpassword()
	{
		String t;
		if(user.getU_name()==null)
		{
			t="error";
			System.out.println("inif");
			
		}
		else
		{
			if(dao.alterpassword(user, newpassword))
			{
				t="success";//用户修改密码成功
			}
			else
			{
				t="false";//用户修改密码失败(原来的用户名和密码输入错误)
			}		
		}
		return t;
	}

	//查找梦
	public String finddream()
	{
		String s;
		System.out.println("ifshang");
		System.out.println(user.getId());
		
			System.out.println("inelse1");
			if(bid!=1)
			{
				List<Dream> dreams1=new ArrayList<Dream>();
				List<Integer> intlist=new ArrayList<Integer>();
				
				dreams1=dao1.finddream(dream, user);	
				BiaoQian bia=new BiaoQian();
				bia.setId(bid);
				intlist=biaoqiandao.dreamid_int(bia);
				for(Dream d:dreams1)
				{
					for(int i:intlist)
					{
						if(i==d.getId())
						{
							dreams.add(dao1.findiddream(i));
						}
					}
				}
			}
			else
			{
				dreams=dao1.finddream(dream, user);
			}
			s="success";
			System.out.println("in finddream else");
		
		return s;
	}
	
	//删除梦
	public String deletedream()
	{
		String s="false";
		
			dream.setId(id);
			dream=dao1.findiddream(dream.getId());
			if(dao1.deletedream(dream))
			{
				if(biaoqiandao.delete(dream.getId(), biaoqiandao.chabid(dream.getId())))
				{
					s="success";
				}
			}
		
		return s;
	}
	
	//添加梦
	public String adddream()
	{
		String s="false";
	
			dream.setStarttime(dao1.String_date(start));
			dream.setEndtime(dao1.String_date(end));
			if(dao1.adddream(dream, user))
			{
				if(biaoqiandao.updateorsave(dao1.maxid(), bid))
				{
					s="success";
				}
			}
		
		return s;
	}
	
	//修改梦
	public String updatedream()
	{
		String s="false";
		System.out.println("update  in  start"+start);
		System.out.println("update  in  end"+end);
	
			dream.setStarttime(dao1.String_date(start));
			dream.setEndtime(dao1.String_date(end));
			System.out.println("dreams1 id"+dream.getId());
			System.out.println(dream.getText());
			System.out.println(dream.getStarttime());
			System.out.println(dream.getEndtime());
			if(dao1.updatedream(dream))
			{
				biaoqiandao.delete(dream.getId(), biaoqiandao.chabid(dream.getId()));
				biaoqiandao.updateorsave(dream.getId(), bid);
				s="success";
			}
		
		return s;
	}
	
	//通过ID查找dream
	public String findid()
	{
		String s;
		
				dream=dao1.findiddream(id);
				//System.out.println(dream.getDreamname());
				System.out.println("findid"+id);
				start=dao1.date_dateloacaltime(dream.getStarttime());
				end=dao1.date_dateloacaltime(dream.getEndtime());
				System.out.println(start);
				int biao=biaoqiandao.chabid(id);
				biaoqian.setB_name(biaoqiandao.cha_bname(biao));				
				s="success";
			
			return s;
	}
	
	//取得系统时 让初始时间
	public String time() throws ParseException
	{
		String p;
	
			SimpleDateFormat dtime=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String s=dtime.format(new Date());
			Date date =  dtime.parse(s);
			start=dao1.date_dateloacaltime(date);
			end=dao1.date_dateloacaltime(date);
			p="success";
		
		return p;
	}
	
	
	//属性的get和set方法
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public Dream getDream() {
		return dream;
	}
	public void setDream(Dream dream) {
		this.dream = dream;
	}
	public List<Dream> getDreams() {
		return dreams;
	}
	public void setDreams(List<Dream> dreams) {
		this.dreams = dreams;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	public BiaoQian getBiaoqian() {
		return biaoqian;
	}

	public void setBiaoqian(BiaoQian biaoqian) {
		this.biaoqian = biaoqian;
	}
	
	
}
