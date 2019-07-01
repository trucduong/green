package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.AccountDao;
import com.green.entity.Account;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lấy thông tin user từ session
		HttpSession session = request.getSession();
		String currentUser = (String) session.getAttribute("current_user");
		
		// nếu chưa login thì tự động chuyển qua trang login
		if (currentUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		// lấy danh sách Account từ DB
		AccountDao accountDao = new AccountDao();
		List<Account> accountList = accountDao.findAll();
		
		// set danh sách account tìm được vào request
		request.setAttribute("account_list", accountList);
		
		// show home page
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
