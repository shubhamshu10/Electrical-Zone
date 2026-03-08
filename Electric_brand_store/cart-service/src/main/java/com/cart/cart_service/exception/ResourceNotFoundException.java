package com.cart.cart_service.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
       String msg;
}
