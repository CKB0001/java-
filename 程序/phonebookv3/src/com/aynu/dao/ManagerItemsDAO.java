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
			// ��ȡ���ݿ�����
			conn = JDBCUtils.getConnection();
			// ��Ӽ�¼��sql
			String sql = "insert into t_mangeritems(name,phone,address,qq,manger) values(?,?,?,?,?)";
			// ��ȡԤ����������
			pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setString(1, mItems.getName());
			pstmt.setString(2, mItems.getPhone());
			pstmt.setString(3, mItems.getAddress());
			pstmt.setString(4, mItems.getQq());
			pstmt.setString(5, mItems.getManger());

			// ִ��sql
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
		// ����һ������list��������е�ManagerItems����
		List<ManagerItems> list = new ArrayList<ManagerItems>();
		try {
			conn = JDBCUtils.getConnection();
			// ��ѯ�����û���sql
			String sql = "select * from t_mangeritems where manger = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manger);
			// ִ��sql���õ������
			rs = pstmt.executeQuery();
			// ������������ӽ������ÿȡ��һ����¼�Ͱ�����װ��һ��mangeritems����Ȼ����뼯��list
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
		// ����һ������list��������е�ManagerItems����
		List<ManagerItems> list = new ArrayList<ManagerItems>();
		try {
			conn = JDBCUtils.getConnection();
			// ��ѯ�����û���sql
			String sql = "select * from t_mangeritems where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// ִ��sql���õ������
			rs = pstmt.executeQuery();
			// ������������ӽ������ÿȡ��һ����¼�Ͱ�����װ��һ��mangeritems����Ȼ����뼯��list
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
	
	
	
	
	// �޸��û�
	public boolean update(ManagerItems mItems) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			// �޸��û���Ϣ��sql
			String sql = "update t_mangeritems set name=?,phone=?,address=?,qq=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mItems.getName());
			pstmt.setString(2, mItems.getPhone());
			pstmt.setString(3, mItems.getAddress());
			pstmt.setString(4, mItems.getQq());
			pstmt.setInt(5, mItems.getId());

			// ִ��sql
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
			// �����û�idɾ��ĳ���û�
			String sql = "delete from t_mangeritems where id = ?";
			pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setInt(1, id);
			// ִ��sql
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
