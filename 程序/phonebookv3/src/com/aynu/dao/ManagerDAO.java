package com.aynu.dao;
import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aynu.entity.*;
import com.aynu.utils.JDBCUtils;

/*
 * 
 */

public class ManagerDAO {

	public boolean exists(Manager manager) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_manger where manger = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager.getUsername());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("用户:" + rs.getString("manger"));
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return false;
	}

	public boolean insert(Manager manager) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into t_manger(manger,password) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager.getUsername());
			pstmt.setString(2, manager.getPassword());
            
			int num = pstmt.executeUpdate();
			if(num > 0) {
				return true;
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
        
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pstmt, conn);
		}
		return false;
	}

	public boolean delete(Manager manager) {
		
			Connection conn = null;
			PreparedStatement pstmt = null;		
			try {
				conn = JDBCUtils.getConnection();
				//根据用户id删除某个用户
				String sql = "delete from manger where manger = ?";
				pstmt = conn.prepareStatement(sql);
				//给占位符赋值
				pstmt.setString(1, manager.getUsername());
				//执行sql
				int num = pstmt.executeUpdate();
				if(num>0){
					return true;
				}
				return false;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.release(pstmt, conn);
			}
			return false;
		}
    
}
