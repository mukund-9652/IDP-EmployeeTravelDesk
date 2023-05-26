package com.cognizant.employeetraveldesk.reimbursement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.TOO_MANY_REQUESTS)
public class DuplicateResourceException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public DuplicateResourceException(String message) {
		super(message);
	}
}
