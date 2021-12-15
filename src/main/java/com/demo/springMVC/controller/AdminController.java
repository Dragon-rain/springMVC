package com.demo.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/administrator-page")
	public String adminPage() {
		return "AdminDashBoard";
	}

}
