package com.blogapp.vlog.service;

import java.util.List;

import com.blogapp.vlog.entity.Post;
import com.blogapp.vlog.payloads.PostDTO;

public interface PostService {
	

	//create
	
	PostDTO createPost(PostDTO postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDTO updatePost(PostDTO postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all Posts
	
	List<PostDTO> getAllPost(Integer pageNo, Integer pageSize);
	
	//get Single Post
	
	PostDTO getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDTO> getPostsByCategory(Integer categoryId);
	
	//get all Post by user
	List<PostDTO> getAllPostByUser(Integer userId);
	
	//search post
	List<Post> searchPosts(String keyword);

}
