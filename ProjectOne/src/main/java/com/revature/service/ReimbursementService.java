package com.revature.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ReimbursementService {
	
	ReimbursementDAO reim = new ReimbursementDAOImpl();

/*	
	public void subReim(int emplId, Double amount) {
	    Date dt = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(dt);
		int id = emplId;
		Double amnt = amount;
		String dateSubmitted = formattedDate;
		String approvedBy = "Manager";
		String status = "Pending";
		reim.addReimbursement(id, amnt, dateSubmitted, approvedBy, status);
	}
*/
}