package com.revature.beans;

public class Login {
	
	public Login(int loginId, int empId, String loginuser, String password) {
		super();
		this.loginId = loginId;
		this.empId = empId;
		this.loginuser = loginuser;
		this.password = password;
	}
	private int loginId;
	private int empId;
	private String loginuser;
	private String password;
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getLoginUser() {
		return loginuser;
	}
	public void setLoginUser(String LoginUser) {
		this.loginuser = LoginUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String Password) {
		this.password = Password;
	}
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", empId=" + empId + ", loginuser=" + loginuser + ", password="
				+ password + "]";
	}

}