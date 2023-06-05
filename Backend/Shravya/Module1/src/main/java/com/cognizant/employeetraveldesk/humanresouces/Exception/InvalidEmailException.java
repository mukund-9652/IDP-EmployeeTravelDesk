package com.cognizant.employeetraveldesk.humanresouces.Exception;

public class InvalidEmailException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public  InvalidEmailException(){}
	public InvalidEmailException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}

}
