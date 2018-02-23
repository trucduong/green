package com.green.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		model.setViewName("home");
		
		
		return model;
	}
}
