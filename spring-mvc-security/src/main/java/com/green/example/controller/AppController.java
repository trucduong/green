package com.green.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;
	
	@GetMapping
	public String index() {
		return "redirect:/contact";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		// check login status
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authenticationTrustResolver.isAnonymous(authentication)) {
			return "login";
		}
		
		return "redirect:/contact";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout=true";
    }
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        return "denied";
    }

}
