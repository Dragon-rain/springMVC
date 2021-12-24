package com.demo.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.demo.springMVC.dto.Post;
import com.demo.springMVC.dto.User;
import com.demo.springMVC.service.PostService;
import com.demo.springMVC.service.UserService;

//@Controller
public class UserController implements Controller{
	
	//@Autowired
	private final PostService postService;
	private final UserService userService;
	
	public UserController(PostService postService, UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}
	
	/*
	 * @RequestMapping("/add-post") public String addPost(Post post, HttpSession
	 * session) { if(post.getTitle()!=null) { User user =
	 * (User)session.getAttribute("user"); post.setUserId(user.getId());
	 * postService.addPost(post); return "redirect:/posts"; } return "addPost"; }
	 * 
	 * @RequestMapping("/edit-post") public String updatePost(int id, Model model,
	 * Post post) { if(post.getTitle()!=null) { postService.updatePost(post); return
	 * "redirect:/post?id="+id; } model.addAttribute("post",
	 * postService.getPostByID(id)); return "EditePost"; }
	 * 
	 * @RequestMapping("/delete-post") public String deletePost(int id) {
	 * postService.deletePostById(id); return "redirect:/posts"; }
	 * 
	 * @RequestMapping("/chat-page") public String chatPage() { return "chat"; }
	 * 
	 * @RequestMapping("/logout") public String logout(HttpSession session) {
	 * session.removeAttribute("user"); return"redirect:/"; }
	 */

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getRequestURI().contains("/add-post")) {
			if(request.getParameter("title")==null) return new ModelAndView("addPost");
			User user = (User)request.getSession().getAttribute("user");
			Post post = new Post();
			post.setTitle(request.getParameter("title"));
			post.setDescription(request.getParameter("description"));
			post.setUserId(user.getId());
			postService.addPost(post); 
			response.sendRedirect("/springMVC/posts");
		} else if(request.getRequestURI().contains("/edit-post")) {
			if(request.getParameter("title")==null)return new ModelAndView("EditePost", "post", postService.getPostByID(Integer.parseInt(request.getParameter("id"))));
			Post post = new Post();
			post.setTitle(request.getParameter("title"));
			post.setDescription(request.getParameter("description"));
			post.setId(Integer.parseInt(request.getParameter("id")));
			postService.updatePost(post); 
			response.sendRedirect("/springMVC/post?id="+post.getId());
		} else if(request.getRequestURI().contains("/delete-post")) {
			postService.deletePostById(Integer.parseInt(request.getParameter("id"))); 
			response.sendRedirect("/springMVC/posts");
		} else if(request.getRequestURI().contains("/chat-page")) {
			return new ModelAndView("chat", "usersList", userService.getUsersList());
		} else if (request.getRequestURI().contains("/logout")) {
			request.getSession().removeAttribute("user");
			response.sendRedirect("/springMVC/");
		}
		return null;
	}

}
