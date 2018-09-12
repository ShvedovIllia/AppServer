package com.zavada.exceptions;

public class AuthorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2492861483324808462L;

	public AuthorNotFoundException(String message) {
		super(message);
	}

}
