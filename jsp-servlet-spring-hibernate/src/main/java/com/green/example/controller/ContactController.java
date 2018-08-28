package com.green.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.example.service.ContactService;

import utils.Constants;
import utils.SpringUtils;

@WebServlet(
		  name = "ContactController", 
		  urlPatterns = "/contact")
public class ContactController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ContactService contactService;
	
	public ContactController() {
		contactService = SpringUtils.getApplicationContext().getBean(ContactService.class);
	}

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
		// back to home page and show contact list
		resp.sendRedirect(req.getContextPath() + "/home");
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case Constants.DELETE:
			handDelete(req, resp);
			break;

		default:
			// back to home page
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}
	
	private void handDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String contactIdParam = req.getParameter("contactId");
		if (contactIdParam != null && contactIdParam.length() > 0) {
			long contactId = Long.parseLong(contactIdParam);
			contactService.deleteContact(contactId);
		}
		
		// back to home page
		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
