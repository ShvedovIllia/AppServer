package com.zavada.exceptions;

public class AuthorServiceException extends RuntimeException {

	//private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = -2668966045940214908L;

	public AuthorServiceException(String message) {
		super(message);
	}

}
