package com.green.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.green.example.entity.Contact;
import com.green.example.model.ContactDetailModel;
import com.green.example.service.ContactService;

import utils.Constants;

@WebServlet(
		  name = "ContactDetailController", 
		  urlPatterns = "/contact-detail")
public class ContactDetailController extends BaseAuthController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ContactService contactService;
	
	public ContactDetailController() {
		contactService = new ContactService();
	}

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
		
		ContactDetailModel model = new ContactDetailModel();
		
		String contactIdParam = req.getParameter("contactId");
		
		// update mode
		if (contactIdParam != null && contactIdParam.length() > 0) {
			long contactId = Long.parseLong(contactIdParam);
			Contact contact = contactService.findContact(contactId);
			if (contact != null) {
				model.setContact(contact);
			} else {
				
				// Error contact not found
				model.setErrContactNotFound(true);
				model.setId(contactId);
			}
			
		// create mode
		} else {
			model.setContact(new Contact());
		}
		
		// view
		req.setAttribute("model", model);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/contact-detail.jsp");
        dispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case Constants.DELETE:
			RequestDispatcher dispatcher = req.getRequestDispatcher("/contact");
		    dispatcher.forward(req, resp);
			break;
		case Constants.CREATE:
			handleCreate(req, resp);
			break;
		case Constants.UPDATE:
			handleUpdate(req, resp);
			break;

		default:
			// back to home page
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}
	
	private void handleCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// parse request to model
		ContactDetailModel model = new ContactDetailModel(req);
		
		// get contact object form model
		Contact contact = model.getContact();
		
		// call service to insert contact
		contactService.createContact(contact);
		
		// back to home page
		resp.sendRedirect(req.getContextPath() + "/home");
	}
	
	private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
	}
}
