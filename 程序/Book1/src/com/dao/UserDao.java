package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db_util.DBConnection;
import com.model.EndUser;

public class UserDao {
	// 鎯虫暟鎹簱涓彃鍏ヤ竴涓敤鎴�
	public int save(EndUser user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnection.getDBConnection();
		int row = 0;
		String sql = "insert into t_user(userName,userPassword,userRealName) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserRealName());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, pstmt, rs);
		}
		return row;
	}

	// 浠庢暟鎹簱涓垹闄や竴涓敤鎴�
	public int delete(EndUser user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		con = DBConnection.getDBConnection();
		String sql = "delete from t_user where username=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, pstmt, rs);
		}
		return row;
	}

	// 淇敼鐢ㄦ埛鍊�
	public int update(EndUser user, String newPassword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		con = DBConnection.getDBConnection();
		String sql = "update  t_user set userpassword=? where username=? and userpassword=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, pstmt, rs);
		}
		return row;
	}

	// 浠庢暟鎹簱涓煡鎵句竴涓敤鎴�
	public EndUser find(EndUser user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnection.getDBConnection();
		EndUser user2 = null;
		String sql = "select id,username,userpassword,userrealname from t_user where  username=? and  userpassword=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user2 = new EndUser();
				user2.setUserId(rs.getInt("id"));
				user2.setUserName(rs.getString("username"));
				user2.setUserPassword(rs.getString("userpassword"));
				user2.setUserRealName(rs.getString("userrealname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, pstmt, rs);
		}
		return user2;
	}

	// 鍒楀嚭鎵�鏈夌敤鎴�
	public List<EndUser> findAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EndUser> users = new ArrayList<EndUser>();
		con = DBConnection.getDBConnection();
		String sql = "select id,userName,userPassword,userRealName from t_user ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EndUser user = new EndUser();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserRealName("userRealName");
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, pstmt, rs);
		}
		return users;
	}
}