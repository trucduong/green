package com.green.sale.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.sale.dao.ProductDao;
import com.green.sale.entity.Cart;
import com.green.sale.entity.CartDetail;
import com.green.sale.entity.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    // kiểm thông tin giỏ hàng từ session
	    // và tạo mới nếu chưa tồn tại
        Cart cart = (Cart) request.getSession().getAttribute("CART");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("CART", cart);
        }
        
	    request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request, response);
	}

	/**
	 * Xử lý tăng/giảm/xóa sản phẩm trong giỏ hàng
	 * Request parameters:
	 *     mode: add / subtract / remove
	 *     productCode: mã sản phẩm được chọn
	 *     page: trang web sẽ hiển thị sau khi xử lý cập nhật giỏ hàng
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		String productCode = request.getParameter("productCode");
		
		String redirectPage = request.getParameter("page");
		if (redirectPage == null || redirectPage.isEmpty()) {
		    redirectPage = "sale";
		}
		
		// kiểm tra request parameters
		if (mode == null || mode.isEmpty()
		        || productCode == null || productCode.isEmpty()) {
		    response.sendRedirect(request.getContextPath() + "/" + redirectPage);
		    return;
		}
		
		switch (mode) {
            case "add":
                add(request, response);
                break;

            case "subtract":
                subtract(request, response);
                break;
                
            case "remove":
                remove(request, response);
                break;
            default:
                break;
        }
	    
		response.sendRedirect(request.getContextPath() + "/" + redirectPage);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // lấy thông tin giỏ hàng từ session
	    Cart cart = (Cart) request.getSession().getAttribute("CART");
	    if (cart == null) {
	        cart = new Cart();
	    }
	    
	    // lấy thông tin product từ request và database
	    int productCode = Integer.parseInt(request.getParameter("productCode"));
	    ProductDao productDao = new ProductDao();
	    Product product = productDao.find(productCode);
	    
	    // lấy thông tin product từ giỏ hàng
	    CartDetail cartDetail = cart.getDetails().get(productCode);
	    if (cartDetail == null) {
	        cartDetail = new CartDetail();
	        cartDetail.setProductCode(productCode);
	        cartDetail.setPrice(product.getPrice());
	        cartDetail.setProductName(product.getName());
	        cartDetail.setQuantity(1);
	        
	    } else {
	        int newQuantity = cartDetail.getQuantity() + 1;
	        cartDetail.setQuantity(newQuantity);
	    }
	    
	    long cartDetailTotal = cartDetail.getPrice() * cartDetail.getQuantity();
	    cartDetail.setTotal(cartDetailTotal);
	    
	    // cập nhật thông tin product trong giỏ hàng
	    cart.getDetails().put(productCode, cartDetail);
	    cart.calculate();
	    
	    // lưu thông tin cart vào session
	    request.getSession().setAttribute("CART", cart);
	}
	
	private void subtract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // sinh viên tự thực hiện phần này
    }
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // sinh viên tự thực hiện phần này
    }
}
