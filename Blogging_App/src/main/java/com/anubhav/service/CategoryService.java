package com.anubhav.service;

import java.util.List;

import com.anubhav.payloads.CategoryDto;

public interface CategoryService {

	//create
	public CategoryDto createCategory(CategoryDto  categoryDto);
	
	//update
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//get
	public CategoryDto getCategoryById(Integer categoryId);
	
	//get all
	public List<CategoryDto> getAllCategories();
	
	//delete
	public void deleteCategoryById(Integer categoryId);
}
