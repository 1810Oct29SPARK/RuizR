package com.revature.dao;

import java.util.List;

import com.revature.beans.Employees;

public interface EmployeesDAO {
	//CRUD methods
	public Employees getEmployeesByUsername(String username);
	public void addEmployees(String firstName, String lastName, String title, String reportTo, String email);
	public void updateEmployees(int empId, String newFirst, String newLast, String newTitle, String newReportTo, String newEmail);
	public void removeEmployees(int empId);
	List<Employees> getEmployees();
}