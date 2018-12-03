package com.revature.transport;

public class MaintenanceException extends Exception { // serializable - has a "marker" 
	
	

	public MaintenanceException() {
		// TODO Auto-generated constructor stub
	}

	public MaintenanceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MaintenanceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MaintenanceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MaintenanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
