package com.jp.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jp.hr.daos.DaoEmployee;
import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
import com.jp.hr.exceptions.HrException;

/*
 * One layer refers to another layer through interface only.
 * Implementation of a business rule should be done here in absence of separate business layer.
 * This layer will also ensure only custom exceptions to come out.
 * 
 * Features:
 * 	* Only one gateway with preserving privacy of inner classes.
 * 	* One point for implementing security, txn mgmt, caching.
 * 	* Multiple interfaces per client to give restricted view of all services.
 * 	* Facade (Gang of Four) pattern. (one point to implement)
 * 	* DAO is a JEE pattern.
 * 	* Implemented singleton by creating single object of outermost class.
 * 	* Delegates and controls cross cutting concerns(dispersing in different layers).
 * 
 */

@Service("service")
public class ServiceEmployeeImpl implements ServiceEmployee {

	private DaoEmployee daoEmp; // One layer refers to another layer through
								// interface only.

	public ServiceEmployeeImpl() throws HrException {
		// daoEmp = new DaoEmployeeImpl();
	}

	@Autowired // by name in @Qualifier
	public ServiceEmployeeImpl(@Qualifier("daoDs") DaoEmployee daoEmp) throws HrException {
		this.daoEmp = daoEmp;
	}

	@Override
	public List<Emp> getEmpList() throws HrException {
		return daoEmp.getEmpList();

	}

	@Override
	public List<Dept> getDeptList() throws HrException {
		return daoEmp.getDeptList();
	}

	@Override
	public Emp getEmpDetails(int empId) throws HrException {
		return daoEmp.getEmpDetails(empId);

	}

	@Override
	public Dept getDeptDetails(int deptId) throws HrException {
		return daoEmp.getDeptDetails(deptId);
	}

	/*@Override
	public boolean addNewEmployee(Emp emp) throws HrException {
		// TODO Auto-generated method stub
		return false;
	}*/

	/*@Override
	public boolean addNewEmployee(Emp emp) throws HrException {
		return daoEmp.insertNewRecord(emp);
	}
*/
}
