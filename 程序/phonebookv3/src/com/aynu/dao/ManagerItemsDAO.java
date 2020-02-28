package com.aynu.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aynu.entity.ManagerItems;
import com.aynu.utils.JDBCUtils;


public class ManagerItemsDAO {

	public boolean insertManagerItems(ManagerItems mItems) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 获取数据库连接
			conn = JDBCUtils.getConnection();
			// 添加纪录的sql
			String sql = "insert into t_mangeritems(name,phone,address,qq,manger) values(?,?,?,?,?)";
			// 获取预编译语句对象
			pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setString(1, mItems.getName());
			pstmt.setString(2, mItems.getPhone());
			pstmt.setString(3, mItems.getAddress());
			pstmt.setString(4, mItems.getQq());
			pstmt.setString(5, mItems.getManger());

			// 执行sql
			int num = pstmt.executeUpdate();
			if (num > 0) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (java.sql.SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.release(pstmt, conn);

		}
		return false;
	}


	public List<ManagerItems> findItemsByManager(String manger) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 创建一个集合list，存放所有的ManagerItems对象
		List<ManagerItems> list = new ArrayList<ManagerItems>();
		try {
			conn = JDBCUtils.getConnection();
			// 查询所有用户的sql
			String sql = "select * from t_mangeritems where manger = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manger);
			// 执行sql，得到结果集
			rs = pstmt.executeQuery();
			// 遍历结果集，从结果集中每取出一条记录就把它封装成一个mangeritems对象，然后放入集合list
			while (rs.next()) {
				ManagerItems mItems = new ManagerItems();
				mItems.setName(rs.getString("name"));
				mItems.setAddress(rs.getString("address"));
				mItems.setPhone(rs.getString("phone"));
				mItems.setQq(rs.getString("qq"));
				mItems.setManger(rs.getString("manger"));
				mItems.setId(rs.getInt("id"));
				list.add(mItems);
			}
			return list;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}
     
	public List<ManagerItems> findItemsById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 创建一个集合list，存放所有的ManagerItems对象
		List<ManagerItems> list = new ArrayList<ManagerItems>();
		try {
			conn = JDBCUtils.getConnection();
			// 查询所有用户的sql
			String sql = "select * from t_mangeritems where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// 执行sql，得到结果集
			rs = pstmt.executeQuery();
			// 遍历结果集，从结果集中每取出一条记录就把它封装成一个mangeritems对象，然后放入集合list
			while (rs.next()) {
				ManagerItems mItems = new ManagerItems();
				mItems.setName(rs.getString("name"));
				mItems.setAddress(rs.getString("address"));
				mItems.setPhone(rs.getString("phone"));
				mItems.setQq(rs.getString("qq"));
				mItems.setManger(rs.getString("manger"));
				mItems.setId(rs.getInt("id"));
				list.add(mItems);
			}
			return list;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}
	
	
	
	
	// 修改用户
	public boolean update(ManagerItems mItems) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			// 修改用户信息的sql
			String sql = "update t_mangeritems set name=?,phone=?,address=?,qq=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mItems.getName());
			pstmt.setString(2, mItems.getPhone());
			pstmt.setString(3, mItems.getAddress());
			pstmt.setString(4, mItems.getQq());
			pstmt.setInt(5, mItems.getId());

			// 执行sql
			int num = pstmt.executeUpdate();
			if (num > 0) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pstmt, conn);
		}
		return false;
	}

	public boolean delete(int id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.getConnection();
			// 根据用户id删除某个用户
			String sql = "delete from t_mangeritems where id = ?";
			pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setInt(1, id);
			// 执行sql
			int num = pstmt.executeUpdate();
			if (num > 0) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pstmt, conn);
		}
		return false;
	}

}
