package com.jp.hr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity(name="empRec")
@Table(name="EMPLOYEE2")
public class Employee {
	private int EMP_ID;
	
	@NotNull
	@Size(min = 3, max = 20, message="Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Name has invalid characters")
	private String FIRST_NAME;
	
	@NotNull
	@Size(min = 3, max = 20, message="Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Name has invalid characters")
	private String LAST_NAME;
	
	public Employee(int empId, String firstName, String lastName) {
		this.EMP_ID = empId;
		this.FIRST_NAME = firstName;
		this.LAST_NAME = lastName;
	}

	public Employee() {
		super();
	}

	@Id
	@Column(name="EMP_ID")
	public int getEmpId() {  // Property name: empId
		return EMP_ID;
	}

	public void setEmpId(int empId) {
		this.EMP_ID = empId;
	}

	@Column(name="FIRST_NAME")
	public String getFirstName() {  // firstName
		return FIRST_NAME;
	}

	public void setFirstName(String firstName) {
		this.FIRST_NAME = firstName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() {	// lastName
		return LAST_NAME;
	}

	public void setLastName(String lastName) {
		this.LAST_NAME = lastName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + EMP_ID + ", firstName=" + FIRST_NAME + ", lastName=" + LAST_NAME + "]";
	}
}
