package com.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
		ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getStatus());
		return new ResponseEntity<>(response,ex.getStatus());
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequestExceptiom (BadRequestException ex){
		
		ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getStatus());
		return new ResponseEntity<>(response,ex.getStatus());
		
	}


}
