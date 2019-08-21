package com.green.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.Account;
import com.green.exception.MyException;
import com.green.model.LoginModel;
import com.green.service.AccountService;

@Controller
@RequestMapping("/login1")
public class LoginController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LOGIN_VIEW_NAME = "login1";
	
	@Autowired
	private AccountService accountService;

	@GetMapping
	public String showLoginPage() {
		return LOGIN_VIEW_NAME;
	}

	@PostMapping
	public String processSubmitLogin(@ModelAttribute("loginModel") LoginModel loginModel,
									Model model, ServletRequest request) {
		// kiem tra
		if (loginModel.getUsername() == null || loginModel.getUsername().isEmpty()) {
			model.addAttribute("error", "Vui long nhap username.");
			return LOGIN_VIEW_NAME;
		}
		
		if (loginModel.getPassword() == null || loginModel.getPassword().isEmpty()) {
			model.addAttribute("error", "Vui long nhap password.");
			return LOGIN_VIEW_NAME;
		}
		
		Account account;
		try {
			account = accountService.login(loginModel.getUsername(), loginModel.getPassword());
			
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
		return "redirect:/";
	}

}
