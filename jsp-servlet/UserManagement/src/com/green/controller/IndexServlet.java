package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.AccountDao;
import com.green.entity.Account;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// lấy danh sách Account từ DB
		AccountDao accountDao = new AccountDao();
		List<Account> accountList = accountDao.findAll();
		
		// set danh sách account tìm được vào request
		request.setAttribute("account_list", accountList);
		
		// show home page
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
}
