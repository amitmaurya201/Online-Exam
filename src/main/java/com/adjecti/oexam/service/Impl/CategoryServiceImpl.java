package com.adjecti.oexam.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.oexam.entity.Category;
import com.adjecti.oexam.modal.CategoryDTO;
import com.adjecti.oexam.repository.CategoryRepository;
import com.adjecti.oexam.service.CategoryService;

@Service

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public Category addCategory(CategoryDTO categoryDto)  {
		
		Category category = modelMapper.map(categoryDto, Category.class);
		category.setCreatedby(categoryDto.getCreatedby());
		category.setTitle(categoryDto.getTitle());	
				return this.categoryRepository.save(category);
	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		this.categoryRepository.save(category);
	}

	@Override
	public CategoryDTO getCategory(Long categoryId) {
		Category category = categoryRepository.getOne(categoryId);
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO>  getCategories() {

		return  ((List<Category>) categoryRepository  
                .findAll())  
                .stream()  
                .map(this::convertDataIntoDTO)  
                        .collect(Collectors.toList());  
	}
	
	  private CategoryDTO convertDataIntoDTO (Category category) {  
          
	        CategoryDTO dto = new CategoryDTO();  
	        dto.setCreatedby(category.getCreatedby());
	        dto.setCid(category.getCid());  
	        dto.setTitle(category.getTitle());  
	        dto.setCreateOn(category.getCreateOn());    
	        return dto;  
	  }
	
	@Override
	public void deleteCategory(Long categoryId) {
		Category category = new Category();
		category.setCid(categoryId);
		this.categoryRepository.deleteById(categoryId);
	}



}
