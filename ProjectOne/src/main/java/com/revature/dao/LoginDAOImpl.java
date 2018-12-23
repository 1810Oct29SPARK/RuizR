package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employees;
import com.revature.beans.Login;
import com.revature.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public Login getLoginInfoById(String loginId) {
		Login l = new Login(0, 0, null, null);
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM LOGIN WHERE LOGIN_USER = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int loginId1 = rs.getInt("LOGIN_ID");
				int empId = rs.getInt("EMP_ID");
				String loginUser = rs.getString("LOGIN_USER");
				String loginPassword = rs.getString("LOGIN_PASSWORD");
				l = new Login(loginId1, empId, loginUser, loginPassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void addLoginInfo(int empId, String loginUser, String loginPassword) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			//join?
			String sql = "INSERT INTO LOGIN(EMP_ID, LOGIN_USER, LOGIN_PASSWORD) VALUES(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.setString(2, loginUser);
			pstmt.setString(3, loginPassword);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}