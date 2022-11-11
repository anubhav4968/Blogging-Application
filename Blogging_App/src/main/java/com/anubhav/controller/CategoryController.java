package com.anubhav.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anubhav.payloads.ApiResponse;
import com.anubhav.payloads.CategoryDto;
import com.anubhav.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{	
		CategoryDto createdCategory= this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId){
	 CategoryDto updatedCategory=	this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);	
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
	{
		this.categoryService.deleteCategoryById(categoryId);
		return new ResponseEntity<ApiResponse> (new ApiResponse("Category deleted successfully!!!",false),HttpStatus.OK);
	}
	//get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		CategoryDto getCategory = this.categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto> (getCategory,HttpStatus.OK);
	}
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		 List<CategoryDto> listCategory= this.categoryService.getAllCategories();
		return  ResponseEntity.ok(listCategory);
	}
	
}
