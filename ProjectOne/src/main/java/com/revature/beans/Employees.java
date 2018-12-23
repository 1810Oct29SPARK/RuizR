package com.revature.beans;

public class Employees {

	public Employees(int Id, String firstName, String lastName, String title, String reportTo, String email) {
		super();
		this.Id = Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.reportTo = reportTo;
		this.email = email;
	}

	public Employees() {
		super();
	}
	
	private int Id;
	private String firstName;
	private String lastName;
	private String title;
	private String reportTo;
	private String email;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getReportTo() {
		return reportTo;
	}
	
	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employees [Id=" + Id + ", firstName=" + firstName + ", "
				+ "lastName=" + lastName + ", title=" + title + ", reportTo=" + reportTo + ", email=" + email + "]";
	}

}