package com.fb.controllers;

import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fb.entities.Complaint;
import com.fb.exceptions.CompException;
import com.fb.services.ServiceComplaint;

@Controller
public class HomePageController {
	
	@Autowired
	@Qualifier("service")
	private ServiceComplaint compService;
	
	private Validator validator;
	
	@InitBinder
	private void validateBinder() {
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		validator = validationFactory.getValidator();
	}
	
	@RequestMapping("homePage.hr")
	public String getHomePage(Model model){
		System.out.println("In getHomePage()");
		Complaint comp = new Complaint();
		model.addAttribute("compCommand", comp);
		return "HomePage";
	}
	
	@RequestMapping("getCompList.hr")
	public ModelAndView getCompList(){
		ModelAndView mAndV = new ModelAndView();
		try {
			List<Complaint> compList = compService.getCompList();
			mAndV.addObject("compList", compList);
			
			mAndV.setViewName("CompList");
			
		} catch (CompException e) {
			e.printStackTrace();
		}
		return mAndV;
	}
}
