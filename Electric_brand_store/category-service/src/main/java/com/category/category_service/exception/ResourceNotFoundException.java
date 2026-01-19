package com.category.category_service.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
//@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
      //String msg;
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
