package com.jpm.inheritance.tpc.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SMGR_TPC")
@AttributeOverrides({
	@AttributeOverride(column=@Column(name="EMP_ID"), name="empId"),
	@AttributeOverride(column=@Column(name="EMP_ID"), name="empName"),
	@AttributeOverride(column=@Column(name="EMP_SAL"), name="empSal"),
	@AttributeOverride(column=@Column(name="BONUS"), name="bonus"),
})
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
