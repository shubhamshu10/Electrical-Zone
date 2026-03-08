package com.cart.cart_service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.cart_service.dto.CartDTO;
import com.cart.cart_service.dto.ProductDTO;
import com.cart.cart_service.entity.Cart;
import com.cart.cart_service.exception.ResourceNotFoundException;
import com.cart.cart_service.repository.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService {
	private CartRepository repo;
	private ProductClient client;
	
	public CartDTO getCart(int cartId) {
		Cart cart = repo.findById(cartId)
				.orElseThrow(()-> new ResourceNotFoundException("cart item not available"));
		return CartDTO.builder().cartId(cart.getCartId())
				.count(cart.getCount()).productId(cart.getProductId()).build();
	}
	public CartDTO addProductInCart(int productId, int cartId) {

	    // Optional: validate product exists
	    client.getProductById(productId);

	    return repo.findById(cartId)
	        .map(c -> {
	            c.setCount(c.getCount() + 1);
	            repo.save(c);

	            return CartDTO.builder()
	                    .cartId(c.getCartId())
	                    .productId(c.getProductId())
	                    .count(c.getCount())
	                    .build();
	        })
	        .orElseGet(() -> {
	            Cart newCart = Cart.builder()
	                    .cartId(cartId)
	                    .productId(productId)
	                    .count(1)
	                    .build();

	            repo.save(newCart);

	            return CartDTO.builder()
	                    .cartId(newCart.getCartId())
	                    .productId(newCart.getProductId())
	                    .count(newCart.getCount())
	                    .build();
	        });
	}
	public CartDTO removeProductFromCart(int productId, int cartId) {

	    return repo.findById(cartId)
	        .map(c -> {
	            if (c.getCount() > 1) {
	                c.setCount(c.getCount() - 1);
	                repo.save(c);

	                return CartDTO.builder()
	                        .cartId(c.getCartId())
	                        .productId(c.getProductId())
	                        .count(c.getCount())
	                        .build();
	            } else {
	                repo.delete(c);

	                return CartDTO.builder()
	                        .cartId(cartId)
	                        .productId(productId)
	                        .count(0)
	                        .build();
	            }
	        })
	        .orElseThrow(() -> new ResourceNotFoundException("Cart or product not found"));
	}


}
