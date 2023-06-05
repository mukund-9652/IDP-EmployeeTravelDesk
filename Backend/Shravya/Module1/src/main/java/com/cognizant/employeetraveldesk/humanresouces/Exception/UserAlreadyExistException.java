package com.cognizant.employeetraveldesk.humanresouces.Exception;

public class UserAlreadyExistException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public  UserAlreadyExistException(){}
	public UserAlreadyExistException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}

}
