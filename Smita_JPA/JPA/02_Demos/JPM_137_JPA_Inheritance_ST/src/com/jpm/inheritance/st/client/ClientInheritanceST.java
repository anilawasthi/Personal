package com.jpm.inheritance.st.client;

import javax.persistence.EntityManager;

import com.jpm.inheritance.st.entities.Employee;
import com.jpm.inheritance.st.entities.Manager;
import com.jpm.inheritance.st.entities.SalesManager;
import com.jpm.inheritance.st.util.JPAUtil;

public class ClientInheritanceST {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		
//emp obj
		Employee emp = new Employee("A",999.99);
				
//mgr obj
		Manager mgr = new Manager("B", 888.50,700.50);
//smgr obj
		SalesManager smgr= new SalesManager( "C", 777.66,100.66,50.55);
//persist them
		em.getTransaction().begin();
		em.persist(emp);
		em.persist(mgr);
		em.persist(smgr);
		em.getTransaction().commit();
//commit tx		
		
		em.close();
	}
}
