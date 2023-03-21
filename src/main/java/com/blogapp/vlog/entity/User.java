package com.blogapp.vlog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name",nullable = false,length =100)
	private String name;
	
	//if the column is not specified means it should have the same name as in table
	private String user_email;
	
	private String user_password;
	
	private String about_user;
	
	@OneToMany(mappedBy="user" , cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post> User_Posts=new ArrayList<>();
	
}
