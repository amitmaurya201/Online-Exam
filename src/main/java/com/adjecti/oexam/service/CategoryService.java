package com.adjecti.oexam.service;

import java.security.Principal;
import java.util.List;

import com.adjecti.oexam.entity.Category;
import com.adjecti.oexam.modal.CategoryDTO;

public interface CategoryService {

	// to add new category
	public Category addCategory(CategoryDTO categoryDto);

	// to update existing category
	public void updateCategory(CategoryDTO categoryDTO);

	// to get category by id
	public CategoryDTO getCategory(Long categoryId);

	// to get all categories
	public List<CategoryDTO> getCategories();

	// to delete any category
	public void deleteCategory(Long categoryId);
	
	

}
