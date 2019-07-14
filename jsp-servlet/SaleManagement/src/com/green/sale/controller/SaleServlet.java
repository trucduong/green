package com.green.sale.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sale")
public class SaleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy điều kiện tìm kiếm từ request
        String productName = request.getParameter("productName");
        String categoryCode = request.getParameter("categoryCode");
        
        // gọi phương thức findByNameAndCategory của class ProductDao để tìm danh sách product 
        
        // gán danh sách procuct tìm được và request attribute
        
        request.getRequestDispatcher("WEB-INF/sale.jsp").forward(request, response);
    }
}
