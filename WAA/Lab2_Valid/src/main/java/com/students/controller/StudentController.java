package com.students.controller;

import com.students.domain.Student;
import com.students.repository.GenderRepository;
import com.students.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StudentController {
	@Autowired
	private GenderService genderService;

	@RequestMapping(value="/registration",method=RequestMethod.GET)	
	    public String showForm(@ModelAttribute("student") Student student, Model model){
 	        return "registration";
	    }
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	    public String processForm(@ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
			if(bindingResult.hasErrors())
				return "registration";
			return "success";
	    }


}

	

