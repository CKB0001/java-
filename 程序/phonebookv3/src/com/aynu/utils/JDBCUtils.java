package com.aynu.utils;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

	// ��ȡ���ݿ�����
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// ������������
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("�������ݿ���������ɹ�");
		// ���ݿ��url
		String url = "jdbc:mysql://localhost:3306/db_phonebook?useSSL=true&serverTimezone=GMT";
		// ���ݿ��û���
		String user = "root";
		// ���ݿ�����
		String password = "201711045";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	// �ر����ӣ��ͷ������Դ
	public static void release(java.sql.PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}

	// �ر����ӣ��ͷ������Դ
	public static void release(java.sql.ResultSet rs, java.sql.PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
