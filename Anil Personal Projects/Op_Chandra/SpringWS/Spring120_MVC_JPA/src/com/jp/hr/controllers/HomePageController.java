package com.jp.hr.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;

// http://localhost:8080/Spring110_MVCbasics/homePage.do

/*
 * @Controller: A kind of @Component to declare SpringMVC controllers.
 * @RequestMapping: To map a controlling method to the URL.
 * @RequestParam: To take single QueryString or FormData field value.
 * 
 * Multi-Action controllers.
 */
@Controller
public class HomePageController {
	
	@Autowired
	@Qualifier("service")
	private ServiceEmployee empService; 
	
	private Validator validator;
	
	@InitBinder
	private void validateBinder(){
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		validator = validationFactory.getValidator();
	}
	
	@RequestMapping("homePage.hr")
	public String getHomePage(){
		System.out.println("In getHomePage()");
		return "HomePage";
	}
	
	@RequestMapping("getEmpList.hr")
	public ModelAndView getEmpList(){
		ModelAndView mAndV = new ModelAndView();
		try {
			List<Employee> empList = empService.getEmpList();
			mAndV.addObject("empList", empList);
			
			mAndV.setViewName("EmpList");
			
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}
	
	@RequestMapping("empDetails.hr")
	public ModelAndView getEmpDetails(@RequestParam("id") int empId){
		//String strEmpId = request.getParameter("id");
		//int empId = Integer.parseInt(strEmpId);
		ModelAndView mAndV = new ModelAndView();
		try {
			Employee emp = empService.getEmpDetails(empId);
			mAndV.addObject("empDetails", emp);
			
			mAndV.setViewName("EmpDetails");
			
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}
	
	@RequestMapping("registrationForm.hr")
	public String getRegistrationForm(Model model){
		// Define command object
		System.out.println("Inside Registration");
		Employee emp = new Employee();
		model.addAttribute("command", emp);
		return "EntryPage";
	}
	
	@RequestMapping("submitRegistrationData.hr")
	public String submitRegistrationForm(@ModelAttribute("command") Employee emp, BindingResult result, Model model){
		// Define command object
		System.out.println(emp);
		
Set<ConstraintViolation<Employee>> violations = validator.validate(emp);
    	
    	for (ConstraintViolation<Employee> violation : violations)
        {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult. This allows Spring to display them in view via a FieldError
            FieldError error = new FieldError("employee",propertyPath,
                    "Invalid "+ propertyPath + "(" + message + ")");
            result.addError(error);
        }
    	
    	if (result.hasErrors()) {
    		model.addAttribute("msg", "Errors in entry. ");
            return "EntryPage";
        } else {
        	try {
    			empService.addNewEmployee(emp);
    			return "SaveSuccess";
    		} catch (HrException e) {
    			model.addAttribute("msg", "Insert failed. " + e.getMessage());
    			return "EntryPage";
    		}
        }
	}
}
