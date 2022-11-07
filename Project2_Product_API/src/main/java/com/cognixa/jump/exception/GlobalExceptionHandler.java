package com.cognixa.jump.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cognixa.jump.exception.ErrorDetails;
import com.cognixa.jump.exception.ResourceNotFoundException;

// advice the controller about what to do when an exception is thrown
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	 
	public String itemNotFoundException(ItemNotFoundException ex) {
		
		return "error"; 
	}
		@ExceptionHandler(ResourceNotFoundException.class) 
		public ResponseEntity<?> resourceNotFoundException( ResourceNotFoundException ex, WebRequest request ) {
			
			// request.getDescription(false) => details on the request (usually includes the uri path where request was made)
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			
			// when the exception gets thrown, instead of returning the exception as json in the response,
			// return instead this response entity
			return ResponseEntity.status(404).body(errorDetails);
			
		
}
	// Rest APIs 
	
}
