package com.jp.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

@Repository("daoDS")
public class DaoEmployeeImplJPA implements DaoEmployee {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmpList() throws HrException {
		String sql = "SELECT e FROM empRec e";
		Query qry = entityManager.createQuery(sql);
		
		List<Employee> empList = qry.getResultList();
		return empList;
	}
	
	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		Employee emp = entityManager.find(Employee.class, empId);
		return emp;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean insertNewRecord(Employee emp) throws HrException {
		entityManager.persist(emp);
		return true;
	}

}
