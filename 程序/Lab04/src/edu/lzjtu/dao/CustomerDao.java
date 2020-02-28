package edu.lzjtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import edu.lzjtu.bean.Customer;

public class CustomerDao extends BaseDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean addCustomer(Customer customer) {
		try {
			conn = this.getConn();
			String sql = "INSERT INTO customer(cid,cname,csex,cbirthday,cidcard,caddress,cphone)VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getId());
			ps.setString(2, customer.getCustName());
			ps.setString(3, customer.getSex());
			ps.setString(4, customer.getBirthday());
			ps.setString(5, customer.getIdcard());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getPhone());
			ps.executeUpdate();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			this.closeAll(conn, ps, rs);
		}
	}
	//ɾ����Ϣ
	public boolean DeleteCustomer(Customer c) {
		try {
			conn = this.getConn();
			
			String sql1 = "DELETE FROM customer WHERE cname='"+c.getCustName()+"';";
			String sql2 = "DELETE FROM customer WHERE cidcard='"+c.getIdcard()+"';";
			if(!c.getCustName().equals("")){
				ps = conn.prepareStatement(sql1);
				ps.executeUpdate();
			}
			if(!c.getIdcard().equals("")){
				ps = conn.prepareStatement(sql2);
				ps.executeUpdate();
			}
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			this.closeAll(conn, ps, rs);
		}
	}
	
	public boolean AlterCustomer(Customer customer) {
		try {
			conn = this.getConn();
			String sql = "UPDATE customer SET cname=?,csex =?,cbirthday=?,cidcard=?,caddress=?,cphone=? WHERE cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getCustName());
			ps.setString(2, customer.getSex());
			ps.setString(3, customer.getBirthday());
			ps.setString(4, customer.getIdcard());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getPhone());
			ps.setString(7, customer.getId());
			ps.executeUpdate();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			this.closeAll(conn, ps, rs);
		}
	}
	
	public List<Customer> searchALLCustomer(){
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = this.getConn();
			String sql = "SELECT * FROM customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("cid"));
				customer.setCustName(rs.getString("cname"));
				customer.setSex(rs.getString("csex"));
				customer.setBirthday(rs.getString("cbirthday"));
				customer.setIdCard(rs.getString("cidcard"));
				customer.setAddress(rs.getString("caddress"));
				customer.setPhone(rs.getString("cphone"));
				list.add(customer);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return list;
	}
	
	public List<Customer> searchCustomerByParam(Customer customerParam){
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = this.getConn();
			String sql = "SELECT cid,cname,csex,cbirthday,cidcard,caddress,cphone, FROM customer where 1=1";
			if(!customerParam.getCustName().equals("")) {
				sql += " and cname like '%"+customerParam.getCustName()+"%'";
			}
			if(!customerParam.getAddress().equals("")) {
				sql += " and caddress like '%"+customerParam.getAddress()+"%'";
			}
			if(!customerParam.getSex().equals("")) {
				sql += " and csex like '%"+customerParam.getSex()+"%'";
			}
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("cid"));
				customer.setCustName(rs.getString("cname"));
				customer.setSex(rs.getString("csex"));
				customer.setBirthday(rs.getString("cbirthday"));
				customer.setIdCard(rs.getString("cidcard"));
				customer.setAddress(rs.getString("caddress"));
				customer.setPhone(rs.getString("cphone"));
				list.add(customer);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return list;
	}
}
