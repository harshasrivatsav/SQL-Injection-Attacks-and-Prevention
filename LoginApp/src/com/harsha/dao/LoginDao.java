package com.harsha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public static String validate(String name, String pass) {		
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
			//String query = "select * from loginapp where username='".concat(name.replace("'", "\\'").replace("#", "").replace("\"", "\\\"")).concat("' and password='").concat(pass.replace("'", "\\'")).concat("'");
			String query = "select * from loginapp where username='".concat(name).concat("' and password='").concat(pass).concat("'");
			System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			System.out.println(pst);
			status = Boolean.toString(rs.next());

		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
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
		return status;
	}
}