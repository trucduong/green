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

import utils.SpringUtils;

@WebServlet(name = "ContactUpdateServlet",
		urlPatterns = "/contact/update")
public class ContactUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContactService contactService;
	
	public ContactUpdateServlet() {
		contactService = SpringUtils.getApplicationContext().getBean(ContactService.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactDetailModel model = new ContactDetailModel();
		
		String contactIdParam = req.getParameter("contactId");
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
			
		}
		
		req.setAttribute("model", model);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/contact-detail.jsp");
        dispatcher.forward(req, resp);
	}

}
