package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.AccountDao;
import com.green.entity.Account;
import com.green.exception.MyException;
import com.green.service.AccountService;
import com.green.util.SpringUtil;


// http://localhost:8080/UserManagement/login

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String LOGIN_PAGE = "/WEB-INF/login.jsp";
	
	private AccountService accountService;
	
	public LoginServlet() {
		accountService = SpringUtil.getContext().getBean(AccountService.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// kiem tra
		if (username == null || username.isEmpty()) {
			request.setAttribute("error", "Vui long nhap username.");
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;
		}
		
		if (password == null || password.isEmpty()) {
			request.setAttribute("error", "Vui long nhap password.");
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;
		}
		
		Account account;
		try {
			account = accountService.login(username, password);
			
		} catch(MyException le) {
			request.setAttribute("error", le.getMessage());
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Loi, vui long thu lai");
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;
		}
		
		// luu thong tin account vao session
		HttpSession session = request.getSession();
		session.setAttribute("current_user", account);
		
		// quay ve trang Index va hien thi danh sach account.
		response.sendRedirect(request.getContextPath() + "/");
	}

}
