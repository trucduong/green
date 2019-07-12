package com.green.sale.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.green.sale.dao.CategoryDao;
import com.green.sale.dao.ProductDao;
import com.green.sale.entity.Category;
import com.green.sale.entity.Product;
import com.green.sale.utils.ApplicationConfig;

@WebServlet("/product/detail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletFileUpload uploader;
    private String PRODUCT_IMAGE_DIR;

    @Override
    public void init() throws ServletException {
        PRODUCT_IMAGE_DIR = ApplicationConfig.getConfig("image.dir.product");
        
        File filesDir = new File(PRODUCT_IMAGE_DIR);
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }

        FileItemFactory factory = new DiskFileItemFactory();
        uploader = new ServletFileUpload(factory);
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String action = request.getParameter("action");
	    String code = request.getParameter("code");
	    
	    if (action == null || action.isEmpty()) {
	        response.sendRedirect(request.getContextPath() + "/product");
	        return;
	    }
	    
	    // Lấy danh sách category và gán vào request attribute
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.findAll();
        request.setAttribute("_categoryList", categoryList);
	    
	    switch (action) {
            case "update":
                if(code == null || code.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/product");
                    break;
                }
                
                ProductDao productDao = new ProductDao();
                Product product = productDao.find(code);
                if (product == null) {
                    response.sendRedirect(request.getContextPath() + "/product");
                    break;
                }
                
                request.setAttribute("_product", product);
                request.setAttribute("action", "update");
                request.getRequestDispatcher("WEB-INF/product-detail.jsp").forward(request, response);
                break;

            case "create":
                request.setAttribute("_product", new Product());
                request.setAttribute("action", action);
                request.getRequestDispatcher("WEB-INF/product-detail.jsp").forward(request, response);
                break;
                
            default:
                response.sendRedirect(request.getContextPath() + "/product");
                break;
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
        
        if (action == null || action.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/product");
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
                response.sendRedirect(request.getContextPath() + "/product");
                break;
        }
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy thông tin product từ request
        
        // kiểm tra thông tin
        
        // lưu thông tin product vào database (gọi phương thức update trong ProductDao)
		
		// lấy hình product từ request và lưu vào ổ dĩa
        
        // chuyển về trang product list
        response.sendRedirect(request.getContextPath() + "/product");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin product từ request
	    
	    // kiểm tra thông tin
	    
	    // lưu thông tin product vào database (gọi phương thức update trong ProductDao)
		
		// lấy hình product từ request và lưu vào ổ dĩa
	    
	    // chuyển về trang product list
        response.sendRedirect(request.getContextPath() + "/product");
    }
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy categroy code từ request
	    String code = request.getParameter("code");
	    
	    // Kiểm tra 
	    if(code == null || code.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/product");
            return;
        }
	    
	    // Xóa product theo code
	    ProductDao productDao = new ProductDao();
	    productDao.delete(code);
	    
	    // chuyển về trang product list
	    response.sendRedirect(request.getContextPath() + "/product");
    }
}
