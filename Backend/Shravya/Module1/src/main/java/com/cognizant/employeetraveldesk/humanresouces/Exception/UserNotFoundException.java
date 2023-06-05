package com.cognizant.employeetraveldesk.humanresouces.Exception;

public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public  UserNotFoundException(){}
	public UserNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}

}
