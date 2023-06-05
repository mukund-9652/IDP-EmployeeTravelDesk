package com.cognizant.employeetraveldesk.humanresouces.Exception;

public class InvalidEmployeeIdException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public  InvalidEmployeeIdException(){}
	public InvalidEmployeeIdException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}

}
