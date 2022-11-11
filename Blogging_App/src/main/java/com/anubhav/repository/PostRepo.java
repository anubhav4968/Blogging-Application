package com.anubhav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anubhav.entity.Category;
import com.anubhav.entity.Post;
import com.anubhav.entity.User;


public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
