package com.blogapp.vlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.vlog.entity.Category;
import com.blogapp.vlog.payloads.CategoryDTO;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

	
}
