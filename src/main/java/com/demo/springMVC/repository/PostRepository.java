package com.demo.springMVC.repository;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.springMVC.dto.Post;

public interface PostRepository {
	
	List<Post> getAllPosts();

	Post getPostByID(int id);

	void addPost(@Param("post") Post post, @Param("creationDate") Date creationDate);

	void updatePost(@Param("post") Post post, @Param("updateDate") Date updateDate);

	void deletePostById(@Param("id") int id, @Param("deletedDate") Date deletedDate);

}
