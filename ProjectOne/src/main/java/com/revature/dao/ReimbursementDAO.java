package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	//CRUD methods
	public Reimbursement getReimbursementById(int reimId);
	public void addReimbursement(int empId, Double amount, String dateSubmitted, String approvedBy, String status);
	public void updateReimbursement(int reimId, String approvedBy, String status);
	List<Reimbursement> getReimbursement();
}