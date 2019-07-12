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

// Yêu cầu login đối với các request có path như bên dưới 
//@WebFilter(urlPatterns = {
//        "/sale/*",
//        "/category/*",
//        "/product/*",
//        "/profile/*"
//})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest htttpRequest = (HttpServletRequest) request;
        HttpSession session = htttpRequest.getSession();
        Account currentUser = (Account) session.getAttribute("CURRENT_USER");
        
        // Nếu chưa login thì redirect về trang index
        if (currentUser == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(htttpRequest.getContextPath());
            return;
        }
        
        // thực hiện các filter tiếp theo
        chain.doFilter(request, response);
    }
}
