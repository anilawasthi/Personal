package com.jp.dp;

/*
 * 1.	Declare self reference as static and private.
 * 2.	Create private constructor. - Constructor cannot be called from outside the class i.e no one will be able to create the class from outside.
 * 3.   A static public method to create restricted number of instances.	
 */

public class Singleton01 {
	private static Singleton01 singleton;

	private Singleton01() {
		System.out.println("Constructor executed.");
	}

	public static Singleton01 getInstance() {
		if (singleton == null) {
			singleton = new Singleton01();
			System.out.println("Inside getInstance()");
		}
		return singleton;
	}
}