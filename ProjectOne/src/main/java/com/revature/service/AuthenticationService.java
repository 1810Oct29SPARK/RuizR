package com.revature.service;

import com.revature.beans.Employees;
import com.revature.beans.Login;
import com.revature.beans.Credentials;
import com.revature.dao.EmployeesDAO;
import com.revature.dao.EmployeesDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;

public class AuthenticationService {

	LoginDAO log = new LoginDAOImpl();
	EmployeesDAO emp = new EmployeesDAOImpl();

	public AuthenticationService() {
	}
	
	public Employees isValidUser(Credentials credentials) {
		Employees u = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		Login val = log.getLoginInfoById(username);
		if (username != null && password != null) {
			if (username.equals(val.getLoginUser()) && password.equals(val.getPassword())) {
				Employees e = emp.getEmployeesByUsername(username);
				u = new Employees(e.getId(), e.getFirstName(), e.getLastName(), e.getTitle(), e.getReportTo(), e.getEmail());
			}
		}
		return u;
	}
	

}