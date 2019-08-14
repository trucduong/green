package com.green.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.close();
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
