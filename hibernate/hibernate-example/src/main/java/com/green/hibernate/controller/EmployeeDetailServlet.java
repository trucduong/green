package com.green.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.hibernate.dao.EmployeeDao;
import com.green.hibernate.entity.Employee;

@WebServlet("/employee/detail")
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String action = request.getParameter("action");
	    String id = request.getParameter("id");
	    
	    if (action == null || action.isEmpty()) {
	        response.sendRedirect(request.getContextPath() + "/employee");
	        return;
	    }
	    
	    switch (action) {
            case "update":
                if(id == null || id.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/employee");
                    break;
                }
                
                EmployeeDao dao = new EmployeeDao();
                Employee employee = dao.find(Integer.parseInt(id));
                if (employee == null) {
                    response.sendRedirect(request.getContextPath() + "/employee");
                    break;
                }
                
                request.setAttribute("_employee", employee);
                request.setAttribute("action", "update");
                request.getRequestDispatcher("/WEB-INF/employee-detail.jsp").forward(request, response);
                break;

            case "create":
                request.setAttribute("_employee", new Employee());
                request.setAttribute("action", action);
                request.getRequestDispatcher("/WEB-INF/employee-detail.jsp").forward(request, response);
                break;
                
            default:
                response.sendRedirect(request.getContextPath() + "/employee");
                break;
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
        
        if (action == null || action.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/employee");
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
                response.sendRedirect(request.getContextPath() + "/employee");
                break;
        }
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy thông tin employee từ request
        
        // kiểm tra thông tin
        
        // lưu thông tin employee vào database (gọi phương thức update trong EmployeeDao)
        
        // chuyển về trang employee list
        response.sendRedirect(request.getContextPath() + "/employee");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin employee từ request
	    
	    // kiểm tra thông tin
	    
	    // lưu thông tin employee vào database (gọi phương thức update trong EmployeeDao)
	    
	    // chuyển về trang employee list
        response.sendRedirect(request.getContextPath() + "/employee");
    }
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lấy categroy id từ request
	    String id = request.getParameter("id");
	    
	    // Kiểm tra 
	    if(id == null || id.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/employee");
            return;
        }
	    
	    // Xóa employee theo id
	    EmployeeDao employeeDao = new EmployeeDao();
	    employeeDao.delete(Integer.parseInt(id));
	    
	    // chuyển về trang employee list
	    response.sendRedirect(request.getContextPath() + "/employee");
    }
}
