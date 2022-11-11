package com.anubhav.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anubhav.entity.Category;
import com.anubhav.entity.Post;
import com.anubhav.entity.User;
import com.anubhav.exceptions.ResourceNotFoundException;
import com.anubhav.payloads.PostDto;
import com.anubhav.repository.CategoryRepo;
import com.anubhav.repository.PostRepo;
import com.anubhav.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		 
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Post","Id",userId));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Post", "Id",categoryId));
		
		Post post= this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		Post postNew= this.postRepo.save(post);
		return this.modelMapper.map(postNew, PostDto.class);
	}
	
	
	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPost(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
