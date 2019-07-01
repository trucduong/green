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

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/detail")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDao accountDao = new AccountDao();
		
		HttpSession session = request.getSession();

		// lay username được truyền qua từ trang home
		// http://localhost:8080/UserManagement/detail?u=admin
		String username = request.getParameter("u");
		if (username != null) { // update
			Account account = accountDao.findByUsername(username);
			request.setAttribute("ACCOUNT", account);
			
			session.setAttribute("MODE", "UPDATE");
		} else { // create
			session.setAttribute("MODE", "CREATE");
		}

		request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mode = (String) session.getAttribute("MODE");
		
		if ("CREATE".equals(mode)) {
			create(request, response);
			
		} else {
			String action = request.getParameter("btnAction");
			if ("update".equals(action)) { // nhấn butotn Update
				update(request, response);
			} else { // nhấn button Delete
				delete(request, response);
			}
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
		AccountDao accountDao = new AccountDao();
		boolean result = accountDao.insert(account);
		if (result) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("ERROR", "Loi, Vui long thu lai.");
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDao accountDao = new AccountDao();
		
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
		boolean result = accountDao.update(account.getUsername(), account);
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
		
		AccountDao accountDao = new AccountDao();
		boolean result = accountDao.delete(username);
		if (result) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("ERROR", "Loi, Vui long thu lai.");
			request.getRequestDispatcher("/WEB-INF/user-detail.jsp").forward(request, response);
		}
		
	}
}
