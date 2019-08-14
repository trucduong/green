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
import com.green.util.SpringUtil;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountDao accountDao;
	
	public IndexServlet() {
//		accountDao = (AccountDao) SpringUtil.getContext().getBean("accountDao");
		accountDao = SpringUtil.getContext().getBean(AccountDao.class);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// lấy danh sách Account từ DB
		List<Account> accountList = accountDao.findAll();
		
		// set danh sách account tìm được vào request
		request.setAttribute("account_list", accountList);
		
		// show home page
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
}
