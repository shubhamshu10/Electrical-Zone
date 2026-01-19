package com.category.category_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException{
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourseNotFoundException(ResourceNotFoundException ex) {
    	String msg=ex.getMessage();
    	return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
    	
    }
}
