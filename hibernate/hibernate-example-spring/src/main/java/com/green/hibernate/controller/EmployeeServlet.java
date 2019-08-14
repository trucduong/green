package com.green.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.hibernate.dao.EmployeeDao;
import com.green.hibernate.entity.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employeeList = employeeDao.findAll();
		
		request.setAttribute("_employee_list", employeeList);
		request.getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);
	}
}
