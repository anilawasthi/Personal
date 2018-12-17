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

import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;

/*
 * @Controller : A kind of @Component to declare Srping MVC controllers.
 * @RequestMapping: To map a controlling method to the URL
 * @RequestParam: To take single Query String or form data field value
 *  
 *  Multi action controllers - multiple methods
 */

@Controller
public class HomePageController {

	@Autowired
	@Qualifier("service")
	private ServiceEmployee service;

	private Validator validator;

	@InitBinder
	private void validatorBinder() {
		ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
		validator = valFac.getValidator();
	}

	@RequestMapping("homePage.hr")
	public String getHomePage() {
		System.out.println("In getHomePage()");
		return "HomePage";
	}

	@RequestMapping("getEmpList.hr")
	public ModelAndView getEmpList() {
		ModelAndView mAndV = new ModelAndView();
		try {
			List<Emp> empList = service.getEmpList();
			System.out.println(empList);
			mAndV.addObject("empList", empList);

			mAndV.setViewName("EmpList");

		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mAndV;
	}
	
	
	@RequestMapping("getDeptList.hr")
	public ModelAndView getDeptList() {
		ModelAndView mAndV = new ModelAndView();
		try {
			List<Dept> deptList = service.getDeptList();
			System.out.println(deptList);
			mAndV.addObject("deptList", deptList);

			mAndV.setViewName("DeptList");

		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mAndV;
	}
	

	@RequestMapping("empDetails.hr")
	public ModelAndView getEmpDetails(@RequestParam("id") int empId) {
		// public ModelAndView getEmpDetails(HttpServletRequest request) {
		// String strEmpId = request.getParameter("id");
		// int empId = Integer.parseInt(strEmpId);

		ModelAndView mAndV = new ModelAndView();
		try {
			Emp emp = service.getEmpDetails(empId);

			mAndV.addObject("empDetails", emp);

			mAndV.setViewName("EmpDetails");

		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mAndV;
	}
	
	@RequestMapping("deptDetails.hr")
	public ModelAndView getDeptDetails(@RequestParam("id") int deptId) {
		// public ModelAndView getEmpDetails(HttpServletRequest request) {
		// String strEmpId = request.getParameter("id");
		// int empId = Integer.parseInt(strEmpId);

		ModelAndView mAndV = new ModelAndView();
		try {
			Dept dept = service.getDeptDetails(deptId);
			mAndV.addObject("deptDetails", dept);
			mAndV.setViewName("DeptDetails");
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

	@RequestMapping("registrationForm.hr")
	public String getRegistrationForm(Model model) {
		// Define command object
		Emp emp = new Emp();
		model.addAttribute("command", emp);

		return "EntryPage";
	}

	/*@RequestMapping("submitRegistrationData.hr")
	public String submitRegistrationForm(@ModelAttribute("command") Emp emp, BindingResult result, Model model) {

		Set<ConstraintViolation<Emp>> violations = validator.validate(emp);

		for (ConstraintViolation<Emp> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			// Add JSR-303 errors to BindingResult. This allows Spring to
			// display them in view via a FieldError
			FieldError error = new FieldError("command", propertyPath, "Invalid " + propertyPath + "(" + message + ")");
			result.addError(error);
		}
		if (result.hasErrors()) {
			model.addAttribute("msg", "Error(s) in entry!!!  ");
			return "EntryPage";
		} else {
			try {
				service.addNewEmployee(emp);
				return "SaveSuccess";
			} catch (HrException e) {
				model.addAttribute("msg", "Insert Failed! Try re-entering it!!!  " + e.getMessage());
				return "EntryPage";
			}
		}

	}*/

}
