package com.blogapp.vlog.service;

import java.util.List;

import com.blogapp.vlog.payloads.CategoryDTO;

public interface CategoryService {

	//create
		public CategoryDTO createCategory(CategoryDTO categoryDto);
		
		//update
		public CategoryDTO updateCategory(CategoryDTO categoryDto,Integer categoryId);
		
		//delete
		public void deleteCategory(Integer categoryId);
		
		//get
		public CategoryDTO getCategory(Integer categoryId);
		
		//getAll
		public List<CategoryDTO> getCategoryList();
		
}
