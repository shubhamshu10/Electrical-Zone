package com.cart.cart_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.cart_service.dto.CartDTO;
import com.cart.cart_service.service.CartService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("electric-store/cart")
public class CartController {

	private CartService cartService;
	
	@GetMapping("/{cartId}")
	public ResponseEntity<CartDTO> getCart(@PathVariable int cartId) {
		return ResponseEntity.ok(cartService.getCart(cartId));
	}
	@GetMapping("/add/{cartId}/{productId}")
	public ResponseEntity<CartDTO> addProductToCart(@PathVariable int productId, @PathVariable int cartId) {
		return ResponseEntity.ok(cartService.addProductInCart(productId, cartId));
	}
	@GetMapping("/remove/{cartId}/{productId}")
	public ResponseEntity<CartDTO> deleteProductFromCart(@PathVariable int productId, @PathVariable int cartId) {
		return ResponseEntity.ok(cartService.removeProductFromCart(productId, cartId));
	}
}
