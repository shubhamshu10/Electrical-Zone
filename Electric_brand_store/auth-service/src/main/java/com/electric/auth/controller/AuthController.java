package com.electric.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electric.auth.dto.ApiRequest;
import com.electric.auth.dto.ApiResponse;
import com.electric.auth.service.AuthUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
	private final AuthUserService service;
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ApiRequest request) {
		service.registerUser(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody ApiRequest request) {
        return ResponseEntity.ok(service.loginUser(request));
    }

}
