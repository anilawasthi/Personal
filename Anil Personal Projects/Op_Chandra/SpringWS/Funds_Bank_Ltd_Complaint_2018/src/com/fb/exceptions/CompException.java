package com.fb.exceptions;

public class CompException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CompException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CompException(String message) {
		super(message);
	}

}
