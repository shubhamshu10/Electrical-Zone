package com.cart.cart_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.cart_service.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
     
}
