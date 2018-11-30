package com.jp.products.exceptions;

public class ProductsException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProductsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public ProductsException(String arg0) {
		super(arg0);
	}
}
