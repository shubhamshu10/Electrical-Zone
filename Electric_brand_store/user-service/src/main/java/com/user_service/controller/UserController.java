package com.user_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.DTO.UserDTO;
import com.user_service.entity.User;
import com.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
		UserDTO user = userService.getUserById(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
		UserDTO createdUser = userService.addNewUser(user);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	@GetMapping("/{email}")
	public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
		UserDTO user = userService.getUserByEmail(email);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> editUser(@PathVariable int id,@RequestBody User user) {
		UserDTO updatedUser = userService.updateUser(user, id);
		if (updatedUser != null) {
			return ResponseEntity.ok(updatedUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
