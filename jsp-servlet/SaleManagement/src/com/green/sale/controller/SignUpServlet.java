package com.green.sale.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regis")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/regis.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy thông tin đăng ký người dùng đã nhập từ request
	    
	    // kiểm tra thông tin đăng ký
	    
	    // Kiểm tra email đã tồn tại hay chưa (gọi phương thức isExist của class AccountDao)
	    
	    // Khởi tạo giá trị ngẩu nhiên cho mật khẩu
	    
	    // gửi email xác nhận (mật khẩu được gửi kèm trong nội dung email)
        // EmailUtils.send(to, subject, htmlMessage)
	    
	    // Lưu thông tin vào db
	    
	    // quay về trang index
	}
}
