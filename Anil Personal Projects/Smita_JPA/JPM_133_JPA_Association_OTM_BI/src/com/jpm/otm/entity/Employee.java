package com.jpm.otm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
	@Table(name="EMP_OTM")
	public class Employee implements Comparable<Employee>{
		
		@Id
		@Column(name="EMP_ID")
		private Long empId;
		
		@Column(name="EMP_NAME")
		private String empName;
		
		@Column(name="EMP_SAL")
		private Double empSal;
		
		
		@ManyToOne
		@JoinColumn(name = "DEPT_ID") // NAME OF THE COLUMN WHICH WILL BE CREATED IN EMP_OTM TABLE
		private Department department;

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Employee() {
			super();
		}

		public Long getEmpId() {
			return empId;
		}

		public void setEmpId(Long empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public Double getEmpSal() {
			return empSal;
		}

		public void setEmpSal(Double empSal) {
			this.empSal = empSal;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", department="
					+ department.getDeptId() + "]";
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return obj.hashCode()==this.hashCode();
		}

		@Override
		public int hashCode() {
			// We created this method because we want to give a unique hash value to empId sicne if we have multiple empId's then it will clash
			return empId.intValue(); // this line (empId.intValue) was written becuase we wanted to convert Long to int  
		}

		@Override
		public int compareTo(Employee o) {
			// comparing the emp obj with empId
			return (int) (this.empId-o.empId);
			// Compare to object checks the below 3 things
			//1 if first object is greater
			//-1  if first object is smaller
			//0 if both are equal
		}		
}
	

