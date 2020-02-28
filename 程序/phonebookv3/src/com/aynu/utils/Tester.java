package com.aynu.utils;

import java.sql.Connection;

public class Tester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection conn;
		conn=JDBCUtils.getConnection();
		System.out.println(conn.isClosed());
	}

}
