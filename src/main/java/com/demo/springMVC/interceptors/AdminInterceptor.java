package com.demo.springMVC.interceptors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.demo.springMVC.dto.User;
import com.demo.springMVC.dto.UserRoles;

public class AdminInterceptor extends WebContentInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		User user = (User)request.getSession().getAttribute("user");
		if(!user.getRole().equals(UserRoles.ADMIN.name()))
			try {
				response.sendRedirect("/springMVC/posts");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return super.preHandle(request, response, handler);
	}

}
