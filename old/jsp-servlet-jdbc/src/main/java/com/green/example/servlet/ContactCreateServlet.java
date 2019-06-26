package com.green.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.example.entity.Contact;
import com.green.example.model.ContactDetailModel;
import com.green.example.service.ContactService;

@WebServlet(name = "ContactCreateServlet",
		urlPatterns = "/contact/create")
public class ContactCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContactService contactService;
	
	public ContactCreateServlet() {
		contactService = new ContactService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactDetailModel model = new ContactDetailModel();
		
		Contact contact = new Contact();
		model.setContact(contact);
		
		req.setAttribute("model", model);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/contact-detail.jsp");
        dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parse request to model
		ContactDetailModel model = new ContactDetailModel(req);
		
		// get contact object form model
		Contact contact = model.getContact();
		
		// call service to insert contact
		contactService.createContact(contact);
		
		// back to home page
		resp.sendRedirect(req.getContextPath() + "/contact");
	}
}
