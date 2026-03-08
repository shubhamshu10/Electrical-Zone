package com.electric.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.electric.auth.config.JwtUtil;
import com.electric.auth.dto.ApiRequest;
import com.electric.auth.dto.ApiResponse;
import com.electric.auth.entity.AuthUser;
import com.electric.auth.entity.Role;
import com.electric.auth.repo.AuthRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthUserService {
      private final AuthRepository authUserRepository;
      private PasswordEncoder passwordEncoder;
      private JwtUtil jwtUtil;
      
      public String registerUser(ApiRequest request) {
			if (authUserRepository.findByUsername(request.getUsername()).isPresent()) {
				  throw new RuntimeException("Username already exists");
			}
			String encodedPassword = passwordEncoder.encode(request.getPassword());
			AuthUser user = new AuthUser();
			user.setUsername(request.getUsername());
			user.setPassword(encodedPassword);
			user.setRole(Role.CUSTOMER);
			authUserRepository.save(user);
			return "User registered successfully";
	  }
      public ApiResponse loginUser(ApiRequest request) {
    	  			AuthUser user = authUserRepository.findByUsername(request.getUsername())
		  					.orElseThrow(() -> new RuntimeException("Invalid username or password"));
    	  			if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
    	  	            throw new RuntimeException("Invalid credentials");
    	  	        }
    	  			String token = jwtUtil.generateToken(user.getUsername());
    	  			return new ApiResponse(token);
      }
}
