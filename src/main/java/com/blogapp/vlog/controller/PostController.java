package com.blogapp.vlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.vlog.payloads.PostDTO;
import com.blogapp.vlog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;

	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postdto,
			@PathVariable Integer userId,@PathVariable("categoryId") Integer categoryId){
		System.out.println(categoryId);
		PostDTO createPost=postService.createPost(postdto, userId, categoryId);
		
		return new ResponseEntity<PostDTO>(createPost,HttpStatus.CREATED);
	}
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable("userId") Integer userId){
		
		List<PostDTO> posts=this.postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
	}
	//get post by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable("categoryId") Integer categoryId){
		System.out.println(categoryId);
		List<PostDTO> posts=this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
	}
	
	//get all posts
	@GetMapping("/a-z")
	public ResponseEntity<List<PostDTO>> getAllPosts(@RequestParam(value="PageNo",defaultValue="0",required=false) Integer pageNo,
			@RequestParam(value="PageSize",defaultValue="5",required=false) Integer pageSize
			){
		List<PostDTO> posts=this.postService.getAllPost(pageNo,pageSize);
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
		}
	//get posts by Id
	@GetMapping("/postById/{postId}")
	public ResponseEntity<PostDTO> getPostsById(@PathVariable("postId") Integer postId ){
		PostDTO posts=this.postService.getPostById(postId);
		return new ResponseEntity<PostDTO>(posts,HttpStatus.OK);
		}
	
	//delete post
	@DeleteMapping("/delPostById/{postId}")
	public String deletePostById(@PathVariable("postId") Integer postId ){
		this.postService.deletePost(postId);;
		return "PostDeleted";
		}
	@PutMapping("/updatePostById/{postId}")
	public ResponseEntity<PostDTO> updatePostById(@RequestBody PostDTO postDto,@PathVariable("postId") Integer postId ){
		PostDTO posts=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDTO>(posts,HttpStatus.OK);
		}
}
