package com.user_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.user_service.DTO.UserDTO;
import com.user_service.entity.User;
import com.user_service.repository.UserRepository;

@Service
//@AllArgsConstructor
public class UserService {
	private final UserRepository userRepository;
   
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<UserDTO> getAllUsers() {
		List<User> all = userRepository.findAll();
		return all
				.stream()
				.map(user -> UserDTO.builder()
						.userId(user.getUserId())
						.name(user.getName())
						.email(user.getEmail())
						.mobile(user.getMobile())
						.address(user.getAddress())
						
						.build())
				.collect(Collectors.toList());
						
	}
	public UserDTO getUserById(int userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		return UserDTO.builder()
				.userId(user.getUserId())
				.name(user.getName())
				.email(user.getEmail())
				.mobile(user.getMobile())
				.address(user.getAddress())
				
				.build();
		
    }
	public UserDTO addNewUser(User user) {
		
		userRepository.save(user);
		return UserDTO.builder()
				.userId(user.getUserId())
				.name(user.getName())
				.email(user.getEmail())
				.mobile(user.getMobile())
				.address(user.getAddress())
				
				.build();
	}
	
	public UserDTO getUserByEmail(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
		return UserDTO.builder()
				.userId(user.getUserId())
				.name(user.getName())
				.email(user.getEmail())
				.mobile(user.getMobile())
				.address(user.getAddress())
				
				.build();
		
	}
	public UserDTO updateUser(User user, int userId) {
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setMobile(user.getMobile());
		existingUser.setAddress(user.getAddress());
		
		
		userRepository.save(existingUser);
		return UserDTO.builder()
				.userId(existingUser.getUserId())
				.name(existingUser.getName())
				.email(existingUser.getEmail())
				.mobile(existingUser.getMobile())
				.address(existingUser.getAddress())
				
				.build();
		
	}
}