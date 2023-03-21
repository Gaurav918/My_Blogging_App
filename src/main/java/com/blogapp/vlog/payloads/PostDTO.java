package com.blogapp.vlog.payloads;

import java.util.Date;

import com.blogapp.vlog.entity.Category;
import com.blogapp.vlog.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
	
	private Integer postId;
	private String postTitle;
	
	private String postContent;
	
	private String imageName;
	
	private Date creationDate;
	
	private CategoryDTO category;
	
	private UserDTO user;
	
	
	

}
