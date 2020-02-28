package com.edu.entity.two.one2one_pk;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edu.db_util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
//		Person person=new Person();
//		person.setName("张三2");
//		IdCard idCard=new IdCard();
//		idCard.setCardNo("123456789_2");
//		idCard.setPerson(person);
        Session session= HibernateUtil.getThreadLocalSession();
        Transaction tx=session.beginTransaction();        
        Person p=(Person)session.get(Person.class, 1);
        session.delete(p);
        //        session.save(person);
//        session.save(idCard);
        tx.commit();
        HibernateUtil.closeSession();
	}
}
