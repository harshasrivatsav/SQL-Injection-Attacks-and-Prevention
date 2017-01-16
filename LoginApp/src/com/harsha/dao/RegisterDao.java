package com.harsha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	public static boolean register(String fname, String lname, String email, String uname, String pass) {		
		boolean dataExists = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "form";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Harsha.8";
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			
			//Check for existing username
			pst = conn
					.prepareStatement("select * from loginapp where username=?");
			pst.setString(1, uname);
			rs = pst.executeQuery();
			boolean status1 = rs.next();
			if(status1){
				dataExists = true;
			}
			pst.close();
			
			//Check for existing email
			pst = conn
					.prepareStatement("select * from loginapp where email=?");
			pst.setString(1, email);
			rs = pst.executeQuery();
			status1 = rs.next();
			if(status1){
				dataExists = true;
			}
			pst.close();
			
			if(!dataExists){
				pst = conn.prepareStatement("insert into loginapp (firstname, lastname, email, username, password) values (?,?,?,?,?)");
				pst.setString(1, fname);
				pst.setString(2, lname);
				pst.setString(3, email);
				pst.setString(4, uname);
				pst.setString(5, pass);
	
				pst.executeUpdate();
			}

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
	return dataExists;
	}
}
