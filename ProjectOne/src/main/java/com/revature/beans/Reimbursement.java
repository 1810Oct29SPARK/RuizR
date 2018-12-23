package com.revature.beans;

public class Reimbursement {
	
	public Reimbursement(int reimId, int empId, Double amount, String dateSubmitted, String approvedBy, String status) {
		super();
		this.reimId = reimId;
		this.empId = empId;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.approvedBy = approvedBy;
		this.status = status;
	}
	private int reimId;
	private int empId;
	private Double amount;
	private String dateSubmitted;
	private String approvedBy;
	private String status;

	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", empId=" + empId + ", amount=" + amount + ", dateSubmitted=" + dateSubmitted + " approvedBy=" + approvedBy + 
				" status=" + status + "]";
	}

}