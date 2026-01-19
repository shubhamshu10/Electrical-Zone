package com.category.category_service.controller;

import java.util.List;

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

import com.category.category_service.entity.Category;
import com.category.category_service.service.CategoryService;

@RestController
@RequestMapping("electric-store/api/category")
public class CategoryController {

	private CategoryService service;

	public CategoryController(CategoryService service) {
		super();
		this.service = service;
	}
	@GetMapping("/")
	public ResponseEntity<List<Category>> selectAllCategory(){
		return new ResponseEntity<List<Category>>(service.getAllCategory(), HttpStatus.OK);		
	}
	@GetMapping("/{category_id}")
	public ResponseEntity<Category> selectCategory(@PathVariable int category_id){
		return new ResponseEntity<Category>(service.getCategoryById(category_id), HttpStatus.OK);		
	}
	@GetMapping("/{category_name}")
	public ResponseEntity<Category> selectCategoryByName(@PathVariable String category_name){
		return new ResponseEntity<Category>(service.getCategoryByName(category_name), HttpStatus.OK);		
	}
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@RequestBody Category cate){
		return new ResponseEntity<Category>(service.addNewCategory(cate), HttpStatus.CREATED);	
	}
	@PutMapping("/{category_id}")
	public ResponseEntity<Category> editCategory(@PathVariable int category_id, @RequestBody Category cate){
		return new ResponseEntity<Category>(service.updateCategory(cate, category_id), HttpStatus.OK);	
	}
	
	@DeleteMapping("/{category_id}")
	public ResponseEntity<Category> removeCategory(@PathVariable int category_id){
		service.deleteCategory(category_id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);	
	}
		
}
