package com.blogapp.vlog.controller;





import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.vlog.payloads.UserDTO;
import com.blogapp.vlog.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	//Post- create user
	
	@PostMapping("/signup")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto)
	{
		UserDTO createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	//PUT- update user 
	@PutMapping("/signup/{userId}")
	public ResponseEntity<UserDTO> upgateUser(@Valid @RequestBody UserDTO user,@PathVariable("userId") Integer userid)
	{
		UserDTO usr=this.userService.updateUser(user, userid);
		return ResponseEntity.ok(usr);
	}
	//Delete- delete user
	@DeleteMapping("/signup/{userId}")                                         //this path variable name should only be given when 
	public ResponseEntity<?> deleteUser(@RequestBody UserDTO user,@PathVariable("userId") Integer userid)//variable defined here and on path is not same
	{
		this.userService.deleteUser(userid);
		return ResponseEntity.ok("user deleted");
	}

	//Get- user
	@GetMapping("/getallUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers()
	{
		List<UserDTO> usr=this.userService.getAllUsers();
		return ResponseEntity.ok(usr) ;
	}

}
