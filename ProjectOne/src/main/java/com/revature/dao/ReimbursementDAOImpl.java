package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employees;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public Reimbursement getReimbursementById(int empId) {
		Reimbursement r = null;
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				int empId1 = rs.getInt("EMP_ID");
				Double amount = rs.getDouble("AMOUNT");
				String dateSubmitted = rs.getString("DATE_SUBMITTED");
				String approvedBy = rs.getString("APPROVED_BY");
				String status = rs.getString("STATUS");
				r = new Reimbursement(reimId, empId1, amount, dateSubmitted, approvedBy, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void addReimbursement(int empId, Double amount, String dateSubmitted, String approvedBy, String status) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			//join?
			String sql = "INSERT INTO REIMBURSEMENT(EMP_ID, AMOUNT, DATE_SUBMITTED,  APPROVED_BY, STATUS) "+"VALUE(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.setDouble(2, amount);
			pstmt.setString(3, dateSubmitted);
			pstmt.setString(4, approvedBy);
			pstmt.setString(5, status);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursement(int reimId, String approvedBy, String status) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			//join?
			String sql = "UPDATE REIM_ID " + 
					"SET STATUS = ?, APPROVED_BY = ? " + 
					"WHERE REIM_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setString(2, approvedBy);
			pstmt.setInt(3, reimId);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursement() {
		List<Reimbursement> reim = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			//join?
			String sql = "SELECT * " + 
					"FROM REIMBURSEMENT ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int remId = rs.getInt("REIM_ID");
				int empId = rs.getInt("EMP_ID");
				Double amount = rs.getDouble("AMOUNT");
				String dateSubmitted = rs.getString("DATE_SUBMITTED");
				String approvedBy = rs.getString("APPROVED_BY");
				String status = rs.getString("STATUS");
				reim.add(new Reimbursement(remId, empId, amount, dateSubmitted, approvedBy, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reim;
	}

}