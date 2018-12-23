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
import com.revature.util.ConnectionUtil;

public class EmployeesDAOImpl implements EmployeesDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public Employees getEmployeesByUsername(String username) {
		Employees g = new Employees();
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * " + 
					"FROM EMPLOYEES E " + 
					"FULL JOIN LOGIN ON E.ID = LOGIN.ID " + 
					"WHERE USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int Id = rs.getInt("ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String title = rs.getString("TITLE");
				String reportTo = rs.getString("REPORTTO");
				String email = rs.getString("EMAIL");
				g = new Employees(Id, firstName, lastName, title, reportTo, email); // g for gemployees -- the g is silent.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public void addEmployees(String firstName, String lastName, String title, String reportTo, String email) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO EMPLOYEES(FIRSTNAME, LASTNAME, TITLE, REPORTTO, EMAIL) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, title);
			pstmt.setString(4, reportTo);
			pstmt.setString(5, email);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployees(int id, String newFirstName, String newLastName, String newTitle, String newReportTo, String newEmail) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			//do I have to join stuff?
			//write a join which unifies Employee into a ResultSet
			//map the ResultSet's entries onto a Employee
			String sql = "UPDATE EMPLOYEES " + 
					"SET FIRSTNAME = ?, LASTNAME = ?, TITLE = ?, REPORTTO = ?, EMAIL = ? " + 
					"WHERE ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newFirstName);
			pstmt.setString(2, newLastName);
			pstmt.setString(3, newTitle);
			pstmt.setString(4, newReportTo);
			pstmt.setString(5, newEmail);
			pstmt.setInt(6, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployees(int Id) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			//do I need a join?
			//write a join which unifies Employee into a ResultSet
			//map the ResultSet's entries onto a Employee
			String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Employees> getEmployees() {
		List<Employees> emps = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * " + 
					"FROM EMPLOYEES ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int Id = rs.getInt("ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String title = rs.getString("TITLE");
				String reportTo = rs.getString("REPORTTO");
				String email = rs.getString("EMAIL");
				emps.add(new Employees(Id, firstName, lastName, title, reportTo, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emps;
	}
}