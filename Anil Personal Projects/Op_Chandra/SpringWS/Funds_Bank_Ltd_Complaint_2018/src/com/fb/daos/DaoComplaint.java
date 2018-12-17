package com.fb.daos;

import java.util.ArrayList;

import com.fb.entities.Complaint;
import com.fb.exceptions.CompException;

public interface DaoComplaint {
	
	public ArrayList<Complaint> getCompList() throws CompException;

	/*public Complaint getCompDetails(int empId) throws CompException;*/

	public boolean insertNewRecord(Complaint emp) throws CompException;

}
