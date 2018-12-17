package com.fb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fb.daos.DaoComplaint;
import com.fb.entities.Complaint;
import com.fb.exceptions.CompException;

@Service("service")
public class ServiceComplaintImpl implements ServiceComplaint{

	private DaoComplaint daoComp;
	
	public ServiceComplaintImpl() throws CompException {
		
	}
	
	@Autowired
	public ServiceComplaintImpl(@Qualifier("daoDS") DaoComplaint daoComp) throws CompException {
		this.daoComp = daoComp;
	}
	@Override
	public List<Complaint> getCompList() throws CompException {
		return daoComp.getCompList();
	}
}
