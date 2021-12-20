package com.demo.springMVC.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.springMVC.dto.Post;
import com.demo.springMVC.repository.PostRepository;
import com.demo.springMVC.service.PostService;
import com.demo.springMVC.utils.DateUtil;

@Service
public class PostServiceImpl implements PostService {
	
	private final PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.getAllPosts();
	}

	@Override
	public Post getPostByID(int id) {
		return postRepository.getPostByID(id);
	}

	@Override
	public void addPost(Post post) {
		postRepository.addPost(post, DateUtil.getCurrentSqlDate());
	}

	@Override
	public void updatePost(Post post) {
		postRepository.updatePost(post, DateUtil.getCurrentSqlDate());
	}

	@Override
	public void deletePostById(int id) {
		postRepository.deletePostById(id, DateUtil.getCurrentSqlDate());
	}

}
