package com.jpm.inheritance.tpc.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MGR_TPC")
@AttributeOverrides({
	@AttributeOverride(column=@Column(name="EMP_ID"), name="empId"),
	@AttributeOverride(column=@Column(name="EMP_ID"), name="empName"),
	@AttributeOverride(column=@Column(name="EMP_SAL"), name="empSal"),
})
public class Manager extends Employee {
	private double bonus;

	public Manager() {
		
	}
	
	public Manager(String empName, Double empSal, double bonus) {
		super(empName, empSal);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
	}

	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+bonus;
	}
	
	
	
}
