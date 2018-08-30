package com.green.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.example.service.ContactService;

@WebServlet(name = "ContactDeleteServlet",
		urlPatterns = "/contact/delete")
public class ContactDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ContactService contactService;

	public ContactDeleteServlet() {
		contactService = new ContactService();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contactIdParam = req.getParameter("contactId");
		if (contactIdParam == null || contactIdParam.length() == 0) {
			resp.sendRedirect(req.getContextPath() + "/contact");
			return;
		}
		
		long contactId = Long.parseLong(contactIdParam);
		contactService.deleteContact(contactId);
		
		resp.sendRedirect(req.getContextPath() + "/contact");
	}
}
