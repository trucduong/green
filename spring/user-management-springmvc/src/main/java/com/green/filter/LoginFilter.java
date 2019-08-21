package com.green.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.entity.Account;

@WebFilter(urlPatterns={
		"/",
		"/detail"
})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		// Lấy thông tin user từ session
		HttpSession session = request.getSession();
		Account currentUser = (Account) session.getAttribute("current_user");
		
		// nếu chưa login thì tự động chuyển qua trang login
		if (currentUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
