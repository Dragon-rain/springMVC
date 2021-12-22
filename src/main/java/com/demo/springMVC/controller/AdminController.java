package com.demo.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AdminController implements Controller {
	
	/*
	 * @RequestMapping("/administrator-page") public String adminPage() { return
	 * "AdminDashBoard"; }
	 */

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("AdminDashBoard");
	}

}
