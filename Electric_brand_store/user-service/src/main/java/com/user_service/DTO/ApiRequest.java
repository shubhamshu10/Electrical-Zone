package com.user_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiRequest {
	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String password;
	private String role;
	}
