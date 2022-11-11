package com.anubhav.service;

import java.util.List;

import com.anubhav.entity.Post;
import com.anubhav.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	Post updatePost(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	List<Post> getAllPost();
	
	Post getPostById(Integer postid);
	
	List<Post> getPostByCategory(Integer categoryId);
	
	List<Post> getPostByUser(Integer userId);
	
	List<Post> searchPost(String keyWord);
}
