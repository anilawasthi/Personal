package com.jp.hr.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*
 * The implementation of IniializingBean interface.
 * 	* The name of implementing method cannot be customizable.
 * 	* The exception being thrown cannot be changed.
 * 	* The initializing code cannot be grouped as per category in different methods.
 * 	* The interface tightly bound the code to Spring framework API.
 * 
 * The ApplicationContextAware is an interface to inject SpringContext reference within Bean.
 * 		Such a reference can be used to achieve Dependency relationship.
 * 
 * Lifecycle:
 * 		1. Object created and constructor invoked by JVM.
 * 		2. All setter methods (Value and Reference initialization).
 * 		3. All Aware methods
 * 		4. The init() methods (@PostConstruct afterPropertiesSet()).
 */

@Component("service")
public class ServiceBean implements InitializingBean, ApplicationContextAware {
	private int x;
	private ApplicationContext ctx;
	public ServiceBean() {
		System.out.println("In Constructor.");
	}
	
	@Autowired
	public ServiceBean(@Value("10")int x) {
		this.x = x;
		System.out.println("In Constructor(10).");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.ctx = arg0;
		System.out.println("Setting ApplContext.");
		
	}
	
	@Value("20")
	public void setValueX(int x) {
		this.x = x;
		System.out.println("In setter.");
	}
	
	@PostConstruct
	public void validateConfig(){
		System.out.println("In validaetConfig()");
		if(x > 100) {
			System.out.println("Wrong input.");
		}
	}
		
	@PostConstruct
	public void validateConfigX(){
		System.out.println("In validaetConfigX()");
		if(x > 100) {
			System.out.println("Wrong input.");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In afterPropertiesSet()");	
	}

	@Override
	public String toString() {
		return "ServiceBean [x=" + x + "]";
	}

	public void myServices(){
		ctx.getBean("");
	}
		
	
}
