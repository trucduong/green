package com.green.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.example.entity.Contact;
import com.green.example.model.ContactModel;
import com.green.example.service.ContactService;

//localhost:8080/spring-mvc/contact

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	//localhost:8080/spring-mvc/contact
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		
		List<Contact> contacts = contactService.search(null);
		model.addAttribute("contacts", contacts);
		
		return "contact-list"; // WEB-INF/view/contact-list.jsp
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView list() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("contact-list");
//		
//		List<Contact> contacts = contactService.search(null);
//		model.addObject("contacts", contacts);
//		
//		return model; // WEB-INF/view/contact-list.jsp
//	}
	
	// localhost:8080/spring-mvc/contact/create
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		
		ContactModel contact = new ContactModel();
		model.addAttribute("contact", contact);
		
		return "contact-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute("contact") ContactModel contact, 
			BindingResult result, Model model) {
		
		// validate inputed contact info and convert to entity
		if (result.hasErrors()) {
			return "contact-detail";
		}
		
		// save contact info
		Contact c = contact.toContact();
		contactService.createContact(c);
		
		// back to contact list page
		return "redirect:/contact";
	}
	
	// http://localhost:8080/spring-mvc/contact/update?contactId=1
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(name="contactId") Long contactId, Model model) {
		
		Contact c = contactService.findContact(contactId);
		if (c == null) {
			return "redirect:/contact";
		}
		
		ContactModel contactModel = new ContactModel();
		contactModel.fromContact(c);
		
		model.addAttribute("contact", contactModel);
		
		return "contact-detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String handleUpdate(@RequestParam(name="contactId") Long contactId,
			@ModelAttribute("contact") ContactModel contact, 
			BindingResult result, Model model) {
		
		// validate inputed contact info and convert to entity
		if (result.hasErrors()) {
			return "contact-detail";
		}
		
		// save contact info
		
		// back to contact list page
		return "redirect:/contact";
	}
}
