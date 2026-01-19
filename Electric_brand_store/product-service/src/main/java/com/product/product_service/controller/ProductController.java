package com.product.product_service.controller;

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

import com.product.product_service.dto.ProductDTO;
//import com.product.product_service.entity.Category;
import com.product.product_service.entity.Product;
//import com.category.category_service.entity.Category;
import com.product.product_service.service.ProductService;

@RestController
@RequestMapping("electric-store/api/product")
public class ProductController {
      private ProductService service;

	  public ProductController(ProductService service) {
		super();
		this.service = service;
	  }
	 
	    @GetMapping("/")
		public ResponseEntity<List<ProductDTO>> selectAllProducts(){
			return new ResponseEntity<List<ProductDTO>>(service.getAllProduct(), HttpStatus.OK);		
		}
		@GetMapping("/{product_id}")
		public ResponseEntity<ProductDTO> selectproduct(@PathVariable int product_id){
			return new ResponseEntity<ProductDTO>(service.getProductById(product_id), HttpStatus.OK);		
		}
		@GetMapping("/{product_name}")
		public ResponseEntity<ProductDTO> selectProductByName(@PathVariable String product_name){
			return new ResponseEntity<ProductDTO>(service.getProductByName(product_name), HttpStatus.OK);		
		}
		@PostMapping("/")
		public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
			return new ResponseEntity<ProductDTO>(service.addNewProduct(product), HttpStatus.CREATED);	
		}
		@PutMapping("/{product_id}")
		public ResponseEntity<ProductDTO> updateProduct(@PathVariable int product_id, @RequestBody ProductDTO product){
			return new ResponseEntity<ProductDTO>(service.editProduct(product, product_id), HttpStatus.OK);	
		}
		
		@DeleteMapping("/{product_id}")
		public ResponseEntity<ProductDTO> deleteProduct(@PathVariable int product_id){
			service.removeProduct(product_id);
			return new ResponseEntity<ProductDTO>(HttpStatus.NO_CONTENT);	
		}
		@GetMapping("/category/{category_id}")
		public ResponseEntity<List<ProductDTO>> selectproductByCatgory(@PathVariable int category_id){
			return new ResponseEntity<List<ProductDTO>>(service.getProductByCategory(category_id), HttpStatus.OK);		
		}
		
}
