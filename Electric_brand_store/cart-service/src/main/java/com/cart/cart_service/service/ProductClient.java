package com.cart.cart_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cart.cart_service.dto.ProductDTO;

//import com.product.product_service.dto.ProductDTO;

@FeignClient(name="product-service",url="http://localhost:8082/")
public interface ProductClient {
	@GetMapping("electric-store/api/product/{product_id}")
	public ProductDTO getProductById(@PathVariable int product_id);
}
