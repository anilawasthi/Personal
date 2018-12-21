package com.jp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;



/*
 * @Controller: A kind of @Component to declare SpringMVC controllers.
 * @RequestMapping: To map a controlling method to the URL.
 * @RequestParam: To take single QueryString or FormData field value.
 * 
 * Multi-action controllers.
 * 
 * http://localhost:8080/Spring300_MvcJpaRestNg/hr/countries
 * http://localhost:8080/Spring300_MvcJpaRestNg/hr/empDetails?id=12
 * http://localhost:8080/Spring300_MvcJpaRestNg/hr/submitForm/17/Rashmi/Tawde
 */


@RestController
public class HomePageController {
	@Autowired
	@Qualifier("service")
	private ServiceEmployee empService;
	
	@RequestMapping(value = "/countries",method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> getEmpList() {
		List<Employee> empList = null;
		try {
			empList = empService.getEmpList();
		}catch (HrException e) {
			e.printStackTrace();
		}
		return empList;
	}
	

	
	@RequestMapping(value="/empDetails1", method = RequestMethod.GET, headers="Accept=application/json")
	public Employee getEmpDetails1(@RequestParam ("id") int empId){
		Employee emp = null;
		try {
			 emp = empService.getEmpDetails(empId);
			
		} catch (HrException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	@RequestMapping(value="/empDetails2/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public Employee getEmpDetails2(@PathVariable ("id") int empId){
		Employee emp = null;
		try {
	
			 emp = empService.getEmpDetails(empId);
			 
		} catch (HrException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	@RequestMapping(value="/submitForm/{id}/{nameF}/{nameL}", method = RequestMethod.GET, headers="Accept=application/json")
	public String submitRegistrationForm(@PathVariable ("id")int id,  @PathVariable ("nameF")String nameF, @PathVariable ("nameL")String nameL) throws HrException{
		Employee emp = new Employee(id, nameF, nameL);
		
		empService.joinNewEmployee(emp);
		return "Record inserted";
	}
}
