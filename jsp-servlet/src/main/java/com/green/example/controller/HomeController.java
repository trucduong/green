package com.green.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		  name = "HomeController", 
		  urlPatterns = "/home")
public class HomeController extends AuthServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
        dispatcher.forward(request, response);
    }
}
