package com.cognizant.employeetraveldesk.humanresources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class InvalidResourceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidResourceException(String message) {
		super(message);
		
	}
}
