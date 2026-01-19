package com.product.product_service.exception;

public class ResourceNotFoundException extends RuntimeException{
    String msg;

	public ResourceNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
    
}
