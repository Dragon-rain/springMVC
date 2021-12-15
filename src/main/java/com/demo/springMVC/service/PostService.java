package com.demo.springMVC.service;

import java.util.List;

import com.demo.springMVC.dto.Post;


public interface PostService {

	List<Post> getAllPosts();

	Post getPostByID(int id);

	void addPost(Post post);

	void updatePost(Post post);

	void deletePostById(int id);

}
