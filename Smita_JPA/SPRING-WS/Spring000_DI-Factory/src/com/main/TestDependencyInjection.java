package com.main;

import com.jp.dao.MyApplDao;
import com.jp.services.MyApplServices;
import com.jp.Factory.ObjectFactory;

public class TestDependencyInjection {

	public static void main(String[] args) {
			
		
//		MyApplDao dao = new MyApplDao();
//		MyApplServices services = new MyApplServices(dao);

		// Object Factory concept
		ObjectFactory factory = new ObjectFactory();
		// Constructor Injection
		//MyApplDao dao = factory.getDao(); // getDao is the factory method here client doesn't know which class object it is actually creating.
		
		/* getDao() - Client should get the list not ArrayList. If ArrayList is visible to client then he will get to know we are using ArrayList so ideally it should return list 
		 * Even we are providing Custom Exception instead of DAo Exception 
		*/		
		
		//MyApplServices services = factory.getService(); // getService is the factory method here client doesn't know which class object it is actually creating.

		// Calling getBean Method - for this you have to comment the above two lines
		
		MyApplDao dao = (MyApplDao) factory.getBean("dao"); // Why TypeCasting - Because return type is dao and actually we are returning Object superclass and dao is subclass
		MyApplServices services = (MyApplServices) factory.getBean("service");
		
		
		
		

	}

}
