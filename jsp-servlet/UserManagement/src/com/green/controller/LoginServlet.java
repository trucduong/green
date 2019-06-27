package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.green.dao.AccountDao;
import com.green.entity.Account;

/**
 * Servlet implementation class LoginServlet
 */

// http://localhost:8080/user/login

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String LOGIN_PAGE = "/WEB-INF/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		AccountDao accountDao = new AccountDao();
		Account account = accountDao.findByUsername(username);
		
		if (account == null) {
			request.setAttribute("error", "Username khong ton tai.");
			request.getRequestDispatcher(LOGIN_PAGE)
						.forward(request, response);
			return;
		}
		
		if (!password.equals(account.getPassword())) {
			request.setAttribute("error", "Password khong dung.");
			request.getRequestDispatcher(LOGIN_PAGE)
						.forward(request, response);
			return;
		}
		
		// luu thong tin account vao session
		HttpSession session = request.getSession();
		session.setAttribute("current_user", username);
		
		// quay ve trang Index va hien thi danh sach account.
		response.sendRedirect(request.getContextPath() + "/");
	}

}
