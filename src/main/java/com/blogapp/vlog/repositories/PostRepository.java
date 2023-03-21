package com.blogapp.vlog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.vlog.entity.Category;
import com.blogapp.vlog.entity.Post;
import com.blogapp.vlog.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{

	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
