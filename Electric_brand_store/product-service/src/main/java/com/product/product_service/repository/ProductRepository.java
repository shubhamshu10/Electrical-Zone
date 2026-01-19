package com.product.product_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.product_service.dto.CategoryDTO;
//import com.product.product_service.entity.Category;
import com.product.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	 // @Query("select p.categoryId from Product p join Category c where p.categoryId=:categoryId")
	List<Product> findByCategoryId(int categoryId);
	  @Query("select p from Product p where p.product_name=:product_name")
      Optional<Product> findByName(@Param(value="product_name") String name);
}
