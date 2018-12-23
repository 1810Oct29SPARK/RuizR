package com.revature.dao;

import com.revature.beans.Login;

public interface LoginDAO {
	//CRUD methods
	public Login getLoginInfoById(String loginId);
	public void addLoginInfo(int empId, String loginUser, String loginPassword);
}