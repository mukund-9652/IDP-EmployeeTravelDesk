package com.EmployeeTravelDesk.ReservationsManagement.Exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	protected ResponseEntity<Object> handleHttpMessageNotReadableException(Exception ex, WebRequest request) {
		String error = "Request body is missing or invalid.";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(Exception ex, WebRequest request) {
		String error = "Requested API is missing or invalid.";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	@ExceptionHandler({ ConstraintViolationException.class })
	protected ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
		String error = "Costraint Error check the fields entered.\n" + ex.getMessage();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler({ CustomException.class })
	protected ResponseEntity<Object> handleIdNotExistException(CustomException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}

