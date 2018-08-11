package com.green.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.example.entity.Contact;
import com.green.example.model.HomeModel;
import com.green.example.service.ContactService;

@WebServlet(
		  name = "HomeController", 
		  urlPatterns = "/home")
public class HomeController extends BaseAuthController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ContactService contactService;
	
	public HomeController() {
		contactService = new ContactService();
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
		
		// get input parameters
		String name = request.getParameter("name"); // contact name
		
		// declare model
		HomeModel model = new HomeModel();
		
		// get necessary data
		List<Contact> contacts = contactService.search(name);
		model.setContacts(contacts);
 
		// view
		request.setAttribute("model", model);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
        dispatcher.forward(request, response);
    }
}
