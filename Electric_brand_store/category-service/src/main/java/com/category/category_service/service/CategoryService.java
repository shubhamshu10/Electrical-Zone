package com.category.category_service.service;

import org.springframework.stereotype.Service;

import com.category.category_service.entity.Category;
//import com.category.category_service.exception.GlobalException;
import com.category.category_service.exception.ResourceNotFoundException;
import com.category.category_service.repository.CategoryRepository;
import java.util.*;
//import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class CategoryService {
	private CategoryRepository category_repo;
	
    public CategoryService(CategoryRepository category_repo) {
		super();
		this.category_repo = category_repo;
		//this.cat = cat;
	}
	
	public List<Category> getAllCategory(){
		return category_repo.findAll();		
	}
	public Category addNewCategory(Category cate) {
		return category_repo.save(cate);		
	}
	public Category getCategoryById(int id) {
		Category category=category_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category with id : "+id+" not exist"));
		return category;	
	}
	public Category getCategoryByName(String name) {
		Category category=category_repo.findByName(name).orElseThrow(()-> new ResourceNotFoundException("Category with name : "+name+" not exist"));
		return category;	
	}
	public Category updateCategory(Category cate, int id) {
		Category category = category_repo.findById(id).get();
		category.setCategory_name(cate.getCategory_name());
		return category;
	}
	public void deleteCategory(int id) {
		category_repo.deleteById(id);
	}
}
