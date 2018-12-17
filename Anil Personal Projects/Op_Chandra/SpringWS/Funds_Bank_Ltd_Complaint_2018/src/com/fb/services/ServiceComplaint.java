package com.fb.services;

import java.util.List;

import com.fb.entities.Complaint;
import com.fb.exceptions.CompException;

public interface ServiceComplaint {
	
	public List<Complaint> getCompList() throws CompException;

}
