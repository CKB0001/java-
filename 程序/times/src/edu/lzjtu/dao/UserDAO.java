package edu.lzjtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.jdbc.Connection;

import edu.lzjtu.db.DBHelper;

public class UserDAO {

	public boolean exist(String username,String pwd){
		boolean flag=false;
		PreparedStatement st;
		Connection conn;
		String sql;
		ResultSet rs;
		
		try{
			sql = "select *  from t_user where username=? and pwd=?;";
			conn = DBHelper.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, pwd);
			rs = st.executeQuery();
			if(rs.next()){
				flag = true;
			}
		}catch(Exception e){
			
		}
		return flag;
	}
	
	
}
