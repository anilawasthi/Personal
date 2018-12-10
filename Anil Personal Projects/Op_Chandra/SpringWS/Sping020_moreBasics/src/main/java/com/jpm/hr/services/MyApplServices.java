package com.jpm.hr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jpm.hr.daos.MyApplDao;

/*
 * When bean alias in not mentioned, the default is class name in camel case i.e first character should be in lower case
 * e.g myApplServices 
 * 
 * @Component  // Below mentioned are the sub components for @Component and they will work wherever @Component woprks
 * 		@Service 		: For declaring service bean.
 * 		@Repository 	: For declaring DAO beans.
 * 		@Controller 	: For Controller in SpringMVC 
 * 		@RestController	: For declaring REST service layer.
*/

//@Component("service")
@Service("service")
@Lazy(true)
@Scope("singleton")
public class MyApplServices {
	@Autowired
	private MyApplDao dao;

	public MyApplServices() {
		// This code owns a responsibility of creating an object and holding a reference.
		//dao = new MyApplDao();
		System.out.println("Object of class MyApplServicres() is created.");
	}
	
	//Dependency injection using Constructor
	//@Autowired   //It is also called as Autowiring/Plumbing by type.
	public MyApplServices(MyApplDao dao) {
		this.dao = dao;
		System.out.println("Object of class MyApplServicres(dao) is created.");
	}

	// Setter injection.
	//@Autowired
	public void setDao(MyApplDao dao) {
		this.dao = dao;
		System.out.println("In setter for injecting dao.");
	}
}
