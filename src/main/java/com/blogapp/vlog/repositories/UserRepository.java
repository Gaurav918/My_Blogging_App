package com.blogapp.vlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.vlog.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	

}
