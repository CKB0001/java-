package com.cm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cm.domain.Emp;

public class AdminDao extends BaseDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Emp> searchAllEmp(){
		List<Emp> list = new ArrayList<Emp>();
		try {
			conn = this.getConn();
			String sql = "SELECT id,empid,empname,emppwd,sex,birthday,jointime,idcard,phone,storeid,statusid FROM emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setEmpId(rs.getString("empid"));
				emp.setEmpName(rs.getString("empname"));
				emp.setEmpPwd(rs.getString("emppwd"));
				emp.setSex(rs.getString("sex"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setJoinTime(rs.getString("jointime"));
				emp.setIdCard(rs.getString("idcard"));
				emp.setPhone(rs.getString("phone"));
				emp.setStoreId(rs.getInt("storeid"));
				emp.setStatusId(rs.getInt("statusid"));
				list.add(emp);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return list;
	}
	public Emp checkEmpLogin(String loginId,String loginPwd) {
		Emp emp = null;
		try {
			conn = this.getConn();
			String sql = "SELECT id,empid,empname,emppwd,sex,birthday,jointime,idcard,phone,storeid,statusid FROM emp WHERE empname=? AND emppwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPwd);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setEmpId(rs.getString("empid"));
				emp.setEmpName(rs.getString("empname"));
				emp.setEmpPwd(rs.getString("emppwd"));
				emp.setSex(rs.getString("sex"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setJoinTime(rs.getString("jointime"));
				emp.setIdCard(rs.getString("idcard"));
				emp.setPhone(rs.getString("phone"));
				emp.setStoreId(rs.getInt("storeid"));
				emp.setStatusId(rs.getInt("statusid"));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn, ps, rs);
		}
		return emp;
	}
}
