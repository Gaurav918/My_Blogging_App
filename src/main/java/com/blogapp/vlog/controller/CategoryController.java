package com.blogapp.vlog.controller;

import java.util.List;

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

import com.blogapp.vlog.payloads.CategoryDTO;
import com.blogapp.vlog.payloads.ExceptionResponse;
import com.blogapp.vlog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO catDto){
		
		CategoryDTO cat= this.categoryService.createCategory(catDto);
		
		return new ResponseEntity<CategoryDTO>(cat,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO catDto,@PathVariable("catId") Integer id){
		
	CategoryDTO updatedcatDto =	this.categoryService.updateCategory(catDto,id);
		
		return new ResponseEntity<CategoryDTO>(updatedcatDto,HttpStatus.OK);
	}
	//delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ExceptionResponse> deleteCategory(@PathVariable("catId") Integer id){
		
  	   this.categoryService.deleteCategory(id);
		
		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse("category is Deleted Successfully!!",true),HttpStatus.OK);
	}
	//get
	@GetMapping("/fetchCategory/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("catId") Integer id){
		
  	CategoryDTO cat=   this.categoryService.getCategory(id);
		
		return new ResponseEntity<CategoryDTO>(cat ,HttpStatus.OK);
	}
	
	//getall
	@GetMapping("/fetchCategory/")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		
  	List<CategoryDTO> cat=   this.categoryService.getCategoryList();
		
		return new ResponseEntity<List<CategoryDTO>>(cat ,HttpStatus.FOUND);
	}
	
	

}
