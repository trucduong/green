package com.green.sale.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.sale.dao.CategoryDao;
import com.green.sale.entity.Category;

@WebServlet("/category/detail")
public class CategoryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String action = request.getParameter("action");
	    String codeStr = request.getParameter("code");
	    
	    if (action == null || action.isEmpty()) {
	        response.sendRedirect(request.getContextPath() + "/category");
	        return;
	    }
	    
	    switch (action) {
            case "update":
                if(codeStr == null || codeStr.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/category");
                    break;
                }
                
                int code = Integer.parseInt(codeStr);
                CategoryDao categoryDao = new CategoryDao();
                Category category = categoryDao.find(code);
                if (category == null) {
                    response.sendRedirect(request.getContextPath() + "/category");
                    break;
                }
                
                request.setAttribute("_category", category);
                request.setAttribute("action", "update");
                request.getRequestDispatcher("/WEB-INF/category-detail.jsp").forward(request, response);
                break;

            case "create":
                request.setAttribute("_category", new Category());
                request.setAttribute("action", action);
                request.getRequestDispatcher("/WEB-INF/category-detail.jsp").forward(request, response);
                break;
                
            default:
                response.sendRedirect(request.getContextPath() + "/category");
                break;
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
        
        if (action == null || action.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/category");
            return;
        }
        
        switch (action) {
            case "update":
                update(request, response);
                break;

            case "create":
                create(request, response);
                break;
                
            case "delete":
                delete(request, response);
                break;
                
            default:
                response.sendRedirect(request.getContextPath() + "/category");
                break;
        }
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy thông tin category từ request
        
        // kiểm tra thông tin
        
        // lưu thông tin category vào database (gọi phương thức update trong CategoryDao)
        
        // chuyển về trang category list
        response.sendRedirect(request.getContextPath() + "/category");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin category từ request
	    
	    // kiểm tra thông tin
	    
	    // lưu thông tin category vào database (gọi phương thức update trong CategoryDao)
	    
	    // chuyển về trang category list
        response.sendRedirect(request.getContextPath() + "/category");
    }
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy categroy code từ request
	    String code = request.getParameter("code");
	    
	    // Kiểm tra 
	    if(code == null || code.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/category");
            return;
        }
	    
	    // Xóa category theo code
	    CategoryDao categoryDao = new CategoryDao();
	    categoryDao.delete(Integer.parseInt(code));
	    
	    // chuyển về trang category list
	    response.sendRedirect(request.getContextPath() + "/category");
    }
}
