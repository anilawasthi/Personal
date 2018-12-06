package com.jpm.oto.client;

import javax.persistence.EntityManager;

import com.jpm.oto.entities.Address;
import com.jpm.oto.entities.Employee;
import com.jpm.oto.util.JPAUtil;

public class ClientOTO {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
// address obj
		Address homeAddress = new Address();
		homeAddress.setAddressId(145L);
		homeAddress.setStreet("MG Road");
		homeAddress.setCity("Pune");
		homeAddress.setState("Maharashtra");
		homeAddress.setZipCode("411017");
//Employee obj
		Employee empObj = new Employee();
		empObj.setEmpId(1211L);
		empObj.setEmpName("Zara");
		empObj.setEmpSal(99.99);
//set address to empObj
		empObj.setAddress(homeAddress);
//set address to the empObj
		em.persist(empObj);
//commit tx
		em.getTransaction().commit();
		em.close();
	}
}
