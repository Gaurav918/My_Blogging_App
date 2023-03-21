package com.blogapp.vlog.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.blogapp.vlog.entity.Category;
import com.blogapp.vlog.entity.Post;
import com.blogapp.vlog.entity.User;
import com.blogapp.vlog.exceptionshandler.ResourceNotFoundException;
import com.blogapp.vlog.payloads.PostDTO;
import com.blogapp.vlog.repositories.CategoryRepo;
import com.blogapp.vlog.repositories.PostRepository;
import com.blogapp.vlog.repositories.UserRepository;
import com.blogapp.vlog.service.PostService;
@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public PostDTO createPost(PostDTO postDto,Integer userId,Integer categoryId) {
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		Category category=catRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setCreationDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDTO.class);
	}

	@Override
	public PostDTO updatePost(PostDTO postDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        
        post=this.postRepo.save(post);
		return this.modelMapper.map(post, PostDTO.class);
	}

	@Override
	public void deletePost(Integer postId) {
		this.postRepo.deleteById(postId);
		
	}

	@Override
	public List<PostDTO> getAllPost(Integer pageNo,Integer pageSize) {
		//for implementing pagination
		
		Pageable page=PageRequest.of(pageNo, pageSize);
		Page<Post> pagePost=this.postRepo.findAll(page);
		List<Post> allPosts=pagePost.getContent();
		//List<Post> allPosts=this.postRepo.findAll();
		List<PostDTO> postDtos=	allPosts.stream().map(post->this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public PostDTO getPostById(Integer postId) {
		Post postbyId=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
		return this.modelMapper.map(postbyId, PostDTO.class);
	}

	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId) {
		Category cat=this.catRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
	List<PostDTO> postDtos=	posts.stream().map(post->this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDTO> getAllPostByUser(Integer userId){
	User user=	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
		List<Post> posts=this.postRepo.findByUser(user);
		List<PostDTO> postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		
		return postDtos;
	}
	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
