package com.jp.products.exceptions;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserException(String arg0) {
		super(arg0);
	}

}
