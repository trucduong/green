package com.green.sale.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.sale.entity.Account;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Xử lý hiển thị trang profile
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
	    // lấy thông tin user đang đăng nhập
	    HttpSession session = request.getSession();
	    Account account = (Account) session.getAttribute("CURRENT_USER");

	    // gán thông tin user vào request attribute và hiển thị trên trang profile
	    request.setAttribute("_account", account);
	    request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
	}

	/**
	 * Xử lý cập nhật thông tin user
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy thông tin user người dùng đã nhập từ request
	    
	    // kiểm tra thông tin đăng ký
	    
	    // Kiểm tra email đã tồn tại hay chưa
	    
	    // gọi phương thức update của class AccountDao để lưu thông tin vào db
	    
	    // Cập nhật thông tin user trong session (CURRENT_USER)
	    
	    // hiển thị trang profile với thông tin mới nhất được lấy từ DB
	    doGet(request, response);
	}
}
