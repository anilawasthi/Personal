package com.jp.hr.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// Annotation and bean id is dao, as we have comment the dao tags
//@Component("dao")  -- Repace with Repository
@Repository("dao")
public class MyApplDao {
		
	public MyApplDao() {
		System.out.println("Object of class MyApplDao() is created");
	}
}
