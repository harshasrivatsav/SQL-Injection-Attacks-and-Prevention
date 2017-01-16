package com.harsha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDao {
	public static void validate(String name, String comment) {		
		String status = "false";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "form?allowMultiQueries=true";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Harsha.8";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			
			pst = conn.prepareStatement("insert into comments (username, comment) values (?,?)");
			pst.setString(1, name);
			pst.setString(2, comment);
			pst.executeUpdate();
			System.out.println(pst);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}