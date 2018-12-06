package com.jpm.inheritance.jt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MGR_JT")

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
