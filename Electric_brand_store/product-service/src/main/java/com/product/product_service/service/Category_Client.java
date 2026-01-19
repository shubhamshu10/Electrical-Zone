package com.product.product_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.product_service.dto.CategoryDTO;
//import com.product.product_service.entity.Category;

@FeignClient(name="category-service",url="http://localhost:8081/")
public interface Category_Client {
    @GetMapping("/electric-store/api/category/{category_id}")  
    CategoryDTO getCategoryById(@PathVariable int category_id);
    @GetMapping("/electric-store/api/category/{category_name}")
	CategoryDTO getCategoryByName(@PathVariable String category_name);
}
