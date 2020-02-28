package com.edu.action.user;

import java.util.List;

import com.edu.dao.card.CardDao;
import com.edu.model.card.Card;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CardAction extends ActionSupport {

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//return super.execute();
		System.out.println(username);
		List<Card> list = new CardDao().findByUsername(username);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			Card o = list.get(i);
			System.out.println(o);
		}
		return Action.SUCCESS;
	}

	public String execFind() throws Exception {
		// TODO Auto-generated method stub
		//return super.execute();
		System.out.println(username);
		List<Card> list = new CardDao().findByUsernamePosition(username);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			Card o = list.get(i);
			System.out.println(o);
		}
		return Action.SUCCESS;
	}
	private String username;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
