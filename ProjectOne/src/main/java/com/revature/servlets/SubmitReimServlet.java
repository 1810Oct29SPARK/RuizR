package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/submitReim")
public class SubmitReimServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7376963557662103425L;
	ReimbursementService reimb = new ReimbursementService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("home.html").include(request, response);
		String id = request.getParameter("id");
		String amount = request.getParameter("amount");
		//reimb.subReim(Integer.parseInt(id), Double.parseDouble(amount));

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
