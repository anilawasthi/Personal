package com.jp.services;

import com.jp.dao.MyApplDao;

public class MyApplServices {
	private MyApplDao dao;
	
	
	public MyApplServices() {
		// This code owns a responsibility of creating an object and holding a reference.
		dao = new MyApplDao();
		System.out.println("Object of class MyApplServices() is created");
	}

	// Dependency Injection using the Constructor
	public MyApplServices(MyApplDao dao) {
		this.dao=dao;
		System.out.println("Object of class MyApplServices(dao) is created");
	}
}
