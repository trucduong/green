package com.green.sale.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.sale.entity.Account;

// Nếu đã login thì không được truy cập vào các trang bên dưới
//@WebFilter(urlPatterns = {
//        "",
//        "/login",
//        "/regis"
//})
public class LoginRedirectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest htttpRequest = (HttpServletRequest) request;
        HttpSession session = htttpRequest.getSession();
        Account currentUser = (Account) session.getAttribute("CURRENT_USER");
        
        // Nếu đã login thì redirect về trang sale
        if (currentUser != null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(htttpRequest.getContextPath() + "/sale");
            return;
        }
        
        // thực hiện các filter tiếp theo
        chain.doFilter(request, response);
    }
}
