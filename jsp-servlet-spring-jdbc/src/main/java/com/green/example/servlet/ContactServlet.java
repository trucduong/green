package com.green.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.example.entity.Contact;
import com.green.example.model.HomeModel;
import com.green.example.service.ContactService;

import utils.SpringUtils;

@WebServlet(name = "ContactServlet",
		urlPatterns = "/contact")
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ContactService contactService;

	public ContactServlet() {
		contactService = SpringUtils.getApplicationContext().getBean(ContactService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// declare model
		HomeModel model = new HomeModel();

		// get data
		List<Contact> contacts = contactService.findAll();
		model.setContacts(contacts);

		// view
		req.setAttribute("model", model);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/contact-list.jsp");
		dispatcher.forward(req, resp);
	}
}
