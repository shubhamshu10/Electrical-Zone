package com.product.product_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product_service.dto.CategoryDTO;
import com.product.product_service.dto.ProductDTO;
//import com.product.product_service.entity.Category;
import com.product.product_service.entity.Product;
import com.product.product_service.exception.ResourceNotFoundException;
import com.product.product_service.repository.ProductRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ProductService {
     private ProductRepository repo;
     private Category_Client client;
	 
     
	 public List<ProductDTO> getAllProduct(){
		List<Product> all = repo.findAll(); 
		return all.stream().map(product->ProductDTO.builder()
				.product_id(product.getProduct_id())
				.product_name(product.getProduct_name())
				.description(product.getDescription())
				.price(product.getPrice()).build()).collect(Collectors.toList());
		 	 
	 }
	 public ProductDTO addNewProduct(Product product) {
		 repo.save(product);
		 return ProductDTO.builder()
				 .product_id(product.getProduct_id())
			   	 .product_name(product.getProduct_name())
				 .description(product.getDescription())
				 .price(product.getPrice())
				 .build();
				 
	 }
	 public ProductDTO getProductById(int id) {
		 
		 Product product=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product is not exist with id: "+id));
		return ProductDTO.builder()
				 .product_id(product.getProduct_id())
				 .product_name(product.getProduct_name())
				 .description(product.getDescription())
				 .price(product.getPrice())
				 .build();		 
	 }
	 
	 public ProductDTO getProductByName(String name) {
		   Product product=repo.findByName(name).orElseThrow(()-> new ResourceNotFoundException("Product is not exist with name: "+name));	
		   return ProductDTO.builder()
					 .product_id(product.getProduct_id())
					 .product_name(product.getProduct_name())
					 .description(product.getDescription())
					 .price(product.getPrice())
					 .build();		 
	 }
	 public ProductDTO editProduct(ProductDTO product, int id) {
		 Product prod=repo.findById(id).get();
		 prod.setProduct_name(product.getProduct_name());
		 prod.setDescription(product.getDescription());
		 prod.setPrice(product.getPrice());
		 return ProductDTO.builder()
				 .product_id(prod.getProduct_id())
				 .product_name(prod.getProduct_name())
				 .description(prod.getDescription())
				 .price(prod.getPrice())
				 .build();		 
	 }
	 public void removeProduct(int id) {
		 repo.deleteById(id);
	 }
	 public List<ProductDTO> getProductByCategory(int category_id) {
		 CategoryDTO category= client.getCategoryById(category_id);
		 List<Product> productList = repo.findByCategoryId(category.getCategory_id());
		 return productList.stream().map(product->ProductDTO.builder()
					.product_id(product.getProduct_id())
					.product_name(product.getProduct_name())
					.description(product.getDescription())
					.price(product.getPrice()).build()).collect(Collectors.toList());
	 }
	 
	 
}
