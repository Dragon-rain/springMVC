package com.demo.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.demo.springMVC.dto.User;
import com.demo.springMVC.service.PostService;
import com.demo.springMVC.service.UserService;

public class MainController implements Controller {
	
	private final PostService postService;
	private final UserService userService;
	
	public MainController(PostService postService,  UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}	
	
	/*
	 * @RequestMapping("/") public String mainPage() { return "index"; }
	 * 
	 * @RequestMapping("/login") public String login(String username, String
	 * password, HttpSession session) { User user = userService.userLogin(username,
	 * password); if(user==null) return "redirect:/";
	 * if(session.getAttribute("user")!=null) session.removeAttribute("user");
	 * session.setAttribute("user", user); return "redirect:/posts"; }
	 * 
	 * @RequestMapping("/posts") public String postsBoard(Model model) {
	 * model.addAttribute("postsList", postService.getAllPosts()); return
	 * "PostsBoard"; }
	 * 
	 * @RequestMapping("/post") public String postDetails(int id, Model model) {
	 * model.addAttribute("post", postService.getPostByID(id)); return "PostPage"; }
	 * 
	 * @RequestMapping("/registration") public String registration(String username,
	 * String password) { if(username!= null&&password!=null){ User user = new
	 * User(); user.setUsername(username); userService.userRegistration(user,
	 * password); return "redirect:/"; } return "Registration"; }
	 */

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getRequestURI().contains("/login")) {
			User user = userService.userLogin(request.getParameter("username"), request.getParameter("password"));
			System.out.println(user);
			if(user==null) return new ModelAndView("index");;
			if(request.getSession().getAttribute("user")!=null) request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/springMVC/posts");
		} else if(request.getRequestURI().contains("/posts")) {
			return new ModelAndView("PostsBoard", "postsList", postService.getAllPosts());
		} else if(request.getRequestURI().contains("/post")) {
			return new ModelAndView("PostPage", "post", postService.getPostByID(Integer.parseInt(request.getParameter("id"))));
		} else if(request.getRequestURI().contains("/registration")) {
			if(request.getParameter("username")==null)return new ModelAndView("Registration");
			User user = new User(); 
			user.setUsername(request.getParameter("username")); 
			userService.userRegistration(user, request.getParameter("password"));
			response.sendRedirect("/springMVC/");
		} 
		return new ModelAndView("index");
	}
	
	

}
