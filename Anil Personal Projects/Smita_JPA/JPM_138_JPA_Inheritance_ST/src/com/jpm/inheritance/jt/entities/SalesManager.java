package com.jpm.inheritance.jt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SMGR_JT")

public class SalesManager extends Manager {
	@Column(name="commission")
	private double commission;

	public SalesManager() {
		
	}
	
	public SalesManager(String empName, Double empSal, double bonus, double commission) {
		super(empName, empSal, bonus);
		this.commission = commission;
	}

	
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}


	@Override
	public String toString() {
		return "SalesManager [commission=" + commission + ", toString()=" + super.toString() + "]";
	}

	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+commission;
	}
	
	
	
}
