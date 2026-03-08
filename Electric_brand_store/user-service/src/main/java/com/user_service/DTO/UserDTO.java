package com.user_service.DTO;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String address;
	
	
	
}
