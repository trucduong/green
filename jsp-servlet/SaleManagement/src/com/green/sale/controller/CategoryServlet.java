package com.green.sale.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.sale.dao.CategoryDao;
import com.green.sale.entity.Category;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Xử lý hiển thị trang cateogry list
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
	    CategoryDao categoryDao = new CategoryDao();
	    List<Category> categoryList = categoryDao.findAll();

	    // Gán danh sách category vào request attribute
	    request.setAttribute("_categoryList", categoryList);
	    request.getRequestDispatcher("WEB-INF/category.jsp").forward(request, response);
	}
}
