package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.entity.Account;
import com.green.service.AccountService;

@Controller
public class IndexController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("")
	public String index(Model model) {
		// lấy danh sách Account từ DB
		List<Account> accountList = accountService.findAll();
		
		// set danh sách account tìm được vào request
//		request.setAttribute("account_list", accountList);
		model.addAttribute("account_list", accountList);
		
		// show home page
//		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		return "home";
	}
}
