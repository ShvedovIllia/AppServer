package com.zavada.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.zavada.domain.response.ErrorMessage;

@ControllerAdvice
public class ServerExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> handleExceptions(Exception ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = AuthorServiceException.class)
	public ResponseEntity<ErrorMessage> handleAuthorExceptions(AuthorServiceException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = AuthorNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleAuthorNotFoundException(AuthorNotFoundException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserServiceException.class)
	public ResponseEntity<ErrorMessage> hangleUserServiceException(UserServiceException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
