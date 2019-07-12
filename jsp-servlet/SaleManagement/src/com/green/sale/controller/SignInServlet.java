package com.green.sale.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin đăng ký người dùng đã nhập từ request
        
        // kiểm tra email và password khác rỗng
        
        // kiểm tra email và password đúng với db (gọi phương thức findByEmail của class AccountDao)
        
        // lưu thông tin user vào session với key là CURRENT_USER
        //HttpSession session = request.getSession();
        //session.setAttribute("CURRENT_USER", account);
        

        // redirect qua trang sale
    	response.sendRedirect(request.getContextPath() + "/sale");
    }
}
