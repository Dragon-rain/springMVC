package com.demo.springMVC.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springMVC.dto.User;
import com.demo.springMVC.service.PostService;
import com.demo.springMVC.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String mainPage() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		User user = userService.userLogin(username, password);
		if(user==null) return "redirect:/";
		if(session.getAttribute("user")!=null) session.removeAttribute("user");
		session.setAttribute("user", user);
		return "redirect:/posts";
	}
	
	@RequestMapping("/posts")
	public String postsBoard(Model model) {
		model.addAttribute("postsList", postService.getAllPosts());
		return "PostsBoard";
	}
	
	@RequestMapping("/post")
	public String postDetails(int id, Model model) {
		model.addAttribute("post", postService.getPostByID(id));
		return "PostPage";
	}
	
	@RequestMapping("/registration")
	public String registration(String username, String password) {
		if(username!= null&&password!=null){
			User user = new User();
			user.setUsername(username);
			userService.userRegistration(user, password);
			return "redirect:/";
		}
		return "Registration";
	}
	
	

}
