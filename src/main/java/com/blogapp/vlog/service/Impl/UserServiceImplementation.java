package com.blogapp.vlog.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.vlog.entity.User;
import com.blogapp.vlog.exceptionshandler.ResourceNotFoundException;
import com.blogapp.vlog.payloads.UserDTO;
import com.blogapp.vlog.repositories.UserRepository;
import com.blogapp.vlog.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelDtotoUserMapper;
	
	@Override
	public UserDTO createUser(UserDTO user) {
		
		User newUser=this.getUserData(user);
		User savedUser =this.userRepo.save(newUser);
		
		
		return this.userData(savedUser);
	}
	
	@Override
	public void deleteUser(Integer userId) {
		 
		User usr=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "Deletion", userId));
		this.userRepo.delete(usr);
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
		
	List<User> userslst=	this.userRepo.findAll();
	List<UserDTO> usrdtolst=userslst.stream().map(usersls->this.userData(usersls)).collect(Collectors.toList());
	
		return usrdtolst;
	}
	
	@Override
	public UserDTO getUserById(Integer userId) {
	
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "Id", userId));
		return this.userData(user);
	}
	
	@Override
	public UserDTO updateUser(UserDTO userdto, Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User Id",userId));
		user.setName(userdto.getName());
		user.setUser_email(userdto.getUser_email());
		user.setUser_password(userdto.getUser_password());
		user.setAbout_user(userdto.getAbout_user());
		
		User updatedUser=this.userRepo.save(user);
		return this.userData(updatedUser);
	}
	
	//Model data mapper
	
	public User getUserData(UserDTO userdto)
	{
		User user=this.modelDtotoUserMapper.map(userdto,User.class);
		/*user.setId(userdto.getId());
		user.setAbout_user(userdto.getAbout_user());
		user.setUser_email(userdto.getUser_email());
		user.setName(userdto.getName());
		user.setUser_password(userdto.getUser_password());*/
		return user;
	}
	public UserDTO userData(User usertodto)
	{
		UserDTO user=this.modelDtotoUserMapper.map(usertodto, UserDTO.class);
		/*user.setId(usertodto.getId());
		user.setUser_email(usertodto.getUser_email());
		user.setAbout_user(usertodto.getAbout_user());
		user.setName(usertodto.getName());
		user.setUser_password(usertodto.getUser_password());*/
		return user;
	}

}
