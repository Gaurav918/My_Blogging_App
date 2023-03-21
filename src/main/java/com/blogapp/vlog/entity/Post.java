package com.blogapp.vlog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name = "post_title",length = 100,nullable=false)
	private String postTitle;
	
	@Column(name = "post_Content",length = 500,nullable=false)
	private String postContent;
	
	@Column(name="image_url",length = 200)
	private String imageName;
	
	@Column(name = "post_Creation_Date",length = 500,nullable=false)
	private Date creationDate;
	
	@ManyToOne
	//@JoinColumn(name="category_Id")we can use this to specify the name of column that we want
	private Category category;
	
	@ManyToOne
	private User user;

}
