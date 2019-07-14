package com.green.sale.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.sale.dao.CategoryDao;
import com.green.sale.dao.ProductDao;
import com.green.sale.entity.Category;
import com.green.sale.entity.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Xử lý hiển thị trang product list
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
	    
	    // Gán danh sách category vào request attribute
	    CategoryDao categoryDao = new CategoryDao();
	    List<Category> categoryList = categoryDao.findAll();
        request.setAttribute("_categoryList", categoryList);
	    
        // Tìm danh sách product theo category
	    ProductDao productDao = new ProductDao();
	    List<Product> productList;
	    
	    String categoryCode = request.getParameter("categoryCode");
	    if (categoryCode == null || categoryCode.isEmpty()) {
	        productList = productDao.findAll();
	    } else {
	        productList = productDao.findByCategory(Integer.parseInt(categoryCode));
	    }
	    
	    // Gán danh sách product vào request attribute
	    request.setAttribute("_productList", productList);

	    request.getRequestDispatcher("WEB-INF/product.jsp").forward(request, response);
	}
}
