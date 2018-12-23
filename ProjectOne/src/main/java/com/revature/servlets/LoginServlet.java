package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employees;
import com.revature.service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3604302146815873126L;
	AuthenticationService auth = new AuthenticationService();

	//return Login page for GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.html").forward(req, resp);
	}
	
	//handle POST request from form on Login page
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("handling request...");
		HttpSession session = req.getSession(); 
		resp.setContentType("text/html");
		Credentials cred = new Credentials(req.getParameter("username"),req.getParameter("password"));
		Employees u = auth.isValidUser(cred);
		if (u != null) {
			session.setAttribute("Id", u.getId());
			session.setAttribute("firstname", u.getFirstName());
			session.setAttribute("lastname", u.getLastName());
			session.setAttribute("title", u.getTitle());
			session.setAttribute("reportTo", u.getReportTo());
			session.setAttribute("email", u.getEmail());
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("login");
		}
		
	}
}