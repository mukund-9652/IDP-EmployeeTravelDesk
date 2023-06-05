package com.cognizant.employeetraveldesk.humanresouces.Exception;

public class GradeUpdationException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public  GradeUpdationException(){}
	public GradeUpdationException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}

}
