package com.edu.action.card;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;


import com.edu.dao.card.CardDao;
import com.edu.model.card.Card;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;
@Namespace("/card2")
@Scoped(Scope.REQUEST)
@ParentPackage("struts-default")  //表示继承的父包
public class CardRetrieveAction extends ActionSupport {	
	private static final long serialVersionUID = 1L;
	
	private CardDao cardDao=new CardDao();	
	
	private Card card;  //传入提交值(插入记录)
	
	//提交页面——查询信息提交
	private String condition;//查询条件
	private String[] checkList; //可以选择多条记录的复选框所形成的记录序号的字符串
	private int id;        //单记录时的主键号
	
	private String order;    //设置查询结果排序方式：按记录号升序或降序（添加的先后次序）
	private long pageNo;    //设置查询结果要显示的分页页码号
	private int pageSize;    //设置查询结果要显示的分页，每页要显示的记录条数（当不设置时，不分页）
	
	
	
	//返回执行结果的返回信息
	private long recordCount;//查询满足条件的记录总条数
	private long pageCount;//查询出记录的总页数（按所设置的每页条数后，形成的页总数）
	private List<Card> listCard;//传出查询结果集合
	
	private String msg;    //返回运行后的信息
	

	
	
	@Action( //表示请求的Action及处理方法
			value="delete", 		   
			results={@Result(name="success",location="/find",type="redirectAction")}
		)		
	public String delecte() throws Exception {
		cardDao.delete(id);
		msg="删除入一条记录成功！";
		return "success";
	}
	
	@Action( //表示请求的Action及处理方法
			value="delecteList", 		   
			results={@Result(name="success",location="/find",type="redirectAction")}
		)	
	public String delecteList() throws Exception {
		int ids[]=new int[checkList.length];
		for(int i=0;i<checkList.length;++i){
			ids[i]=Integer.parseInt(checkList[i]);
		}		
		int n=cardDao.deleteList(ids);		
		msg="删除一组（"+n+"条）记录成功！";
		return "success";
	}	
	
	@Action( //表示请求的Action及处理方法
			value="find", 		   
			results={@Result(name="success",location="/card/retrieve.jsp",type="dispatcher")}
		)	
	public String find() throws Exception {
		listCard=cardDao.findByCondition(condition, "1");		
		return "success";
	}
	

	@Action( //表示请求的Action及处理方法
			value="revert", 		   
			results={@Result(name="success",location="/find",type="redirectAction")}
		)	
	public String revert() throws Exception {
		int ids[]=new int[checkList.length];
		for(int i=0;i<checkList.length;++i){
			ids[i]=Integer.parseInt(checkList[i]);
		}	
		cardDao.revert(ids);			
		return "success";
	}
	

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}	

	public String[] getCheckList() {
		return checkList;
	}

	public void setCheckList(String checkList[]) {
		this.checkList = checkList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public List<Card> getListCard() {
		return listCard;
	}

	public void setListCard(List<Card> listCard) {
		this.listCard = listCard;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
}
