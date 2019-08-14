package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.AccountDao;
import com.green.entity.Account;
import com.green.service.AccountService;
import com.green.util.SpringUtil;

@WebServlet("/detail")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountService accountService;
	
	public UserDetailServlet() {
		accountService = SpringUtil.getContext().getBean(AccountService.class);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = (String) request.getParameter("action");
		
		if (action == null) {
			action = "CREATE";
		} else if (action.equals("UPDATE")) {
			String username = request.getParameter("username");
			Account account = accountService.findByUsername(username);
			request.setAttribute("ACCOUNT", account);
		}

		request.setAttribute("action", action);
		request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			// loi, quay ve trang index
			request.getRequestDispatcher(request.getContextPath()).forward(request, response);
		} else if (action.equals("CREATE")) {
			create(request, response);
		} else if (action.equals("UPDATE")) {
			update(request, response);
		} else if (action.equals("DELETE")) {
			delete(request, response);
		} else {
			// loi, quay ve trang index
			request.getRequestDispatcher(request.getContextPath()).forward(request, response);
		}
		
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lấy thông tin đc nhập
		Account account = new Account();
		account.setUsername(request.getParameter("username"));
		account.setPassword(request.getParameter("password"));
		account.setFullName(request.getParameter("fullName"));
		account.setEmail(request.getParameter("email"));

		// kiểm tra thông tin đc nhập
		if (account.getUsername() == null || account.getUsername().isEmpty()) {
			request.setAttribute("ERROR", "Vui lòng nhập user name.");
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
			return;
		}

		if (account.getPassword() == null || account.getPassword().isEmpty()) {
			request.setAttribute("ERROR", "Vui lòng nhập password.");
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
			return;
		}
		// email, full name

		// insert vào DB
		boolean result = accountService.insert(account);
		if (result) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("ERROR", "Loi, Vui long thu lai.");
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lấy thông tin đc nhập
		Account account = new Account();
		account.setUsername(request.getParameter("username"));
		account.setPassword(request.getParameter("password"));
		account.setFullName(request.getParameter("fullName"));
		account.setEmail(request.getParameter("email"));

		// kiểm tra thông tin đc nhập
		if (account.getPassword() == null || account.getPassword().isEmpty()) {
			request.setAttribute("ERROR", "Vui lòng nhập password.");
			request.setAttribute("ACCOUNT", account); // giữ lại thông tin đang được nhập
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
			return;
		}
		// email, full name

		// update vào DB
		boolean result = accountService.update(account.getUsername(), account);
		if (result) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("ERROR", "Loi, Vui long thu lai.");
			request.setAttribute("ACCOUNT", account); // giữ lại thông tin đang được nhập
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		boolean result = accountService.delete(username);
		if (result) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("ERROR", "Loi, Vui long thu lai.");
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
		}
		
	}
}
