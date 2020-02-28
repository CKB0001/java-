package com.edu.dao.card;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.edu.dao.DaoHibernate;
import com.edu.db_util.HibernateUtil;
import com.edu.model.card.Card;

public class CardDao extends DaoHibernate<Card> {
	public List<Card> findByUsername(String username){
		String hql;
		Session s=null;
		
		hql="from Card c WHERE c.name LIKE :name";
		try {
			s = HibernateUtil.getThreadLocalSession();		
			 Query query=s.createQuery(hql);
			 @SuppressWarnings("unchecked")
			List<Card> list=query.setString("name", "%"+username+"%").list();
			 
			return list;
		} finally {
			HibernateUtil.closeSession();
		}		
	}
	//
	public List<Card> findByUsernamePosition(String username){
		String hql;
		Session s=null;
		
		hql="from Card c WHERE c.name LIKE ?";
		try {
			s = HibernateUtil.getThreadLocalSession();		
			 Query query=s.createQuery(hql);
			 @SuppressWarnings("unchecked")
			List<Card> list=query.setParameter(0,  "%"+username+"%").list();
			 
			return list;
		} finally {
			HibernateUtil.closeSession();
		}		
	}
	public List<Card> findByCondition(String condition,String flag) {
		String hql = "from Card ";
		String cardFields[]={"name","sex","department","mobile","phone","email","address"};
		List<Card> cards1=this.findByFields(hql, cardFields, condition);
		List<Card> cards2 = new ArrayList<Card>();
		for (Card card : cards1) {
			if (card.getFlag().equals(flag)) {
				cards2.add(card);
			}
		}
		return cards2;	
	}
	
	public Card findById(int id, String flag) {
		Card card2 = findById(Card.class,id);
		if (card2.getFlag().equals(flag)) {
			return card2;
		} else {
			return null;
		}
	}    
	public int delete(int id) {
		return this.delete(Card.class, id);		
	}
	public int deleteList(int[] ids){
		return this.deleteList(Card.class,ids);
	}	

	// 将名片移到回收站
	public int retrieve(int... ids){
		for (int id : ids) {
			Card card=this.findById(Card.class, id);		
			card.setFlag("1");	
			this.update(card);		
		}
		return ids.length;
	}

	// 从回收站中还原名片
	public int revert(int... ids){
		for (int id : ids) {
			Card card=this.findById(Card.class, id);		
			card.setFlag("0");
			this.update(card);	
		}
		return ids.length;
	}	

	//
	
}
