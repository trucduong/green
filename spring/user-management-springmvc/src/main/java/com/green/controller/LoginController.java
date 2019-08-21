package com.green.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.Account;
import com.green.exception.MyException;
import com.green.service.AccountService;


// http://localhost:8080/UserManagement/login

//@WebServlet("/login")
@Controller
@RequestMapping("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LOGIN_VIEW_NAME = "login";
	
	@Autowired
	private AccountService accountService;

	@GetMapping
	public String showLoginPage() {
		return LOGIN_VIEW_NAME;
	}

	@PostMapping
	public String processSubmitLogin(@RequestParam(name="username") String username,
									@RequestParam(name="username") String password,
									Model model, ServletRequest request) {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		
		// kiem tra
		if (username == null || username.isEmpty()) {
			model.addAttribute("error", "Vui long nhap username.");
			return LOGIN_VIEW_NAME;
		}
		
		if (password == null || password.isEmpty()) {
			model.addAttribute("error", "Vui long nhap password.");
			return LOGIN_VIEW_NAME;
		}
		
		Account account;
		try {
			account = accountService.login(username, password);
			
		} catch(MyException le) {
			model.addAttribute("error", le.getMessage());
			return LOGIN_VIEW_NAME;
			
		} catch (Exception e) {
			model.addAttribute("error", "Loi, vui long thu lai");
			return LOGIN_VIEW_NAME;
		}
		
		// luu thong tin account vao session
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		session.setAttribute("current_user", account);
		
		// quay ve trang Index va hien thi danh sach account.
//		response.sendRedirect(request.getContextPath() + "/");
		return "redirect:/";
	}

}
