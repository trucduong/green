package com.green.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.example.model.User;
import com.green.example.service.UserService;

@WebServlet(
		  name = "LoginController", 
		  urlPatterns = "/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
 
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserService service = new UserService();
		User user = service.authenticate(username, password);
		if (user == null) {
			req.setAttribute("error", "Incorrect username or password.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
	        dispatcher.forward(req, resp);
	        return;
		}
		
		req.getSession(true).setAttribute("authUser", username);
		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
