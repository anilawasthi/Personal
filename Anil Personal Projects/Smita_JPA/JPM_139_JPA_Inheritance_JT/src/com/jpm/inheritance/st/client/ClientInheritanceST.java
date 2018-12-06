package com.jpm.inheritance.st.client;

import javax.persistence.EntityManager;

import com.jpm.inheritance.st.entities.Employee;
import com.jpm.inheritance.st.entities.Manager;
import com.jpm.inheritance.st.entities.SalesManager;
import com.jpm.inheritance.st.util.JPAUtil;

public class ClientInheritanceST {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
// EMP obj
		Employee emp = new Employee("A", 999.99);

		
// MGR obj
		Manager mgr = new Manager("B", 888.50,700.50);

		
// SMGR obj
		SalesManager smgr = new SalesManager("C", 888.50, 700.50, 1000.10);
		
//persist them
		em.persist(emp);
		em.persist(mgr);
		em.persist(smgr);
		
		
//commit tx
		em.getTransaction().commit();
		em.close();
		
	}
}
