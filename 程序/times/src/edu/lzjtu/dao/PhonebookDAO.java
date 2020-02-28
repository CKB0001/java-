package edu.lzjtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.lzjtu.db.DBHelper;
import edu.lzjtu.entity.Phonebook;

public class PhonebookDAO {

	public void insert(String name,String phonenumber){

		PreparedStatement st;
		Connection conn;
		String sql;
	
		
		try{
			sql = "select *  from t_user where username=? and pwd=?;";
			sql="insert into t_phonebook(name,phonenumber) values(?,?);";
			
			conn = DBHelper.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, phonenumber);
			
			st.executeUpdate();
			
			st.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ;
	}
	
	public List<Phonebook> getList(){
		PreparedStatement st;
		Connection conn;
		String sql;
	
		ResultSet rs;
		List<Phonebook> list = new ArrayList<Phonebook>();
		
		try{
			sql = "select *  from t_user where username=? and pwd=?;";
			sql="insert into t_phonenumber(name,phonenumber) values(?,?);";
			sql="select * from t_phonebook";
			
			conn = DBHelper.getConnection();
			st = conn.prepareStatement(sql);
			//st.setString(1, name);
			//st.setString(2, phonenumber);
			rs = st.executeQuery();
			
			//st.executeUpdate();
			while(rs.next()){
				Phonebook o = new Phonebook();
				o.setId(rs.getInt(1));
				o.setName(rs.getString(2));
				o.setPhonenumber(rs.getString(3));
				list.add(o);
			}
			
			st.close();
			rs.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
