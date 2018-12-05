package com.jpm.otm.client;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jpm.otm.entity.Department;
import com.jpm.otm.entity.Employee;
import com.jpm.otm.util.JPAUtil;

public class OTMClient {

	public static void main(String[] args) {
		// step 1: obtain entityManager object
		EntityManager entityManager = JPAUtil.geEntityManager();
		
		// step 2: create the object ot be persisted
		// a. dept obj
		Department department = new Department();
		department.setDeptId(20L);
		department.setDeptName("IT");

		//b. emp obj
		Employee e1 = new Employee();
		e1.setEmpId(101L);
		e1.setEmpName("Zara");
		e1.setEmpSal(99.99);
		
		//c. set department
		e1.setDepartment(department);
		
		//b. emp obj2
		Employee e2 = new Employee();
		e2.setEmpId(101L);
		e2.setEmpName("Zara");
		e2.setEmpSal(99.99);
		
		//c. set department
		e2.setDepartment(department);
		
		//d. create the set of employees and set to the department
		Set<Employee> employees = new HashSet<>();
		// adding the employee obj to the HashSet
		employees.add(e1);employees.add(e2);
		
		//set the employees set in Department object
		department.setEmployees(employees);
		
		//begin transaction
		entityManager.getTransaction().begin();
		//persist the department
		entityManager.persist(department);
		
		//commit transaction
		entityManager.getTransaction().commit();
		
		//close em
		entityManager.close();
	}

}
