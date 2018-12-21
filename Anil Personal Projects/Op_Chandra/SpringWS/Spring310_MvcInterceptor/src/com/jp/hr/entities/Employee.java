package com.jp.hr.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	private int empNo;
	
	@NotNull
	@Size(min = 3, max = 20, message="Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Name has invalid characters")
	private String eName;
	
	@NotNull
	@Size(min = 3, max = 20, message="Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Name has invalid characters")
	private String salary;
	
	public Employee(int empNo, String eName, String salary) {
		this.empNo = empNo;
		this.eName = eName;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	
	public int getEmpId() {  // Property name: empId
		return empNo;
	}

	public void setEmpId(int empId) {
		this.empNo = empId;
	}

	public String getFirstName() {  // firstName
		return eName;
	}

	public void setFirstName(String firstName) {
		this.eName = firstName;
	}

	public String getLastName() {	// lastName
		return salary;
	}

	public void setLastName(String lastName) {
		this.salary = lastName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empNo + ", firstName=" + eName + ", lastName=" + salary + "]";
	}
}
