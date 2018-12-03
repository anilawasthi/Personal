package com.jp.shopping.excptions;

public class ShoppingExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	public ShoppingExceptions(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ShoppingExceptions(String arg0) {
		super(arg0);
	}

}
