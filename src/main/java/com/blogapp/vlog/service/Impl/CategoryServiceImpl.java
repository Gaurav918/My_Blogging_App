package com.blogapp.vlog.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.vlog.entity.Category;
import com.blogapp.vlog.exceptionshandler.ResourceNotFoundException;
import com.blogapp.vlog.payloads.CategoryDTO;
import com.blogapp.vlog.repositories.CategoryRepo;
import com.blogapp.vlog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapperCategory;
	//@Autowired
	//List<Category> cat;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {


		// cat.add(this.modelMapperCategory.map(categoryDto, Category.class));
		Category cat=this.modelMapperCategory.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapperCategory.map(addedCat,CategoryDTO.class);
		// return categoryDto;
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId) {


		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
	//return	cat.stream().filter(e->e.getCategoryId().equals(categoryId)).map(e->{
		//	e.setCategoryDescription(categoryDto.getCategoryDescription());
			//e.setCategoryTitle(categoryDto.getCategoryTitle());
			//return modelMapperCategory.map(e, CategoryDTO.class);}).findFirst()
		//.orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));	
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		return this.modelMapperCategory.map(cat, CategoryDTO.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		this.categoryRepo.delete(cat);
		//cat=cat.stream().filter(e->!e.getCategoryId().equals(categoryId)).collect(Collectors.toList());
		
	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		
	Category cat =	this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id",categoryId));
		
		
		return this.modelMapperCategory.map(cat, CategoryDTO.class);
		//return cat.stream().filter(e->e.getCategoryId().equals(categoryId)).map(e->{
			//return modelMapperCategory.map(e, CategoryDTO.class);}).findFirst()
		//.orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
	}

	@Override
	public List<CategoryDTO> getCategoryList() {
		
	List<Category>	categories = this.categoryRepo.findAll();
		
	List<CategoryDTO> catDtos=categories.stream().map(e -> this.modelMapperCategory.map(e, CategoryDTO.class)).collect(Collectors.toList());
	
		return catDtos;
	}
	
	

}
