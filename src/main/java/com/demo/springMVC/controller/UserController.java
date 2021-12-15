package com.demo.springMVC.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springMVC.dto.Post;
import com.demo.springMVC.dto.User;
import com.demo.springMVC.service.PostService;

@Controller
public class UserController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/add-post")
	public String addPost(Post post, HttpSession session) {
		if(post.getTitle()!=null) {
			User user = (User)session.getAttribute("user");
			post.setUserId(user.getId());
			postService.addPost(post);
			return "redirect:/posts";
		}
		return "addPost";
	}
	
	@RequestMapping("/edit-post")
	public String updatePost(int id, Model model, Post post) {
		if(post.getTitle()!=null) {
			postService.updatePost(post);
			return "redirect:/post?id="+id;
		}
		model.addAttribute("post", postService.getPostByID(id));
		return "EditePost";
	}

	@RequestMapping("/delete-post")
	public String deletePost(int id) {
		postService.deletePostById(id);
		return "redirect:/posts";
	}
	
	@RequestMapping("/chat-page")
	public String chatPage() {
		return "chat";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return"redirect:/";
	}

}
